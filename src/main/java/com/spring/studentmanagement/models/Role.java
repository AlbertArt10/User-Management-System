package com.spring.studentmanagement.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
@Entity(name = "Role")
@Builder
@Cacheable
public class Role {

    @Id
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role_name", length = 45, unique = true, nullable = false)
    private String roleName;
}
