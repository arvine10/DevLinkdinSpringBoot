package com.dev.backend.Repositories;

import com.dev.backend.Entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ExperinceRepository extends JpaRepository<Experience, Integer> {
}
