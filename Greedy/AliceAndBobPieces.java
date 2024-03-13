package Greedy;

public class AliceAndBobPieces {

    public static void main(String[] args) {
        String s = "AAAABBBB";
        Solution_AliceAndBobPieces solution = new Solution_AliceAndBobPieces();
        System.out.println(solution.winnerOfGame(s));
    }

}

class Solution_AliceAndBobPieces {
    public boolean winnerOfGame(String colors) {
        int aCount = 0, bCount = 0;

        int aCurr = 0, bCurr = 0;
        for(char c: colors.toCharArray()) {
            if(c == 'A') {
                aCurr++;
            } else {
                if(aCurr>2)
                    aCount += (aCurr-2);
                aCurr = 0;
            }
            if(c == 'B') {
                bCurr++;
            } else {
                if(bCurr>2)
                    bCount += (bCurr-2);
                bCurr = 0;
            }
        }
        if(aCurr>2)
            aCount += (aCurr-2);
        if(bCurr>2)
            bCount += (bCurr-2);
        return aCount>bCount;
    }
}