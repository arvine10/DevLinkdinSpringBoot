package com.dev.backend.Services;

import com.dev.backend.Entities.Experience;
import com.dev.backend.Repositories.ExperinceRepository;
import org.springframework.stereotype.Service;

@Service
public class ExperinceService {

    private ExperinceRepository experinceRepository;

    public ExperinceService(ExperinceRepository experinceRepository) {
        this.experinceRepository = experinceRepository;
    }

    public Experience addExperince(Experience exp){
        return this.experinceRepository.save(exp);
    }


}
