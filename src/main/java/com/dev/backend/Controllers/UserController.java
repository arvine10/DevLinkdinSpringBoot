package com.dev.backend.Controllers;


import com.dev.backend.Entities.Users;
import com.dev.backend.Services.ExperinceService;
import com.dev.backend.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;

    private ExperinceService experienceService;

    public UserController(UserService userService, ExperinceService experienceService){
        this.userService = userService;
        this.experienceService = experienceService;
    }


    @GetMapping("login")
    public ResponseEntity<String> getUserByEmailAndPassword(@RequestParam String email, @RequestParam String password){
        Users foundUser = this.userService.getUserByEmailAndPassword(email,password);
        HttpStatus status;
        if (foundUser!=null){
            status = HttpStatus.OK;
            System.out.println(foundUser);
            return new ResponseEntity(foundUser,status);
        }
        status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity(status);
    }


    @GetMapping("myLikedPosts")
    public ResponseEntity<String> getMyLikedPosts(@RequestParam Integer userId){
        List<Object> allPostsIds = new ArrayList<>();
        allPostsIds = this.userService.getMyLikedPosts(userId);
        HttpStatus status;
        if (allPostsIds.size()!=0){
            status = HttpStatus.OK;
            return new ResponseEntity(allPostsIds, status);
        }
        status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity(status);
    }


    @GetMapping("all")
    public List<Users> getAllUsers(){
        return this.userService.getAllUsers();
    }


    @GetMapping("{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Integer id){
        Users foundUser = this.userService.getUserById(id);
        HttpStatus status;
        if (foundUser != null){
            status = HttpStatus.OK;
            return new ResponseEntity(foundUser, status);
        } else{
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity(status);
        }
    }

    @PostMapping("add")
    public Users addUser(@RequestBody Users user){
        return this.userService.addUser(user);
    }

    @PutMapping("update")
    public Users updateUser(@RequestBody Users user){
        return this.userService.updateUser(user);
    }


    @DeleteMapping("delete")
    public ResponseEntity<String> deleteUser(@RequestBody Users user){
        boolean reutrnVal = this.userService.deleteUser(user);
        HttpStatus status;
        if (reutrnVal == true) {
            status = HttpStatus.OK;
        } else{
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity(status);
    }


    @GetMapping("followers")
    public ResponseEntity<String> getAllFollowers(@RequestParam Integer userId){
        Users foundUser = this.userService.getUserById(userId);
        HttpStatus status;
        if (foundUser!=null){
            status = HttpStatus.OK;
            List<Users> allFollowers = this.userService.getAllFollowers(userId);
            return new ResponseEntity(allFollowers,status);
        }
        status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity(status);
    }

    @GetMapping("IAmFollowing")
    public ResponseEntity<String> getAllIAmFollowing(@RequestParam Integer userId){
        Users foundUser = this.userService.getUserById(userId);
        HttpStatus status;
        if (foundUser!=null){
            List<Users> allFollowings = this.userService.getAllWhoIAmFollowing(userId);
            status = HttpStatus.OK;
            return new ResponseEntity(allFollowings, status);
        }
        status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity(status);
    }



}
