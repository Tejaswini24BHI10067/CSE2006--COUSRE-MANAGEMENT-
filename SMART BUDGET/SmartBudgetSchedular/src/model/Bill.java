package model;
import java.time.LocalDate;

public class Bill{
    private String name;
    private double amount ;
    private LocalDate duedate;
    private boolean ispaid;

    public Bill(String name,double amount,LocalDate duedate){
        this.name=name;
        this.amount=amount;
        this.duedate=duedate;
        this.ispaid=false;
    }
    public String getname(){
        return name;
    }
    public double getamount(){
        return amount;
    }
    public LocalDate getduedate(){
        return duedate;
    }
    public boolean isPaid(){
        return ispaid;
    }
    public void mark_paid(){
        this.ispaid=true;
    }
    
    @Override
    public String toString(){
        return "Name:"+name+"| Amount: Rs "+amount+" | Due: "+duedate+" | Paid: "+ispaid;
    }

}
