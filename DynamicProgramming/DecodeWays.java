package DynamicProgramming;

public class DecodeWays {
	public int numDecodings(String s) {
		if (s.charAt(0) == '0')
			return 0;
		int len = s.length();
		int dp[] = new int[len + 1];
		dp[len] = 1;
		for (int i = len - 1; i >= 0; i--) {
			if (s.charAt(i) == '0') {
				dp[i] = 0;
			} else {
				dp[i] = dp[i + 1];
				if (i < len - 1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')))
					dp[i] += dp[i + 2];
			}
		}
		return (s.isEmpty()) ? 0 : dp[0];
	}
}
