package com.muordb.muordb_server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GuestController{

    @RequestMapping("/")
    public String index() {
        return "index";
    }

}