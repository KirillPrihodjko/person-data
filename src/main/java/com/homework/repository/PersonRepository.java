package com.homework.repository;

import com.homework.domain.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    Optional<PersonEntity> findPersonEntityByDateOfBirth(String name);
}
