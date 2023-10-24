package tn.esprit.SkiStationProject.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tn.esprit.SkiStationProject.entities.Course;
import tn.esprit.SkiStationProject.services.ICourseServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class CourseRestControllerTest {

    @InjectMocks
    private CourseRestController courseRestController;

    @Mock
    private ICourseServices courseServices;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddCourse() throws Exception {
        Course course = new Course();
        Mockito.when(courseServices.addCourse(any(Course.class))).thenReturn(course);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/course/add")
                .content(asJsonString(course))
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").exists()); // Replace with the appropriate JSON property.

        // Add more assertions as needed based on the expected JSON response.
    }

    @Test
    public void testGetAllCourses() throws Exception {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course());
        courses.add(new Course());

        Mockito.when(courseServices.retrieveAllCourses()).thenReturn(courses);

        mockMvc.perform(MockMvcRequestBuilders.get("/course/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(courses.size()));
    }

    @Test
    public void testUpdateCourse() throws Exception {
        Course course = new Course();
        Mockito.when(courseServices.updateCourse(any(Course.class))).thenReturn(course);

        mockMvc.perform(MockMvcRequestBuilders
                .put("/course/update")
                .content(asJsonString(course))
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").exists()); // Replace with the appropriate JSON property.

        // Add more assertions as needed based on the expected JSON response.
    }

    @Test
    public void testGetById() throws Exception {
        Course course = new Course();
        Long courseId = 1L;
        Mockito.when(courseServices.retrieveCourse(eq(courseId))).thenReturn(course);

        mockMvc.perform(MockMvcRequestBuilders.get("/course/get/{id-course}", courseId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists()) // Replace with the appropriate JSON property.
                .andExpect(jsonPath("$.id").value(course.getId()));
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
