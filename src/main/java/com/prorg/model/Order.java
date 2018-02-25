package com.prorg.model;

import com.prorg.helper.hibernate.PostgresEnumType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "order_details")
@TypeDef(name = "pg_sql_enum", typeClass = PostgresEnumType.class)
public class Order {
    private static final int MASKING_NUMBER = 1234566789;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "order_status_type")
    @Type(type = "pg_sql_enum")
    private StatusType status;

    @Column(name = "last_update_on", columnDefinition= "TIMESTAMP WITH TIME ZONE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateOn;

    @Column(name = "last_location")
    private String lastLocation;

    @ManyToOne
    @JoinColumn(name="placed_by_user_id", nullable=false)
    private User placedBy;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carrier_id")
    private User carrier;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_details_id")
    private CourierDetails courierDetails;

    public int getId() {
        return id;
    }

    public Order setId(int id) {
        this.id = id;
        return this;
    }

    public StatusType getStatus() {
        return status;
    }

    public Order setStatus(StatusType status) {
        this.status = status;
        return this;
    }

    public Date getLastUpdateOn() {
        return lastUpdateOn;
    }

    public Order setLastUpdateOn(Date lastUpdateOn) {
        this.lastUpdateOn = lastUpdateOn;
        return this;
    }

    public String getLastLocation() {
        return lastLocation;
    }

    public Order setLastLocation(String lastLocation) {
        this.lastLocation = lastLocation;
        return this;
    }

    public User getPlacedBy() {
        return placedBy;
    }

    public Order setPlacedBy(User placedBy) {
        this.placedBy = placedBy;
        return this;
    }

    public User getCarrier() {
        return carrier;
    }

    public Order setCarrier(User carrier) {
        this.carrier = carrier;
        return this;
    }

    public CourierDetails getCourierDetails() {
        return courierDetails;
    }

    public Order setCourierDetails(CourierDetails courierDetails) {
        this.courierDetails = courierDetails;
        return this;
    }

    public int getMaskedId() {
        return MASKING_NUMBER + id;
    }

    public static int unMaskId(int maskedId) {
        return maskedId - MASKING_NUMBER;
    }
}
