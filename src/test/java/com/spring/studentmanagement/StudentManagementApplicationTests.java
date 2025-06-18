package com.spring.studentmanagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootTest
class StudentManagementApplicationTests implements StudentManagementTest {
    private final Environment environment;
    private final ApplicationContext context;
    @Autowired
    public StudentManagementApplicationTests(Environment environment, ApplicationContext context) {
        this.environment = environment;
        this.context = context;
    }

    @Test
    void contextLoads() {
        Assertions.assertNotNull(context, "Application context is not configured");
    }

    @Test
    void testProfile() {
        final String failureMessage = "Tests cannot read properties from application-test.yaml!";
        final String expectedValue = "Test property";
        final String actualValue = this.environment.getProperty("custom-properties.test");
        Assertions.assertEquals(expectedValue, actualValue, failureMessage);
    }

}
