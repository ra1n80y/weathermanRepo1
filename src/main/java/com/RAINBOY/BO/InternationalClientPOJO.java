package com.RAINBOY.BO;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name = "GlobalClientData")//For table creation only, updates don't need it
public class InternationalClientPOJO
{
    @Id
    @Column(name = "ID")//For table creation only, updates don't need it
    private int ID;

    @Column(name = "AGE")
    private int AGE;

    @Column(name = "NAME")
    private String NAME;

    @Column(name = "COUNTRY")
    private String COUNTRY;
}
