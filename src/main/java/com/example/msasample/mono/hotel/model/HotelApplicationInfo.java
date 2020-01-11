package com.example.msasample.mono.hotel.model;

import java.time.LocalDate;

import lombok.Data;

/**
 * 予約サービスからのホテル予約情報。
 * 
 * @author zhong
 *
 */
@Data
public class HotelApplicationInfo {
	/**
	 * ホテル名。
	 */
	private String name;

	/**
	 * チェックイン日。
	 */
	private LocalDate checkInDate;

	/**
	 * チェックアウト日。
	 */
	private LocalDate checkOutDate;
}
