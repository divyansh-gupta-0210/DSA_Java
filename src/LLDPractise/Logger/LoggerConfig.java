package LLDPractise.Logger;

import LLDPractise.Logger.Entities.LogLevel;
import LLDPractise.Logger.Strategy.LogAppender;

import java.util.ArrayList;
import java.util.List;

public class LoggerConfig {

    private LogLevel logLevel;
    private final List<LogAppender> logAppenderList;

    public LoggerConfig(){
        this.logLevel = LogLevel.INFO;
        this.logAppenderList = new ArrayList<>();
    }

    public void setLogLevel(LogLevel logLevel){
        this.logLevel = logLevel;
    }

    public LogLevel getLogLevel(){
        return logLevel;
    }

    public void addLogAppender(LogAppender appender){
        logAppenderList.add(appender);
    }

    public List<LogAppender> getLogAppenderList(){
        return logAppenderList;
    }

}
