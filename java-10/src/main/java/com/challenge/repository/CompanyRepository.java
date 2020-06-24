package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    @Query("SELECT distinct ca.id.company from  Candidate as ca " +
            "where ca.id.acceleration.id = :aceleracao")
    public List<Company> findByAccelerationId(@Param("aceleracao") Long accelerationId);

    @Query("SELECT ca.id.company from Candidate as ca where ca.id.user.id = :usuario")
    public List<Company> findByUserId(@Param("usuario") Long userId);
}
