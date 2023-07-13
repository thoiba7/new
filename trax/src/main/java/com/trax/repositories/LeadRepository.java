package com.trax.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.trax.entities.Lead;
@Repository
public interface LeadRepository extends JpaRepositoryImplementation<Lead, Long> {

}
