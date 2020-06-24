package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.advice.ResourceNotFoundException;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationService accelerationService;

    @GetMapping("/{id}")
    public ResponseEntity<Acceleration> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<Acceleration>(this.accelerationService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Acceleration")), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Acceleration>> findByCompanyId(@RequestParam(required = false) Long companyId) {
        List<Acceleration> accelerations = this.accelerationService.findByCompanyId(companyId);
        return new ResponseEntity<>(accelerations, HttpStatus.OK);
    }

}
