package chuxiao.leetcode.array;

/**
 * 在一个8x8的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。
 * 它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 * <p>
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、
 * 到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 * <p>
 * 返回车能够在一次移动中捕获到的卒的数量。
 */
public class 车的可用捕获量999 {
    public static void main(String[] args) {


    }

    public static int numRookCaptures(char[][] board) {
        int res = 0;
        int x = -1;
        int y = -1;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        for (int i = y; i >= 0; i--) {
            if(board [x][i] == 'p'){
                res ++;
                break;
            }
            if(board [x][i] == 'B'){
                break;
            }
        }
        for (int i = y; i < board[x].length; i++) {
            if(board [x][i] == 'p'){
                res ++;
                break;
            }
            if(board [x][i] == 'B'){
                break;
            }
        }

        for (int i = x; i >= 0; i--) {
            if(board [i][y] == 'p'){
                res ++;
                break;
            }
            if(board [i][y] == 'B'){
                break;
            }
        }
        for (int i = x; i < board.length; i++) {
            if(board [i][y] == 'p'){
                res ++;
                break;
            }
            if(board [i][y] == 'B'){
                break;
            }
        }
        return res;
    }
}
