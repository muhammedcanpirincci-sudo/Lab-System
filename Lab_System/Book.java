package Hw1;

import com.sun.org.apache.bcel.internal.ExceptionConst;

public class Book {
    int id;
    String title;
    Author author;
    boolean borrowed=false;
    //Name- Surname : Muhammedcan Pirinççi
    //StudentID: 150119679
    //Purpose of this project: Making system that students can borrow or return books to-from ceratain libraries.

    Book(int id, String title, Author author){
        try {
            setId(id);
            setAuthor(author);
            setTitle(title);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }

    Book(int id, String title){
        try {
            setId(id);
            setTitle(title);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
    boolean isBorrowed(){
        return this.borrowed;

    }
    boolean borrowed(){
        if (!this.borrowed){
            this.borrowed=true;
            return this.borrowed;
        }
        else {
            this.borrowed=false;
            return false;
        }
    }
    boolean returned(){
        if (this.borrowed){
            this.borrowed=false;
            return this.borrowed;
        }
        else {

            return false;
        }
    }



    int getId(){
        return this.id;
    }
    String getTitle(){
        return this.title;
    }
    Author getAuthor(){
        return this.author;
    }
    void setId(int id) throws Exception {
        if (id<0){
            throw new Exception("Id cannot be smaller than 0");
        }
        else {
            this.id=Math.abs(id);
        }

    }
    void setTitle(String title) throws Exception {
        if (title.length()<3){
            throw new Exception("Book title can't be smaller than 3 charachters");
        }
        else {
            this.title=title;
        }

    }
    void setAuthor(Author author){
        this.author=author;
    }

    @Override
    public String toString(){
        return "Book name is "+this.title+this.author;
    }


}
