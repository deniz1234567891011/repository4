package az.developia.az.developia.Servicee;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import az.developia.az.developia.repository.CourseRepository;
import az.developia.az.developia.repository.TeacherRepository;
import az.devopia.az.developia.response.StudentResponse;
import ch.qos.logback.classic.Logger;
import az.developia.az.developia.info.CourseEntity;
import az.developia.az.developia.info.Teacher;


@Service
public class TeacherService {


	@Autowired
	TeacherRepository teacherR;
	@Autowired
	CourseRepository cRepository;

	
	
	
    public List<StudentResponse> getAllTeacher() {
        List<Teacher> teachers = teacherR.findAll();
        List<StudentResponse> responses = new ArrayList<>();

        for (Teacher teacher : teachers) {
        	StudentResponse response = new StudentResponse();
            response.setName(teacher.getName());
            response.setSurname(teacher.getSurname());
            responses.add(response);
        }

        return responses;
    }
	public List<Teacher> findAllTeachers(){
		return teacherR.findAll();
	}

	public Optional<Teacher> findById(Long id){
		return teacherR.findById(id);
	}

	public void saveTeachers(Teacher teacher) {
//		Log.info(null);
		teacherR.save(teacher);
	}
	public void deleteTeacher(Long id) {
	    teacherR.deleteById(id);
	}
	public Teacher updateTeacher(Long id, Teacher teacher) {
	    Optional<Teacher> exist = teacherR.findById(id);
	    if (exist.isPresent()) {
	        Teacher updatedTeacher = exist.get();
	        updatedTeacher.setName(teacher.getName());
	        updatedTeacher.setSurname(teacher.getSurname());
	        updatedTeacher.setAge(teacher.getAge());
	        return teacherR.save(updatedTeacher);
	    }
	    return null;
	}
	  public List<Teacher> searchTeachers(String keyword) {
	        return teacherR.findByNameContainingIgnoreCase(keyword);
	    }

public Optional<CourseEntity> getTeacherCourse(Long teacherId) {
	Teacher teacher= teacherR.findById(teacherId).orElse(null);
	return cRepository.findById(teacher.getCourseId());
}
}
