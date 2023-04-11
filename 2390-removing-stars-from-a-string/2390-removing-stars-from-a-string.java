class Solution {
    public String removeStars(String s) {
        int n=s.length(),i=0;
        Stack<Character>st=new Stack<>();
        while(i<n){
            if(s.charAt(i)=='*'){
                if(st.size()>0) st.pop();
                i++;
            }else{
                st.add(s.charAt(i));
                i++;
            }
        }
          StringBuilder answer = new StringBuilder();
        while (!st.isEmpty()) {
            answer.append(st.pop());
        }

        return answer.reverse().toString();
    }
}