package com.dev.backend.Controllers;

import com.dev.backend.Entities.Follower;
import com.dev.backend.Entities.Users;
import com.dev.backend.Services.FollowerService;
import com.dev.backend.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("follow")
public class FollowerController {

    private UserService userService;
    private FollowerService followerService;

    public FollowerController(UserService userService, FollowerService followerService) {
        this.userService = userService;
        this.followerService = followerService;
    }


    @PostMapping("add")
    public ResponseEntity<String> addFollower(@RequestParam Integer beingFollowedId,
                                              @RequestParam Integer followerId){
        Follower newFollower = new Follower();
        Users foundBeingFollowed = this.userService.getUserById(beingFollowedId);
        Users foundFollower = this.userService.getUserById(followerId);
        HttpStatus status;

        if (foundFollower!=null && foundBeingFollowed!=null){
            newFollower.setBeingFollowed(foundBeingFollowed);
            newFollower.setFollower(foundFollower);
            status = HttpStatus.OK;
            Follower result = this.followerService.addFollower(newFollower);
            return new ResponseEntity(result, status);
        }
        status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity(status);
    }




    @DeleteMapping("delete")
    public ResponseEntity<String> unfollow( @RequestParam Integer beingFollowedId,
                                            @RequestParam  Integer followerId){
        Users foundBeingFollowed = this.userService.getUserById(beingFollowedId);
        Users foundFollower = this.userService.getUserById(followerId);
        HttpStatus status;
        if (foundBeingFollowed!=null && foundFollower!=null){
            status = HttpStatus.OK;
            this.followerService.unfollow(beingFollowedId, followerId);
            return new ResponseEntity(status);
        }
        status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity(status);
    }






}
