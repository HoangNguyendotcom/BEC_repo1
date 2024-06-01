package vn.unigap.api.service;

import vn.unigap.api.entity.Job;
import vn.unigap.api.repository.JobRepository;
import vn.unigap.api.dto.in.JobCreationRequest;
import vn.unigap.api.dto.in.JobUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAllEmployers() {

        return jobRepository.findAll();
    }

    public Job getEmployer(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employer not found"));
    }

    public Job createEmployer(JobCreationRequest request) {
        Job employer = new Job();
        if (jobRepository.existsByEmail(request.getEmail()))
            throw new RuntimeException("Email existed");

        employer.setEmail(request.getEmail());
        employer.setName(request.getName());
        employer.setProvinceId(request.getProvinceId());
        employer.setDescription(request.getDescription());
        employer.setCreated_at(LocalDate.now());
        employer.setUpdated_at(LocalDate.now());
        return jobRepository.save(employer);
    }
    public Job updateEmployer(long employerId, JobUpdateRequest request) {
        Job employer = getEmployer(employerId);

        employer.setName(request.getName());
        employer.setProvinceId(request.getProvinceId());
        employer.setDescription(request.getDescription() != null ? request.getDescription() : employer.getDescription());
        employer.setUpdated_at(LocalDate.now());

        return jobRepository.save(employer);
    }
    public void deleteEmployer(long employerId){
        jobRepository.deleteById(employerId);
    }

}