package com.spring.studentmanagement.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Cacheable
@Table(name = "course_category", schema = "public")
@Entity(name = "CourseCategory")
public class CourseCategory {
    @Id
    @Column(name = "course_category_id", columnDefinition = "BIGINT UNIQUE")
    private Long id;

    @Column(name = "course_category_name", length = 65, nullable = false)
    private String name;

}
