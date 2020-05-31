package com.desafio.banco.userservice.model;

import com.desafio.banco.userservice.common.UserType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class User {
    @Id
    private Long document; // TODO validar se PJ 14 numeros, se PF 11 numeros

    @NotNull
    private UserType type;

    @NotNull
    private String name;

    @NotNull
    @Min(0)
    @Max(9)
    private Integer score;
}
