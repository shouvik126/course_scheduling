package com.example.geektrust.enums;

public enum CommandOperator {
    ADD_COURSE_OFFERING(5),
    REGISTER(2),
    ALLOT(1),
    CANCEL(1);



    private final Integer noOfArguments;

    CommandOperator(Integer noOfArguments) {
        this.noOfArguments = noOfArguments;
    }

    public Integer getNoOfParams() {
        return this.noOfArguments;
    }

}
