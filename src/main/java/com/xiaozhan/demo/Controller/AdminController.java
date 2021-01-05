package com.xiaozhan.demo.Controller;


import com.xiaozhan.demo.Entities.*;
import com.xiaozhan.demo.Service.Impl.AdminService;
import com.xiaozhan.demo.Service.Impl.ReportService;
import com.xiaozhan.demo.Service.Impl.UserService;
import com.xiaozhan.demo.Service.Impl.VideoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    @Autowired
    VideoService videoService;
    @Autowired
    ReportService reportService;
    boolean isLogin=false;
    @GetMapping
    @RequestMapping(path = "/admin/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, @RequestParam Map<String, String> map,HttpSession session){
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        System.out.println(username);
        List<Admin> lst = adminService.getUserByUserName(username);
        if(lst.size()==0){
            map.put("msg","用户名密码错误");
        }else if(!lst.get(0).getPassword().equals(password)){
            map.put("msg","用户名密码错误");
        }else{
            session.setAttribute("loginUser",username);
            isLogin=true;
            return "redirect:/admin/users";
        }
        return "adminpages/login";
    }
    @RequestMapping(path = "/admin/login", method = RequestMethod.GET)
    public String login_get(HttpServletRequest request, @RequestParam Map<String, String> map,HttpSession session){
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        System.out.println(username);
        List<Admin> lst = adminService.getUserByUserName(username);
        if(lst.size()==0){
            map.put("msg","用户名密码错误");
        }else if(!lst.get(0).getPassword().equals(password)){
            map.put("msg","用户名密码错误");
        }else{
            session.setAttribute("loginUser",username);
            isLogin=true;
            return "redirect:/admin/users";
        }
        return "adminpages/login";
    }
    @ResponseBody
    @PostMapping("/adminRegister")
    public MyResult register(@RequestBody Admin user){

        return adminService.register(user);
    }
    @GetMapping
    @RequestMapping(path = "/admin/users", method = RequestMethod.GET)
    public String starter(@RequestParam Map<String, String> map, Model model) {
        if(!isLogin){
            return "redirect:/admin/login";
        }
        if (map.size() == 0 || map.get("currentPage").isEmpty()) {
            map.put("currentPage", "0");
        }
        // 查询用户列表 及设置分页信息
        List<User> users = userService.findAll();
        // 参数为当前页码、每页显示条数、查询的列表集合
        Page<User> pageInfo = new Page<>(Integer.parseInt(map.get("currentPage")), 10, users);
        model.addAttribute("users", pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);

        return "adminpages/users";
    }
    @GetMapping
    @RequestMapping(path = "/admin/videos", method = RequestMethod.GET)
    public String video(@RequestParam Map<String, String> map, Model model) {
        if(!isLogin){
            return "redirect:/admin/login";
        }
        if (map.size() == 0 || map.get("currentPage").isEmpty()) {
            map.put("currentPage", "0");
        }
        // 查询用户列表 及设置分页信息
        List<Video> videos = videoService.findAll();
        // 参数为当前页码、每页显示条数、查询的列表集合
        Page<Video> pageInfo = new Page<>(Integer.parseInt(map.get("currentPage")), 10, videos);
        model.addAttribute("Videos", pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);

        return "adminpages/videos";
    }
    @RequestMapping(path = "/admin/checkVideos", method = RequestMethod.GET)
    public String checkVideo(@RequestParam Map<String, String> map, Model model) {
        if(!isLogin){
            return "redirect:/admin/login";
        }
        if (map.size() == 0 || map.get("currentPage").isEmpty()) {
            map.put("currentPage", "0");
        }
        // 查询用户列表 及设置分页信息
        List<Video> videos = videoService.getUnCheckedVideo();
        System.out.println(videos.size());
        // 参数为当前页码、每页显示条数、查询的列表集合
        Page<Video> pageInfo = new Page<>(Integer.parseInt(map.get("currentPage")), 10, videos);
        model.addAttribute("Videos", pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);

        return "adminpages/check";
    }
    @RequestMapping(path = "/admin/report", method = RequestMethod.GET)
    public String HandleReport(@RequestParam Map<String, String> map, Model model) {
        if(!isLogin){
            return "redirect:/admin/login";
        }
        if (map.size() == 0 || map.get("currentPage").isEmpty()) {
            map.put("currentPage", "0");
        }
        // 查询用户列表 及设置分页信息
        List<Report> reports = reportService.findAll();
        Map<Integer,String> map1 = new HashMap<>();
        for(Report r:reports){
            List<Video> v= videoService.getVideoById(r.getVideoId());
            if(v.size()>0){
                map1.put(r.getVideoId(),v.get(0).getFile());
            }
        }
        // 参数为当前页码、每页显示条数、查询的列表集合
        Page<Report> pageInfo = new Page<>(Integer.parseInt(map.get("currentPage")), 10, reports);
        model.addAttribute("Reports", pageInfo.getList());
        model.addAttribute("videos", map1);
        model.addAttribute("pageInfo", pageInfo);
        return "adminpages/report";
    }
    @RequestMapping("/admin/banuser")
    public String banuser(Integer id2,Integer id3){
        List<Video> v = videoService.getVideoById(id2);
        List<User> u = userService.getUserByUserName(v.get(0).getUp());
        userService.ban(u.get(0).getId());
        videoService.deleteUserVideo(u.get(0).getUsername());
        reportService.deleteReport(id3);
        return "redirect:/admin/report";
    }

    @RequestMapping("/admin/deleteVideo")
    public String deleteVideo(Integer id2,Integer id3){
        videoService.delete(id2);
        reportService.deleteReport(id3);
        return "redirect:/admin/report";
    }
    @RequestMapping("/admin/deleteReport")
    public String deleteReport(Integer id3){
        reportService.deleteReport(id3);
        return "redirect:/admin/report";
    }
    @RequestMapping("/admin/check")
    public String check(Integer id) {
        videoService.check(id);
        return "redirect:/admin/checkVideos";
    }

}
