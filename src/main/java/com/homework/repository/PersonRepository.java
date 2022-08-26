package com.homework.repository;

import com.homework.domain.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    List<PersonEntity> findAllByIdAndDateOfBirth(Long id, String dateOfBirth);
}
