public class TESTME {
    public static void switchME(int month){
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println(month + " has 31 days"); break;
            case 2:
                System.out.println(month + " has 29 days"); break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(month + " has 30 days"); break;
            default:
                System.out.println("Invalid value");
        }
    }
    public static void whileME() {
        int num = 1;
        while(num<=12){
            switchME(num++);
        }
    }
    public static void main(String[] args) {
        whileME();
    }
}
