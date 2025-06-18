package com.spring.studentmanagement.controllers;

import com.spring.studentmanagement.controllers.utils.ApiConstants;
import com.spring.studentmanagement.models.AppUser;
import com.spring.studentmanagement.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final HttpServletRequest request;

    @GetMapping
    public String getUserView(Model model) {
        final HttpSession session = this.request.getSession();
        AppUser principal = (AppUser) session.getAttribute("userPrincipal");
        model.addAttribute("principal", principal);
        final List<AppUser> users = this.userService.findAllUsers();
        model.addAttribute("userList", users);
        return "users";
    }

    @GetMapping(path = "/{userId}")
    public String getUserProfile(@PathVariable(name = "userId", required = false) Long userId, Model model) {
        log.info("principal =   {} ", request.getSession().getAttribute("userPrincipal"));
        try {
            AppUser user = this.userService.getUserById(userId);
            // add user information to the model for rendering in the view
            model.addAttribute("user", user);
            return "user";
        } catch (Exception e) {
            return ApiConstants.REDIRECT_ERROR_500;
        }
    }

    @DeleteMapping
    public String deleteUser(@RequestParam("userId") Long userId) {
        this.userService.deleteUserById(userId);
        return "redirect:/users";
    }

}

