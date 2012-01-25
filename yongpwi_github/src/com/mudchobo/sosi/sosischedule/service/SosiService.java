package com.mudchobo.sosi.sosischedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mudchobo.sosi.sosischedule.dao.SosiDao;
import com.mudchobo.sosi.sosischedule.entity.Schedule;
import com.mudchobo.sosi.sosischedule.entity.Sosi;

@Service
public class SosiService {
    
    @Autowired
    private SosiDao sosiDao;
    
    public List<Sosi> getSosiList()
    {
        return sosiDao.getSosiList(); 
    }
    
    public Sosi getSosi(Long sosiId) {
        return sosiDao.getSosi(sosiId);
    }
    
    public List<Schedule> getScheduleList(Long sosiId) {
        return sosiDao.getScheduleList(sosiId);
    }
    
    public void deleteSchedule(String scheduleKey) {
        sosiDao.deleteSchedule(scheduleKey);
    }

    public void addSchedule(Long sosiId, String program) {
        sosiDao.addSchedule(sosiId, program);
    }
}