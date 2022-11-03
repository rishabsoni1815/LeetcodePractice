class Solution {
    public int longestPalindrome(String[] a) {
        HashMap<String,Integer>h=new HashMap<>();
        int ans=0;
        for(int i=0;i<a.length;i++){
            h.put(a[i],h.getOrDefault(a[i],0)+1);
        }
        boolean flag=false;
        for(String key:h.keySet()){
            int v=h.get(key);
            String t=(key.charAt(1)+""+key.charAt(0));
            if(t.equals(key)){
                if(flag==false && v%2!=0){
                    ans++;
                    flag=true;
                }
                if(v%2==0) ans+=v;
                else ans+=(v-1);
            }else{
                if(h.containsKey(t)){
                    ans+=Math.min(v,h.get(t));
                }
            }
        }
        return 2*ans;
    }
}