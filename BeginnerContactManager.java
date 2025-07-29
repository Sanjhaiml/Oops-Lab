import java.util.ArrayList;
import java.util.Scanner;

public class BeginnerContactManager {
    public static void main(String[] args) {
        ArrayList<String> contacts = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Delete Contact");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                contacts.add(name);
                System.out.println("Contact added.");
            } else if (choice == 2) {
                System.out.println("Contacts:");
                for (int i = 0; i < contacts.size(); i++) {
                    System.out.println((i + 1) + ". " + contacts.get(i));
                }
                if (contacts.isEmpty()) {
                    System.out.println("No contacts found.");
                }
            } else if (choice == 3) {
                System.out.print("Enter contact number to delete: ");
                int num = sc.nextInt();
                if (num > 0 && num <= contacts.size()) {
                    contacts.remove(num - 1);
                    System.out.println("Contact deleted.");
                } else {
                    System.out.println("Invalid number.");
                }
            } else if (choice == 4) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}