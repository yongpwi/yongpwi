package com.mudchobo.sosi.sosischedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mudchobo.sosi.sosischedule.entity.Schedule;
import com.mudchobo.sosi.sosischedule.entity.Sosi;
import com.mudchobo.sosi.sosischedule.service.SosiService;

@Controller
public class SosiController {
    private static String PREFIX = "/sosischedule";
    
    @Autowired
    private SosiService sosiService;
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index(Model model) {
        List<Sosi> sosiList = sosiService.getSosiList();
        model.addAttribute("sosiList", sosiList);
        
        return "index";
    }
    
    @RequestMapping(value="/schedule/{sosiId}", method=RequestMethod.GET)
    public String getSchedule(
            @PathVariable("sosiId") Long sosiId, 
            Model model) {
        Sosi sosi = sosiService.getSosi(sosiId);
        List<Schedule> scheduleList = sosiService.getScheduleList(sosiId);
        model.addAttribute("scheduleList", scheduleList)
            .addAttribute("sosi", sosi);
        
        return "sosi";
    }
    
    @RequestMapping(value="/schedule/{sosiId}/add", method=RequestMethod.POST)
    public String addSchedule(
            @PathVariable("sosiId") Long sosiId,
            @RequestParam("program") String program,
            Model model
            ) {
        sosiService.addSchedule(sosiId, program);
        
        return "redirect:" + PREFIX + "/schedule/" + sosiId;
    }
    
    @RequestMapping(value="/schedule/{sosiId}/{scheduleKey}", method=RequestMethod.GET)
    public String removeSchedule(
            @PathVariable("sosiId") Long sosiId,
            @PathVariable("scheduleKey") String scheduleKey,
            Model model) {
        sosiService.deleteSchedule(scheduleKey);
        
        return "redirect:" + PREFIX + "/schedule/" + sosiId;
    }
}