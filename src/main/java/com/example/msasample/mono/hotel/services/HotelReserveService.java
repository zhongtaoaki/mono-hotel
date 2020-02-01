package com.example.msasample.mono.hotel.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.msasample.mono.hotel.model.HotelApplicationInfo;
import com.example.msasample.mono.hotel.model.entities.HotelReservation;
import com.example.msasample.mono.hotel.model.entities.HotelReservationRepository;

/**
 * ホテル予約サービス。
 * 
 * @author zhong
 *
 */
@Service
public class HotelReserveService {

	@Autowired
	private HotelReservationRepository hotelReservationRepository;

	/**
	 * ホテル予約を行う。
	 * 
	 * @param HotelApplicationInfo
	 * @return HotelReservation
	 */
	@Transactional
	public HotelReservation reserveHotel(HotelApplicationInfo hotelApplicationInfo) {

		if (hotelReservationRepository.count() > 5) {
			throw new RuntimeException("満室です。");
		}

		HotelReservation hotelReservation = HotelReservation.builder()//
				.name(hotelApplicationInfo.getName())//
				.checkInDate(hotelApplicationInfo.getCheckInDate())//
				.checkInDateTime(LocalDateTime.now())//
				.checkOutDate(hotelApplicationInfo.getCheckOutDate())//
				.checkOutDateTime(LocalDateTime.now())//
				.roomNo("101")//
				.build();

		return hotelReservationRepository.saveAndFlush(hotelReservation);
	}

	@Transactional
	public void cancelHotel(Long id) {
		hotelReservationRepository.deleteById(id);
	}

}
