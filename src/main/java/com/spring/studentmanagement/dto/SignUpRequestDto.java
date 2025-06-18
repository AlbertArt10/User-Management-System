package com.spring.studentmanagement.dto;

import com.spring.studentmanagement.models.AppUser;
import com.spring.studentmanagement.models.Role;
import lombok.Data;
import lombok.ToString;

@Data
public class SignUpRequestDto {

    private String username;
    private String email;
    private @ToString.Exclude String password;
    private @ToString.Exclude String confirmPassword;
    private String firstName;
    private String lastName;
    private long roleId;


    public boolean passwordMatches() throws NullPointerException {
        return this.password.equals(this.confirmPassword);
    }

    public AppUser toUser() {
        final Role role = Role.builder().roleId(this.roleId).build();
        return AppUser.builder()
                .username(this.username)
                .email(this.email)
                .password(this.password)
                .firstName(this.firstName)
                .lastName(this.lastName)
                .role(role)
                .isEnabled(true)
                .build();

    }

}
