package com.spring.studentmanagement.utils;

import com.spring.studentmanagement.models.AppUser;
import com.spring.studentmanagement.models.Role;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EntityFactoryTestUtils {

    private static final long ID_ONE = 1;
    private static final long ID_TWO = 2;
    private static final long ID_THREE = 3;
    public static final Role ROLE_ADMIN = Role.builder().roleId(ID_ONE).roleName("ROLE_ADMIN").build();
    public static final Role ROLE_VISITOR = Role.builder().roleId(ID_TWO).roleName("ROLE_VISITOR").build();
    public static final Role ROLE_USER = Role.builder().roleId(ID_THREE).roleName("ROLE_USER").build();

    public static final AppUser USER_TEST_ONE = AppUser.builder()
            .userId(ID_ONE)
            .role(ROLE_ADMIN)
            .firstName("John")
            .lastName("Doe")
            .username("johndoe")
            .password("password")
            .isEnabled(true)
            .dateAdded(LocalDateTime.now())
            .build();
    public static final AppUser USER_TEST_TWO = AppUser.builder()
            .userId(ID_TWO)
            .role(ROLE_USER)
            .firstName("Jane")
            .lastName("Doe")
            .username("janedoe")
            .password("password")
            .isEnabled(false)
            .dateAdded(LocalDateTime.now())
            .build();
    public static final AppUser USER_TEST_THREE = AppUser.builder()
            .userId(ID_TWO)
            .role(ROLE_VISITOR)
            .firstName("Mike")
            .lastName("Johnson")
            .username("JohnTestUser")
            .password("password")
            .isEnabled(false)
            .dateAdded(LocalDateTime.now())
            .build();

    public static List<AppUser> getUserEntityList() {
        return Arrays.asList(USER_TEST_ONE, USER_TEST_TWO, USER_TEST_THREE);
    }

}
