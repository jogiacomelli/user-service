package com.desafio.banco.userservice.model;

import com.desafio.banco.userservice.common.UserType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private UserType type;

    @NotNull
    private Long document;

    @NotNull
    @Min(0)
    @Max(9)
    private Integer score;
}
