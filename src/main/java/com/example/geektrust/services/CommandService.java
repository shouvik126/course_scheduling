package com.example.geektrust.services;

import com.example.geektrust.constants.ExceptionConstant;
import com.example.geektrust.constants.StatusConstant;
import com.example.geektrust.enums.CommandOperator;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.model.Command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandService {
    public static CommandService commandService = null;
    public static CommandService getInstance() {
        if (commandService == null) {
            commandService = new CommandService();
        }
        return commandService;
    }

    public Command getCommandFromString(String input) throws InvalidInputException {
        try {
            String[] commandWithArguments = input.split(" ");
            CommandOperator commandOperator = CommandOperator.valueOf(StatusConstant.getValue(commandWithArguments[0]));
            List<String> commandParams = Arrays.stream(commandWithArguments).skip(1).collect(Collectors.toList());
            Command command = new Command(commandOperator, commandParams);
            this.validateInputCommand(commandOperator, command);
            return command;
        } catch (InvalidInputException ex) {
            throw new InvalidInputException(ExceptionConstant.INPUT_DATA_ERROR);
        }
    }

    private void validateInputCommand(CommandOperator commandOperator, Command command) throws InvalidInputException {
        if (commandOperator.getNoOfParams() != command.getCommandParam().size()) {
            throw new InvalidInputException(ExceptionConstant.INPUT_DATA_ERROR);
        }
    }


}
