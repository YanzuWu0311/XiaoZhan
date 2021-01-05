package com.xiaozhan.demo.Service.Impl;

import com.xiaozhan.demo.Dao.IAdminDao;
import com.xiaozhan.demo.Dao.IAdminDao;
import com.xiaozhan.demo.Entities.Admin;
import com.xiaozhan.demo.Entities.MyResult;
import com.xiaozhan.demo.Entities.Admin;
import com.xiaozhan.demo.Service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService implements IAdminService {
    @Autowired
    private IAdminDao adminDao;

    @Override
    public List<Admin> findAll() {
        return adminDao.findAll();
    }

    @Override
    public List<Admin> getUserByUserName(String Username) {
        return adminDao.getAdminByUserName(Username);
    }


    @Override
    public void insertAdmin(Admin admin) {
       adminDao.insertAdmin(admin);
    }


    @Override
    public void deleteAdmin(int i) {
        adminDao.deleteAdmin(i);
    }

    @Override
    public MyResult login(Admin admin) {
        Admin u = new Admin();
        List<Admin> list = new ArrayList<>();
        list = adminDao.getAdminByUserName(u.username);
        MyResult result = new MyResult();
        if (list.size() != 0) {
            result.setCode(0);
            result.setMsg("success");
            result.setList(list);
            result.setObj(list.get(0));
        } else {
            result.setCode(1);
            result.setMsg("failed");
        }
        return result;
    }

    @Override
    public MyResult register(Admin Admin) {
        List<Admin> list = new ArrayList<>();
        list = adminDao.getAdminByUserName(Admin.username);
        MyResult result = new MyResult();
        System.out.println(list);
        if (list == null) {
            result.setCode(1);
            result.setMsg("failed");
        } else {
            adminDao.insertAdmin(Admin);
            result.setCode(0);
            result.setMsg("success");
        }
        return result;
    }
}
