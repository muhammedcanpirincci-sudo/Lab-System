package Hw1;

public class Dictionary extends Book{

    int definitions;

    Dictionary(int id, String title,Author author,int definitions){
        super(id,title,author);
        try {
            setDef(definitions);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    Dictionary(int id, String title, int definitions) {
        super(id, title);
        try {
            setDef(definitions);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    int getDefinitions(){
        return this.definitions;
    }
    void setDef(int definitions) throws Exception {
        if (definitions<0){
            throw new Exception("Definitions cant be negative");
        }
        else {
            this.definitions=Math.abs(definitions);
        }

    }
    @Override
    public String toString(){
        return "Dictionary Name is "+this.title+", definitons: "+this.definitions;
    }
}
