package r2s.training.main;

import r2s.training.entities.Customer;
import r2s.training.entities.Order;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    static List<Customer> customers = new ArrayList<>();
    public static void main(String[] args) throws ParseException {
        try{
            int choice;
            String phone;
            Scanner scanner = new Scanner(System.in);
            customers = null;
            do{
                System.out.println("Choose function:\n1. Add a new Customer\n2. Show all Customer\n" +
                        "3. Search Customer\n4. Remove Customer\n5. Exit");
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice){
                    case 1:{
                        createCustomer();
                        break;
                    }
                    case 2:{
//                        for(Customer customer: findAll()){
//                            System.out.println("Customer[Name = "+customer.getName()+", Phone = "+customer.getPhone()+
//                                    ", Address = "+customer.getAddress()+", Order[]]");
//                        }
                        display(findAll());
                        break;
                    }
                    case 3:{
                        do{
                            System.out.print("Enter Phone Search: (+84) ");
                            phone = scanner.nextLine();
                            if(phone.length() != 9){
                                System.err.print("\nWrong phone number format\n");
                                continue;
                            }
                            for(int i=0; i<9; i++){
                                if(Character.isLetter(phone.charAt(i))){
                                    phone = "0";
                                    break;
                                }
                            }
                        }while (phone.length() != 9);
                        if(search(phone) == null){
                            System.out.println("Phone number is not on the list");
                        }
                        else {
                            display(search(phone));
                        }
                        break;
                    }
                    case 4:{
                        do{
                            System.out.print("Enter Phone Remove: (+84) ");
                            phone = scanner.nextLine();
                            if(phone.length() != 9){
                                System.err.print("\nWrong phone number format\n");
                                continue;
                            }
                            for(int i=0; i<9; i++){
                                if(Character.isLetter(phone.charAt(i))){
                                    phone = "0";
                                    break;
                                }
                            }
                        }while (phone.length() != 9);
                        if(remove(phone)){
                            System.out.println("Successful remove");
                        }
                        else {
                            System.out.println("Phone number is not on the list");
                        }
                        break;
                    }
                    case 5:{
                        System.out.println("-----Good Bye!!!-----");
                        break;
                    }
                    default:{
                        break;
                    }
                }
            }while (choice != 5);
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    public static void createCustomer() throws ParseException {
        char choice;
        String name, phone, address;
        Scanner scanner = new Scanner(System.in);
        List<Order> order;
        try{
            do{
                System.out.print("Enter Name: ");
                name = scanner.nextLine();
                do{
                    System.out.print("Enter Phone: (+84) ");
                    phone = scanner.nextLine();
                    if(phone.length() != 9){
                        System.err.print("\nWrong phone number format\n");
                        continue;
                    }
                    for(int i=0; i<9; i++){
                        if(Character.isLetter(phone.charAt(i))){
                            phone = "0";
                            break;
                        }
                    }
                }while (phone.length() != 9);
                System.out.print("Enter Address: ");
                address = scanner.nextLine();
                System.out.println("Enter Order Info:");
                order = setOrder();
                System.out.print("Enter 'n' or 'N' Exit: ");
                choice = scanner.next().charAt(0);
                scanner.nextLine();
                customers.add(new Customer(name, phone, address, order));
            }while (choice != 'n' && choice != 'N');
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    public static List<Order> setOrder() throws ParseException {
        String number, stDate;
        Date date;
        Double price;
        Integer quantity;
        List<Order> order = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.print("+ number: ");
                number = scanner.nextLine();
                if (number.length() != 10) {
                    System.err.println("Wrong number format");
                }
            } while (number.length() != 10);
            System.out.print("+ date (dd/mm/yyyy): ");
            stDate = scanner.nextLine();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            date = df.parse(stDate);
            System.out.print("+ price: ");
            price = scanner.nextDouble();
            System.out.print("+ quantity: ");
            quantity = scanner.nextInt();
            order.add(new Order(number, date, price, quantity));
            return order;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    public static List<Customer> findAll(){
        return customers;
    }
    public static void display(List<Customer> customers){
        if(customers == null){
            System.out.println("Empty list");
            return;
        }
        for(Customer customer: customers){
            System.out.println("[Name "+customer.getName()+", Phone 0"+customer.getPhone()+
                    ", Address "+customer.getAddress()+", Order "+customer.getOrder().toString()+"]");
        }
    }
    public static List<Customer> search(String phone){
        List<Customer> result = new ArrayList<>();
        result = null;
        for (Customer customer: customers) {
            if (customer.getPhone().equals(phone)) {
                result.add(customer);
            }
        }
        return result;
    }
    public static boolean remove(String phone) {
        for (Customer customer: customers) {
            if (customer.getPhone().equals(phone)) {
                customers.remove(customer);
                return true;
            }
        }
        return false;
    }
}
