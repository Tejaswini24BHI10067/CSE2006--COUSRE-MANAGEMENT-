package service;
import model.Bill;
import storage.FileStorage;

import java.util.ArrayList;
import java.util.List;

public class BillManager {
    private List<Bill> bills=new ArrayList<>();
    public BillManager(){
        bills=FileStorage.loadBills();
    }

    public void addBill(Bill bill){
        bills.add(bill);
        FileStorage.saveBill(bill);
        System.out.println("Bill added successfully !");
    }
    public void viewBills(){
        if(bills.isEmpty()){
            System.out.println("No bills added yet.");
            return;
        }
        bills.forEach(System.out::println);
    }
    public List<Bill> getPendingBills(){
        List<Bill> pending =new ArrayList<>();
        for (Bill b: bills){
            if (!b.isPaid()) pending.add(b);
        }
        return pending;
    }
    public void markBillPaid (String name){
        for (Bill b: bills){
            if (b.getname().equalsIgnoreCase(name)){
                b.mark_paid();
                FileStorage.updateBills(bills); //Save update properly
                System.out.println("Bill marked as PAID!");
                return;
            }
        }
        System.out.println("Bill not found!");
    }
}
