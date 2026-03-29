package storage;
import model.Bill;
import model.Expense;

import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class FileStorage {
    private static final String BILL_FILE="data/bills.txt";
    private static final String EXPENSE_FILE="data/expenses.txt";

    //Save bill to file
    public static void saveBill(Bill bill){
        try(FileWriter fw=new FileWriter(BILL_FILE,true)){
            fw.write(bill.getname()+","+bill.getamount()+","+bill.getduedate()+","+bill.isPaid()+"\n");

        }catch(Exception e){
            System.out.println("Error saving bill!");
        }
    }
    //Load Bills to file
    public static List<Bill> loadBills(){
        List<Bill> bills =new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new FileReader(BILL_FILE))){
            String line;
            while((line=br.readLine())!=null){
                String[] data=line.split(",");
                Bill b=new Bill(data[0],Double.parseDouble(data[1]),LocalDate.parse(data[2]));
                if (Boolean.parseBoolean(data[3])) b.mark_paid(); 
                bills.add(b);
            }
        }catch(Exception ignored){

        }
        return bills;
    } 
    public static void updateBills(List<Bill> bills){
        try(FileWriter fw=new FileWriter(BILL_FILE,false)){
            for (Bill b: bills){
                fw.write(b.getname()+","+b.getamount()+","+b.getduedate()+","+b.isPaid()+"\n");
            }
        }catch(Exception e){
                System.out.println("Error updating bills file!");
            }
    }
     
    //Save Expense
     public static void saveExpense(Expense expense){
        try(FileWriter fw=new FileWriter(EXPENSE_FILE,true)){
            fw.write(expense.getcategory()+","+expense.getamount()+","+expense.getdate()+","+"\n");

        }catch(Exception e){
            System.out.println("Error saving expense!");
        }
    }

    //Load Expenses
    public static List<Expense> loadExpense(){
        List<Expense> list =new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new FileReader(EXPENSE_FILE))){
            String line;
            while((line=br.readLine())!=null){
                String[] data=line.split(",");
                list.add(new Expense(data[0],Double.parseDouble(data[1]),LocalDate.parse(data[2])));
            }
        }catch(Exception ignored){

        }
        return list;
    } 
}
