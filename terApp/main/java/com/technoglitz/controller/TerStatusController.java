package com.technoglitz.controller;

import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.technoglitz.domain.ManagerForm;
import com.technoglitz.domain.Status;
import com.technoglitz.domain.TravelExpenseReport;
import com.technoglitz.service.ter.TerService;

@Controller
public class TerStatusController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TerStatusController.class);

    private final TerService terService;
    
    @Autowired
    public TerStatusController(TerService terService) {
    	this.terService = terService;
    }

    @RequestMapping(value="/ter/{id}", method = RequestMethod.GET)
    public ModelAndView getUserPage(@PathVariable Long id) {
        LOGGER.debug("Getting user page for user={}", id);
        Collection<ManagerForm> allManagers = terService.getAllManagers(id);
		return new ModelAndView("expense_view", "ter", allManagers);
    }
    
    @PreAuthorize("hasAuthority('MANAGER') or hasAuthority('EMPLOYEE')")
    @RequestMapping(value = "/ter/{id}", method = RequestMethod.POST)
    public String handleTerUpdateForm(@Valid @ModelAttribute("form") ManagerForm form, BindingResult bindingResult) {
    	TravelExpenseReport travelExpenseReport = null;
        LOGGER.debug("Processing Travel Expense Report Form={}, bindingResult={}", form, bindingResult);
        if (bindingResult.hasErrors()) {
            // failed validation
            return "travelexpense_create";
        }
        try {
        	Optional<TravelExpenseReport> terById = terService.getTerById(Long.parseLong(form.getTerId()));
        	LOGGER.info("FORM={}",form);
        	travelExpenseReport = terById.get();
			travelExpenseReport.setStatus(Status.SUBMITTED);
        	travelExpenseReport.setManId(Long.parseLong(form.getManId()));
            terService.updateTerById(travelExpenseReport);
        } catch (DataIntegrityViolationException e) {
            // probably email already exists - very rare case when multiple admins are adding same user
            // at the same time and form validation has passed for more than one of them.
            LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
//            bindingResult.reject("email.exists", "Email already exists");
            return "travelexpense_create";
        }
        // ok, redirect
        return "redirect:/ters/"+travelExpenseReport.getUserId();
    }


}
