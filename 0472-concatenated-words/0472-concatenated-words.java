class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] a) {
        List<String> res=new ArrayList<>();
        int n=a.length;
        if(n==0) return res;
        HashSet<String>h=new HashSet<>();
        for(int i=0;i<n;i++){
            h.add(a[i]);
        }
        for(int i=0;i<n;i++){
            if(h(a[i],h)) res.add(a[i]);
        }   
        return res;
    }
    boolean h(String s,HashSet<String>h){
        int n=s.length();
        for(int i=0;i<n-1;i++){  //0 1 2 3 4       (n=5) not n=4  as empty string is not in input ( so 0 to n-1 not n as substring(i,n) will be empty fot i=n-1)
             if(h.contains(s.substring(0,i+1))){
                if(h.contains(s.substring(i+1))) return true;
                 if(h(s.substring(i+1),h)) return true;   
            }
        }
               return false;
    }
}