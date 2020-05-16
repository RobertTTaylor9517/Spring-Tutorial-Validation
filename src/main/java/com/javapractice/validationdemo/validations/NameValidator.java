package com.javapractice.validationdemo.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<NameConstraint, String> {
    
    @Override
    public void initialize(NameConstraint name){

    }

    @Override
    public boolean isValid(String nameField, ConstraintValidatorContext cxt){
        return !nameField.matches(".*\\d.*");
    }
}