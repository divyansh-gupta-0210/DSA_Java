package LLDPractise.Logger.Strategy;

import LLDPractise.Logger.Entities.LoggerMessage;

public interface LogAppender {
    void append(LoggerMessage message);
}
