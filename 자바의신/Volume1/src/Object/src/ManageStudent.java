package Object.src;

class Student {
    String name;
    String address;
    String phone;
    String email;

    public Student(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null) return false;

        if (getClass() != obj.getClass()) return false;

        Student other = (Student) obj;

        if (address == null) {
            if (other.address != null) return false;

        } else if (!address.equals(other.address)) return false;

        if (email == null) {
            if (other.email != null) return false;

        } else if (!email.equals(other.email)) return false;

        if (name == null) {
            if (other.name != null) return false;

        } else if (!name.equals(other.name)) return false;

        if (phone == null) {
            return other.phone == null;
        } else return phone.equals(other.phone);
    }
}
public class ManageStudent{
    public static void main(String[] args) {
        ManageStudent student = new ManageStudent();
        student.checkEquals();
    }

    public void checkEquals(){
        Student student1 = new Student("Min","Seoul","010xxxxxxxx","oxix97@github.com");
        Student student2 = new Student("Min","Seoul","010xxxxxxxx","oxix97@github.com");

        if(student1.equals(student2)) System.out.println("Equals");
        else System.out.println("NotEquals");


    }
}