package com.spring.studentmanagement.models;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "course", schema = "public")
@Entity(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_course")
    @SequenceGenerator(name = "seq_course", allocationSize = 1)
    @Column(name = "course_id", columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_course') UNIQUE")
    private Long courseId;

    @Column(name = "course_name", length = 65, nullable = false)
    private String courseName;

    @ManyToOne(targetEntity = CourseCategory.class, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "fk_course_category",
            nullable = false,
            columnDefinition = "BIGINT",
            foreignKey = @ForeignKey(name = "course_fk_course_category")
    )
    private CourseCategory courseCategory;
}
