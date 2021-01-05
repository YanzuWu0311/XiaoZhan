package com.xiaozhan.demo.Dao;

import com.xiaozhan.demo.Entities.Admin;
import com.xiaozhan.demo.Entities.ThumbUp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IThumbUpDao {
    public List<ThumbUp> findAll();
    public List<ThumbUp> getByUserId(int id);
    public List<ThumbUp> getByUserAndVideo(int id1,int id2);
    public void insertThumbUp(ThumbUp tu);
    public void deleteThumbUp(int id);
}
