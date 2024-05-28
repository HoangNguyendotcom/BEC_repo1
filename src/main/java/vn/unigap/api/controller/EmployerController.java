package vn.unigap.api.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.unigap.api.dto.in.EmployerUpdateRequest;
import vn.unigap.api.dto.out.EmployerResponse;
import vn.unigap.api.service.EmployerService;
import vn.unigap.api.dto.in.EmployerCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/employer")
public class EmployerController {
    @Autowired
    private EmployerService employerService;

    @GetMapping
    public ResponseEntity<Object> getAllEmployers(){
        return EmployerResponse.responseBuilder(
                "Requested All Employers",
                HttpStatus.OK,
                employerService.getAllEmployers()
        );
    }
    @GetMapping("/{employerId}")
    public ResponseEntity<Object> getEmployer(@PathVariable long employerId){
        return EmployerResponse.responseBuilder(
                "Requested Employer by Id",
                HttpStatus.OK,
                employerService.getEmployer(employerId)
        );
    }
    @PostMapping
    public ResponseEntity<Object> createEmployer(@RequestBody @Valid EmployerCreationRequest request){
        return EmployerResponse.responseBuilder(
                "Requested to create new Employer",
                HttpStatus.CREATED,
                employerService.createEmployer(request)
        );
    }

    @PutMapping("/{employerId}")
    public ResponseEntity<Object> updateEmployer(@PathVariable long employerId, @RequestBody @Valid EmployerUpdateRequest request){
        return EmployerResponse.responseBuilder(
                "Requested to update Employer",
                HttpStatus.CREATED,
                employerService.updateEmployer(employerId, request)
                );
    }
    @DeleteMapping("/{employerId}")
    String deleteEmployer(@PathVariable long employerId){
        employerService.deleteEmployer(employerId);
        return "Employer has been deleted";
    }

}