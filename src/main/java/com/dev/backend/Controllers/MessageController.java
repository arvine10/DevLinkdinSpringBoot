package com.dev.backend.Controllers;


import com.dev.backend.Entities.Message;
import com.dev.backend.Entities.Users;
import com.dev.backend.Services.MessageService;
import com.dev.backend.Services.UserService;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("message")
public class MessageController {

    private MessageService messageService;
    private UserService userService;

    public MessageController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }



    @PostMapping("add")
    public ResponseEntity<String> addMessage(@RequestBody Message msg, @RequestParam Integer sender_id, @RequestParam Integer reciver_id){
        Users foundSender = this.userService.getUserById(sender_id);
        Users foundReciver = this.userService.getUserById(reciver_id);
        HttpStatus status;
        if (foundReciver != null && foundSender != null){
            msg.setSender(foundSender);
            msg.setReciver(foundReciver);
            this.messageService.addMessage(msg);
            status = HttpStatus.OK;
            return new ResponseEntity(msg, status);
        }
        status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity(status);
    }

}
