package com.training.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class UserProfile 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int profileId;

	private String name;
	private char gender;
	private long contactNo;
	private boolean isAccActive;
	private double feePaid;
	private String occupation;
	private LocalDate dob;
	private LocalDateTime joinedAt;

	@OneToOne(mappedBy = "profile", fetch = FetchType.LAZY)
	private User user;
	

	public UserProfile() {
		super();
	}

	public UserProfile(int profileId, String name, char gender, long contactNo, boolean isAccActive, double feePaid,
			String occupation, LocalDate dob, LocalDateTime joinedAt) {
		super();
		this.profileId = profileId;
		this.name = name;
		this.gender = gender;
		this.contactNo = contactNo;
		this.isAccActive = isAccActive;
		this.feePaid = feePaid;
		this.occupation = occupation;
		this.dob = dob;
		this.joinedAt = joinedAt;
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public boolean isAccActive() {
		return isAccActive;
	}

	public void setAccActive(boolean isAccActive) {
		this.isAccActive = isAccActive;
	}

	public double getFeePaid() {
		return feePaid;
	}

	public void setFeePaid(double feePaid) {
		this.feePaid = feePaid;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDateTime getJoinedAt() {
		return joinedAt;
	}

	public void setJoinedAt(LocalDateTime joinedAt) {
		this.joinedAt = joinedAt;
	}

}
