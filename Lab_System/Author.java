package Hw1;

public class Author extends Person{
    String publisher;

    Author(String name, String publisher, int birthDate) {
        super(name, birthDate);
        try {
            setPublisher(publisher);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) throws Exception {
        if (publisher.length()<3){
            throw new Exception("Publisher cant be smaller than 3 charachters.");
        }
        else {
            this.publisher = publisher;
        }

    }

    @Override
    public String toString() {
        return "Author is "+name;
    }
}
