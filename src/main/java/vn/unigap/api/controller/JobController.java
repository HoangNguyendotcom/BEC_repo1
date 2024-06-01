package vn.unigap.api.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.unigap.api.dto.in.JobUpdateRequest;
import vn.unigap.api.dto.out.ResponseHandler;
import vn.unigap.api.service.JobService;
import vn.unigap.api.dto.in.JobCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/employer")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping
    public ResponseEntity<Object> getAllEmployers(){
        return ResponseHandler.responseBuilder(
                "Requested All Employers",
                HttpStatus.OK,
                jobService.getAllEmployers()
        );
    }
    @GetMapping("/{employerId}")
    public ResponseEntity<Object> getEmployer(@PathVariable long employerId){
        return ResponseHandler.responseBuilder(
                "Requested Employer by Id",
                HttpStatus.OK,
                jobService.getEmployer(employerId)
        );
    }
    @PostMapping
    public ResponseEntity<Object> createEmployer(@RequestBody @Valid JobCreationRequest request){
        return ResponseHandler.responseBuilder(
                "Requested to create new Employer",
                HttpStatus.CREATED,
                jobService.createEmployer(request)
        );
    }

    @PutMapping("/{employerId}")
    public ResponseEntity<Object> updateEmployer(@PathVariable long employerId, @RequestBody @Valid JobUpdateRequest request){
        return ResponseHandler.responseBuilder(
                "Requested to update Employer",
                HttpStatus.CREATED,
                jobService.updateEmployer(employerId, request)
                );
    }
    @DeleteMapping("/{employerId}")
    String deleteEmployer(@PathVariable long employerId){
        jobService.deleteEmployer(employerId);
        return "Employer has been deleted";
    }

}