package com.muordb.muordb_server.controller;

import com.muordb.muordb_server.entity.DemoEntity;
import com.muordb.muordb_server.service.DemoEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class GuestController{

    @Autowired
    DemoEntityService demoEntityService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/demodata/show")
    public ModelAndView demoData(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("data", demoEntityService.getDemoData());
        mav.setViewName("demodata");
        return mav;
    }

    @RequestMapping("/demodata/list")
    @ResponseBody
    public ArrayList<DemoEntity> demoDataList(){
        return demoEntityService.getDemoData();
    }



}
