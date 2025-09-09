

import java.io.*;
import java.util.*;

 class javaapplication2{
    // Keep file in project folder
    static final String FILE = "students.txt";
    static Scanner sc = new Scanner(System.in);

    public static void writeRecord(String record) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {
            bw.write(record);
            bw.newLine();
            System.out.println("Record written (file overwritten).");
        } catch (IOException e) {
            System.out.println("Error writing record: " + e.getMessage());
        }
    }

    public static void appendRecord(String record) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE, true))) {
            bw.write(record);
            bw.newLine();
            System.out.println("Record appended.");
        } catch (IOException e) {
            System.out.println("Error appending record: " + e.getMessage());
        }
    }

    public static void readRecords() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            System.out.println("\n--- Student Records ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading records: " + e.getMessage());
        }
    }

    public static void updateRecord(String rollNo, String newRecord) {
        File input = new File(FILE);
        File temp = new File("temp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(input));
             BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {

            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(rollNo + ",")) {
                    bw.write(newRecord);
                    found = true;
                } else {
                    bw.write(line);
                }
                bw.newLine();
            }
            if (found) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("Record not found.");
            }
        } catch (IOException e) {
            System.out.println("Error updating record: " + e.getMessage());
        }

        input.delete();
        temp.renameTo(input);
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n==== Student Record Management System ====");
            System.out.println("1. Write New Record (overwrite file)");
            System.out.println("2. Append New Record");
            System.out.println("3. Read All Records");
            System.out.println("4. Update Record");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter RollNo: ");
                    String roll1 = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name1 = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course1 = sc.nextLine();
                    writeRecord(roll1 + "," + name1 + "," + course1);
                    break;

                case 2:
                    System.out.print("Enter RollNo: ");
                    String roll2 = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name2 = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course2 = sc.nextLine();
                    appendRecord(roll2 + "," + name2 + "," + course2);
                    break;

                case 3:
                    readRecords();
                    break;

                case 4:
                    System.out.print("Enter RollNo to Update: ");
                    String rollU = sc.nextLine();
                    System.out.print("Enter New RollNo: ");
                    String newRoll = sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();
                    updateRecord(rollU, newRoll + "," + newName + "," + newCourse);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }
}