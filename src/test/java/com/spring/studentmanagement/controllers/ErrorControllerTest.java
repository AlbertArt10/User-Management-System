package com.spring.studentmanagement.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ErrorControllerTest {

    @InjectMocks
    private ErrorController errorController;

    @Test
    @DisplayName(
            "Should return the Internal Server Error view with the correct error title and message")
    void getInternalServerErrorViewReturnsCorrectErrorTitleAndMessage() {
        Model model = mock(Model.class);

        String viewName = errorController.getInternalServerErrorView(model);

        assertEquals("errors/error-500", viewName);
        verify(model).addAttribute("errorTitle", "Internal Server Error");
        verify(model)
                .addAttribute(
                        "errorMessage",
                        "Sorry, an internal server error has occurred. We apologize for the inconvenience. Please try again later, or contact our support team if the problem persists.");
    }
}
