package LLDPractise.Logger.Strategy;

import LLDPractise.Logger.Entities.LoggerMessage;

public class ConsoleAppender implements LogAppender{

    @Override
    public synchronized void append(LoggerMessage message){
        System.out.println(message.format());
    }

}
