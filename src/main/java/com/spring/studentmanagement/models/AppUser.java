package com.spring.studentmanagement.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "app_user")
@Entity(name = "AppUser")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_app_user")
    @SequenceGenerator(name = "seq_app_user", allocationSize = 1)
    @Column(name = "user_id", columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_app_user') UNIQUE")
    private Long userId;

    @ManyToOne(targetEntity = Role.class, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "fk_role",
            nullable = false,
            columnDefinition = "BIGINT DEFAULT 1",
            foreignKey = @ForeignKey(name = "app_user_fk_role")
    )
    private Role role;

    @OneToOne(
            targetEntity = Address.class,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "fk_address",
            columnDefinition = "BIGINT NULL",
            foreignKey = @ForeignKey(name = "app_user_fk_address")
    )
    private Address address;

    @Column(name = "first_name", length = 65, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 65, nullable = false)
    private String lastName;

    @Column(name = "username", length = 45, unique = true, nullable = false)
    private String username;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "email", length = 65, unique = true, nullable = false)
    private String email;

    @Column(name = "is_enabled", nullable = false, columnDefinition = "boolean DEFAULT true")
    private boolean isEnabled;

    @Column(name = "date_added", nullable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private LocalDateTime dateAdded;

}
