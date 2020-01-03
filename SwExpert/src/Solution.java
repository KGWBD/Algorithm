import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
  public static int[] solution(int[] arr) {
      int[] answer = arr;
      ArrayList<Integer> tempList = new ArrayList<Integer>();
      
      for(int i = 0 ; i < answer.length; i++) {
    	  tempList.add(answer[i]);
      }
      Collections.sort(tempList,new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
	});
      
      tempList.remove(tempList.size()-1);
      if(tempList.size()==0) {
    	  answer = new int[] {-1};
      } else {
    	  answer = new int[tempList.size()];
    	  int size = 0;
    	  for(int i : tempList) {
    		  answer[size++] = i;
    	  }
      }
      return answer;
  }
  public static void main(String[] args) {
	  int[] arr = {4};
	  int[] result = solution(arr);
	  for(int i = 0 ; i<result.length; i++) {
		  System.out.println(result[i]);
	  }
}
  
}