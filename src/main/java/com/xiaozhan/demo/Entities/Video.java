package com.xiaozhan.demo.Entities;

import ws.schild.jave.MultimediaInfo;
import ws.schild.jave.MultimediaObject;

import java.io.File;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Video implements Serializable {
    private Boolean isCheck = false;
    private String file;
    private String cover;
    private Long time;
    private int thumbs;
    private String title;
    private String up;

    @Override
    public String toString() {
        return "Video{" +
                "isCheck=" + isCheck +
                ", file='" + file + '\'' +
                ", cover='" + cover + '\'' +
                ", time=" + time +
                ", thumb=" + thumbs +
                ", title='" + title + '\'' +
                ", up='" + up + '\'' +
                ", uptime=" + uptime +
                ", id=" + id +
                ", type=" + type +
                '}';
    }

    private Date uptime;
    private int id;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public Boolean getCheck() {
        return isCheck;
    }

    public void setCheck(Boolean check) {
        isCheck = check;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public int getThumbs() {
        return thumbs;
    }

    public void setThumbs(int thumbs) {
        this.thumbs = thumbs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static Long getVedioTime(File file) {
        try {
            MultimediaObject instance = new MultimediaObject(file);
            MultimediaInfo result = instance.getInfo();
            long ls = result.getDuration() / 1000;
            return ls;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0l;
    }
}
