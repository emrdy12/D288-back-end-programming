package com.d288.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;


@Entity
@Table (name = "divisions" )
@Getter
@Setter
public class Division {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "division_id")
    private Long id;

    @Column (name = "division", nullable = false)
    private String division_name;

    @CreationTimestamp
    @Column (name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column (name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn (name = "country_id", nullable = false)
    private Country country;

    @OneToMany (mappedBy = "division", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Customer> customers;
}
