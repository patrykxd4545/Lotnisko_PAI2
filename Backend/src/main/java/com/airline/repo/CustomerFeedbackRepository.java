package com.airline.repo;

import com.airline.entity.CustomerFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerFeedbackRepository extends JpaRepository<CustomerFeedback, Integer>, CrudRepository<CustomerFeedback, Integer> {

}
