package com.challenge.endpoints;


import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.advice.ResourceNotFoundException;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CandidateMapper candidateMapper;

    @GetMapping("/{userId}/{accelerationId}/{companyId}")
    public ResponseEntity<CandidateDTO> findById(@PathVariable Long userId,
                                                 @PathVariable Long companyId,
                                                 @PathVariable Long accelerationId) {

        Candidate candidate = this.candidateService.findById(userId, companyId, accelerationId)
                .orElseThrow(() -> new ResourceNotFoundException("Canditate"));

        CandidateDTO candidateDTO = candidateMapper.map(candidate);
        return new ResponseEntity<>(candidateDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Set<CandidateDTO>> findByCompanyIdOrAccelerationId(@RequestParam(required = false) Long companyId,
                                                                             @RequestParam(required = false) Long accelerationId) {
        Set<Candidate> candidateSet = new HashSet<>();

        if (companyId != null) {
            candidateSet.addAll(this.candidateService.findByCompanyId(companyId));
        }

        if (accelerationId != null) {
            candidateSet.addAll(this.candidateService.findByAccelerationId(accelerationId));
        }

        Set<CandidateDTO> candidateDTOS = candidateSet.stream()
                .map(c -> candidateMapper.map(c)).collect(Collectors.toSet());

        return new ResponseEntity<>(candidateDTOS, HttpStatus.OK);
    }
}
