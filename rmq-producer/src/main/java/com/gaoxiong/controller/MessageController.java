package com.gaoxiong.controller;

import com.gaoxiong.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoxiong
 * @ClassName MessageController
 * @Description TODO
 * @date 2019/7/30 11:52
 */
@RestController
public class MessageController {

    @Autowired
    private SendMessageService sendMessageService;

    @GetMapping("/send")
     public String send(){
        sendMessageService.sendMsg();
        return "success";
    }

}
