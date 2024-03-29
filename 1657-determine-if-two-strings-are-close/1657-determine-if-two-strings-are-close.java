class Solution {
    public boolean closeStrings(String a, String b) {
        int h1[]=new int[26];
        int h2[]=new int[26];
        for(int i=0;i<a.length();i++){
            h1[a.charAt(i)-'a']++;
        }
        for(int i=0;i<b.length();i++){
            h2[b.charAt(i)-'a']++;
            if(h1[b.charAt(i)-'a']==0) return false;		// if one has a letter which another one doesn't have, dont exist as Operation 2: is on char both existing not with any char (swap btw itself) 
        }
        
        // ***************** instead of doing this can also sort both h1 and h2 and check as tc = o(nlogn)=o(1) only as size is 26 *******************
        
        
        HashMap<Integer,Integer>m1=new HashMap<>();
        for(int i=0;i<26;i++){
            if(h1[i]>0) m1.put(h1[i],m1.getOrDefault(h1[i],0)+1);
        }
        for(int i=0;i<26;i++){
            if(h2[i]>0){
                if(m1.containsKey(h2[i])){
                    m1.put(h2[i],m1.get(h2[i])-1);
                    if(m1.get(h2[i])==0) m1.remove(h2[i]);
                }else{
                    return false;
                }
            }
        }
        return m1.size()==0;
    }
}