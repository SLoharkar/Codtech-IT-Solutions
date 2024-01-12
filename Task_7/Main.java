//Student Grade Management System
package Task_7;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Student> studList = new ArrayList<Student>();

    public static void main(String arg[]) {

        System.out.println("\n\t\tWelcome to Student Grade Management System");

        int ch;
        do {
            System.out.println("\n\n1: Add Student");
            System.out.println("2: Delete Student");
            System.out.println("3: Update Student");
            System.out.println("4: Display Student");
            System.out.println("5: Exit");
            System.out.print("Enter your choice: ");
            ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    displayStudent();
                    break;
                case 5:
                    System.out.println("\nGoodbye! Thank you for using Student Grade Management System");
                    break;
            }
        } while (ch != 5);
    }

    private static void addStudent() {

        System.out.print("\nEnter your name : ");
        String studName = scanner.next();

        System.out.print("\nEnter your roll number : ");
        int roll = scanner.nextInt();

        System.out.print("\nEnter the number of Subjects: \t");
        int numberOfSubjects = scanner.nextInt();

        int[] marks = new int[numberOfSubjects];

        int totalMarks = 0;

        for (int i = 0, value; i < numberOfSubjects; i++) {

            System.out.print("\nEnter the marks obtained out of 100 in Subject " + (i + 1) + ":\t ");

            value = scanner.nextInt();

            if (value <= 100) {
                // Storing Subject Marks in Array
                marks[i] = value;

                // Calculate Total Marks
                totalMarks += marks[i];
            } else {
                System.out.println("\n\t!!! Please enter the valid marks !!!");
                i--;
            }

        }

        // Calculate Average Percentage
        float averagePercentage = (float) totalMarks / numberOfSubjects;

        String grade;

        switch ((int) (averagePercentage / 10)) {
            case 9, 10:
                grade = "A";
                break;
            case 8:
                grade = "B";
                break;
            case 7:
                grade = "C";
                break;
            case 6:
                grade = "D";
                break;
            case 5, 4:
                grade = "Pass";
                break;
            default:
                grade = "Fail";
                break;
        }

        System.out.println("\nTotal marks: " + totalMarks + "/" + numberOfSubjects * 100);

        System.out.println("\nAverage percentage: " + averagePercentage);

        System.out.println("\nGrade: " + grade);

        studList.add(new Student(studName, roll, marks, totalMarks, numberOfSubjects, grade, averagePercentage));

    }

    private static void updateStudent() {

        System.out.print("Please Enter Existing Student Roll No : ");
        int roll = scanner.nextInt();
        int cnt = 0;

        for (Student stud : studList) {

            if (stud.roll == roll) {
                System.out.println("\n\t\t !!! Student Marks Update Restricted !!! \n");

                int choice;
                do {
                    System.out.println("\n1: Update Student Name");
                    System.out.println("2: Update Student Roll");
                    System.out.println("3: Exit");
                    System.out.print("Enter your choice : ");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.print("\nPlease Enter your Name : ");
                            stud.name = scanner.next();
                            break;
                        case 2:
                            System.out.print("\nPlease Enter your Roll : ");
                            stud.roll = scanner.nextInt();
                            break;
                    }

                } while (choice != 3);

            } else {
                cnt++;
            }

        }
        if (cnt > 0) {
            System.out.println("\nEnter Roll No is not valid");
        }

    }

    private static void displayStudent() {
        for (int i = 0; i < studList.size(); i++) {
            System.out.println("\n\nRecord " + (i + 1));
            System.out.println("\n\t\tStudent Name : " + studList.get(i).name);
            System.out.println("\nStudent Roll : " + studList.get(i).roll);
            System.out.println("Student Number of Subjects : " + studList.get(i).numberOfSubjects);
            System.out.println("Student Total Marks : " + studList.get(i).totalMarks);
            System.out.println("Student Average Percentage : " + studList.get(i).averagePercentage);
            System.out.println("Student Grade : " + studList.get(i).grade);
            System.out.print("Student Subject Marks : ");
            Student.printMarks(studList.get(i).subjectMarks);
        }
    }

    private static void deleteStudent() {
        System.out.print("\nPlease Enter Existing Student Roll No : ");
        int roll = scanner.nextInt();

        for (Student stud : studList) {
            if (stud.roll == roll) {
                studList.remove(stud);
                System.out.println("\nStudent " + stud.name + " Record Deleted Sucessfully");
                break;
            } else {
                System.out.println("\nEnter Roll No is not valid");
                break;

            }
        }

    }

}