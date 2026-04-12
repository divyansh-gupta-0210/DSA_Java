package LLDPractise.Logger;

import LLDPractise.Logger.Entities.LogLevel;
import LLDPractise.Logger.Entities.LoggerMessage;
import LLDPractise.Logger.Strategy.LogAppender;

import java.util.List;

public class Logger {

    private final LoggerConfig config;

    public Logger(LoggerConfig config){
        this.config = config;
    }

    public void log(LogLevel level, String message){
        if(level.getPriority() < config.getLogLevel().getPriority()){
            return;
        }
        LoggerMessage logMessage = new LoggerMessage(level, message);
        List<LogAppender> appenders = config.getLogAppenderList();
        for(LogAppender appender : appenders){
            appender.append(logMessage);
        }
    }

    public LoggerConfig getConfig(){
        return config;
    }

    public void debug(String msg){
        log(LogLevel.DEBUG, msg);
    }

    public void info(String msg){
        log(LogLevel.INFO, msg);
    }

    public void warning(String msg){
        log(LogLevel.WARNING, msg);
    }

    public void error(String msg){
        log(LogLevel.ERROR, msg);
    }

    public void fatal(String msg){
        log(LogLevel.FATAL, msg);
    }
}
