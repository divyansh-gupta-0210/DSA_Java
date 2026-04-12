package LLDPractise.Logger.Strategy;

import LLDPractise.Logger.Entities.LoggerMessage;

public class DatabaseAppender implements LogAppender{

    @Override
    public synchronized void append(LoggerMessage message){
        System.out.println("Writing to DB : " + message.format());
    }

}
