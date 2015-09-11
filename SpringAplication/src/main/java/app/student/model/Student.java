package app.student.model;



public class Student  {
    private int id;
    private String firstName;
    private String secondName;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public String toString(){
        return "Id: "+ id +" First_Name: " + firstName+" Second_name: "+ secondName+"\n";
    }
}
