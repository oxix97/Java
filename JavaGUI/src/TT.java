public class TT {
    public static void main(String[] args) {
        int k =2,j;
        while (true) {
            j=2;
            while(k%j!=0)
                j++;
            if (k == j) {
                System.out.println(k);
            }
            if (k < 7) {
                k++;
            } else {
                break;
            }
        }
    }
}
