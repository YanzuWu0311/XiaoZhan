package com.xiaozhan.demo.Service;

import com.xiaozhan.demo.Entities.MyResult;
import com.xiaozhan.demo.Entities.ThumbUp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IThumbUpService {
    public List<ThumbUp> findAll();
    public List<ThumbUp> getByUserId(int i);
    public void insertThumbUp(ThumbUp tu);
    public void deleteThumbUp(int id);
    public List<ThumbUp> getByUserAndVideo(int id1,int id2);
    public MyResult up(ThumbUp up);
}
