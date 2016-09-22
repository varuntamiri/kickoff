package com.technoglitz.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.technoglitz.domain.TravelExpenseCreateForm;
import com.technoglitz.domain.validator.TravelExpenseReportCreateFormValidator;
import com.technoglitz.service.ter.TerService;

@Controller
public class ExportReportController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExportReportController.class);
    private final TerService terService;
    private final TravelExpenseReportCreateFormValidator expenseReportCreateFormValidator;

    @Autowired
    public ExportReportController(TerService terService, TravelExpenseReportCreateFormValidator expenseReportCreateFormValidator) {
        this.terService = terService;
        this.expenseReportCreateFormValidator = expenseReportCreateFormValidator;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(expenseReportCreateFormValidator);
    }


    
    @PreAuthorize("hasAuthority('MANAGER') or hasAuthority('EMPLOYEE')")
    @RequestMapping(value = "/ter/create", method = RequestMethod.GET)
    public ModelAndView getTravelExpenseReportCreatePage() {
    	LOGGER.debug("Getting Travel Expense Report create form");
    	return new ModelAndView("travelexpense_create", "form", new TravelExpenseCreateForm());
    }

    @PreAuthorize("hasAuthority('MANAGER') or hasAuthority('EMPLOYEE')")
    @RequestMapping(value = "/ter/create", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") TravelExpenseCreateForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing Travel Expense Report Form={}, bindingResult={}", form, bindingResult);
        if (bindingResult.hasErrors()) {
            // failed validation
            return "travelexpense_create";
        }
        try {
            terService.create(form);
        } catch (DataIntegrityViolationException e) {
            // probably email already exists - very rare case when multiple admins are adding same user
            // at the same time and form validation has passed for more than one of them.
            LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
//            bindingResult.reject("email.exists", "Email already exists");
            return "travelexpense_create";
        }
        // ok, redirect
        return "redirect:/ters/"+form.getUserId();
    }

}
