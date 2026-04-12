package LLDPractise.Logger;

import LLDPractise.Logger.Entities.LogLevel;
import LLDPractise.Logger.Entities.LoggerMessage;
import LLDPractise.Logger.Strategy.LogAppender;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoggerAsync extends Logger{

    private final ExecutorService executorService;

    public LoggerAsync(LoggerConfig config){
        super(config);
        this.executorService = Executors.newFixedThreadPool(5);
    }

    @Override
    public void log(LogLevel level, String message){
        if(level.getPriority() < getConfig().getLogLevel().getPriority()){
            return;
        }
        LoggerMessage loggerMessage = new LoggerMessage(level, message);
        List<LogAppender> apprenders = getConfig().getLogAppenderList();
        for(LogAppender appender : apprenders){
            executorService.submit(() -> appender.append(loggerMessage));
        }
    }

    public void shutdown(){
        executorService.shutdown();
    }

}
