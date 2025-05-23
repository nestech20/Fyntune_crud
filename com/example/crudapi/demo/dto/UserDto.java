package com.example.crudapi.demo.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.example.crudapi.demo.enums.Gender;
import com.example.crudapi.demo.enums.Title;

public class UserDto {

	private String fullName;

	private Date dob;


	private Gender gender;

	private Title title;


	private String panNo;

	private Long annualIncome;

	private String mobileNo;

	private String email;

	private String alternateNo;

	private String address;

	private Long pincode;

	private String city;

	private String state;

	private Character status;
	
	private LocalDateTime createdDate;

	private LocalDateTime updatedDate;
	
	private Character isUpdatingNominee;

    private  List<NomineeDto> nominees;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public Long getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(Long annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAlternateNo() {
		return alternateNo;
	}

	public void setAlternateNo(String alternateNo) {
		this.alternateNo = alternateNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<NomineeDto> getNominees() {
		return nominees;
	}

	public void setNominees(List<NomineeDto> nominees) {
		this.nominees = nominees;
	}

	public Character getIsUpdatingNominee() {
		return isUpdatingNominee;
	}

	public void setIsUpdatingNominee(Character isUpdatingNominee) {
		this.isUpdatingNominee = isUpdatingNominee;
	}


	
}
