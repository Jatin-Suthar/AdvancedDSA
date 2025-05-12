package BitManipulationTricksAndHacks.basicfunctions;

public class PrintBinary {
    public static void main(String[] args) {
        int num = 48;
        StringBuilder sBinary = new StringBuilder();
        for(int i=10; i>=0; i--) {
            sBinary.append((num >> i) & 1);
        }
        System.out.println(sBinary);
    }
}
