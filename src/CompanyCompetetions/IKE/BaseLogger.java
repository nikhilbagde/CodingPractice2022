package CompanyCompetetions.IKE;

/**
 * Created by Nikhil on 1/4/2017 5:04 AM.
 */
class BaseLogger {
    private static BaseLogger log = new BaseLogger();
    private BaseLogger() {}
    public synchronized static BaseLogger getInstance() {
        return log;
    }
    private StringBuilder logMessage = new StringBuilder();
    public void addLog(String logMessage) {
        this.logMessage.append(logMessage + "|");
        //Logic to write log into file.
    }
    public void printLog() {
        System.out.println(logMessage.toString());//To print log.
    }
}
