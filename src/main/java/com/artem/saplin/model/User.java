package com.artem.saplin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    @Column(nullable = false)
    private String fio;

    @NonNull
    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    @NonNull
    private String phone;

    @Column(nullable = false, unique = true)
    @NonNull
    private String passport;

    @NonNull
    @Column(nullable = false)
    private String password;

    @NonNull
    @Column(nullable = false)
    private String roles;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<Order> orders;
}
