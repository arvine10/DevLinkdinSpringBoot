package com.dev.backend.Pojos;

import com.dev.backend.Entities.Experience;

import java.util.List;

public class UserDetail {


    private List<Experience> experience;

    public UserDetail() {
    }

    public List<Experience> getExperience() {
        return experience;
    }

    public void setExperience(List<Experience> experience) {
        this.experience = experience;
    }
}
