package com.technoglitz.controller;

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

import com.technoglitz.domain.FinDeciForm;
import com.technoglitz.domain.TravelExpenseReport;
import com.technoglitz.service.ter.TerService;

@Controller
public class FinTerStatusController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FinTerStatusController.class);

    private final TerService terService;
    
    @Autowired
    public FinTerStatusController(TerService terService) {
    	this.terService = terService;
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping(value="/ter/fin/{id}", method = RequestMethod.GET)
    public ModelAndView getUserPage(@PathVariable Long id) {
        LOGGER.debug("Getting user page for user={}", id);
        FinDeciForm finDeciForm = new FinDeciForm();
        finDeciForm.setId(id.toString());
		return new ModelAndView("fin_expense_view", "ter", finDeciForm);
    }
    
    @PreAuthorize("hasAuthority('FINANCE')")
    @RequestMapping(value = "/ter/fin/{id}", method = RequestMethod.POST)
    public String handleTerUpdateForm(@Valid @ModelAttribute("form") FinDeciForm form, BindingResult bindingResult) {
    	TravelExpenseReport travelExpenseReport = null;
        LOGGER.debug("Processing Travel Expense Report Form={}, bindingResult={}", form, bindingResult);
        try {
        	Optional<TravelExpenseReport> terById = terService.getTerById(Long.parseLong(form.getId()));
        	LOGGER.info("FORM={}",form);
        	travelExpenseReport = terById.get();
			travelExpenseReport.setStatus(form.getFinStat());
            terService.updateTerById(travelExpenseReport);
        } catch (DataIntegrityViolationException e) {
            LOGGER.warn("Exception occurred when trying to save the ter", e);
        }
        // ok, redirect
        return "redirect:/ters/fin";
    }


}
