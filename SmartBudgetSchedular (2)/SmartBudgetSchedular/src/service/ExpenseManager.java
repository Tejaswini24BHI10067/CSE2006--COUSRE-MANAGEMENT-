package service;
import model.Expense;
import storage.FileStorage;

import java.util.ArrayList ;
import java.util.List;

public class ExpenseManager {
    private List<Expense> expenses=new ArrayList<>();
    
    public ExpenseManager(){
        expenses=FileStorage.loadExpense();
    }
    public void addExpense(Expense expense){
        expenses.add(expense);
        FileStorage.saveExpense(expense);
        System.out.println("Expense added successfully!");
    }
    public void viewExpense(){
        if(expenses.isEmpty()){
            System.out.println("No expenses recorded yet.");
            return;
        }
        expenses.forEach(System.out::println);
    }
    public double monthlyTotal(int month){
        return expenses.stream()
               .filter(e-> e.getdate().getMonthValue()==month)
               .mapToDouble(Expense::getamount)
               .sum();
         

    }

}
