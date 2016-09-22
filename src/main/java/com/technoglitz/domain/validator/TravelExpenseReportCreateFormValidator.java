package com.technoglitz.domain.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.technoglitz.domain.TravelExpenseCreateForm;
import com.technoglitz.service.ter.TerService;

@Component
public class TravelExpenseReportCreateFormValidator implements Validator {

    private static final Logger LOGGER = LoggerFactory.getLogger(TravelExpenseReportCreateFormValidator.class);
    @Autowired
    public TravelExpenseReportCreateFormValidator(TerService terService) {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(TravelExpenseCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.debug("Validating {}", target);
    }


}
