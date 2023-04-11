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
/*

class Solution {
    public String removeStars(String s) {
        int j = 0;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                answer.deleteCharAt(answer.length() - 1);
            } else {
                answer.append(s.charAt(i));
            }
        }
        return answer.toString();
    }
}

*/