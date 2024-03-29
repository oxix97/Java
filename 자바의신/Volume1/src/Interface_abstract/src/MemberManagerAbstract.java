package Interface_abstract.src;

public abstract class MemberManagerAbstract {
    public abstract boolean addMember(MemberDTO member);
    public abstract boolean removeMember(String name, String phone);
    public abstract boolean updateMember(MemberDTO member);
    public void print(String data){
        System.out.println("data " + data);
    }
}