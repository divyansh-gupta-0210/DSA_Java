package LLDPractise.Logger;

import LLDPractise.Logger.Entities.LogLevel;
import LLDPractise.Logger.Factory.LoggerFactory;
import LLDPractise.Logger.Strategy.ConsoleAppender;
import LLDPractise.Logger.Strategy.DatabaseAppender;
import LLDPractise.Logger.Strategy.FileAppender;

public class LoggerMain {
    public static void main(String[] args) {

        System.out.println("**** LOGGER SINGLETON ****");
        Logger logger = LoggerFactory.getLogger();

        logger.info("Application started");
        logger.debug("Debugging details");
        logger.warning("Warning message");
        logger.error("Error occurred");
        logger.fatal("Fatal error!");

        // Custom configuration
        System.out.println("\n**** LOGGER CONFIGURATION ****");
        LoggerConfig config = new LoggerConfig();
        config.setLogLevel(LogLevel.DEBUG);

        config.addLogAppender(new ConsoleAppender());
        config.addLogAppender(new FileAppender("app.log"));
        config.addLogAppender(new DatabaseAppender());

        Logger customLogger = new Logger(config);
        customLogger.info("Logging to multiple outputs");

        // Use AsyncLogger
        System.out.println("\n**** LOGGER ASYNC ****");
        LoggerAsync asyncLogger = new LoggerAsync(config);

        asyncLogger.info("Application started");
        asyncLogger.debug("Debugging details");
        asyncLogger.warning("Warning message");
        asyncLogger.error("Error occurred");
        asyncLogger.fatal("Fatal error!");
        asyncLogger.shutdown();

    }
}
