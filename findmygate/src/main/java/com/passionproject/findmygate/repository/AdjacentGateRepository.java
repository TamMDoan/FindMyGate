package com.passionproject.findmygate.repository;

import com.passionproject.findmygate.entities.AdjacentGate;
import com.passionproject.findmygate.entities.PositionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdjacentGateRepository extends JpaRepository<AdjacentGate, PositionKey> {

}
