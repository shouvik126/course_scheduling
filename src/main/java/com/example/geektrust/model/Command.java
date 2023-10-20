package com.example.geektrust.model;

import com.example.geektrust.enums.CommandOperator;

import java.util.List;

public class Command {
    private final CommandOperator commandOperator;
    private final List<String> commandParam;

    public Command(CommandOperator commandOperator, List<String> commandParam) {
        this.commandOperator = commandOperator;
        this.commandParam = commandParam;
    }

    public CommandOperator getCommandOperator() {
        return commandOperator;
    }

    public List<String> getCommandParam() {
        return commandParam;
    }
}
