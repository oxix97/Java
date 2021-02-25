public class InheritanceCasting {
    public static void main(String[] args) {
        InheritanceCasting ic = new InheritanceCasting();
        ic.objectCasting();
    }

    public void objectCasting() {
        ParentCasting pc1 = new ParentCasting();
        ChildCasting cc1 = new ChildCasting();

        ParentCasting pc2 = cc1;
        ChildCasting cc2 = (ChildCasting) pc1;
    }

}
