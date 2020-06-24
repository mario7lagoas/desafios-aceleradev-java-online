package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository extends CrudRepository<Candidate, CandidateId> {

    @Query("select ca from Candidate as ca where ca.id.company.id = :empresa")
    List<Candidate> findByCompanyId(@Param("empresa") Long companyId);

    @Query("Select ca from Candidate as ca " +
            " where ca.id.acceleration.id = :aceleracao")
    List<Candidate> findByAccelerationId(@Param("aceleracao") Long accelerationId);

    @Query("SELECT ca FROM Candidate as ca WHERE ca.id.user.id = :userId AND ca.id.company.id = :companyId " +
            "AND ca.id.acceleration.id = :accelerationId")
    Optional<Candidate> findByUserIdCompanyIdAccelerationId(@Param("userId") Long userId,
                                                            @Param("companyId") Long companyId,
                                                            @Param("accelerationId") Long accelerationId);
}
