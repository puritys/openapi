package com.puritys.spring.api;

import com.puritys.spring.model.*;
import com.puritys.spring.validation.ValidationGroups;
import com.puritys.spring.validation.HeroValidation;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ValidationApiImpl implements ValidationApiDelegate {

    @Override
    public ResponseEntity<Hero> createHero(Hero hero) {
        validate(hero, ValidationGroups.Create.class);
        return new ResponseEntity<>(new Hero(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Hero> updateHero(String id, Hero hero) {
        validate(hero, ValidationGroups.Update.class);
        return new ResponseEntity<>(new Hero(), HttpStatus.OK);
    }

    private void validate(Hero input, Class<?> group) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Hero>> violations = validator.validate(input, group);

        if (!violations.isEmpty()) {
            String errorMessage = violations.stream()
                .map(h -> String.format("%s: %s", h.getPropertyPath(), h.getMessage()))
                .collect(Collectors.joining(","));
            throw new RuntimeException(errorMessage);
        }

    }

}
