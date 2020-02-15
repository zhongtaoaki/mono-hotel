package com.example.msasample.mono.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.msasample.mono.hotel.model.HotelApplicationInfo;
import com.example.msasample.mono.hotel.model.entities.HotelReservation;
import com.example.msasample.mono.hotel.services.HotelReserveService;


/**
 * ホテル予約のコントローラー。
 * 
 * @author zhong
 *
 */
@RestController
public class MonoHotelController {

	@Autowired
	private HotelReserveService hotelReserveService;

	/**
	 * ホテル予約を行う。
	 * 
	 * @return HotelReservation
	 */
	@PostMapping("/hotel")
	public HotelReservation reserveHotel(@RequestBody HotelApplicationInfo hotelApplicationInfo) {
		return hotelReserveService.reserveHotel(hotelApplicationInfo);
	}
	
	@DeleteMapping("/hotel/{hotelReservationId}")
	public void deleteHotel(@PathVariable Long hotelReservationId) {
		hotelReserveService.deleteHotel(hotelReservationId);
	}
}
