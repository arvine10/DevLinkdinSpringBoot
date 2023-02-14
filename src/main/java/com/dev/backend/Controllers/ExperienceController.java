package com.dev.backend.Controllers;


import com.dev.backend.Entities.Experience;
import com.dev.backend.Entities.Users;
import com.dev.backend.Services.ExperinceService;
import com.dev.backend.Services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("experience")
public class ExperienceController {

    private ExperinceService experienceService;
    private UserService userService;

    public ExperienceController(ExperinceService experienceService, UserService userService) {
        this.experienceService = experienceService;
        this.userService = userService;
    }

    @PostMapping("add")
    public ResponseEntity<String> addExperience(@RequestBody Experience exp, @RequestParam Integer userId){
        Users foundUser = this.userService.getUserById(userId);
        HttpStatus status;
        if (foundUser != null){
            exp.setUser(foundUser);
            status = HttpStatus.OK;
            this.experienceService.addExperince(exp);
            return new ResponseEntity(exp,status);
        }
        status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity(status);
    }





//    @PatchMapping("update")
//    public ResponseEntity<String> updateExperience(@RequestBody Experience exp,
//                                                   @RequestParam Integer expId,
//                                                   @RequestParam Integer userId){
//        Experience foundExp = this.experienceService.getExperienceById(expId);
//        Users foundUser = this.userService.getUserById(userId);
//        HttpStatus status;
//
//        if (foundUser!=null && foundExp!=null){
//            status = HttpStatus.OK;
//            exp.setId(foundExp.getId());
//            exp.setUser(foundUser);
//
//            this.experienceService.updateExperience(exp);
//            return new ResponseEntity(exp,status);
//        }
//        status = HttpStatus.BAD_REQUEST;
//        return new ResponseEntity(status);
//    }


//    @DeleteMapping("{expId}")
//    public ResponseEntity<String> deleteExperience(@PathVariable Integer expId){
//        Experience foundExperience = this.experienceService.getExperienceById(expId);
//        HttpStatus status;
//        if (foundExperience!=null){
//            status = HttpStatus.OK;
//            this.experienceService.deleteExperience(expId);
//            return new ResponseEntity(status);
//        }
//        status = HttpStatus.BAD_REQUEST;
//        return new ResponseEntity(status);
//    }



}
