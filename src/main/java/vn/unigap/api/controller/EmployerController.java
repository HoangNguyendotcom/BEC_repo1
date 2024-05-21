package vn.unigap.api.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import vn.unigap.api.dto.in.EmployerUpdateRequest;
import vn.unigap.api.service.EmployerService;
import vn.unigap.api.entity.Employer;
import vn.unigap.api.dto.in.EmployerCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/employer")
public class EmployerController {
    @Autowired
    private EmployerService employerService;

    @GetMapping
    List<Employer> getEmployers(){
        return employerService.getEmployers();
    }
    @GetMapping("/{employerId}")
    Employer getEmployer(@PathVariable long employerId){
        return employerService.getEmployer(employerId);
    }
    @PostMapping
    Employer createEmployer(@RequestBody @Valid EmployerCreationRequest request){
        return employerService.createEmployer(request);
    }

    @PutMapping("/{employerId}")
    public Employer updateEmployer(@PathVariable long employerId, @RequestBody @Valid EmployerUpdateRequest request){
        return employerService.updateEmployer(employerId, request);
    }
    @DeleteMapping("/{employerId}")
    String deleteEmployer(@PathVariable long employerId){
        employerService.deleteEmployer(employerId);
        return "Employer has been deleted";
    }

}