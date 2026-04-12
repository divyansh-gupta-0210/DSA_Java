package LLDPractise.Logger.Entities;

import java.time.LocalDateTime;

public class LoggerMessage {

    private final LocalDateTime timeStamp;
    private final LogLevel level;
    private final String message;

    public LoggerMessage(LogLevel level, String message){
        this.timeStamp = LocalDateTime.now();
        this.level = level;
        this.message = message;
    }

    public String format(){
        return String.format("[%s] [%s] %s", timeStamp, level, message);
    }

    public LogLevel logLevel(){
        return level;
    }

}
