package az.developia.az.developia.StudentController;

import az.developia.az.developia.info.CourseEntity;
import az.devopia.az.developia.response.StudentResponse;
import jakarta.validation.Valid;
import az.developia.az.developia.Servicee.CourseService;
import az.developia.az.developia.Servicee.TeacherService;
import az.developia.az.developia.exception.MyException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;
@Autowired
private TeacherService teacherService;
@GetMapping("/get-all")
public List<StudentResponse> getAllCourses() {
    return courseService.getAllTeachers();
}


    @GetMapping("/get/{id}")
    public Optional<Long> getCourseById(@PathVariable Long id) {
        return Optional.ofNullable(courseService.getTeacherCourse(id).orElseThrow((() -> new MyException("course not found"))));
    }

    @PostMapping("/add")
    public CourseEntity createCourse(@RequestBody CourseEntity course) {
        return courseService.save(course);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.delete(id);
    }

    @GetMapping("/search")
    public List<CourseEntity> searchCourses(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return courseService.search(keyword, pageable);
    }
    
    @GetMapping("/{id}/course")
    public Optional<Long> getTeacherCourse(@PathVariable Long id) {
        return courseService.getTeacherCourse(id);
    }

    	
    
}
