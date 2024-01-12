//Student Grade Management System
package Task_7;

public class Student {

    String name;
    int roll;
    int subjectMarks[];
    int totalMarks;
    int numberOfSubjects;
    String grade;
    float averagePercentage;

    Student(String name, int roll, int[] subjectMarks, int totalMarks, int numberOfSubjects, String grade,
            float averagePercentage) {
        this.name = name; // Assigns the student's name
        this.roll = roll; // Assigns the student's roll number
        this.subjectMarks = subjectMarks; // Assigns the array of subject marks
        this.totalMarks = totalMarks; // Assigns the total marks obtained
        this.numberOfSubjects = numberOfSubjects; // Assigns the number of subjects
        this.grade = grade; // Assigns the student's grade
        this.averagePercentage = averagePercentage; // Assigns the average percentage
    }

    public static void printMarks(int[] subjectMarks) {
        int subMarks[] = subjectMarks;
        for (int i = 0; i < subMarks.length; i++) {

            System.out.print("[Subject " + (i + 1) + " : " + subMarks[i] + "]\t");
        }
    }

}
