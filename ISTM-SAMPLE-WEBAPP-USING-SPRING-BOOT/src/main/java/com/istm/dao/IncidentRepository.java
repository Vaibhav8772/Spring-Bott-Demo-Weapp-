package com.istm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.istm.entities.Incident;

public interface IncidentRepository extends JpaRepository<Incident, Integer> {

}
