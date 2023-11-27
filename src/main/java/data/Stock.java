package data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Stock implements Financial {

    private final String details;
    private final String color;
    private final double weight;
    private final double price;
    private final int soldUnits;
    private final Date dateOfProduction;
    private final Date dueDate;
    public Stock (String details, String color, double weight, double price, int soldUnits, Date dateOfProduction, Date dueDate) {
        this.details = details;
        this.color = color;
        this.weight = weight;
        this.price = price;
        this.soldUnits = soldUnits;
        this.dateOfProduction = dateOfProduction;
        this.dueDate = dueDate;
    }

    public int getSoldUnits() {
        return soldUnits;
    }

    public double getPrice() {
        return price;
    }

    public Date getDateOfProduction() {
        return dateOfProduction;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public double totalGross() {
        return this.getSoldUnits() * this.getPrice();
    }

    @Override
    public double totalNet() {
        return totalGross() * 0.83;
    }

    @Override
    public double estimatedLoss() {
        return this.totalNet() / 12;
    }

    @Override
    public int daysOfDifference() {
        long difference = getDueDate().getTime() - getDateOfProduction().getTime();
        return (int) TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
    }

    public String toStringStock() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        return "Stock { " +
                "details ='" + this.getDetails() + '\'' +
                ", color ='" + this.getColor() + '\'' +
                ", weight =" + this.getWeight() +
                ", price =" + this.getPrice() +
                ", soldUnits =" + this.getSoldUnits() +
                ", dateOfProduction =" + dateFormat.format(this.getDateOfProduction()) +
                ", dueDate =" + dateFormat.format(this.getDueDate()) +
                '}';
    }

    public String toStringFinancial() {
        return "Financial { " +
                "totalGross =" + totalGross() +
                ", totalNet =" + totalNet() +
                ", estimatedLoss =" + estimatedLoss() +
                ", daysOfDifference =" + daysOfDifference() +
                '}';
    }
}
