package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

    @GetMapping
    public ResponseEntity<List<Challenge>> findByAccelerationIdAndUserId(@RequestParam Long accelerationId,
                                                                         @RequestParam Long userId) {
        List<Challenge> challenges = this.challengeService.findByAccelerationIdAndUserId(accelerationId, userId);

        return new ResponseEntity<>(challenges, HttpStatus.OK);
    }
}
