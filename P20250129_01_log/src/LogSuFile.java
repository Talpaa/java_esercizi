
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogSuFile {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(LogSuFile.class.getName());
        logger.setUseParentHandlers(false);

        logger.setLevel(Level.ALL);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINE);
        logger.addHandler(consoleHandler);

         FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("log.txt");
            fileHandler.setLevel(Level.ALL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.addHandler(fileHandler);

        // Log messages at all levels
        logger.severe("This is a SEVERE error message");
        logger.warning("This is a WARNING message");
        logger.info("This is an INFO message");
        logger.config("This is a CONFIG message");
        logger.fine("This is a FINE debug message");
        logger.finer("This is a FINER debug message (more detailed)");
        logger.finest("This is a FINEST debug message (most detailed)");
    }
}
