package com.example.geektrust.factory;

import com.example.geektrust.model.Command;
import com.example.geektrust.services.CommandExecutor;
import com.example.geektrust.services.impl.AddCourseCommandExecutorImpl;
import com.example.geektrust.services.impl.AllotCourseCommandExecutorImpl;
import com.example.geektrust.services.impl.CancelCourseCommandExecutorImpl;
import com.example.geektrust.services.impl.RegisterCourseCommandExecutorImpl;

public class CommandExecutionFactory {

    public static CommandExecutor getExecutor(Command command) {
        CommandExecutor commandExecutor = null;
        if (command != null) {
            switch (command.getCommandOperator()) {
                case ADD_COURSE_OFFERING:
                    commandExecutor = new AddCourseCommandExecutorImpl();
                    break;
                case ALLOT:
                    commandExecutor = new AllotCourseCommandExecutorImpl();
                    break;
                case CANCEL:
                    commandExecutor = new CancelCourseCommandExecutorImpl();
                    break;
                case REGISTER:
                    commandExecutor = new RegisterCourseCommandExecutorImpl();
                    break;
                default:
                    break;
            }
        }
        return commandExecutor;
    }
}
