import java.util.Stack; //or java.util.all 
public class RecitationWeek5{


  //question 20 leet code: iterate through list of strings, if open bracket/paren add to stack, if closed compare to most recent input into stack and pop if sa,em if not program wrong 
  //have to check if stack is empty before pop as well, at end have to check if stack still has elements then false 
  //O(N) runtime 

  //stack
  public boolean isValid(String s){
  Stack<Character> stack = new Stack<Character>();
  //must put object version rather than primitive version 
  //s.toCharArray
  for (int i =0; i<s.length; i++){
    char c = s.charAt(i);
    if (c=='('||'{'||'['){
      stack.push(c);
    } else if (stack.empty()){
      return false;
    } else {
        char popped = stack.pop();
        if (c==')'&&popped!='(') return false;
        if (c==']'&&popped!='[') return false;
        if (c=='}'&&popped!='{') return false;
    }

}



return stack.empty(); //must be empty to be true at end, otherwise could add only open paren and would pass 
  }


//queue   0 1 2 3 4 5 6    2 3 4 5 6 0     4 5 6 0 2   6 0 2 5   2 5 6  6 5   6 
// populate queue with numbers up to n-1
// add all elements up to m-1 to queue and remove mth element (and print) 
// keep going until queue is empty 
//runtime is O(n*m), bigger m actually makes it slower  
//space is O(N), never have more than n things in queue 
public



}