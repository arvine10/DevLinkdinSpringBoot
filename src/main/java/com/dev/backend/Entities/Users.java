package com.dev.backend.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
// add skills (string []), city (String), state (String)

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;

    private String password;
    private String email;
    private String phoneNumber;
    private String profileImage;
    private String userName;

    private String [] skills;

    private String state;

    private String city;

    private String title;

    private String [][] education;

    private String aboutMe;


    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Likes> allLikes;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;


    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private List<Message> sentMessages;


    @OneToMany(mappedBy = "reciver", cascade = CascadeType.ALL)
    private  List<Message> recivedMessages;


    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<Comment> allComments;


    @OneToMany(mappedBy = "beingFollowed", cascade = CascadeType.ALL)
    private List<Follower> following;


    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL)
    private List<Follower> myFollowers;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Experience> experiences;



    public Users() {
    }

    public Users(Integer id, String firstName, String lastName, String password ,String email, String phoneNumber, String profileImage, String userName) {
        this.id = id;
        this.firstName = firstName;
        this.password = password;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.profileImage = profileImage;
        this.userName = userName;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post post){
        this.posts.add(post);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public List<Message> getRecivedMessages() {
        return recivedMessages;
    }

    public void setRecivedMessages(List<Message> recivedMessages) {
        this.recivedMessages = recivedMessages;
    }


    public List<Follower> getMyFollowers() {
        return myFollowers;
    }

    public void setMyFollowers(List<Follower> myFollowers) {
        this.myFollowers = myFollowers;
    }


    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }


    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[][] getEducation() {
        return education;
    }

    public void setEducation(String[][] education) {
        this.education = education;
    }


    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
}
