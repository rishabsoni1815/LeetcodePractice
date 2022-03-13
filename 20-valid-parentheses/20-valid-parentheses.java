class Solution {
    public boolean isValid(String s) {
        if(s.length()==0) return true;
         int n=s.length();
	      Stack<Character> a=new Stack<>();
	   //   a.push(s.charAt(0));
	      for(int i=0;i<n;i++){
	          char d=s.charAt(i);
	       //   System.out.println(d+"fz");
	          if(d=='('||d=='{'||d=='['){
	              a.push(d);
	             continue;
	          }
	          //else  {
	          if(a.isEmpty()){
	              return false;
	          }
	             if(d==')'){
	                 if(a.peek()=='(') a.pop();
	                 else {
	                    return false;
	                 }
	             } if(d=='}'){
	                 if(a.peek()=='{') a.pop();
	                 else {
	                   return false;
	                 }
	             } if(d==']'){
	                 if(a.peek()=='[') a.pop();
	                 else {
	                 return false;
	                 }
	             }
	         
	      }
        if(!a.isEmpty()) return false;
        return true;
    }
}