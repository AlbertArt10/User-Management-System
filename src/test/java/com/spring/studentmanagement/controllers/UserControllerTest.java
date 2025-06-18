package com.spring.studentmanagement.controllers;

import com.spring.studentmanagement.StudentManagementTest;
import com.spring.studentmanagement.models.AppUser;
import com.spring.studentmanagement.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.List;

import static com.spring.studentmanagement.utils.EntityFactoryTestUtils.getUserEntityList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest implements StudentManagementTest {

    @Mock
    private UserService userService;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpSession session;

    @InjectMocks
    private UserController userController;

    @Mock
    private Model model;

    @Test
    @DisplayName("Should redirect to the users page after deleting the user")
    void redirectToUsersPageAfterDeletingUser() {
        Long userId = 1L;

        String result = userController.deleteUser(userId);

        verify(userService, times(1)).deleteUserById(userId);
        assertEquals("redirect:/users", result);
    }

    @Test
    @DisplayName("Should return the user view with a list of all users")
    void getUserViewWithAllUsers() {
        List<AppUser> users = getUserEntityList();

        when(userService.findAllUsers()).thenReturn(users);
        when(this.request.getSession()).thenReturn(this.session);

        String viewName = userController.getUserView(model);

        assertEquals("users", viewName);
        verify(userService, times(1)).findAllUsers();
        verify(model, times(1)).addAttribute("userList", users);
        verify(this.session).getAttribute(anyString());
    }
}
