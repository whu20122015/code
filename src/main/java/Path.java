public class Path {

    public static void main(String[] args){
        char[] matrix = {   'A','B','C','E',
                             'S','F','C','S',
                             'A','D','E','E'};
        char[] str = {'A','B','C','C','E','D'};
        boolean result = hasPath(matrix,3,4,str);

        System.out.print(result);
    }


    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {

        if(matrix==null
                || matrix.length==0
                || str==null
                || str.length==0
                || matrix.length!=rows*cols
                || rows<=0
                || cols<=0
                || rows*cols < str.length) {
            return false;
        }


        char[][] array = new char[rows][cols];
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //1：这里必须分开写，先初始化，再去判断，不然就会出问题
                //2：这里是i * cols，而不是i * rows
                array[i][j] = matrix[i * cols + j];
            }
        }
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int[][] flag = new int[rows][cols];
                if(deal(array, i, j, flag, 0, str)){
                    return true;
                }

            }
        }
        return false;

    }

    public static boolean deal(char[][] array, int row, int col,
                               int[][] flag, int temp, char[] str){
        if(temp == str.length){
            return true;
        }

        if(row >= array.length || row < 0 || col < 0 || col >= array[0].length){
            return false;
        }

        if(flag[row][col] == 1){
            return false;
        }

        if(array[row][col] == str[temp]){
            flag[row][col] = 1;
            if(deal(array, row, col+1, flag, temp+1, str)
                    || deal(array, row, col-1, flag, temp+1, str)
                    || deal(array, row+1, col, flag, temp+1, str)
                    || deal(array, row-1, col, flag, temp+1, str)){
                return true;
            }
            flag[row][col] = 0;
            return false;
        }else{
            return false;
        }

    }
}
