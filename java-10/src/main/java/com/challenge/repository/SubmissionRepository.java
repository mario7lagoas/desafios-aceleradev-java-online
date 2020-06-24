package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface SubmissionRepository extends CrudRepository<Submission, Long> {
    @Query("SELECT MAX(su.score) FROM Submission as su where su.id.challenge.id = :desafio")
    BigDecimal findHigherScoreByChallengeId(@Param("desafio") Long challengeId);

    @Query("SELECT s FROM Submission s JOIN s.id.challenge c JOIN c.accelerations a WHERE c.id = ?1 AND a.id = ?2 ")
    List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);
}
