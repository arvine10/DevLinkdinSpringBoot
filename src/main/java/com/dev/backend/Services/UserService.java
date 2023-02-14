package com.dev.backend.Services;

import com.dev.backend.Entities.Message;
import com.dev.backend.Entities.Users;
import com.dev.backend.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers(){
        return this.userRepository.findAll();
    }

    public Users getUserById(Integer id){
        return this.userRepository.findById(id).orElse(null);
    }


    public Users addUser(Users user){
       return this.userRepository.save(user);
    }


    public Users updateUser(Users user){
        if (this.userRepository.findById(user.getId()).orElse(null)!=null){
            return this.userRepository.save(user);
        } return null;
    }


    public boolean deleteUser(Users user){
        if (this.userRepository.findById(user.getId()).orElse(null)!=null){
             this.userRepository.delete(user);
             return true;
        } return false;
    }


    public List<Users> getAllFollowers(Integer userId){
        return this.userRepository.getAllFollowers(userId);
    }


    public List<Users> getAllWhoIAmFollowing(Integer userId){
        return this.userRepository.getWhoIAmFollowing(userId);
    }


    public Users getUserByEmailAndPassword(String email, String password){
        return this.userRepository.getUserByEmailAndPassword(email,password);
    }


    public List<Object> getMyLikedPosts(Integer userId){
        return this.userRepository.getMyLikedPosts(userId);
    }



}
