package dynamic;

public class MaxSquare {
    public static void main(String[] args) {
        System.out.println("hello world");
    }
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;
        int width = matrix[0].length;
        int height = matrix.length;
        int[][] dp = new int[height + 1][width + 1];
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length - 1; i++) {
            for (int j = 0; j < dp[0].length - 1; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                    maxLength = Math.max(maxLength, dp[i + 1][j + 1]);
                }
            }
        }
        return maxLength * maxLength;
    }

    public int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        int height = matrix.length;
        int width = matrix[0].length;
        int maxSide = 0;

        int[] dp = new int[width + 1];

        for (char[] chars : matrix) {
            int northwest = 0; // 个人建议放在这里声明，而非循环体外
            for (int col = 0; col < width; col++) {
                int nextNorthwest = dp[col + 1];
                if (chars[col] == '1') {
                    dp[col + 1] = Math.min(Math.min(dp[col], dp[col + 1]), northwest) + 1;
                    maxSide = Math.max(maxSide, dp[col + 1]);
                } else dp[col + 1] = 0;
                northwest = nextNorthwest;
            }
        }
        return maxSide * maxSide;
    }


}
