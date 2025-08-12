import java.util.Scanner;

public class Employee {
    String fullName, employeeId, homeAddress, emailId;
    long contactNumber;
    double basicPay, dearnessAllowance, houseRentAllowance, providentFund, clubContribution, grossSalary, netSalary;

    public Employee(String name, String id, String address, String email, long contact, double pay) {
        fullName = name;
        employeeId = id;
        homeAddress = address;
        emailId = email;
        contactNumber = contact;
        basicPay = pay;
    }

    void computeSalaryComponents(double daRate, double hraRate, double pfRate, double clubRate) {
        dearnessAllowance = basicPay * daRate / 100;
        houseRentAllowance = basicPay * hraRate / 100;
        providentFund = basicPay * pfRate / 100;
        clubContribution = basicPay * clubRate / 100;
        grossSalary = basicPay + dearnessAllowance + houseRentAllowance;
        netSalary = grossSalary - (providentFund + clubContribution);
    }

    void generatePayStatement() {
        System.out.println("\n==============================");
        System.out.println(" SALARY DETAILS");
        System.out.println("==============================");
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name : " + fullName);
        System.out.println("Address : " + homeAddress);
        System.out.println("Email : " + emailId);
        System.out.println("Contact : " + contactNumber);
        System.out.println("------------------------------");
        System.out.println("Basic Salary : " + basicPay);
        System.out.println("Dearness Allowance : " + dearnessAllowance);
        System.out.println("House Rent Allowance : " + houseRentAllowance);
        System.out.println("Provident Fund : " + providentFund);
        System.out.println("Club Contribution : " + clubContribution);
        System.out.println("Gross Salary : " + grossSalary);
        System.out.println("Net Salary : " + netSalary);
        System.out.println("==============================");
    }

    // Subclasses (keeping original class names)
    static class Programmer extends Employee {
        Programmer(String name, String id, String address, String email, long contact, double pay) {
            super(name, id, address, email, contact, pay);
            computeSalaryComponents(97, 10, 12, 1);
        }
    }

    static class AssistantProfessor extends Employee {
        AssistantProfessor(String name, String id, String address, String email, long contact, double pay) {
            super(name, id, address, email, contact, pay);
            computeSalaryComponents(110, 20, 12, 5);
        }
    }

    static class AssociateProfessor extends Employee {
        AssociateProfessor(String name, String id, String address, String email, long contact, double pay) {
            super(name, id, address, email, contact, pay);
            computeSalaryComponents(130, 30, 12, 10);
        }
    }

    static class Professor extends Employee {
        Professor(String name, String id, String address, String email, long contact, double pay) {
            super(name, id, address, email, contact, pay);
            computeSalaryComponents(140, 40, 12, 15);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String name = input.nextLine();
        System.out.print("Enter Employee ID: ");
        String id = input.nextLine();
        System.out.print("Enter Address: ");
        String address = input.nextLine();
        System.out.print("Enter Email: ");
        String email = input.nextLine();
        System.out.print("Enter Contact Number: ");
        long contact = input.nextLong();

        System.out.println("\nSelect Designation:");
        System.out.println("1. Programmer");
        System.out.println("2. Assistant Professor");
        System.out.println("3. Associate Professor");
        System.out.println("4. Professor");
        System.out.print("Your Choice: ");
        int choice = input.nextInt();

        System.out.print("Enter Basic Salary: ");
        double pay = input.nextDouble();

        Employee staff = null;
        switch (choice) {
            case 1:
                staff = new Programmer(name, id, address, email, contact, pay);
                break;
            case 2:
                staff = new AssistantProfessor(name, id, address, email, contact, pay);
                break;
            case 3:
                staff = new AssociateProfessor(name, id, address, email, contact, pay);
                break;
            case 4:
                staff = new Professor(name, id, address, email, contact, pay);
                break;
            default:
                System.out.println("Invalid choice!");
                System.exit(0);
        }

        staff.generatePayStatement();
        input.close();
    }
}