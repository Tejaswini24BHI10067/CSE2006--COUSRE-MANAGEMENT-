package ui;
import service.*;
import model.*;
import java.util.Scanner;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args){
        BillManager billManager=new BillManager();
        ExpenseManager expenseManager=new ExpenseManager();
        Reminder reminderService=new Reminder();
   
        Scanner s=new Scanner (System.in);

        while(true){
            System.out.println("\n--- Smart Budget and Bill Sceduler ---");
            System.out.println("1. Add Bill");
            System.out.println("2. View Bills");
            System.out.println("3. Add Expenses");
            System.out.println("4. View Expenses");
            System.out.println("5. Monthly Expenditure Report");
            System.out.println("6. Check Reminders");
            System.out.println("7. Mark Bill Paid");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int ch=s.nextInt();s.nextLine();

            switch(ch){
                case 1:
                    System.out.print("Bill Name: ");
                    String bn= s.nextLine();
                    System.out.println("Amount: ");
                    double amt=s.nextDouble();s.nextLine();
                    System.out.println("Due Date  (yyyy-mm-dd): ");
                    LocalDate dd=LocalDate.parse(s.nextLine());
                    billManager.addBill(new Bill(bn,amt,dd));
                    break;
                case 2:
                    billManager.viewBills();    
                    break;
                    
                case 3:
                    System.out.println("Category: ");
                    String cat=s.nextLine();
                    System.out.println("Amount: ");
                    double eAmt=s.nextDouble();s.nextLine();
                    expenseManager.addExpense(new Expense(cat,eAmt, LocalDate.now()));
                    break;
                case 4:
                    expenseManager.viewExpense();
                    break;
                case 5:
                    System.out.println("Enter month number (1-12): ");
                    int m=s.nextInt();
                    System.out.println("Total Monthly Expense: Rs"+ expenseManager.monthlyTotal(m));            
                    break;
                case 6:
                    reminderService.checkDueBills(billManager.getPendingBills());
                    break;
                case 7:
                    System.out.print("Enter bill name to mark paid: ");
                    String name=s.nextLine();
                    billManager.markBillPaid(name);
                    break;
                case 8:
                    System.out.println("Goodbye!");
                    return;    
                default:
                    System.out.println("Invalid choice ! Can't process request.");            
               
               
                }  
                 
             
        }
        
    }
}
