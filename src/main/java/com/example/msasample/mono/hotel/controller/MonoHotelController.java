package com.example.msasample.mono.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.msasample.mono.hotel.model.HotelApplicationInfo;
import com.example.msasample.mono.hotel.model.entities.HotelReservation;
import com.example.msasample.mono.hotel.services.HotelReserveService;

import lombok.extern.slf4j.Slf4j;

/**
 * ホテル予約のコントローラー。
 * 
 * @author zhong
 *
 */
@RestController
@Slf4j
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

	@DeleteMapping("/hotel/{id}")
	public void cancelHotel(@PathVariable Long id) {
		hotelReserveService.cancelHotel(id);
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public void exceptionHandler(Exception exception) {
		if (exception.getMessage().equals("満室です。")) {
			log.info(exception.getMessage());
			return;
		}
	}

}
