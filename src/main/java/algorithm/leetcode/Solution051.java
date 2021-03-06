package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/09
 */
public class Solution051 {
    public static void main(String[] args) {
        List<List<String>> result = new Solution051().solveNQueens(4);

        result.forEach(list -> {
            for (String t : list) {
                System.out.println(t);
            }

            System.out.println("---------------------------");
        });
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        String[] oneAnswer = new String[n];

        dfs(answer, oneAnswer, new int[n], n, 0);
        return answer;
    }

    /**
     * @param answer        所有解法
     * @param oneAnswer     一种解法
     * @param pos           保存每行皇后的位置
     * @param numberOfQueen 皇后的数量
     * @param index         当前迭代的行号
     */
    private void dfs(List<List<String>> answer, String[] oneAnswer, int[] pos, int numberOfQueen, int index) {
        // 最后一行也迭代完成, 把结果存到列表中
        if (numberOfQueen == index) {
            answer.add(Arrays.asList(oneAnswer.clone()));
            return;
        }

        // 从左侧第一列开始
        for (int j = 0; j < numberOfQueen; j++) {
            // 将第index行的皇后放在第j列
            pos[index] = j;
            // 冲突标志位
            boolean conflict = false;
            // 遍历当前已放置好的皇后，看是否有冲突
            for (int i = 0; i < index; i++) {
                if (pos[i] == pos[index] || Math.abs(i - index) == Math.abs(pos[i] - pos[index])) {
                    conflict = true;
                    break;
                }
            }
            // 找到没有冲突的位置坐标,并进行下一步迭代.(如果在当前行没有找到合适位置,则回退到上几行重新摆放位置)
            if (!conflict) {
                char[] line = new char[numberOfQueen];
                Arrays.fill(line, '.');
                line[j] = 'Q';
                oneAnswer[index] = new String(line);
                // 没有冲突，当前解法可行，增加一位皇后
                dfs(answer, oneAnswer, pos, numberOfQueen, index + 1);
            }
        }
    }
}
