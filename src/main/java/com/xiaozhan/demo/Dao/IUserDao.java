package com.xiaozhan.demo.Dao;

import com.xiaozhan.demo.Entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IUserDao {
    public List<User> findAll();
    public List<User> getUserByUserName(String username);
    public List<User> getBannedUser();
    public void insertUser(User user);
    public void deleteUser(int id);
    public void ban(int id);
}
