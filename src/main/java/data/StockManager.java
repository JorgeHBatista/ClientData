package data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ports.ConsoleLogger;

public class StockManager extends Thread {

    private final ArrayList<Stock> stocks;
    private final int amountOfProducts;
    private final ConsoleLogger consoleLogger;

    public StockManager(ConsoleLogger consoleLogger) {
        this.consoleLogger = consoleLogger;
        consoleLogger.write("Insert the amount of products to store: ");
        this.amountOfProducts = consoleLogger.askPositiveInt();
        this.stocks = new ArrayList<>();
    }

    public void manageStock() {
        for (int i = 0; i < amountOfProducts; i++) {
            consoleLogger.write("Insert the details for the product " + (i + 1) + ": ");
            String details = consoleLogger.askString();
            consoleLogger.write("Insert the colour for the product " + (i + 1) + ": ");
            String colour = consoleLogger.askString();
            consoleLogger.write("Insert the weight for the product " + (i + 1) + ": ");
            double weight = consoleLogger.askDouble();
            consoleLogger.write("Insert the price for the product " + (i + 1) + ": ");
            double price = consoleLogger.askDouble();
            consoleLogger.write("Insert the sold units for the product " + (i + 1) + ": ");
            int soldUnits = consoleLogger.askPositiveInt();
            consoleLogger.write("Insert the date of production for the product " + (i + 1) + ": ");
            String dateOfProductionString = consoleLogger.askString();
            consoleLogger.write("Insert the due date for the product " + (i + 1) + ": ");
            String dueDateString = consoleLogger.askString();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date dateOfProduction = dateFormat.parse(dateOfProductionString);
                Date dueDate = dateFormat.parse(dueDateString);
                Stock stock = new Stock(details, colour, weight, price, soldUnits, dateOfProduction, dueDate);
                stocks.add(stock);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    @Override
    public void run() {
        manageStock();
    }

}
