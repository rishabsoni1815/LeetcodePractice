class Solution {
    public List<List<String>> partition(String s) {
        List<String>t=new ArrayList<>();
        List<List<String>>ans=new ArrayList<>();
        h(s,t,ans,0);
        return ans;
    }
    void h(String s,List<String>t,List<List<String>>ans,int i){
        if(i>=s.length()){
            ans.add(new ArrayList<>(t));
            return;
        }
        for(int j=i;j<s.length();j++){
            String t1=s.substring(i,j+1);
            if(p(t1)){
                t.add(t1);
                h(s,t,ans,j+1);
                t.remove(t.size()-1);
            }
        }
    }
    boolean p(String s){
        int i=0;
        for(int ui=0;ui<s.length()/2;ui++){
            if(s.charAt(ui)!=s.charAt(s.length()-ui-1)) return false;
        }
        return true;
    }
}