package com.api.crowdlending.repository;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.*;

@Repository
@Table(name = "contact_visitors")
public interface ContactVisitorRepository extends JpaRepository<ContactModel, Long> {

}
