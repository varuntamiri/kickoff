package com.technoglitz.service.ter;

import java.util.Collection;
import java.util.Optional;

import com.technoglitz.domain.ManagerForm;
import com.technoglitz.domain.TravelExpenseCreateForm;
import com.technoglitz.domain.TravelExpenseReport;

public interface TerService {

    Optional<TravelExpenseReport> getTerById(long id);    
    
    TravelExpenseReport updateTerById(TravelExpenseReport travelExpenseReport);

    Collection<ManagerForm> getAllManagers(Long Id);
    
    Collection<TravelExpenseReport> getAllTers(Long id);

    TravelExpenseReport create(TravelExpenseCreateForm form);

	Collection<TravelExpenseReport> getAllFinTers();

	Collection<TravelExpenseReport> getAllManTers(Long id);

}
