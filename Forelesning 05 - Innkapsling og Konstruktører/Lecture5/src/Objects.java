public class Objects {
    public static void main(String[] args) {
        System.out.println("---Student 1---");

        Student student1 = new Student();
        System.out.println(student1);
        System.out.println(student1.firstName);

        student1.firstName = "Ole-Edvard";
        student1.lastName = "Ørebæk";
        student1.age = 28;
        student1.studentId = "123456";

        System.out.println("First name: " + student1.firstName);
        System.out.println("Last name: " + student1.lastName);
        System.out.println("Age: " + student1.age);
        System.out.println("Student ID: " + student1.studentId);
        System.out.println(student1); // Fortsatt samme rare utskrift


        System.out.println("\n---Student 2---");

        Student student2 = new Student();
        System.out.println(student2);
        System.out.println(student2.firstName);

        student2.firstName = "John";
        student2.lastName = "Doe";
        student2.age = 50;
        student2.studentId = "654321";

        System.out.println("First name: " + student2.firstName);
        System.out.println("Last name: " + student2.lastName);
        System.out.println("Age: " + student2.age);
        System.out.println("Student ID: " + student2.studentId);


        System.out.println("\n---Course object---");

        Course programming2 = new Course();
        programming2.courseName = "Programming 2";
        programming2.courseCode = "ITF10619";
        programming2.studyPoints = 10;

        System.out.println(programming2.courseName + " - "
                + programming2.courseCode + " - "
                + programming2.studyPoints);
    }
}
