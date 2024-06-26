package JavaPoints;

public class AbstractSolution extends Hidden {

    @Override
    public int getSew(int sew) {
        return super.getSew(sew);
    }

    public static void main(String[] args) {
//        Hidden hidden = new Hidden() {
//            @Override
//            public int hashCode() {
//                return super.hashCode();
//            }
//        };
    }

}

class Hidden {
    String a = "10";

    public final int getSew() {
        return 1;
    }

    public int getSew(int sew) {
        return sew;
    }
}
