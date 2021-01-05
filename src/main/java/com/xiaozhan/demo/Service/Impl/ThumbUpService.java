package com.xiaozhan.demo.Service.Impl;

import com.xiaozhan.demo.Dao.IThumbUpDao;
import com.xiaozhan.demo.Dao.IVideoDao;
import com.xiaozhan.demo.Entities.MyResult;
import com.xiaozhan.demo.Entities.ThumbUp;
import com.xiaozhan.demo.Entities.Video;
import com.xiaozhan.demo.Service.IThumbUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ThumbUpService implements IThumbUpService {
    @Autowired
    IThumbUpDao thumbUpDao;
    @Autowired
    IVideoDao videoDao;
    @Override
    public List<ThumbUp> findAll() {
        return thumbUpDao.findAll();
    }

    @Override
    public List<ThumbUp> getByUserId(int i) {
        return thumbUpDao.getByUserId(i);
    }

    @Override
    public List<ThumbUp> getByUserAndVideo(int id1, int id2) {
        return null;
    }

    @Override
    public void insertThumbUp(ThumbUp tu) {
        thumbUpDao.insertThumbUp(tu);
    }

    @Override
    public void deleteThumbUp(int id) {
        thumbUpDao.deleteThumbUp(id);
    }
    @Override
    public MyResult up( ThumbUp up){
        ThumbUp up1 = new ThumbUp();
        up1.setUserId(up.getUserId());
        up1.setVideoId(up.getVideoId());
        videoDao.up(up.getVideoId());
        up1.setTime(new Date());
        up1.setValue(true);
        MyResult result = new MyResult();
        List<ThumbUp> l = thumbUpDao.getByUserAndVideo(up.getUserId(),up.getVideoId());
        if(l.size()==0){
            thumbUpDao.insertThumbUp(up1);
            result.setCode(1);
            result.setMsg("success");
        }
        else{
            result.setCode(0);
            result.setMsg("failed");
        }
        return result;
    }
}
