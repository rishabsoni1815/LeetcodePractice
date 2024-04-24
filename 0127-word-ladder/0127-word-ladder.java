class Solution {
    public int ladderLength(String b, String e, List<String> l) {
        HashSet<String>w=new HashSet<>();
        HashSet<String>v=new HashSet<>();
        for(String u:l) w.add(u);
        Queue<String>q=new LinkedList<>();
        q.add(b);
        v.add(b);
        int ans=0;
        while(q.size()>0){
            ans++;
            int s=q.size();
            for(int i=0;i<s;i++){
                String c=q.poll();
                if(c.equals(e)) return ans;
                for(String cur:w){
                    if(!v.contains(cur) && help(cur,c)){
                        q.add(cur);
                        v.add(cur);
                    }
                }
            }
        }
        return 0;
    }
    boolean help(String cur,String c){
        int x=0;
        for(int i=0;i<cur.length();i++){
            if(cur.charAt(i)!=c.charAt(i)) x++;
        }
        return x==1;
    }
}