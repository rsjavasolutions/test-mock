package com.rsjava.testmock.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "users")
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private boolean active;
    private boolean superuser;

    public User(String username, boolean active, boolean superuser) {
        this.username = username;
        this.active = active;
        this.superuser = superuser;
    }
}
