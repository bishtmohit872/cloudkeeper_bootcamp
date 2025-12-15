package com.example.backend.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    @Email
    private String email;

    @Column(unique = true)
    private String username;

    private String password;

    private LocalTime lastLogin;
    private Boolean isActive;

    @ManyToMany(mappedBy = "users")
    private List<AwsAccountEntity> awsAccount;


    public enum Role{
        Admin,Customer,ReadOnly,
    }

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDateTime timestamp;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }


}





