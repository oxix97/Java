package Interface_abstract.src;

public class MemberDTO {
    String name;
    String phone;
    String email;

    public MemberDTO(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public MemberDTO(String name) {
        this.name = name;
    }

    public MemberDTO() {

    }

    @Override
    public String toString() {
        return "name : " + name + "\nphone: " + phone + "\nEmail " + email;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if(getClass() != obj.getClass()) return false;

        MemberDTO dto = (MemberDTO) obj;

        if(name == null){
            return dto.name.equals(((MemberDTO) obj).name);
        }
        else return name.equals(((MemberDTO) obj).name);
    }
    public static void main(String[] args) {
        MemberDTO dto1 = new MemberDTO("Lee");
        MemberDTO dto2 = new MemberDTO("Lee");

        if (dto1.equals(dto2)) {
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}