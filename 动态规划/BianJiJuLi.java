package 动态规划;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class BianJiJuLi {
	public static void main(String[] args) {
		System.out.println(minDistance("horse", "ros"));
		System.out.println(BianJi("horse", "ros"));
		System.out.println(BJ("horse", "ros"));
	}

	public static int minDistance(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();

		// 有一个字符串为空串
		if (n * m == 0) {
			return n + m;
		}

		// DP 数组
		int[][] D = new int[n + 1][m + 1];

		// 边界状态初始化
		for (int i = 0; i < n + 1; i++) {
			D[i][0] = i;
		}
		for (int j = 0; j < m + 1; j++) {
			D[0][j] = j;
		}

		// 计算所有 DP 值
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				int left = D[i - 1][j] + 1;
				int down = D[i][j - 1] + 1;
				int left_down = D[i - 1][j - 1];
				if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
					left_down += 1;
				}
				D[i][j] = Math.min(left, Math.min(down, left_down));
			}
		}
		return D[n][m];
	}

	public static int BianJi(String word1, String word2) {
		char[] a = word1.toCharArray();
		char[] b = word2.toCharArray();
		int[][] len = new int[a.length + 1][b.length + 1];
		for (int i = 0; i < a.length + 1; i++) {
			len[i][0] = i;
		}
		for (int j = 0; j <b.length + 1; j++) {
			len[0][j] = j;
		}
		for (int i = 1; i < a.length + 1; i++) {
			for (int j = 1; j < b.length + 1; j++) {
				if (a[i - 1] == b[j - 1]) {
					len[i][j] = len[i - 1][j - 1];
				} else {
					len[i][j] = Math.min(Math.min(len[i - 1][j], len[i - 1][j - 1]), len[i][j - 1]) + 1;
				}
			}
		}
		return len[a.length][b.length];
	}

	public static int BJ(String word1, String word2) {
		char[] a = word1.toCharArray();
		char[] b = word2.toCharArray();
		int[][] dp = new int[a.length+1][b.length+1];
		for(int i = 0; i < a.length+1; i++) {
			dp[i][0] = i;
		}
		for(int i = 0; i < b.length+1; i++) {
			dp[0][i] = i;
		}

		for(int i = 1; i < a.length+1; i++) {
			for(int j = 1; j < b.length+1; j++) {
				if(a[i - 1] == b[j - 1]) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
				}
			}
		}
		return dp[a.length][b.length];
	}

}
