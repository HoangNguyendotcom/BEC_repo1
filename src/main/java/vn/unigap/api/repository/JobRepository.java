package vn.unigap.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.unigap.api.entity.Job;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>{
    boolean existsByEmail(String email);
}
