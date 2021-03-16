package Inheritance.src;

public class InheritanceCasting {
    public static void main(String[] args) {
        InheritanceCasting ic = new InheritanceCasting();
        //ic.objectCasting();
        //ic.objectCastingArray();

        ic.callPrintNames();
    }

    public void objectCasting() {
        ChildCasting cc1 = new ChildCasting();
        ParentCasting pc = cc1;
        ChildCasting cc2 = (ChildCasting) pc;
    }

    public void objectCastingArray(){
        ParentCasting[] pca = new ParentCasting[3];

        pca[0] = new ChildCasting();
        pca[1] = new ParentCasting();
        pca[2] = new ChildCasting();

        objectCheck(pca);
    }

    public void objectCheck(ParentCasting[] parentArray){
        for (ParentCasting cast : parentArray) {
            if (cast instanceof ChildCasting) {
                System.out.println("ChildCasting");
                ChildCasting cc = (ChildCasting) cast;
            }else
                System.out.println("ParentCasting");
        }
    }

    public void callPrintNames(){
        Parent parent1 = new Parent();
        Parent parent2 = new Child();

        parent1.printName();
        parent2.printName();
    }
}
