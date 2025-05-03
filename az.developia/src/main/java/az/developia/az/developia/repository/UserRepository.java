package az.developia.az.developia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.developia.az.developia.info.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    boolean existsByUsername(String username);
}

