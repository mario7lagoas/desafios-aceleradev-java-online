package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.advice.ResourceNotFoundException;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<User>(this.userService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User")), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Set<User>> findByAccelerationNameOrCompanyId(@Valid
                                                                       @RequestParam(required = false) String accelerationName,
                                                                       @RequestParam(required = false) Long companyId) {
        Set<User> users = new HashSet<>();
        if (accelerationName != null)
            users.addAll(this.userService.findByAccelerationName(accelerationName));

        if (companyId != null)
            users.addAll(this.userService.findByCompanyId(companyId));

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}


