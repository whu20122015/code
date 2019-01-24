import java.util.HashMap;

class MinimumWindowSubstring {


    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.print(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int count = 0;
        String result = "";
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), 0);
        }

//        for(int i = 0; i < s.length(); i++){
//            if(map.get(s.charAt(i)) != null){
//                map.put(s.charAt(i), map.get(s.charAt(i))+1);
//            }
//
//        }
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.get(t.charAt(i))+1);
        }
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) != null){

                if(map.get(s.charAt(i)) >= 1){
                    count++;
                }
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
            }
            right = i;
            while(count == t.length()){


                if(map.get(s.charAt(left)) == null){

                }else if(map.get(s.charAt(left)) < 0){
                    map.put(s.charAt(left), map.get(s.charAt(left))+1);
                }else{

                    //之前因为这句话一直没有调成功
                    map.put(s.charAt(left), map.get(s.charAt(left))+1);

                    if(result.length() == 0 || right-left+1 < result.length()){
                        result = s.substring(left, right+1);
                    }
                    count--;
                }
                left++;

            }
        }
        return result;
    }
}


