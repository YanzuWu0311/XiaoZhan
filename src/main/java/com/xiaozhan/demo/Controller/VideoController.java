package com.xiaozhan.demo.Controller;

import com.xiaozhan.demo.Entities.*;
import com.xiaozhan.demo.Service.IReportService;
import com.xiaozhan.demo.Service.IThumbUpService;
import com.xiaozhan.demo.Service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class VideoController {
    @Autowired
    IVideoService videoService;
    @Autowired
    IThumbUpService thumbUpService;
    @Autowired
    IReportService reportService;
    @ResponseBody
    @GetMapping("/allvideo")
    public List<Video> getvideos(){
        return videoService.findAll();
    }
    @ResponseBody
    @GetMapping("/animate")
    public List<Video> getanimate(){
        return videoService.getVideoByType(0);
    }
    @ResponseBody
    @GetMapping("/learn")
    public List<Video> getlearn(){
        return videoService.getVideoByType(1);
    }
    @ResponseBody
    @GetMapping("/guichu")
    public List<Video> getguichu(){
        return videoService.getVideoByType(2);
    }
    @ResponseBody
    @GetMapping("/science")
    public List<Video> getScience(){
        return videoService.getVideoByType(3);
    }
    @ResponseBody
    @GetMapping("/dance")
    public List<Video> getdance(){
        return videoService.getVideoByType(4);
    }
    @ResponseBody
    @GetMapping("/music")
    public List<Video> getMusic(){
        return videoService.getVideoByType(5);
    }
    @ResponseBody
    @GetMapping("/amount")
    public List<Integer> getNumber(){
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i <= 5 ; i++) {
            l.add(videoService.getVideoByType(i).size());
        }
        return l;
    }

    @ResponseBody
    @PostMapping("/ThumbUp")
    public MyResult ThumbUp(@RequestBody ThumbUp up){
        return thumbUpService.up(up);
    }
    @ResponseBody
    @PostMapping("/Report")
    public MyResult Report(@RequestBody Report re){
        return reportService.report(re);
    }
}
