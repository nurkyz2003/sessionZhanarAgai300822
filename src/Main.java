import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the employess conter: ");
        Employee[] employees = new Employee[scanner.nextInt()];
        scanner.nextLine();
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee();
            employees[i].setFirstname(writeName(i,"first name "));
            employees[i].setLastname(writeName(i,"last name  "));
            employees[i].setBirthYear(writeYear(i,"birth year "));
            employees[i].setStartWorkYear(writeWorkYear(i,employees[i].getBirthYear(),"work year "));
        }
        for (Employee i : employees) {
            System.out.println("-------------------------------------------");
            System.out.println("Name: " + i.getFirstname());
            System.out.println("Surname: " + i.getLastname());
            System.out.println("Birth Year: " + i.getBirthYear());
            System.out.println("Begin Work Year : " + i.getStartWorkYear());
        }
    }
    public static String writeName(int i,String word){
        System.out.printf("Enter %d'th employee's %s",i,word);
        String names = scanner.nextLine();
        try{
            if(!checkName(names))
                throw new Exception("Name must contain only letters");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            while (!checkName(names)){
                System.out.printf("Enter employee's %d %s again: ",i,word);
                names = scanner.nextLine();
            }
        }
        return names;
    }
    public static boolean checkName(String  names) {
        int counter = 0;
        for (int j = 0; j <names.length(); j++) {
            if (Character.isLetter(names.charAt(j)))
                counter++ ;
        }
        return counter == names.length();
    }
    public static int writeYear(int i, String word) {
        while (true) {
            try {
                System.out.printf("Enter %d'th employe's %s", i, word);
                int year = scanner.nextInt();
                if (year > 1950 && LocalDate.now().getYear() - year > 0) {
                    if (LocalDate.now().getYear() - year < 18) {
                        System.exit(0);
                    }
                    scanner.nextLine();
                    return year;
                }
                throw new Exception();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.printf("Error %d'th employe's %s", i, word);
            }
        }
    }
    public static int writeWorkYear(int i, int birthYear, String word){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter %d'th employee's %s ", i, word);
        int workYear = scanner.nextInt();
        try {
            if (checkWorkYear(workYear, birthYear))
                throw new Exception("Error workYear");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            while (checkWorkYear(workYear, birthYear)){
                System.out.printf("Enter %d'th employee's %s again: ", i, word);
                workYear = scanner.nextInt();
            }
        }
        return workYear;
    }

    public static boolean checkWorkYear(int workYear, int birthYear){
        return (workYear - birthYear) < 18;
    }
}