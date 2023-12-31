package com.passionproject.findmygate.repository;

import com.passionproject.findmygate.entities.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GateRepository extends JpaRepository<Gate, Integer> {

    @Query("SELECT g FROM Gate g WHERE g.name = ?1")
    Gate findByName(String dest);
}
