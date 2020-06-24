package com.challenge.endpoints;

import com.challenge.dto.SubmissionDTO;
import com.challenge.entity.Submission;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @Autowired
    private SubmissionMapper submissionMapper;

    @GetMapping
    public ResponseEntity<List<SubmissionDTO>> findByChallengeIdAndAccelerationId(@RequestParam Long challengeId,
                                                                                  @RequestParam Long accelerationId) {

        List<Submission> submission = this.submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId);

        List<SubmissionDTO> submissionDTOS = submission.stream().map(s -> submissionMapper.map(s))
                .collect(Collectors.toList());

        return new ResponseEntity<>(submissionDTOS, HttpStatus.OK);

    }
}
