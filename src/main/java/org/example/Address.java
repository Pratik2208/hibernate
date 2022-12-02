package org.example;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
public class Address {

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", isOpen=" + isOpen +
                ", x=" + x +
                ", addedDate=" + addedDate +
                ", image=" + Arrays.toString(image) +
                '}';
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Address(int addressId, String street, String city, boolean isOpen, Double x, Date addedDate, byte[] image) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.isOpen = isOpen;
        this.x = x;
        this.addedDate = addedDate;
        this.image = image;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    @Column(name = "STREET")
    private String street;

    @Column(length = 100 , name = "CITY")
    private String city;

    @Column(name = "is_open")
    private boolean isOpen;

    @Transient
    private Double x;

    @Temporal(TemporalType.DATE)
    private Date addedDate;

    @Lob
    private byte[] image;
}
