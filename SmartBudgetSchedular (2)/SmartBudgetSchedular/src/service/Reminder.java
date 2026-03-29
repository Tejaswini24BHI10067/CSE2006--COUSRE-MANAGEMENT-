package service;
import model.Bill;
import java.util.List;
import java.time.LocalDate;

public class Reminder{
    public void checkDueBills(List<Bill> bills){
        LocalDate today=LocalDate.now();
        System.out.println("\n Reminder Check:");

        boolean found=false;
        for(Bill b:bills){
            if(!b.isPaid()){
                long daysLeft= java.time.temporal.ChronoUnit.DAYS.between(today,b.getduedate());
                if(daysLeft>=0 && daysLeft<=3){
                    System.out.println("Bill due soon: "+b.getname()+ " | Due in"+daysLeft+" day(s)");
                    found=true;
                }
            }
        }
        if (!found) {
            System.out.println("No upcoming bills due soon!");
        }
    }
    
}
