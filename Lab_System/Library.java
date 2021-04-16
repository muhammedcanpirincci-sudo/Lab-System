package Hw1;
//Name- Surname : Muhammedcan Pirinççi
//StudentID: 150119679
//Purpose of this project: Making system that students can borrow or return books to-from ceratain libraries.

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class Library {
    String adress;
    ArrayList<Book> books = new ArrayList<Book>();
    ArrayList<Customer> customers=new ArrayList<Customer>();//Creating arrays.

    List<String> names_= new ArrayList<String>();
    List<String> books_= new ArrayList<String>();
    List<Integer> ids_= new ArrayList<Integer>();

    Library(String adress)  {
        try{
            setAdress(adress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void printOpeningHours(){
        System.out.println("Libraries are open daily from 9 am to 5 pm");

    }
    void printAddress(){
        System.out.println(adress);
    }

    boolean addBook(Book book){
        if (book.title!=null){
            books.add(book);
            return true;

        }
        else{
            return false;
        }


        //returns true when book is added succesfully
    }
    void addCustomer(Customer customer){
        customers.add(customer);


    }
    void borrowBook(String bookName,String personName){

        for (Customer cust_ : customers) {
            names_.add(cust_.name);
        }
        for (Book book_names : books) {
            books_.add(book_names.title);
        }

        if(books_.contains(bookName)){

            if (names_.contains(personName)){//Algorithm that checks wheter the person is customer or book is in library.And Checking if book is available to borrow or not.
                for (Book book_names : books) {
                    if(book_names.title.equals(bookName)& !book_names.isBorrowed() & !customers.get(names_.indexOf(personName)).borrowABook){
                        if(!book_names.isBorrowed() & !customers.get(names_.indexOf(personName)).borrowABook){
                            customers.get(names_.indexOf(personName)).setBorrowABook(true);
                            try {
                                customers.get(names_.indexOf(personName)).setBorrowedBook(book_names.title);
                            } catch (Exception e) {
                                System.out.println("Book name cant be smaller than 3");
                            }
                            books.get(books.indexOf(book_names)).borrowed();
                            ids_.add(book_names.id);
                            System.out.println("Book is succesfully borrewed");
                            break;
                        }
                    }
                    else {
                        if (!ids_.contains(book_names.id)){
                            if (books.get(books.indexOf(book_names)).isBorrowed()){
                                System.out.println("This book is borrowed. Please select another book.");
                            }
                            else if (customers.get(names_.indexOf(personName)).borrowABook){
                                System.out.println(personName+" already borrowed a book.");
                                break;
                            }
                        }
                    }
                    if(books.indexOf(book_names)==books.size()-1){ //if iteration ends and still cant find a book that fits to condition.
                        System.out.println("Sorry, this book is already borrowed");
                    }
                }
            }
            else {
                System.out.println("Sorry. "+personName+" Is not our customer.");
            }
        }
        else {
            System.out.println("Sorry."+bookName+" is not in this library.");
        }
    }
    void returnBook (String personName){
        if (names_.contains(personName)){
            if(customers.get(names_.indexOf(personName)).borrowABook){
                customers.get(names_.indexOf(personName)).setBorrowABook(false);
                books.get(books_.indexOf(customers.get(names_.indexOf(personName)).getBorrowedBook())).borrowed=false;
                System.out.println("Book returned.");
            }
            else {
                System.out.println("This customer didnt borrow any book.");
            }
        }
        else{
            System.out.println ("Sorry. "+personName+" is not a customer.");
        }

    }
    void printAvailableBooks(){
        if (books.isEmpty()){
            System.out.println("there is no books in this libray.");
        }
        else{
            for (Book book : books) {
                if (!book.isBorrowed()){
                    System.out.println(book.toString());
                }

            }
        }


    }
    //setter-getter methods.
    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) throws Exception {

        if (adress.length()<3){
            throw new Exception("Adress cannot be smaller than 3 characters");
        }
        else {
            this.adress = adress;
        }



    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Library{" +
                "adress='" + adress + '\'' +
                ", books=" + books +
                ", customers=" + customers +
                '}';
    }
}
