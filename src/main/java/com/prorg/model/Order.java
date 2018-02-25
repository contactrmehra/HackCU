package com.prorg.model;

import com.prorg.helper.hibernate.PostgresEnumType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_details")
@TypeDef(name = "pg_sql_enum", typeClass = PostgresEnumType.class)
public class Order {
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
    @JoinColumn(name="belongs_to_user_id", nullable=false)
    private User userTheOrderBelongsTo;

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

    public User getUserTheOrderBelongsTo() {
        return userTheOrderBelongsTo;
    }

    public Order setUserTheOrderBelongsTo(User userTheOrderBelongsTo) {
        this.userTheOrderBelongsTo = userTheOrderBelongsTo;
        return this;
    }
}
