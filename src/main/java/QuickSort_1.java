public class QuickSort_1 {
    public static void main(String[] args){
        int[] array = {1,100,2,99,3,98};
        quickSort(array, 0, array.length);
        for(int temp:array){
            System.out.println(temp);
        }
    }
    public static int[] quickSort(int[] array, int left, int right){
        if(left >= right){
            return array;
        }
        int flag = array[left];
        int i = left, j = right-1;
        while(i < j){
            while(i < j && array[j] >= flag){
                j--;
            }
            while(i < j && array[i] <= flag){
                i++;
            }
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        array[left] = array[i];
        array[i] = flag;
        quickSort(array, left, i);
        quickSort(array,i+1, right);
        return array;
    }
}
