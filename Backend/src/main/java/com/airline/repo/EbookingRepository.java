package com.airline.repo;

import com.airline.entity.Ebooking;
import org.springframework.data.repository.CrudRepository;

public interface EbookingRepository extends CrudRepository<Ebooking, Integer> {
}
