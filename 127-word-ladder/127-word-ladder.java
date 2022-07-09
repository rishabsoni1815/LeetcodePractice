class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String,Boolean>h=new HashMap<>();
        for(int i=0;i<wordList.size();i++){
            h.put(wordList.get(i),false);
        }
        if (!wordList.contains(endWord)) return 0;
        return bfs( beginWord,endWord,wordList,h);
    }
        int bfs(String s,String e,List<String> w,HashMap<String,Boolean>h){
            int ans=1;
            Queue<String>q=new LinkedList<>();
            q.add(s);
             h.put(s,true);
            while(q.isEmpty()==false){
                int len=q.size();
               for(int ii=0;ii<len;ii++){
                    String t=q.poll();
                   if(t.equals(e)) return ans;
                    for(int i=0;i<t.length();i++){//for evry character in t
                         char c[]=t.toCharArray();
                        for(int j=0;j<26;j++){//change that ith char by some other char so that only one diff. b/w neighbours is maintained
                            c[i]=(char)(j+'a');
                            String jj=String.valueOf(c);
                            if(h.containsKey(jj)&&h.get(jj)==false){
                                q.add(jj);
                                h.put(jj,true);
                            }
                        }
                    }
               }
                ans++;
            }
            return 0;
        }
}