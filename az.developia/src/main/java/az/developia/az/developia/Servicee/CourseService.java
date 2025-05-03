package az.developia.az.developia.Servicee;

import az.developia.az.developia.info.CourseEntity;
import az.developia.az.developia.info.Teacher;
import az.developia.az.developia.repository.CourseRepository;
import az.developia.az.developia.repository.TeacherRepository;
import az.devopia.az.developia.response.StudentResponse;
import jakarta.persistence.Cacheable;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;
@Autowired
private ModelMapper modelMapper;
    
    @org.springframework.cache.annotation.Cacheable("allTeachers")
    public List<StudentResponse> getAllTeachers() {
        System.out.println("Загружаем данные из бд");
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream().map(teacher -> modelMapper.map(teacher, StudentResponse.class))
        		.collect(Collectors.toList());
    }

    


    public List<CourseEntity> findAll() {
        return courseRepository.findAll();
    }

    public Optional<CourseEntity> findById(Long id) {
        return courseRepository.findById(id);
    }

    public CourseEntity save(CourseEntity course) {
        return courseRepository.save(course);
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    public CourseEntity update(Long id, CourseEntity newCourse) {
        Optional<CourseEntity> existing = courseRepository.findById(id);
        if (existing.isPresent()) {
            CourseEntity course = existing.get();
            course.setName(newCourse.getName());
            course.setDescription(newCourse.getDescription());
            course.setDurationInWeeks(newCourse.getDurationInWeeks());
            return courseRepository.save(course);
        }
        return null;
    }

    public List<CourseEntity> search(String keyword, Pageable pageable) {
        return courseRepository.findByNameContainingIgnoreCase(keyword,pageable);
    }

    public Optional<Long> getTeacherCourse(Long teacherId) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
        if (optionalTeacher.isEmpty()) {
            return Optional.empty();
        }

        Teacher teacher = optionalTeacher.get();
        Long course = teacher.getCourseId(); 

        if (course == null) {
            return Optional.empty();
        }

        return Optional.of(course);
    }


}
