package com.example.msasample.mono.hotel.model.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ホテル予約用リポジトリ。
 * 
 * @author zhong
 *
 */
@Repository
public interface HotelReservationRepository extends JpaRepository<HotelReservation, Long> {

}