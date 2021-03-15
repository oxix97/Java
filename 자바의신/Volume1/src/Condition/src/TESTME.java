package Condition.src;

public class TESTME {

    public static void onlyIF(int num){
        if(num > 5) System.out.println("only");
        if(num > 3) System.out.println("only");
    }

    public static void elseIF(int num){
        if(num > 5) System.out.println("else");
        else if(num > 3) System.out.println("else");
    }

    public static void ifME(int point){
        if(point > 90) System.out.println("A");
        else if(point > 80) System.out.println("B");
        else if(point > 70) System.out.println("C");
        else System.out.println("F");
    }

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

    public static void continueME() {
        int num = 0;
        while(++num <=12){
            if(num % 2 == 0) continue;
            switchME(num);
        }
    }

    public static void breakME() {
        int num = 1;
        while(num <= 12){
            if (num > 7) break;
            switchME(num++);
        }
    }

    public static void forME(){
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("1 to 10 = " + sum);
    }
    public static void main(String[] args) {
        forME();
    }
}
