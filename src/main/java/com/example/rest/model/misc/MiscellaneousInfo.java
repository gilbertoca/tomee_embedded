package com.example.rest.model.misc;

import java.util.List;
import java.util.Map;

/**
 * @author Ravisankar C
 *
 */
public class MiscellaneousInfo {
	//Key value "100": "Fokker 100"
	private Map<String, String>  aircraft_type;
	//Key Value "QF": "Qantas Airways"
	private Map<String, String> airlines;
	private List<String> code_share_flight_range;
	private List<String> international_flight_range;
	//Key Value "GK" : "Confirmed"
	private Map<String, String> booking_status;
	//Key Value "Z" : "Premium Economy"
	private Map<String, String> cabin_classes;
	//Key Value "AVML" : "Indian style vegetarian meal"
	private Map<String, String> meal_types;
	//Key Value "W" : "Window"
	private Map<String, String> seat_type;
	//Key Value "Mr" : "Mister"
	private Map<String, String> titles;
	private List<String> voucher_booking_codes;
	
	public Map<String, String> getAircraft_type() {
		return aircraft_type;
	}
	public void setAircraft_type(Map<String, String> aircraft_type) {
		this.aircraft_type = aircraft_type;
	}
	public Map<String, String> getAirlines() {
		return airlines;
	}
	public void setAirlines(Map<String, String> airlines) {
		this.airlines = airlines;
	}
	public Map<String, String> getBooking_status() {
		return booking_status;
	}
	public void setBooking_status(Map<String, String> booking_status) {
		this.booking_status = booking_status;
	}
	public Map<String, String> getCabin_classes() {
		return cabin_classes;
	}
	public void setCabin_classes(Map<String, String> cabin_classes) {
		this.cabin_classes = cabin_classes;
	}
	public Map<String, String> getMeal_types() {
		return meal_types;
	}
	public void setMeal_types(Map<String, String> meal_types) {
		this.meal_types = meal_types;
	}
	public Map<String, String> getSeat_type() {
		return seat_type;
	}
	public void setSeat_type(Map<String, String> seat_type) {
		this.seat_type = seat_type;
	}
	public Map<String, String> getTitles() {
		return titles;
	}
	public void setTitles(Map<String, String> titles) {
		this.titles = titles;
	}
	public List<String> getVoucher_booking_codes() {
		return voucher_booking_codes;
	}
	public void setVoucher_booking_codes(List<String> voucher_booking_codes) {
		this.voucher_booking_codes = voucher_booking_codes;
	}
	public List<String> getCode_share_flight_range() {
		return code_share_flight_range;
	}
	public void setCode_share_flight_range(List<String> code_share_flight_range) {
		this.code_share_flight_range = code_share_flight_range;
	}
	public List<String> getInternational_flight_range() {
		return international_flight_range;
	}
	public void setInternational_flight_range(List<String> international_flight_range) {
		this.international_flight_range = international_flight_range;
	}
	
}
