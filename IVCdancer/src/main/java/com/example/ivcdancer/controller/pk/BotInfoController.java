package com.example.ivcdancer.controller.pk;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author:RammusLeo
 * @date: 2022, 07 14, 11:20
 */
@RestController
@RequestMapping("/pk/")
public class BotInfoController {

    @RequestMapping("getbotinfo/")
    public List<Map<String,String>> getBotList()
    {
        List<Map<String,String>> list = new LinkedList<>();
        Map<String,String> bot1 = new HashMap<>();
        bot1.put("name","tiger");
        bot1.put("rating","1500");
        Map<String,String> bot2 = new HashMap<>();
        bot2.put("name","monkey");
        bot2.put("rating","2500");
        list.add(bot1);
        list.add(bot2);
        return list;
    }
}
