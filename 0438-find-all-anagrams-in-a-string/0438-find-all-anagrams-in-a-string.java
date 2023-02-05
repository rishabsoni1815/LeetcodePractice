class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>ans=new ArrayList<>();
    if (s == null || s.length() == 0 || p == null || p.length() == 0) return ans;
        int h[]=new int[26];
        for(int i=0;i<p.length();i++){
            h[p.charAt(i)-'a']++;
        }
        int i=0,j=0,c=p.length(),n=s.length();//c->no of char in p
        while(j<n){
            //calculations for new element added
            if(h[s.charAt(j)-'a']>=1){//means it is present in p so dec c
                c--;
            }
            h[s.charAt(j)-'a']--;//decreasing freq of current char in map if it is >0 it will decrease by 1 and be >0 but if it is 0 (not present in p) it will become -ve which will help code on line 20
            if(j-i+1<p.length()){//window size less than p's length
                j++;
            }else{//window size equals p's length
                if(c==0) ans.add(i);//ans calculations
                
                //sliding the window
                if(h[s.charAt(i)-'a']>=0) c++;//>=0 means this was present in p as it will be -ve if not present in p bcoz of code on line 15 so inc c
                h[s.charAt(i)-'a']++;//reinitialising h for ith char
                
                //moving window
                i++;
                j++;
            }
        }
        return ans;
    }
}