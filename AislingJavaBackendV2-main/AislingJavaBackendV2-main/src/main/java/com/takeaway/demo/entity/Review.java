package com.takeaway.demo.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private int rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "creationDate")
    @CreationTimestamp
    private Date creationDate;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customerReview")
    @PrimaryKeyJoinColumn
    private Order customerOrder;

    public Review(){

    }

    public Review(String name, int rating, String comment, Order customerOrder) {
        this.customerOrder = customerOrder;
        this.name = name;
        this.rating = rating;
        this.comment = comment;
    }

    //getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    public String getComment() {
        return comment;
    }


    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Order getCustomerOrder() {
        return customerOrder;
    }
    public void setCustomerOrder(Order customerOrder) {
        this.customerOrder = customerOrder;
    }

    //toString
    @Override
    public String toString() {
        return "Review{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }

}

