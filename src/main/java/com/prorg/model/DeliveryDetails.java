package com.prorg.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "delivery_details")
public class DeliveryDetails {
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

    public DeliveryDetails setId(int id) {
        this.id = id;
        return this;
    }

    public String getBoardingLocation() {
        return boardingLocation;
    }

    public DeliveryDetails setBoardingLocation(String boardingLocation) {
        this.boardingLocation = boardingLocation;
        return this;
    }

    public Date getTravellingDateTime() {
        return travellingDateTime;
    }

    public DeliveryDetails setTravellingDateTime(Date travellingDateTime) {
        this.travellingDateTime = travellingDateTime;
        return this;
    }

    public byte[] getItineraryPhoto() {
        return itineraryPhoto;
    }

    public DeliveryDetails setItineraryPhoto(byte[] itineraryPhoto) {
        this.itineraryPhoto = itineraryPhoto;
        return this;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public DeliveryDetails setMaxWeight(float maxWeight) {
        this.maxWeight = maxWeight;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public DeliveryDetails setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }
}
