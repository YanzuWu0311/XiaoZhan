package com.xiaozhan.demo.Dao;

import com.xiaozhan.demo.Entities.Video;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface IVideoDao {
    public List<Video> getVideoById(int id);
    public List<Video> findAll();
    public List<Video> getVideoByTitle(String title);
    public List<Video> getUnCheckedVideo();
    public List<Video> getCheckedVideo();
    public List<Video> getVideoByType(int type);
    public void up(int id);
    public void check(int id);
    public void insertVideo(Video video);
    public void delete(int id);
    public void deleteUserVideo(String up);
}
