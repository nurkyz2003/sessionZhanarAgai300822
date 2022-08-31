import java.util.Scanner;

public class Employee {
    Scanner scanner = new Scanner(System.in);
    private String firstname,lastname;
    private int birthYear,startWorkYear;

    public Employee(){
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getStartWorkYear() {
        return startWorkYear;
    }

    public void setStartWorkYear(int startWorkYear) {
        this.startWorkYear = startWorkYear;
    }
}
