package model;
import java.time.LocalDate;
public class Expense {
    private String category;
    private double amount;
    private LocalDate date;

    public Expense(String category,double amount, LocalDate date){
        this.category=category;
        this.amount=amount;
        this.date=date;
    } 
    public String getcategory(){
        return category;
    }
    public double getamount(){
        return amount;
    }
    public LocalDate getdate(){
        return date;
    }

    @Override
    public String toString(){
        return "Date: "+date + " | Category: "+category+" | Amount: Rs "+amount ;
    }

    
}
