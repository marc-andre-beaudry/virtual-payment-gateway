package com.marc.vpg.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tenant")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;

    @Column
    private String name;

    @Column(nullable = false, unique = true, updatable = false)
    private String uuid;
}

