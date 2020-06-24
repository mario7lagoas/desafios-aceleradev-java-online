package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findById(Long id);

    @Query("Select ca.id.user from Candidate as ca where ca.id.acceleration.name = :aceleracao")
    List<User> findByAccelerationName(@Param("aceleracao") String name);

    @Query("select ca.id.user FROM Candidate as ca where ca.id.company.id = :empresa")
    List<User> findByCompanyId(@Param("empresa") Long companyId);

}
