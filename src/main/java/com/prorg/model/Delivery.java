package com.prorg.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "delivery_details")
public class Delivery {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "boarding_location")
    @NotNull
    private String boardingLocation;

    @Column(name = "travelling_date_time", columnDefinition= "TIMESTAMP WITH TIME ZONE")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date travellingDateTime;

    @Column(name = "itinerary_photo")
    @NotNull
    private byte[] itineraryPhoto;

    @Column(name = "max_weight")
    @NotNull
    private double maxWeight;

    private String remarks;

    public int getId() {
        return id;
    }

    public Delivery setId(int id) {
        this.id = id;
        return this;
    }

    public String getBoardingLocation() {
        return boardingLocation;
    }

    public Delivery setBoardingLocation(String boardingLocation) {
        this.boardingLocation = boardingLocation;
        return this;
    }

    public Date getTravellingDateTime() {
        return travellingDateTime;
    }

    public Delivery setTravellingDateTime(Date travellingDateTime) {
        this.travellingDateTime = travellingDateTime;
        return this;
    }

    public byte[] getItineraryPhoto() {
        return itineraryPhoto;
    }

    public Delivery setItineraryPhoto(byte[] itineraryPhoto) {
        this.itineraryPhoto = itineraryPhoto;
        return this;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public Delivery setMaxWeight(float maxWeight) {
        this.maxWeight = maxWeight;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public Delivery setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }
}
