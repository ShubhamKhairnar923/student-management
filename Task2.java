import java.util.ArrayList;
import java.util.Scanner;

// import javax.xml.stream.events.StartDocument;

class Student{

    private int id;
    private String name;
    private double marks;
    
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
    
}


public class Task2 {

    private static ArrayList<Student> studentList = new ArrayList<>();

    private static Scanner sc = new Scanner(System.in);

      public static void main(String[] args) {

        int choice;

         do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);


      }

      public static void addStudent(){
         System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear buffer
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter marks: ");
        double marks = sc.nextDouble();

        studentList.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");

      }



       private static void viewStudents() {

        if(studentList.isEmpty()){
            System.out.println("No students found.");
        }
        else{
            for(Student s : studentList){
                 System.out.println(s);
            }
        }
       }



       public static void updateStudent(){

         System.out.print("Enter student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

         Student student = findStudentById(id);

         if(student !=  null){
             System.out.print("Enter new name: ");
            String name = sc.nextLine();
            System.out.print("Enter new marks: ");
            double marks = sc.nextDouble();

            student.setName(name);
            student.setMarks(marks);

            System.out.println("Student updated successfully!");

         }
         else{
             System.out.println("Student not found.");
         }
       }



           private static void deleteStudent() {

            System.out.print("Enter student ID to delete: ");
            int id = sc.nextInt();

             Student student = findStudentById(id);

             if (student != null) {
            studentList.remove(student);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
           }




       public static Student findStudentById(int id){

        for(Student s : studentList){
            if(s.getId() == id){
                return s;
            }
        }

        return null;
       }

}
