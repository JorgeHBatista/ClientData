package ports;

import data.Stock;

import java.util.ArrayList;

import static java.lang.System.exit;

public class Interface extends Thread{

    ConsoleLogger consoleLogger;
    ArrayList<Stock> stocks;

    public Interface(ConsoleLogger consoleLogger, ArrayList<Stock> stocks) {
        this.consoleLogger = consoleLogger;
        this.stocks = stocks;
    }
    @Override
    public void run () {
        while (true) {
            consoleLogger.write("""
                
                Please, insert the option to see the data:
                Insert 1 for Stock data.
                Insert 2 for Financial data.
                Insert 0 for exiting the program.
                """);

            int option = consoleLogger.askPositiveInt();
            switch (option) {
                case 1:
                    for (Stock stock : stocks) {
                        consoleLogger.write(stock.toStringStock());
                    }
                    break;
                case 2:
                    for (Stock stock : stocks) {
                        consoleLogger.write(stock.toStringFinancial());
                    }
                    break;

                case 0:
                    consoleLogger.write("Exiting the program...");
                    exit(0);

                default:
                    consoleLogger.write("Incorrect option, exiting the program...");
                    exit(-1);
            }
        }
    }
}
