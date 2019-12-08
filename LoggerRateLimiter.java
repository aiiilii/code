import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

    private Map<String, Integer> msgDict;
    
    public LoggerRateLimiter() {
        msgDict = new HashMap<String, Integer>();
    }

    public boolean shouldPrintMessasge(int timestamp, String message) {
        if (!msgDict.containsKey(message)) {
            msgDict.put(message, timestamp);
            return true;
        }
        Integer oldTimeStamp = msgDict.get(message);
        if (timestamp - oldTimeStamp >= 10) {
            msgDict.replace(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
}