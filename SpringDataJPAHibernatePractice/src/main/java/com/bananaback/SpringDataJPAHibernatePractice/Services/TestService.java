package com.bananaback.SpringDataJPAHibernatePractice.Services;

import com.bananaback.SpringDataJPAHibernatePractice.Models.Course;
import com.bananaback.SpringDataJPAHibernatePractice.Models.Lesson;
import com.bananaback.SpringDataJPAHibernatePractice.Models.Teacher;
import com.bananaback.SpringDataJPAHibernatePractice.Models.WithdrawTransaction;
import com.bananaback.SpringDataJPAHibernatePractice.Repositories.CourseRepository;
import com.bananaback.SpringDataJPAHibernatePractice.Repositories.LessonRepository;
import com.bananaback.SpringDataJPAHibernatePractice.Repositories.TeacherRepository;
import com.bananaback.SpringDataJPAHibernatePractice.Repositories.WithdrawTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Service
public class TestService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private WithdrawTransactionRepository withdrawTransactionRepository;
    @Autowired
    private LessonRepository lessonRepository;

    public void testCRUD() {
        // Create a teacher
        Teacher teacher = new Teacher();
        teacher.setUsername("teacher1");
        teacher.setPasswordHash("password");
        teacher.setTeacherName("John Doe");
        teacher.setEmail("john.doe@example.com");
        teacher.setDescription("English teacher");
        teacher.setCvLink("cvlink");
        teacher.setBalance(100.0);

        teacherRepository.save(teacher);

        // Create a course
        Course course = new Course();
        course.setCourseName("English 101");
        course.setCourseDescription("Basic English course");
        course.setCoverImage("coverimage");
        course.setCreatedAt(new Date());
        course.setPrice(50.0);
        course.setLevel(1);
        course.setUpdatedAt(new Date());
        course.setTeacher(teacher);

        courseRepository.save(course);

        // Create a lesson
        Lesson lesson = new Lesson();
        lesson.setTitle("Lesson1");
        lesson.setDescription("This is the first lesson");
        lesson.setVideo("lesson1.mp4");
        lesson.setCourse(course);

        lessonRepository.save(lesson);


        // Create a withdraw transaction
        WithdrawTransaction withdrawTransaction = new WithdrawTransaction();
        withdrawTransaction.setAmount(25.0);
        withdrawTransaction.setCreatedAt(new Date());
        withdrawTransaction.setTeacher(teacher);

        withdrawTransactionRepository.save(withdrawTransaction);


        Optional<Teacher> teacherOptional = teacherRepository.findByUsername("teacher1");

        teacherOptional.ifPresent(t -> {
            // Remove the associations before deleting
            t.getCourses().clear();  // Assuming you have a getCourses() method
            t.getWithdrawTransactions().clear();  // Assuming you have a getWithdrawTransactions() method

            teacherRepository.delete(t);
            // At this point, Hibernate will automatically cascade the deletion to associated courses and transactions.
        });
    }
}
