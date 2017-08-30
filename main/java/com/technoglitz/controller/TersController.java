package com.technoglitz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.technoglitz.service.ter.TerService;

@Controller
public class TersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TersController.class);
    private final TerService terService;

    @Autowired
    public TersController(TerService terService) {
        this.terService = terService;
    }

    @RequestMapping("/ters/{id}")
    public ModelAndView getTersPage(@PathVariable Long id) {
        LOGGER.debug("Getting ters page");
        return new ModelAndView("expense_list", "ters", terService.getAllTers(id));
    }
    
    @RequestMapping("/ters/man/{id}")
    public ModelAndView getManTers(@PathVariable Long id) {
    	LOGGER.debug("Getting ters page");
    	return new ModelAndView("expense_list", "ters", terService.getAllManTers(id));
    }
    
    @RequestMapping("/ters/fin")
    public ModelAndView getFinTers() {
    	LOGGER.debug("Getting ters page");
    	return new ModelAndView("expense_list", "ters", terService.getAllFinTers());
    }


}
