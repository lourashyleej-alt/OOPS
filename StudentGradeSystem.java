package studentgradesystem;
import java.util.*;
public class StudentGradeSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic her

        Scanner sc = new Scanner(System.in);

        Map<Integer, String> students = new HashMap<>();
        Map<Integer, Integer> marks = new HashMap<>();
        Set<Integer> studentIDs = new HashSet<>();
        List<String> studentNames = new ArrayList<>();

        students.put(101, "Arun");
        students.put(102, "Priya");
        students.put(103, "Kumar");

        marks.put(101, 85);
        marks.put(102, 92);
        marks.put(103, 78);

        studentIDs.add(101);
        studentIDs.add(102);
        studentIDs.add(103);

        studentNames.addAll(students.values());

        System.out.println("STUDENT GRADE MANAGEMENT SYSTEM");
        System.out.println("--------------------------------");

        for (Integer id : studentIDs) {
            System.out.println(
                "ID: " + id +
                ", Name: " + students.get(id) +
                ", Marks: " + marks.get(id)
            );
        }

        System.out.print("\nEnter Student ID to search: ");
        int searchID = sc.nextInt();

        if (students.containsKey(searchID)) {
            System.out.println("Student Name: " + students.get(searchID));
            System.out.println("Student Marks: " + marks.get(searchID));
        } else {
            System.out.println("Student not found!");
        }

        sc.close();
    }
    
}
