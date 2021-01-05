package com.xiaozhan.demo.Service.Impl;

import com.xiaozhan.demo.Dao.IReportDAO;
import com.xiaozhan.demo.Entities.MyResult;
import com.xiaozhan.demo.Entities.Report;
import com.xiaozhan.demo.Entities.ThumbUp;
import com.xiaozhan.demo.Service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReportService implements IReportService {
    @Autowired
    IReportDAO reportDao;

    @Override
    public List<Report> findAll() {
        return reportDao.findAll();
    }

    @Override
    public List<Report> getByUserId(int id) {
        return reportDao.getByUserId(id);
    }

    @Override
    public List<Report> getByUserAndVideo(int id1, int id2) {
        return reportDao.getByUserAndVideo(id1, id2);
    }

    @Override
    public void insertReport(Report tu) {
        reportDao.insertReport(tu);
    }

    @Override
    public MyResult report(Report re) {
        Report report = new Report();
        report.setUserId(re.getUserId());
        report.setVideoId(re.getVideoId());
        report.setMsg(re.getMsg());
        MyResult result = new MyResult();
        try {
            reportDao.insertReport(report);
            result.setCode(1);
            result.setMsg("success");
        }catch(Exception e){
            e.printStackTrace();
            result.setCode(0);
            result.setMsg("failed");
        }

        return result;
    }

    @Override
    public void deleteReport(int id) {
        reportDao.deleteReport(id);
    }
}
