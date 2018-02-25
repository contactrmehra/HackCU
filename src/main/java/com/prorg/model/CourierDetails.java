package com.prorg.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "courier_details")
public class CourierDetails {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private int length;

    @NotNull
    private int width;

    @NotNull
    private int height;

    @NotNull
    private double weight;

    @NotNull
    @NotEmpty
    private String content;

    @Column(name = "is_inflammable")
    private boolean isInflammable;

    @Column(name = "is_breakable")
    private boolean isBreakable;

    @Column(name = "is_tobacco")
    private boolean isTobacco;

    @Column(name = "estimated_price")
    @NotNull
    private double estimatedPrice;

    @Column(name = "is_insurance")
    private boolean isInsurance;

    @Column(name = "bill_photo")
    @NotEmpty
    private byte[] billPhoto;

    public int getId() {
        return id;
    }

    public CourierDetails setId(int id) {
        this.id = id;
        return this;
    }

    public int getLength() {
        return length;
    }

    public CourierDetails setLength(int length) {
        this.length = length;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public CourierDetails setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public CourierDetails setHeight(int height) {
        this.height = height;
        return this;
    }

    public double getWeight() {
        return weight;
    }

    public CourierDetails setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public String getContent() {
        return content;
    }

    public CourierDetails setContent(String content) {
        this.content = content;
        return this;
    }

    public boolean isInflammable() {
        return isInflammable;
    }

    public CourierDetails setInflammable(boolean inflammable) {
        isInflammable = inflammable;
        return this;
    }

    public boolean isBreakable() {
        return isBreakable;
    }

    public CourierDetails setBreakable(boolean breakable) {
        isBreakable = breakable;
        return this;
    }

    public boolean isTobacco() {
        return isTobacco;
    }

    public CourierDetails setTobacco(boolean tobacco) {
        isTobacco = tobacco;
        return this;
    }

    public double getEstimatedPrice() {
        return estimatedPrice;
    }

    public CourierDetails setEstimatedPrice(double estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
        return this;
    }

    public boolean isInsurance() {
        return isInsurance;
    }

    public CourierDetails setInsurance(boolean insurance) {
        isInsurance = insurance;
        return this;
    }

    public byte[] getBillPhoto() {
        return billPhoto;
    }

    public CourierDetails setBillPhoto(byte[] billPhoto) {
        this.billPhoto = billPhoto;
        return this;
    }
}
