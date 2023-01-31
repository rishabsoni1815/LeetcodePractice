class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {

	int len = scores.length, omax = scores[0];
	int[][] temp = new int[len][2];
	for (int i = 0; i < len; i++) {
		temp[i][0] = ages[i];
		temp[i][1] = scores[i];
	}

	Arrays.sort(temp, new Comparator<int[]>() {
		public int compare(int[] o1, int[] o2) {
			return (o1[0] != o2[0]) ? o1[0] - o2[0] : o1[1] - o2[1];
		}
	});

	int[] dp = new int[len];
	dp[0] = temp[0][1];
	for (int i = 1; i < len; i++) {
		int max = 0, score = temp[i][1];
		for (int j = 0; j < i; j++) {
			if (score >= temp[j][1])
                max = Math.max(max, dp[j]);
		}
		dp[i] = max + temp[i][1];
		if (dp[i] > omax)
			omax = dp[i];
	}

	return omax;
}
}