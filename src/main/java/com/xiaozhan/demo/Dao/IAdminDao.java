package com.xiaozhan.demo.Dao;

import com.xiaozhan.demo.Entities.Admin;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface IAdminDao {
    public List<Admin> findAll();
    public List<Admin> getAdminByUserName(String username);
    public void insertAdmin(Admin admin);
    public void deleteAdmin(int id);
}
