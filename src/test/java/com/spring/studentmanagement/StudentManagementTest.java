package com.spring.studentmanagement;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ActiveProfiles(value = "test")
@ContextConfiguration(classes = {StudentManagementApplication.class})
public interface StudentManagementTest {
}
