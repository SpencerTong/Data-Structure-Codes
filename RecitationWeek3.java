public class RecitationWeek3 {
  
  public static int[] twoSums(int[] arr, int target){
    int[] output = new int[2];
    int ptr1 = 0;
    int ptr2 = arr.length-1;
    while(ptr1<ptr2) {
      if (arr[ptr1]+arr[ptr2]==1){
        output[0] = ptr1+1;
        output[0] = ptr2+1;
        return output;
      }else if (arr[ptr1]+arr[pt2]<target){
        ptr1+=1;
      }else if (arr[ptr1]+arr[pt2]>target){
        ptr2-=1;
      }


    }
    return output;
    
  }
  
  public static void main (String args[]){

    String str = new String(args[0]);
    char[] arrNew = new char[str.length()];
    char temp = 'a';

    for (int i = 0; i < str.length(); i++) {
        arrNew[i] = str.charAt(i);
    }

    for (int i =0; i<arrNew.length/2; i++) {
      
      temp = arrNew[i];
      arrNew[i] = arrNew[arrNew.length-i-1];
      arrNew[arrNew.length-i-1] = temp;

    }

    for (int i = 0; i < arrNew.length; i++) {
      System.out.println(arrNew[i]);
  }
  }
}
