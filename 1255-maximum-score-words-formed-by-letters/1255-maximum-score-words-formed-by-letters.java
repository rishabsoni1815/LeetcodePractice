class Solution {
    public int maxScoreWords(String[] a, char[] c, int[] s) {
        HashMap<Character,Integer>h=new HashMap<>();
        for(int i=0;i<c.length;i++){
            h.put(c[i],h.getOrDefault(c[i],0)+1);
        }
        return help(0,a,c,s,h); 
    }
    int help(int i,String[] a, char[] c, int[] s,HashMap<Character,Integer>h){
        if(i==a.length) return 0;
        int max=help(i+1,a,c,s,h);
        if(isPossible(a[i],h)){
            int sc=getScore(a[i],s);
            updateMap(h,a[i],false);
            max=Math.max(max,sc + help(i+1,a,c,s,h));
            updateMap(h,a[i],true);
        }
        return max;
    }
    void updateMap(HashMap<Character,Integer>h,String s,boolean flag){
        if(!flag){//delete s from map
            for(int i=0;i<s.length();i++){
                h.put(s.charAt(i),h.get(s.charAt(i))-1);
                if(h.get(s.charAt(i))==0) h.remove(s.charAt(i));
            }
        }else{
            for(int i=0;i<s.length();i++){
                h.put(s.charAt(i),h.getOrDefault(s.charAt(i),0)+1);
            }
        }
    }
           
    boolean isPossible(String s,HashMap<Character,Integer>h){
        // HashMap<Character,Integer>t=h;//pass by ref value so will change h only
        HashMap<Character,Integer> t = new HashMap<>(h);
        for(int i=0;i<s.length();i++){
            if(t.containsKey(s.charAt(i))){
                t.put(s.charAt(i),t.get(s.charAt(i))-1);
                if(t.get(s.charAt(i))==0) t.remove(s.charAt(i));
            }else{
                return false;
            }
        }
        return true;
    }
    int getScore(String s,int t[]){
        int sc=0;
        for(int i=0;i<s.length();i++){
            sc+=(t[s.charAt(i)-'a']);
        }
        return sc;
    }
}