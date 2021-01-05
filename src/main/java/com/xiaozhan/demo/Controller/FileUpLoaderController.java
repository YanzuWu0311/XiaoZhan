package com.xiaozhan.demo.Controller;
import com.xiaozhan.demo.Entities.User;
import com.xiaozhan.demo.Entities.Video;
import com.xiaozhan.demo.Service.Impl.UserService;
import com.xiaozhan.demo.Service.Impl.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@RestController
public class FileUpLoaderController {
    //绑定文件上传路径到uploadPath
    @Value("${file.uploadFolder}")
    private String uploadPath;
    @Autowired
    VideoService videoService;
    @Autowired
    UserService userService;
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadVideo(HttpServletRequest request) {
        String up= request.getParameter("up");
        List<User> u = userService.getUserByUserName(up);
        if(u.get(0).isbanned){
            return "用户被封禁无法上传视频";
        }
        try {
            MultipartFile video = ((MultipartHttpServletRequest) request).getFile("uploadvideo");
            MultipartFile cover = ((MultipartHttpServletRequest) request).getFile("uploadimg");
            String title= request.getParameter("title");
            String type = request.getParameter("type");
            System.out.println(title);
            String videoName = video.getOriginalFilename();
            System.out.println(videoName);
            String coverName = cover.getOriginalFilename();
            InputStream videoInputStream = video.getInputStream();
            String url = request.getRequestURL().toString();
            String urlVal = url.replace("/upload", "");
            Path videoDirectory = Paths.get(uploadPath+"/video");
            if (!Files.exists(videoDirectory)) {
                Files.createDirectories(videoDirectory);
            }
            if (Files.exists(videoDirectory.resolve(videoName))) {
                File file = new File(uploadPath + "/video/" + videoName);
                file.delete();
            }
            Files.copy(videoInputStream, videoDirectory.resolve(videoName));
            String videoPath = urlVal + "/static/video/"  + videoName;
            InputStream imgInputStream = cover.getInputStream();
            Path coverDirectory = Paths.get(uploadPath+"/cover");
            if (!Files.exists(coverDirectory)) {
                Files.createDirectories(coverDirectory);
            }
            // 判断文件是否存在,存在删除
            if (Files.exists(coverDirectory.resolve(coverName))) {
                File file = new File(uploadPath + "/cover/" + coverName);
                file.delete();
            }
            // 拷贝文件
            Files.copy(imgInputStream, coverDirectory.resolve(coverName));
            // url路径
            // String path = serverConfig.getUrl() + "/" + UPLOAD_PATH + "/" + name;
            String coverPath = urlVal + "/static/cover/"  + coverName;
            Video v = new Video();
            v.setCover(coverPath);
            v.setFile(videoPath);
            v.setTitle(title);
            v.setTime(Video.getVedioTime(new File(uploadPath + "/video/" + videoName)));
            v.setUp(up);
            v.setUptime(new Date());
            System.out.println(type);
            v.setType(Integer.parseInt(type));
            videoService.insertVideo(v);
            return coverPath;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}



