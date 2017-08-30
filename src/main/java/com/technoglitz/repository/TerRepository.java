package com.technoglitz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technoglitz.domain.TravelExpenseReport;

public interface TerRepository extends JpaRepository<TravelExpenseReport, Long> {

    List<TravelExpenseReport> findAllByUserId(Long userId);
    
    List<TravelExpenseReport> findAllByManId(Long manId);
    
}
