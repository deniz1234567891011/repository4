package az.developia.az.developia.repository;

import az.developia.az.developia.info.AuthenticationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<AuthenticationEntity, Long> {
}
