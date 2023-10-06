package com.bananaback.SpringDataJPAHibernatePractice.Repositories;

import com.bananaback.SpringDataJPAHibernatePractice.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
