package 不知名类型;

/**
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 *
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 *
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 示例 1:
 *
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * 输出:
 * [[1,2,3,4]]
 * 解释:
 * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 * 示例 2:
 *
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 2, c = 4
 * 输出:
 * [[1,2],
 *  [3,4]]
 * 解释:
 * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reshape-the-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ReshapeTheMatrix {
    public static void main(String[] args) {
        int[][] nums = {{1,2}, {3,4}};
        int[][] res = matrixReshape(nums, 4, 1);
        for(int i[] : res) {
            for(int j : i) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        //若个数不同直接返回原数组
        if((r * c) != (nums.length * nums[0].length)) {
            return nums;
        }

        int[][] res = new int[r][c];
        r = 0;
        c = 0;
        //依次填数
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums[0].length; j++) {
                res[r][c] = nums[i][j];
                c++;
                //换行
                if(c >= res[0].length) {
                    c = 0;
                    r++;
                }
            }
        }
        return res;
    }
}
