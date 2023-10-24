package tn.esprit.SkiStationProject.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tn.esprit.SkiStationProject.entities.Course;
import tn.esprit.SkiStationProject.repositories.CourseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

public class CourseServiceImplTest {

    @InjectMocks
    private CourseServicesImpl courseServices;

    @Mock
    private CourseRepository courseRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllCourses() {
        // Create sample course data
        List<Course> courses = new ArrayList<>();
        courses.add(new Course());
        courses.add(new Course());

        // Mock the behavior of the courseRepository
        Mockito.when(courseRepository.findAll()).thenReturn(courses);

        List<Course> retrievedCourses = courseServices.retrieveAllCourses();
        // Add assertions to check if the retrieved courses match the expected data
        assertEquals(2, retrievedCourses.size());
    }

    @Test
    public void testAddCourse() {
        Course course = new Course();
        Mockito.when(courseRepository.save(any(Course.class))).thenReturn(course);

        Course addedCourse = courseServices.addCourse(course);
        // Add assertions to check if the added course matches the expected data
        assertEquals(course, addedCourse);
    }

    @Test
    public void testUpdateCourse() {
        Course course = new Course();
        Mockito.when(courseRepository.save(any(Course.class))).thenReturn(course);

        Course updatedCourse = courseServices.updateCourse(course);
        // Add assertions to check if the updated course matches the expected data
        assertEquals(course, updatedCourse);
    }

    @Test
    public void testRetrieveCourse() {
        Course course = new Course();
        Long courseId = 1L;
        Mockito.when(courseRepository.findById(eq(courseId))).thenReturn(Optional.of(course));

        Course retrievedCourse = courseServices.retrieveCourse(courseId);
        // Add assertions to check if the retrieved course matches the expected data
        assertEquals(course, retrievedCourse);
    }
}
