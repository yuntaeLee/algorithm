package level0;

public class SimpleLogicOperation {
    
    public static void main(String[] args) {
        boolean x1 = false;
        boolean x2 = true;
        boolean x3 = true;
        boolean x4 = true;

        boolean actual = solution(x1, x2, x3, x4);

        boolean excepted = true;
        System.out.println(actual == excepted);
    }

    static boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        return (x1 || x2) && (x3 || x4);
    }
}
