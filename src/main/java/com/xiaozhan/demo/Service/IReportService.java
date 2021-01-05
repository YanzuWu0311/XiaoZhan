package com.xiaozhan.demo.Service;

import com.xiaozhan.demo.Entities.MyResult;
import com.xiaozhan.demo.Entities.Report;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IReportService {
    public List<Report> findAll();
    public List<Report> getByUserId(int id);
    public List<Report> getByUserAndVideo(int id1,int id2);
    public void insertReport(Report tu);
    public void deleteReport(int id);
    public MyResult report(Report re);
}
