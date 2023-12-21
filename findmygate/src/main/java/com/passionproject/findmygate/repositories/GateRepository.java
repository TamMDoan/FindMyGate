package com.passionproject.findmygate.repositories;

import com.passionproject.findmygate.entities.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GateRepository extends JpaRepository<Gate, String> {
    Gate findGateByName(String name);
}
