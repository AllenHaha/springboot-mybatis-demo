package com.wzl.springbootmybatisdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Data
public class User {
    private Integer id;
    private String lastName;
    private String email;
}
