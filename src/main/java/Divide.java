import java.util.*;
public class Divide {

    public static void main(String[] args) {
        System.out.print(29^17);
//        System.out.print(fun(2018, 2000));
        }

public static int fun(int m, int n){
//    int m = 2018, n =2000;
    if(m % n == 0){
        return n;
    }else {
        return fun(n, m%n);

    }
}

    public static  void getaxProfit() {
        int[] prices = {2,4,6,8,10};
//        int[] prices = {10,22,5,75,65,80};
        System.out.print(maxProfit(prices, prices.length));
    }

    public static int maxProfit(int[] prices, int length) {
        int[] result = new int[length];
        int res = 0;
        int dp[][] = new int[length][length];
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = prices[j] - prices[i];
//                System.out.print(dp[i][j] + " ");
            }
        }

        int max = 0;
        int ma2 = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < length; i++)
            for (int j = i + 1; j < length; j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    start = i;
                    end = j;
                }
            }
//        System.out.println(start + " " + end + " " + max);
//        System.out.println(start + " " + end);
        result[start] = 1;
        result[end] = 1;
        for (int i = 0; i < start; i++)
            for (int j = i + 1; j < start; j++) {
                if (dp[i][j] > ma2) {
                    ma2 = dp[i][j];
//                    System.out.println(i + " " + j);
                    result[i] = 1;
                    result[j] = 1;
                }
            }

        if (end < length - 1)
            for (int i = end + 1; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    if (dp[i][j] > ma2) {
                        ma2 = dp[i][j];
//                        System.out.println(i + " " + j);
                        result[i] = 1;
                        result[j] = 1;
                    }
                }
            }
        res = max + ma2;
        for(int i = 0; i < result.length; i++){
            if(result[i] == 1){
                System.out.println(i + " ");
            }
        }
        return res;
    }




        public static void divide(){
            int[] array = {2 ,3, 4 ,1 ,6 };
            ArrayList<Integer> list=getMaxDiff(array);
            int[] array1 = new int[list.size()];
            if(list!=null){
                for(int i=0;i<list.size();i++){
                    array1[i] = array[list.get(i)-1];
                    System.out.print(array[list.get(i)-1]);

                    System.out.print(" ");
                }
                System.out.print("\n");
                for(int i = 0; i < array.length; i++){
                    for(int j = 0; j < array1.length; j++){
                        if(array[i] == array1[j]){
                            break;
                        }
                        if(j == array1.length - 1){
                            System.out.print(array[i]);
                            System.out.print(" ");
                        }
                    }

                }
            }else{
                System.out.print("null");
            }
        }

        public static ArrayList<Integer> getMaxDiff(int[] arr) {
            int len = arr.length;
            int sum = 0;
            for (int i = 0; i < len; i++)
                sum += arr[i];
            if(sum%2!=0)return null;
            int[][] dp = new int[len + 1][sum / 2 + 1];
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=1;i<len+1;i++){
                for(int j=1;j<sum/2+1;j++){
                    if(j-arr[i-1]>=0&&dp[i-1][j-arr[i-1]]+arr[i-1]>dp[i-1][j]){
                        dp[i][j]=dp[i-1][j-arr[i-1]]+arr[i-1];
                    }else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
            int mcount=len;
            if(dp[len][sum/2]!=sum/2)return null;
            for(int j=sum/2;j>=0;){
                if(dp[mcount][j]!=dp[mcount-1][j]){
                    list.add(mcount);
                    j=j-arr[mcount-1];
                    mcount--;
                }else {
                    mcount--;
                }
                if(mcount==0){
                    break;
                }
            }
            return list;
        }
    }


