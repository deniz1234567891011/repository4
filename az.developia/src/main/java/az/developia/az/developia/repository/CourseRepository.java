package az.developia.az.developia.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.developia.az.developia.info.CourseEntity;
import az.developia.az.developia.info.Teacher;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
	List<CourseEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);

}
