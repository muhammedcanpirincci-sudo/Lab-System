package Hw1;

public class Person {
    String name;
    String birthDate;
    String birthPlace;

    Person(String name, int birthDate, String birthPlace) {
        try{
            setName(name);
            setBirthPlace(birthPlace);
            setBirthDate(birthDate);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }




    }
    Person(String name,  int birthDate){
        try{
            setName(name);
            setBirthDate(birthDate);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    Person(String name){
        try{
            setName(name);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void setBirthDate(int birthDate) throws Exception {
        if (birthDate<0){
            throw new Exception("Birthdate cant be negative.");
        }
        else {
            this.birthDate =  Integer.toString(Math.abs(birthDate));
        }

    }

    public void setName(String name) throws Exception {

        if (name.length()<3){
            throw new Exception("Name cannot be smaller than 3 char");
        }
        else {
            this.name = name = name;
        }

    }

    public void setBirthPlace(String birthPlace) throws Exception {
        if (birthPlace.length()<3){
            throw new Exception("Birth place cannot be smaller than 3 char");
        }
        else {
            this.birthPlace = birthPlace;
        }

    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return "Name: "+this.name+", Birth Date: "+this.birthDate+", Birth Place: "+this.birthPlace;
    }
}
