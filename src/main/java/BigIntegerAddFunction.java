class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class BigIntegerAddFunction {

    public static void main(String[] args){
        String a = "243";
        String b = "564";
        System.out.println(add(a, b));
    }

    public static String add(String n1,String n2){

        String result="";

        //反转字符串
        String num1=new StringBuffer(n1).reverse().toString();
        String num2=new StringBuffer(n2).reverse().toString();

        int len1=num1.length();
        int len2=num2.length();
        int maxLen=len1>len2?len1:len2;
        //定义和(可能)
        int nSum[]=new int[maxLen+1];

        boolean nOverFlow=false;

        //对齐字符串
        if(len1<len2){
            for (int i = len1; i < len2; i++) {
                num1+="0";
            }
        }else if(len1>len2){
            for (int i = len2; i < len1; i++) {
                num2+="0";
            }
        }

        //两个数相加
        for (int i = 0; i < maxLen; i++) {
            //进位数从第二次开始算
            if (nOverFlow) {
                nSum[i]=Integer.parseInt(num1.charAt(i)+"")+
                        Integer.parseInt(num2.charAt(i)+"")+1;
            }else{
                nSum[i]=Integer.parseInt(num1.charAt(i)+"")+
                        Integer.parseInt(num2.charAt(i)+"");
            }
            //处理溢出位
            nOverFlow=handleSumOverTen(nSum,i);

        }

        //处理最高位
        if(nOverFlow) {
            nSum[maxLen] = 1;
        }else {
            nSum[maxLen] =0 ;
        }

        for (int i = 0; i < nSum.length; i++) {
            result+=String.valueOf(nSum[i]);
        }
        String result1=new StringBuffer(result).reverse().toString();
        return result1;
    }

    private static boolean handleSumOverTen(int[] nSum, int i) {

        boolean flag = false;
        if(nSum[i] >= 10) {
            nSum[i] = nSum[i] - 10;
            flag = true;
        }
        else {
            flag = false;
        }
        return flag;
    }

    /**

     public static String add(String a, String b){

     StringBuilder aS = new StringBuilder();
     for(int i = 0; i < a.length(); i++){
     aS.append(a.charAt(i));
     }

     StringBuilder bS = new StringBuilder();
     for(int i = 0; i < b.length(); i++){
     bS.append(b.charAt(i));
     }

     a = aS.reverse().toString();
     b = bS.reverse().toString();

     int length = a.length() > b.length() ? b.length() : a.length();


     int flag = 0;
     StringBuilder s = new StringBuilder();
     for(int i = 0; i < length; i++){
     int tempA = Integer.valueOf(a.charAt(i));
     int tempB = Integer.valueOf(b.charAt(i));
     int temp = 0;
     if(tempA + tempB + flag >= 10){
     temp = tempA + tempB - 10;
     flag = 1;
     }else{
     temp = tempA + tempB;
     flag = 0;
     }

     s.append(temp);

     }


     for(int i = 0; i < Math.abs(a.length() - b.length()); i++){
     if(length == b.length()){
     s.append(a.charAt(i+b.length()));
     }else{
     s.append(b.charAt(i+a.length()));
     }
     }
     return s.reverse().toString();
     }

     */


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        StringBuilder s1 = new StringBuilder();
        ListNode temp1 = l1;
        while(temp1 != null){
            s1.append(temp1.val);
            temp1 = temp1.next;
        }
        String a1 = s1.reverse().toString();


        StringBuilder s2 = new StringBuilder();
        ListNode temp2 = l2;
        while(temp2 != null){
            s2.append(temp2.val);
            temp2 = temp2.next;
        }
        String a2 = s2.reverse().toString();

        String c = add(a1, a2);

        ListNode temp = new ListNode(0);
        ListNode listNodeResult = temp;

        for(int i = 0; i < c.length(); i++){
            temp.next = new ListNode(Integer.valueOf(c.charAt(i)));
            temp = temp.next;
        }

        return listNodeResult.next;
    }
}