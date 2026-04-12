package LLDPractise.Logger.Strategy;

import LLDPractise.Logger.Entities.LoggerMessage;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender{

    private final String filePath;

    public FileAppender(String filePath){
        this.filePath = filePath;
    }

    @Override
    public synchronized void append(LoggerMessage message){
        try(FileWriter writer = new FileWriter(filePath, true)){
            writer.write(message.format() + "\n");
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

}
