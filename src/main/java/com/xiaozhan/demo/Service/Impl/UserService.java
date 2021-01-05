package com.xiaozhan.demo.Service.Impl;


import com.xiaozhan.demo.Dao.IUserDao;
import com.xiaozhan.demo.Entities.MyResult;
import com.xiaozhan.demo.Entities.User;
import com.xiaozhan.demo.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public List<User> getUserByUserName(String username) {
        return userDao.getUserByUserName(username);
    }

    @Override
    public void insertUser(User user) { userDao.insertUser(user); }

    @Override
    public void deleteUser(int i) {
        userDao.deleteUser(i);
    }

    @Override
    public void ban(int id) {
        userDao.ban(id);
    }

    @Override
    public List<User> getBannedUser() {
        return userDao.getBannedUser();
    }

    @Override
    public MyResult login(User user) {
        User u = new User();
        List<User> list = new ArrayList<>();
        list = userDao.getUserByUserName(user.username);
        MyResult result = new MyResult();
        if (list.size() != 0) {
            result.setCode(0);
            result.setMsg("success");
            result.setList(list);
            result.setObj(list.get(0));
            System.out.println(result.getObj());
        } else {
            result.setCode(1);
            result.setMsg("failed");
        }
        return result;
    }

    @Override
    public MyResult register(User user) {
        List<User> list = new ArrayList<>();
        list = userDao.getUserByUserName(user.username);
        MyResult result = new MyResult();
        user.setIsbanned(false);
        System.out.println(list);
        if(list.size()!=0){
            result.setCode(1);
            result.setMsg("failed");
        }else{
            userDao.insertUser(user);
            result.setCode(0);
            result.setMsg("success");
        }
        return result;
    }
}
