class Solution {
    List<String>temp;
    HashMap<String,List<Character>> top;
    public boolean pyramidTransition(String s, List<String> a) {
        top=new HashMap<>();
        for(String c:a){
            String y=""+c.charAt(0)+c.charAt(1);
            if(!top.containsKey(y)){
                top.put(y,new ArrayList<>());
            }
            top.get(y).add(c.charAt(2));
        }
        return help(s,a); 
    }
    boolean help(String s,List<String>a){
        if(s.length()==1) return true;
        temp=new ArrayList<>();
        gen(s,a,0,"");
        for(String c:temp){
            if(help(c,a)) return true;
        }
        return false;
    }
    void gen(String s,List<String>a,int i,String ans){
        if(i==s.length()-1) {
            temp.add(ans);
            return;
        }
        String y=""+s.charAt(i)+s.charAt(i+1);
        if(!top.containsKey(y)) return;
        for(Character c:top.get(y)){
            gen(s,a,i+1,ans+c);
        }
    }
}