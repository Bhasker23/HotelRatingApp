package com.usermicroservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class User {

    @Id
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    @Transient
    private List<Rating> ratings = new ArrayList<>();

}
