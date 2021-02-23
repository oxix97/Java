public class ManageHeight {
    static int[][] gradeHeights;
    public void setData(){
        gradeHeights = new int[][]{
            {170,180,173,175,177},
            {160,165,167,186},
            {158,177,187,176},
            {173,182,181},
            {170,180,165,177,172}};
    }

    public void printHeight(int classNo){
        setData();
        for (int i = 0; i < gradeHeights.length; i++) {
            System.out.println("Class No. : " + (i + 1));
            for(int data : gradeHeights[i]) System.out.println(data);
        }
    }

    public void printAverage(int classNo){
        setData();
        for (int i = 0; i < gradeHeights.length; i++) {
            double sum = 0;
            System.out.println("Class No. : " + (i + 1));
            for(int data : gradeHeights[i]) sum += data;
            System.out.println("Height average : "+sum/gradeHeights[i].length);
        }
    }

    public static void main(String[] args) {
        ManageHeight height = new ManageHeight();
        height.printAverage(5);

    }
}
