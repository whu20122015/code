import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String[] array = scanner.nextLine().split(" ");
            int a = Integer.valueOf(array[0]);
            int b = Integer.valueOf(array[1]);
            String[] S = new String[a];
            String[] T = new String[b];
            for(int i = 0; i < a; i++){
                S[i] = scanner.nextLine();
            }
            scanner.nextLine();
            for(int i = 0; i < b; i++){
                T[i] = scanner.nextLine();
            }

            int[] result = deal(S,T);
            for(int i = 0; i < result.length; i++){
                System.out.println(result[i]);
            }
        }
    }

    public static int[] deal(String[] S, String[] T){
        int[] result = new int[T.length];
        for(int i = 0; i < T.length; i++){
            int j = 0;
            for(j = 0; j < S.length; j++){
                if(T[i].contains(S[j])){
                    result[i] = 1;
                    break;
                }
            }
            if(j == S.length){
                result[i] = -1;
            }

        }
        return result;
    }
}