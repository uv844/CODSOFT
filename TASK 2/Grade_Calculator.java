import java.util.Scanner;

public class Grade_Calculator {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        float marks[], totalMarks = 0, averagePerc;
        System.out.println("Enter total number of subjects");
        int totalSubjects = sc.nextInt();
        marks = new float[totalSubjects];
        for(int i = 0; i < totalSubjects; i++)
        {
            System.out.println("Enter marks of Subject "+(i+1));
            marks[i] = sc.nextInt();
        }
        sc.close();

        for(int i = 0; i < totalSubjects; i++)
            totalMarks += marks[i];

        averagePerc = totalMarks/totalSubjects;
        char grade;
        if( averagePerc >= 90.0)
            grade = 'A';
        
        else if (averagePerc < 90.0 && averagePerc >=80.0 )
            grade = 'B';

        else if (averagePerc < 80.0 && averagePerc >= 70.0)
            grade = 'C';
            
        else if (averagePerc < 70.0 && averagePerc >= 55.0)
            grade = 'D';

        else if (averagePerc < 55.0 && averagePerc >= 40.0)
            grade = 'E';

        else
            grade = 'F';
        
        System.out.println("\n=================================================");
        System.out.println("Total Subjects = "+totalSubjects);
        System.out.println("Max. Marks of each subject = 100\n");
        System.out.println("Total Marks = "+totalMarks);
        System.out.println("Average Percentage = "+averagePerc);
        System.out.println("Grade = "+grade);
        if(grade == 'F')
            System.out.println("You are fail.");
        System.out.println("=================================================\n");        
    }
}