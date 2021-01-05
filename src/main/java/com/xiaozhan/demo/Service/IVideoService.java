package com.xiaozhan.demo.Service;
import com.xiaozhan.demo.Entities.Video;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IVideoService {
    public List<Video> findAll();
    public List<Video> getVideoByTitle(String Title);
    public List<Video> getCheckedVideo();
    public List<Video> getVideoByType(int type);
    public List<Video> getVideoById(int id);
    public List<Video> getUnCheckedVideo();
    public void insertVideo(Video video);
    public void check(int id);
    public void delete(int id);
    public void deleteUserVideo(String up);
}
