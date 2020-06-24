package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChallengeRepository extends CrudRepository<Challenge, Long> {

    @Query("SELECT distinct ca.id.acceleration.challenge FROM Candidate as ca " +
            "where ca.id.acceleration.id = :aceleracao and ca.id.user.id = :usuario")
    List<Challenge> findByAccelerationIdAndUserId(@Param("aceleracao") Long accelerationId,
                                                  @Param("usuario") Long userId);
}
