package com.xiaozhan.demo.Service;

import com.xiaozhan.demo.Entities.Admin;
import com.xiaozhan.demo.Entities.MyResult;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IAdminService {
    public List<Admin> findAll();
    public List<Admin> getUserByUserName(String Username);
    public MyResult login(Admin admin);
    public void insertAdmin(Admin admin);
    public MyResult register(Admin admin);
    public void deleteAdmin(int i);
}
