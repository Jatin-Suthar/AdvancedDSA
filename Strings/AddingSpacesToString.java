package Strings;

public class AddingSpacesToString {

    public static void main(String[] args) {
        String s = "AddingSpacesToString";
        int[] spaces = {6};
        AddingSpacesToStringSolution solution = new AddingSpacesToStringSolution();
        System.out.println(solution.addSpaces(s, spaces));
    }

}

class AddingSpacesToStringSolution {
    public String addSpaces(String s, int[] spaces) {
        int sliceStart = 0;
        StringBuilder ans = new StringBuilder();
        for(int sliceEnd: spaces) {
            while(sliceStart<sliceEnd) {
                ans.append(s.charAt(sliceStart++));
            }
            ans.append(" ");
        }
        while(sliceStart<s.length()) {
            ans.append(s.charAt(sliceStart++));
        }
        return ans.toString();
    }
}