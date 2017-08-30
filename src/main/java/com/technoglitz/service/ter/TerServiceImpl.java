package com.technoglitz.service.ter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.technoglitz.domain.ManagerForm;
import com.technoglitz.domain.Role;
import com.technoglitz.domain.Status;
import com.technoglitz.domain.TravelExpenseCreateForm;
import com.technoglitz.domain.TravelExpenseReport;
import com.technoglitz.domain.User;
import com.technoglitz.repository.TerRepository;
import com.technoglitz.service.user.UserService;

@Service
public class TerServiceImpl implements TerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TerServiceImpl.class);
    private final TerRepository terRepository;
    private final UserService userService;

    @Autowired
    public TerServiceImpl(TerRepository terRepository, UserService userService) {
        this.terRepository = terRepository;
        this.userService = userService;
    }

    @Override
    public Optional<TravelExpenseReport> getTerById(long id) {
        LOGGER.debug("Getting ter={}", id);
        return Optional.ofNullable(terRepository.findOne(id));
    }
    
	@Override
	public Collection<ManagerForm> getAllManagers(Long Id) {
		Collection<User> allManagers = userService.getAllManagers();
		List<ManagerForm> managerForms = new ArrayList<>();
		for (User user : allManagers) {
			managerForms.add(new ManagerForm(Id.toString(),user.getId().toString(),user.getEmail()));
		}
		return managerForms;
	}   

    @Override
    public TravelExpenseReport updateTerById(TravelExpenseReport travelExpenseReport) {
    	LOGGER.debug("Getting ter={}", travelExpenseReport);
    	return terRepository.save(travelExpenseReport);
    }

    @Override
    public Collection<TravelExpenseReport> getAllTers(Long id) {
        LOGGER.debug("Getting all ters");
        List<TravelExpenseReport> findAll = terRepository.findAll(new Sort("id"));
        Optional<User> userById = userService.getUserById(id);
        if(userById.get().getRole().equals(Role.EMPLOYEE)){
        	findAll=terRepository.findAllByUserId(id);
        }
		return findAll;
    }
    @Override
    public Collection<TravelExpenseReport> getAllManTers(Long id) {
    	LOGGER.debug("Getting all Man ters");
    	List<TravelExpenseReport> findAll = terRepository.findAll(new Sort("id"));
    	Optional<User> userById = userService.getUserById(id);
    	if(userById.get().getRole().equals(Role.MANAGER)){
    		findAll=terRepository.findAllByManId(id);
    	}
    	for (TravelExpenseReport travelExpenseReport : findAll) {
			if(travelExpenseReport.getStatus().equals(Status.DRAFT)||travelExpenseReport.getStatus().equals(Status.REJECT)){
				findAll.remove(travelExpenseReport);
			}
		}
    	return findAll;
    }
    @Override
    public Collection<TravelExpenseReport> getAllFinTers() {
    	LOGGER.debug("Getting all FIN ters");
    	List<TravelExpenseReport> findAll = terRepository.findAll(new Sort("id"));
    	List<TravelExpenseReport> finTers = new ArrayList<>();
    	for (TravelExpenseReport travelExpenseReport : findAll) {
			if(travelExpenseReport.getStatus().equals(Status.SUBMIT_TO_FIN)){
				finTers.add(travelExpenseReport);
			}
		}
    	return finTers;
    }

    @Override
    public TravelExpenseReport create(TravelExpenseCreateForm form) {
        TravelExpenseReport ter = new TravelExpenseReport();
        ter.setPurpose(form.getPurpose());
        ter.setStartDate(form.getStartDate());
        ter.setEndDate(form.getEndDate());
        ter.setModeOfTravel(form.getModeOfTravel());
        ter.setCost(form.getCost());
        ter.setCostFromHomeToAirport(form.getCostFromHomeToAirport());
        ter.setCostFromAirportToAccomodation(form.getCostFromAirportToAccomodation());
        ter.setCostOfLocalConvayance(form.getCostOfLocalConvayance());
        ter.setCostOfHotelAccomodation(form.getCostOfHotelAccomodation());
        ter.setUserId(Long.parseLong(form.getUserId()));
        ter.setStatus(form.getStatus());
        
        return terRepository.save(ter);
    }



}
