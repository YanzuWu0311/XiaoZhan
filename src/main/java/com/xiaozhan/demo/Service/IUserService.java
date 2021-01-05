package com.xiaozhan.demo.Service;


import com.xiaozhan.demo.Entities.MyResult;
import com.xiaozhan.demo.Entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    public List<User> findAll();
    public List<User> getUserByUserName(String Username);
    public MyResult login(User user);
    public void insertUser(User user);
    public MyResult register(User user);
    public void deleteUser(int i);
    public void ban(int id);
    public List<User> getBannedUser();
}
