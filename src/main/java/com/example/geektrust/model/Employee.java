package com.example.geektrust.model;

import com.example.geektrust.constants.ExceptionConstant;
import com.example.geektrust.constants.StatusConstant;
import com.example.geektrust.exceptions.InvalidInputException;

public class Employee {

    private final String name;
    private final String emailAddress;

    public Employee(final String emailAddress) throws InvalidInputException{
        if (StatusConstant.VALID_EMAIL_ADDRESS_REGEX.matcher(emailAddress).matches()) {
            this.emailAddress = emailAddress;
            this.name = this.emailAddress.substring(0, this.emailAddress.indexOf('@'));
        } else {
            throw new InvalidInputException(ExceptionConstant.INPUT_DATA_ERROR);
        }
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
