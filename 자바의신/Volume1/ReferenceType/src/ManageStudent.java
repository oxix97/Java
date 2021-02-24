class Student{
    String name;
    String address;
    String phone;
    String email;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return name + " " + address + " " + phone + " " + email;
    }
}
public class ManageStudent {
    public static void main(String[] args) {
        Student[] students = null;
        ManageStudent manageStudent = new ManageStudent();
        students = manageStudent.addStudent();
        manageStudent.printStudents(students);

    }
    public Student[] addStudent(){
        Student[] students = new Student[3];
        students[0] = new Student("Lee");
        students[1] = new Student("Jong");
        students[2] = new Student("Chan","Seoul","010-1234-5678","oxix97@github.com");
        return students;
    }
    public void printStudents(Student[] students){
        for(Student s : students){
            System.out.println(s);
        }
    }
}
