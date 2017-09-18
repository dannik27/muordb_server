package com.muordb.muordb_server.service;

import com.muordb.muordb_server.entity.DemoEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class DemoEntityService {


    public ArrayList<DemoEntity> getDemoData(){
        ArrayList<DemoEntity> data = new ArrayList<>();
        data.add(new DemoEntity(1, "Vasya", LocalDate.of(2017,06,15)));
        data.add(new DemoEntity(1, "Petya", LocalDate.of(2016,06,30)));
        data.add(new DemoEntity(1, "Kolya", LocalDate.of(2015,06,14)));
        return data;
    }

}
