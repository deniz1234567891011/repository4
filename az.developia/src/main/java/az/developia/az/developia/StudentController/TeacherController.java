package az.developia.az.developia.StudentController;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import az.developia.az.developia.Servicee.TeacherService;
import az.developia.az.developia.exception.MyException;
import az.developia.az.developia.info.CourseEntity;
import az.developia.az.developia.info.Teacher;
import az.devopia.az.developia.response.StudentResponse;
import jakarta.validation.Valid;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService service;

    @GetMapping("/get-all")
    public List<StudentResponse> findAll() {
        return service.getAllTeacher();
    }

    @GetMapping("/{id}")
    public Optional<CourseEntity> findById(@Valid @PathVariable Long id) {
    	return Optional.ofNullable(service.getTeacherCourse(id).orElseThrow((() -> new MyException("teacher not found"))));
    }

    @PostMapping("/add")
    public void save(@Valid @RequestBody Teacher teacher) {
        service.saveTeachers(teacher);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteTeacher(id);
    }

    @PutMapping("/update/{id}")
    public Teacher update(@PathVariable Long id, @RequestBody Teacher teacher) {
        return service.updateTeacher(id, teacher);
    }
    @GetMapping("/search")
    public List<Teacher> searchList(@RequestParam String q){
    	return service.searchTeachers(q);
    }
    
    @GetMapping("/{id}/course")
    public Optional<CourseEntity> getTeacherCourse(@PathVariable Long id) {
    	return service.getTeacherCourse(id);
    }
}
