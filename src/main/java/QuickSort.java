import java.util.ArrayList;

public class QuickSort {

    public static void main(String[] args){
        int[] array = {1,3,5,2,4,6,3,5,7};
        int[] output = quickSort(array, 0, array.length-1);
        for(Integer temp:output){
            System.out.println(temp);
        }
    }

    public static int[] quickSort(int[] array, int left, int right) {


        if(left >= right){
            return array;
        }

        int flag = array[left];
        int i = left;
        int j = right;
        while(i < j){

            //从右向左找到第一个小于flag的元素
            while(i < j && array[j] >= flag){
                j--;
            }
            //从左向右找到第一个大于flag的元素
            while(i < j && array[i] <= flag){
                i++;
            }
            //交换left与right对应的值
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        array[left]=array[i];
        array[i]=flag;
        quickSort(array, left, i-1);
        quickSort(array, i+1,right);
        return array;
    }
}
