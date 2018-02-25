package com.prorg.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "user_profile")
public class UserProfile {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private Date dob;

    @NotNull
    private String address;

    @NotNull
    private String state;

    @NotNull
    private String country;

    @Column(name = "government_photo_id")
    @NotNull
    @NotEmpty
    private byte[] governmentPhotoId;

    @NotNull
    @NotEmpty
    private String pinCode;

    private String occupation;

    @Column(name = "frequent_flyer")
    private boolean frequentFlyer;

    @NotNull
    @NotEmpty
    private byte[] photo;

    @Column(name = "phone_number")
    @NotNull
    @NotEmpty
    private String phoneNumber;

    @Column(name = "verified_customer")
    private boolean verifiedCustomer;

    public int getId() {
        return id;
    }

    public UserProfile setId(int id) {
        this.id = id;
        return this;
    }

    public Date getDob() {
        return dob;
    }

    public UserProfile setDob(Date dob) {
        this.dob = dob;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserProfile setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getState() {
        return state;
    }

    public UserProfile setState(String state) {
        this.state = state;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public UserProfile setCountry(String country) {
        this.country = country;
        return this;
    }

    public byte[] getGovernmentPhotoId() {
        return governmentPhotoId;
    }

    public UserProfile setGovernmentPhotoId(byte[] governmentPhotoId) {
        this.governmentPhotoId = governmentPhotoId;
        return this;
    }

    public String getPinCode() {
        return pinCode;
    }

    public UserProfile setPinCode(String pinCode) {
        this.pinCode = pinCode;
        return this;
    }

    public String getOccupation() {
        return occupation;
    }

    public UserProfile setOccupation(String occupation) {
        this.occupation = occupation;
        return this;
    }

    public boolean isFrequentFlyer() {
        return frequentFlyer;
    }

    public UserProfile setFrequentFlyer(boolean frequentFlyer) {
        this.frequentFlyer = frequentFlyer;
        return this;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public UserProfile setPhoto(byte[] photo) {
        this.photo = photo;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserProfile setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public boolean isVerifiedCustomer() {
        return verifiedCustomer;
    }

    public void setVerifiedCustomer(boolean verifiedCustomer) {
        this.verifiedCustomer = verifiedCustomer;
    }
}
