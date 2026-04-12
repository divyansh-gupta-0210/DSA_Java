package LLDPractise.Logger.Factory;

import LLDPractise.Logger.Entities.LogLevel;
import LLDPractise.Logger.Logger;
import LLDPractise.Logger.LoggerConfig;
import LLDPractise.Logger.Strategy.ConsoleAppender;
import LLDPractise.Logger.Strategy.DatabaseAppender;

public class LoggerFactory {
    private static Logger logger;

    public static synchronized Logger getLogger(){
        if(logger == null){
            LoggerConfig config = new LoggerConfig();
            config.setLogLevel(LogLevel.DEBUG);
            config.addLogAppender(new ConsoleAppender());
//            config.addLogAppender(new DatabaseAppender());
            logger = new Logger(config);
        }
        return logger;
    }

}
