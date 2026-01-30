class Solution {
    public long minimumCost(String ss, String tt, String[] o, String[] c, int[] amt) {
        HashMap<String,List<Integer>>h=new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<o.length;i++){
            set.add(o[i].length()-1);
            if(!h.containsKey(o[i])) h.put(o[i],new ArrayList<>());
            h.get(o[i]).add(i);
        }
        List<Integer> l = new ArrayList<>(set);
        Collections.sort(l);
        
        HashMap<String,HashMap<String,Long>> f= dijkstra(o,c,amt); 
        // System.out.println(f);
        Long dp[]=new Long[ss.length()+1];
        long cans=help(0,ss,tt,o,c,amt,l,h,f,dp);
        return cans==Long.MAX_VALUE ? -1 : cans;
    }

    HashMap<String,HashMap<String,Long>> dijkstra(String o[],String c[],int amt[]){
        HashMap<String,List<Pair>>h=new HashMap<>();
        for(int i=0;i<o.length;i++){
            if(!h.containsKey(o[i])) h.put(o[i],new ArrayList<>());
            h.get(o[i]).add(new Pair(c[i],(long)amt[i]));
        }
        HashMap<String,HashMap<String,Long>>f=new HashMap<>();
        for(int i=0;i<o.length;i++){
            HashMap<String,Long>ans=new HashMap<>();
            PriorityQueue<Pair>q=new PriorityQueue<>((u,v)->Long.compare(u.c,v.c));
            q.add(new Pair(o[i],0L));
            while(q.size()>0){
                Pair cur=q.poll();
                if(!h.containsKey(cur.s)) continue;
                for(Pair temp:h.get(cur.s)){
                    // System.out.println(temp.s+" "+cur.s);
                    if(ans.containsKey(temp.s)){
                        if(cur.c+temp.c<ans.get(temp.s)){
                            ans.put(temp.s,cur.c+temp.c);
                            q.add(new Pair(temp.s,(long)cur.c+temp.c));
                        }
                    }else{
                        ans.put(temp.s,cur.c+temp.c);
                        q.add(new Pair(temp.s,(long)cur.c+temp.c));
                    }
                }
            }
            f.put(o[i],ans);
        }
        return f;
    }

    long help(int i,String s,String t,String o[],String c[],int amt[],List<Integer>l,HashMap<String,List<Integer>>h,HashMap<String,HashMap<String,Long>>f,Long dp[]){
        if(i>=s.length()) return 0L;
        long min=Long.MAX_VALUE;
        // System.out.println(i+" "+s[i]+" "+t[i]);
        if(dp[i]!=null) return dp[i];
        if(s.charAt(i)==t.charAt(i)){
            long cur=help(i+1,s,t,o,c,amt,l,h,f,dp);
            if(cur!=Long.MAX_VALUE){
                min=cur;
            }
        }
        for (int len : l) {
            int end = i + len;
            if (end >= s.length()) break;

            String cs = s.substring(i, end + 1);
            String ts = t.substring(i, end + 1);

            if (!f.containsKey(cs)) continue;
            Long cost = f.get(cs).get(ts);
            if (cost == null) continue;

            long cur = help(end + 1, s, t, o, c, amt, l, h, f, dp);
            if (cur != Long.MAX_VALUE) {
                min = Math.min(min, cur + cost);
            }
        }
        return dp[i]=min;
    }
    void change(char s[],int i,int j,String c){
        int y=0;
        for(int k=i;k<=j;k++){
            s[k]=c.charAt(y);
            y++;
        }
    }
    class Pair{
        String s;
        long c;
        Pair(String s,long c){
            this.s=s;
            this.c=c;
        }
    }
}