package Hw1;

import java.util.zip.Adler32;

public class Customer extends Person{
    String adress;
    String borrowedBook;
    boolean borrowABook=false;
    Customer(String name,String birthPlace,int birthDate,String adress) {
        super(name, birthDate, birthPlace);
        try {
            setAdress(adress);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    Customer(String name,  int birthDate, String adress){
        super(name,birthDate);
        try {
            setAdress(adress);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    Customer(String name, String adress){
        super(name);
        try {
            setAdress(adress);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    Customer(String name, int birthDate){
        super(name,birthDate);
    }

    public String getAdress() {
        return adress;
    }

    public String getBorrowedBook() {
        return this.borrowedBook;
    }

    public void setAdress(String adress) throws Exception {
        if (adress.length()<3){
            throw new Exception("Adress cant be smaller than 3 charachters.");
        }
        else {
            this.adress = adress;
        }
    }


    public void setBorrowABook(boolean borrowABook) {

        this.borrowABook = borrowABook;
    }


    public void setBorrowedBook(String borrowedBook) throws Exception {
        if (borrowedBook.length()<3){
            throw new Exception("Book name cant be smaller than 3 charachters.");
        }
        else {
            this.borrowedBook = borrowedBook;
        }


    }

    @Override
    public String toString() {
        return "Name: "+name+", Birth Date: "+birthDate+", Birth Place: "+birthPlace+", Adress: "+adress;
    }
}
