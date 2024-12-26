package com.zattera.first_spring_app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//Esses @ fazem os get e set das duas variaveis usando o lombok
@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private String email;
 }
