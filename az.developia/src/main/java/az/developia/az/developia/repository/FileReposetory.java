package az.developia.az.developia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import az.developia.az.developia.info.FileEntity;

import java.util.Optional;

@Repository
public interface FileReposetory extends JpaRepository<FileEntity, Long> {
    Optional<FileEntity> findByFileName(String fileName);
}
