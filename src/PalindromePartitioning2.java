
public class PalindromePartitioning2 {
	 public int minCut(String s) {
	        if (s == null || s.length() == 0) return 0;
	        
	        int len = s.length();
	        boolean[][] isPalindrome = new boolean[len][len];
	        for (int i=0; i<len; ++i) {
	        	isPalindrome[i][i] = true;
	        }
	        for (int j=1; j<len; ++j) {
	        	for(int i=0; i<j; ++i) {
	        		if (s.charAt(i) == s.charAt(j)) {
						int index1 = i+1;
						int index2 = j-1;
						isPalindrome[i][j] = (index1>=index2||isPalindrome[index1][index2]);
					}
	        	}
	        }
	        
	        int[] dp = new int[len];
	        dp[0] = 0;
	        for (int i = 1; i < dp.length; ++i) {
	        	if (isPalindrome[0][i]) {
	        		dp[i] = 0;
	        		continue;
	        	}
	        	dp[i] = dp[i-1] + 1;
				for (int j = 1; j < i; ++j) {
					if (isPalindrome[j][i]) {
						dp[i] = Math.min(dp[i], dp[j-1]+1);
					}
				}
			}
	        return dp[len-1];
	    }
}
