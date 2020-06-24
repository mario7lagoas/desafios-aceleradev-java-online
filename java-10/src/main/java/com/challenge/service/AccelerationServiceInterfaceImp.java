package com.challenge.service;

import com.challenge.entity.Acceleration;
import com.challenge.entity.Candidate;
import com.challenge.entity.Company;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import com.challenge.service.interfaces.CandidateServiceInterface;
import com.challenge.service.interfaces.CompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccelerationServiceInterfaceImp implements AccelerationServiceInterface {
    @Autowired
    private AccelerationRepository accelerationRepository;

    @Override
    public Optional<Acceleration> findById(Long id) {
        return this.accelerationRepository.findById(id);
    }
/*
    public List<Acceleration> findAccelerationById(Long id) {
        return this.accelerationRepository.findAccelerationById(id);
    }

    public List<Acceleration> findAccelerationByName(String aceleracao) {
        return this.accelerationRepository.findAccelerationByName(aceleracao);
    }
*/
    @Override
    public List<Acceleration> findByCompanyId(Long companyId) {
        return this.accelerationRepository.findByCompanyId(companyId);
    }

    @Override
    public Acceleration save(Acceleration object) {
        return this.accelerationRepository.save(object);
    }

}
