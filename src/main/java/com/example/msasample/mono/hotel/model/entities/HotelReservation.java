package com.example.msasample.mono.hotel.model.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * ホテルの予約情報。
 * 
 * @author zhong
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@Entity
public class HotelReservation {

	/**
	 * PK. <br>
	 * 自動採番される。
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.PRIVATE)
	private Long hotelReservationId;

	/**
	 * ホテル名称。
	 */
	private String name;

	/**
	 * チェックイン日付。
	 */
	private LocalDate checkInDate;

	/**
	 * チェックアウト日付。
	 */
	private LocalDate checkOutDate;

	/**
	 * チェックイン日時。
	 */
	private LocalDateTime checkInDateTime;

	/**
	 * チェックアウト日時。
	 */
	private LocalDateTime checkOutDateTime;

	/**
	 * 部屋番号。
	 */
	private String roomNo;
}