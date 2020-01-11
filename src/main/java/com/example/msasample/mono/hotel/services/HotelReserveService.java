package com.example.msasample.mono.hotel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

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
	public HotelReservation reserveHotel(HotelApplicationInfo hotelApplicationInfo) {

		HotelReservation example = HotelReservation.builder()//
				.name(hotelApplicationInfo.getName())//
				.checkInDate(hotelApplicationInfo.getCheckInDate())//
				.checkOutDate(hotelApplicationInfo.getCheckOutDate())//
				.build();

		return hotelReservationRepository.findOne(Example.of(example)).orElseThrow();
	}
}
