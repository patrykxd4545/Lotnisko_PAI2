package com.airline.repo;

import com.airline.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaneRepository extends JpaRepository<Plane, Long> {
    List<Plane> findByState(boolean state);
    List<Plane> findByModelContaining(String model);
}
