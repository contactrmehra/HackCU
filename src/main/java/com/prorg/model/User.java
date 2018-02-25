package com.prorg.model;

import com.prorg.helper.contraint.FieldMatch;
import com.prorg.helper.contraint.PasswordHashMatch;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@FieldMatch(first = "password", second = "confirmPassword")
@PasswordHashMatch(passwordHash = "passwordHash", passwordSalt = "salt", passwordString = "password")
@Entity
@Table(name = "user_details")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstname")
    @Size(max = 255, min = 3)
    private String firstName;

    @Column(name = "lastname")
    @Size(max = 255, min = 1)
    private String lastName;

    @Email
    @Column(unique = true)
    @Size(max = 255, min = 7)
    private String email;

    @Column
    @NotNull
    private String salt;

    @Column(name = "passwd_hash")
    @NotNull
    private String passwordHash;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_profile_id")
    private UserProfile userProfile;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_details_id")
    private Delivery delivery;

    @Transient
    private String password;

    @Transient
    private String confirmPassword;

    public int getId() {
        return id;
    }
    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }
    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }
    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }
    public User setEmail(String email) {
        this.email = email;
        return this;

    }

    public String getSalt() {
        return salt;
    }
    public User setSalt(String salt) {
        this.salt = salt;
        return this;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
    public User setPasswordHash(String password) {
        this.passwordHash = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
    public User setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getPassword() {
        return password;
    }
    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public User setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(salt, user.salt) &&
                Objects.equals(passwordHash, user.passwordHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, salt, passwordHash, password);
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public User setDelivery(Delivery delivery) {
        this.delivery = delivery;
        return this;
    }
}