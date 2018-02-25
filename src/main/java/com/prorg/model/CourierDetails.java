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

    @Column(name = "is_inflamable")
    private boolean isInflamable;

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

    public void setId(int id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isInflamable() {
        return isInflamable;
    }

    public void setInflamable(boolean inflamable) {
        isInflamable = inflamable;
    }

    public boolean isBreakable() {
        return isBreakable;
    }

    public void setBreakable(boolean breakable) {
        isBreakable = breakable;
    }

    public boolean isTobacco() {
        return isTobacco;
    }

    public void setTobacco(boolean tobacco) {
        isTobacco = tobacco;
    }

    public double getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(double estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public boolean isInsurance() {
        return isInsurance;
    }

    public void setInsurance(boolean insurance) {
        isInsurance = insurance;
    }

    public byte[] getBillPhoto() {
        return billPhoto;
    }

    public void setBillPhoto(byte[] billPhoto) {
        this.billPhoto = billPhoto;
    }
}
