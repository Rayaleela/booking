package com.capg.campsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.campsite.entity.Booking;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
