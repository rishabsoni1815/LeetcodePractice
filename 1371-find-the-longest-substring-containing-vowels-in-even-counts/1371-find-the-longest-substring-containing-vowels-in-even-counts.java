class Solution {
    public int findTheLongestSubstring(String s) {
        int n=s.length(),ans=0;
        int v[]=new int[5];
        HashMap<String,Integer>h=new HashMap<>();
        h.put(Arrays.toString(v),-1);
        
        for(int i=0;i<n;i++){
            int x=s.charAt(i)-'a';
            
            if(x==0){
                v[0]=(v[0]+1)%2;
            }else if(x==4){
                v[1]=(v[1]+1)%2;
            }else if(x==8){
                v[2]=(v[2]+1)%2;
            }else if(x==14){
                v[3]=(v[3]+1)%2;
            }else if(x==20){
                v[4]=(v[4]+1)%2;
            }
            
            String ss=Arrays.toString(v);
            if(h.containsKey(ss)){
                ans=Math.max(ans,i-h.get(ss));
            }else{
                h.put(ss,i);
            }
                
        }
        return ans;
    }
    boolean vowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return true;
        return false;
    }
}