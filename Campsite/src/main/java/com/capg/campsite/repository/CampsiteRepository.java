package com.capg.campsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.campsite.entity.Campsite;

@Repository
public interface CampsiteRepository extends JpaRepository<Campsite, Integer> {

}
