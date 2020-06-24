package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.advice.ResourceNotFoundException;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/{id}")
    public ResponseEntity<Company> findById(@Valid @PathVariable("id") Long id) {

        return new ResponseEntity<Company>(this.companyService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company ID")), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<Set<Company>> findByAccelerationIdOrUserId(@RequestParam(required = false) Long accelerationId,
                                                                     @RequestParam(required = false) Long userId) {
        Set<Company> companySet = new HashSet<>();
        if (accelerationId != null)
            companySet.addAll(this.companyService.findByAccelerationId(accelerationId));

        if (userId != null)
            companySet.addAll(this.companyService.findByUserId(userId));

        return new ResponseEntity<>(companySet, HttpStatus.OK);
    }

}
