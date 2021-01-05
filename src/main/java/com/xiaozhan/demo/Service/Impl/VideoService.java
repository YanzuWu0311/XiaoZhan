package com.xiaozhan.demo.Service.Impl;

import com.xiaozhan.demo.Dao.IUserDao;
import com.xiaozhan.demo.Dao.IVideoDao;
import com.xiaozhan.demo.Entities.User;
import com.xiaozhan.demo.Entities.Video;
import com.xiaozhan.demo.Service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService implements IVideoService {
    @Override
    public List<Video> getVideoById(int id) {
        return videoDao.getVideoById(id);
    }

    @Autowired
    private IVideoDao videoDao;

    @Override
    public List<Video> getCheckedVideo() {
        return videoDao.getCheckedVideo();
    }

    @Override
    public List<Video> getVideoByType(int type) {
        return videoDao.getVideoByType(type);
    }

    @Override
    public List<Video> findAll() {
        return videoDao.findAll();
    }

    @Override
    public void check(int id) {
        videoDao.check(id);
    }

    @Override
    public List<Video> getVideoByTitle(String Title) {
        return videoDao.getVideoByTitle(Title);
    }

    @Override
    public void deleteUserVideo(String up) {
        videoDao.deleteUserVideo(up);
    }

    @Override
    public void insertVideo(Video video) {
        videoDao.insertVideo(video);
    }

    @Override
    public List<Video> getUnCheckedVideo() {
        return videoDao.getUnCheckedVideo();
    }

    @Override
    public void delete(int i) {
        videoDao.delete(i);
    }
}
