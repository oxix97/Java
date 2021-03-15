package ReferenceType.src;

public class StaticBlock {
    static int data = 1;

    public StaticBlock() {
        System.out.println("staticBlock start");
    }

    static{
        System.out.println("First Block");
        data = 3;
    }

    static{
        System.out.println("Second Block");
        data = 5;
    }

    public static int getData(){
        return data;
    }

    public void makeStaticBlock() {
        System.out.println("data = " + StaticBlock.getData());
        StaticBlock block1 = new StaticBlock();
        data = 1;

        System.out.println("====================");

        StaticBlock block2 = new StaticBlock();
        data = 2;
        System.out.println("data = "+ StaticBlock.getData());
    }
    public static void main(String[] args) {
        StaticBlock block = new StaticBlock();
        block.makeStaticBlock();
    }
}
