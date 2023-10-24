package tn.esprit.SkiStationProject.entities;

import org.junit.jupiter.api.Test;

import tn.esprit.SkiStationProject.entities.enums.Support;
import tn.esprit.SkiStationProject.entities.enums.TypeCourse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CourseTest {

    @Test
    public void testCourseEntity() {
        // Create a sample Course object
        Course course = new Course();
        course.setLevel(1);
        course.setTypeCourse(TypeCourse.COLLECTIVE_CHILDREN);
        course.setSupport(Support.SKI);
        course.setPrice(100.0F);
        course.setTimeSlot(1);

        // Create a sample Registration
        Registration registration = new Registration();
        // Set registration properties here

        // Add the registration to the course
        course.getRegistrations().add(registration);
        registration.setCourse(course);

        // Perform assertions
        assertNotNull(course.getId());
        assertEquals(1, course.getLevel());
        assertEquals(TypeCourse.COLLECTIVE_CHILDREN, course.getTypeCourse());
        assertEquals(Support.SKI, course.getSupport());
        assertEquals(100.0F, course.getPrice(), 0.001); // You can specify a delta for floating-point comparisons.
        assertEquals(1, course.getTimeSlot());
        assertNotNull(course.getRegistrations());
        assertEquals(1, course.getRegistrations().size());
    }
}
