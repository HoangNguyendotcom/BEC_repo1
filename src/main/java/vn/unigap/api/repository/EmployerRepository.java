package vn.unigap.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.unigap.api.entity.Employer;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long>{
    boolean existsByEmail(String email);
}
