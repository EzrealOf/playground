package com.ezreal.leetcode.array;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * 通过次数60,820提交次数77,479
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Medium59 {

    public static void main(String[] args) {
//        int[][] ints = generateMatrix(5);
        int[][] ints = generateMatrix2(5);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print("\t" + ints[i][j]);
            }
            System.out.println();

        }
    }


    public static int[][] generateMatrix(int n) {
        int[][] ints = new int[n][n];
        int count = 1;
        //x 轴开始位置
        int x = 0;
        //y 轴开始位置
        int y = 0;
        //需要循环的次数
        int loop = n / 2;
        int mid = n / 2;
        //每圈循环 控制边的遍历长度
        int offset = 1;

        while (loop-- > 0) {
            int i = y;
            int j = x;
            //左 -> 右
            for (j = x; j < x + n - offset; j++) {
                ints[y][j] = count++;
            }
            //上 -> 下
            for (i = y; i < y + n - offset; i++) {
                ints[i][j] = count++;
            }
            //右 -> 左
            for (; j > x; j--) {
                ints[i][j] = count++;
            }
            //下 -> 上
            for (; i > y; i--) {
                ints[i][j] = count++;
            }
            // 第二圈开始的时候，起始位置要各自加1， 例如：第一圈起始位置是(0, 0)，第二圈起始位置是(1, 1)
            x++;
            y++;
            // offset 控制每一圈里每一条边遍历的长度
            offset += 2;
        }
        if (n % 2 == 1) {
            ints[mid][mid] = count;
        }
        return ints;
    }

    public static int[][] generateMatrix2(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = l; i <= r; i++) mat[t][i] = num++; //left to right
            t++;
            for (int i = t; i <= b; i++) mat[i][r] = num++;// top to bottom
            r--;
            for (int i = r; i >= l; i--) mat[b][i] = num++;//right to left
            b--;
            for (int i=b;i>= t;i--) mat[i][l] = num++; // bottom to top
            l++;
        }
        return mat;
    }
}
