package com.codev.scan_eat_api.repository;


import com.codev.scan_eat_api.entities.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Integer> {
    List<Unit> findAllByBaseUnit(Unit unit);
}
