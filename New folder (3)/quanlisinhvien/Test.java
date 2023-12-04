package quanlisinhvien;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Test {
private static final List<Student> students=new ArrayList<>(){{
add(new Student(1,"ngoc nhi","20/12/1989","duong so 7 hn",6.7f));
    add(new Student(1,"ngoc nhi","9/1/1940","tphcm",8.7f));
    add(new Student(2,"bao tuan","23/4/1987","son tay hn",9.8f));
    add(new Student(3,"quoc bao","21/4/1999","duong so 7 hn",7.7f));
    add(new Student(4,"tieunhi","11/1/1780","duong so 7 hn",6.9f));
    add(new Student(5,"thaongoc","6/5/1976","duong so 7 hn",3.4f));
}};

    public static void main(String[] args) {
        try(final Scanner sc=new Scanner(System.in)) {
            do {
                System.out.println("1. Add student");
                System.out.println("2.Edit student by id");
                System.out.println("3. Delete a student by id");
                System.out.println("4. Sort student by gpa");
                System.out.println("5. Sort student by name");
                System.out.println("6. Show student");
                System.out.println("0.Exit");
                System.out.println("Chosse a menu:");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        addStudent(sc);
                        break;
                    case 2:
                        editStudentById(sc);
                        break;
                    case 3:
                        deleteStudentById(sc);
                        break;
                    case 4:
                        sortStudentByGpa();
                        break;
                    case 5:
                        sortByName();
                        break;
                    case 6:
                        showStudents();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            }while (true);
            }catch (Exception e){
        System.out.println(e.getMessage());
        }
    }
    private static void addStudent(Scanner scanner){
        System.out.println("Enter student name:");
        scanner.nextLine();
        String name=scanner.nextLine();

        System.out.println("Enter student date of birth:");
        String dateOfBirth=scanner.nextLine();

        System.out.println("Enter student address:");
        String address=scanner.nextLine();

        System.out.println("Enter student gpa:");
        float gpa=scanner.nextFloat();

        int studentId=students.size()+1;
        Student student =new Student(studentId,name,dateOfBirth,address,gpa);
        students.add(student);
    }
    private  static void showStudents(){
      for (Student student:students){
          System.out.println(student);
    }
}
    private static void editStudentById(Scanner scanner){
        System.out.println("Enter the student id:");
        int studentId=scanner.nextInt();
        Student student=students.stream()
                .filter(s->s.getId()==studentId)
                .findFirst()
                .orElse(null);
        if(student==null) {
            System.out.println("Student not found");
            return;
        }
        System.out.println("Enter student name:");
        scanner.nextLine();
        String name=scanner.nextLine();

        System.out.println("Enter student date of birth:");
        String dateOfBirth=scanner.nextLine();

        System.out.println("Enter student address:");
        String address=scanner.nextLine();

        System.out.println("Enter student gpa:");
        float gpa=scanner.nextFloat();
        student.setName(name);
        student.setDateOfBirth(dateOfBirth);
       student.setAddress(address);
        student.setGpa(gpa);

        System.out.println("Student updated");
    }
       private  static void sortStudentByGpa() {
           students.sort(Comparator.comparing(Student::getGpa).reversed());
           System.out.println("Student after sort by gpa");
       }
       private static void sortByName() {
        students.sort(Comparator.comparing(Student::getName));
           System.out.println("Student after sort by name:");
           students.forEach(System.out::println);
       }
    private static void deleteStudentById(Scanner scanner){
        System.out.println("Enter the student id:");
        int id=scanner.nextInt();
        boolean isRemoveSucceed=students.removeIf(student -> student.getId()==id);
        if (!isRemoveSucceed) {
            System.out.println("Student with id" + id + "not found");
        }else {
            System.out.println("Student with id"+id+"deleted");
        }
    }
}

