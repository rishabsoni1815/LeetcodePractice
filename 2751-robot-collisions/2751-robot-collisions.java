class Solution {
    public List<Integer> survivedRobotsHealths(int[] aa, int[] h, String d) {
        int a[]=new int[aa.length];
        for(int i=0;i<a.length;i++) a[i]=aa[i];
        HashMap<Integer,Integer>posindex=new HashMap<>();
        for(int i=0;i<a.length;i++){
            posindex.put(a[i],i);
        }
        Arrays.sort(a);
        Stack<Integer>s=new Stack<>();
        for(int i=0;i<a.length;i++){
            int idx=posindex.get(a[i]);
            if(d.charAt(idx)=='R') s.push(a[i]);
            else{
                if(s.size()>0){
                    int ii=posindex.get(s.peek());
                    if(d.charAt(ii)=='R'){
                        if(h[ii]<h[idx]){
                            h[idx]--;
                            s.pop();
                            s.push(a[i]);
                        }else if(h[ii]>h[idx]){
                            h[ii]--;
                        }else{
                            s.pop();
                        }
                    }else{
                        s.push(a[i]);
                    }
                }else{
                    s.push(a[i]);
                }
            }
        }
        HashSet<Integer>hh=new HashSet<>();
        while(s.size()>0) hh.add(s.pop());
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<aa.length;i++){
            if(hh.contains(aa[i])){
                ans.add(h[i]);
            }
        }
        return ans;
    }
}