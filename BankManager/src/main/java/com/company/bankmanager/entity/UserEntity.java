package com.company.bankmanager.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bank_manager")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    int id;

    @Column(name = "user_name")
    String name;

    @Column(name = "user_surname")
    String surName;
    @Column(name = "user_age")
    int age;

}
