package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {

    Optional<Acceleration> findById(Long id);

    /*
        @Query("select ac from Acceleration as ac where ac.name = :aceleracao")
        List<Acceleration> findAccelerationByName(@Param("aceleracao") String aceleracao);
    */
    @Query("select ca.id.acceleration from Candidate as ca  " +
            "where ca.id.company.id = :empresa")
    List<Acceleration> findByCompanyId(@Param("empresa") Long id);
/*
    @Query("select ca.id.acceleration from Candidate as ca Where ca.id.acceleration.id :aceleracao")
    List<Acceleration> findAccelerationById (@Param("aceleracao") Long id);
*/
}
