package com.bananaback.SpringDataJPAHibernatePractice.Repositories;

import com.bananaback.SpringDataJPAHibernatePractice.Models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
