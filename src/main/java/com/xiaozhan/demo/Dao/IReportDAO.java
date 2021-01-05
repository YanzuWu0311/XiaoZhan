package com.xiaozhan.demo.Dao;

import com.xiaozhan.demo.Entities.Report;
import com.xiaozhan.demo.Entities.ThumbUp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface IReportDAO {
    public List<Report> findAll();
    public List<Report> getByUserId(int id);
    public List<Report> getByUserAndVideo(int id1,int id2);
    public void insertReport(Report tu);
    public void deleteReport(int id);
}
