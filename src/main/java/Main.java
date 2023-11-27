import data.StockManager;
import ports.ConsoleLogger;
import ports.Interface;


public class Main {

    public static void main(String[] args) {
        ConsoleLogger consoleLogger = new ConsoleLogger();
        StockManager stockManager = new StockManager(consoleLogger);

        stockManager.start();

        try {
            stockManager.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Interface myInterface = new Interface(consoleLogger, stockManager.getStocks());
        myInterface.start();
    }
}
