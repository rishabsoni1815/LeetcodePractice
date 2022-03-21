class Solution {
    public int repeatedStringMatch(String a, String b) {
        String t=a;
		int ans=1;
        while(a.length()<b.length()) {
        	a+=t;
        	ans++;
        }
           if(a.contains(b)) {
        	   return ans;
           }else {
        	   a+=t;
        	   ans++;
        	   if(a.contains(b)) {
        		   return ans;
        	   }else {
        		   return -1;
        	   }
           }
    }
}