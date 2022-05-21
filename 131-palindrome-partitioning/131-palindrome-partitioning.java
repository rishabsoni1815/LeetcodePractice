class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<>();
        List<String>t=new ArrayList<>();
        StringBuilder c=new StringBuilder();
        c.append(s);
        help(ans,t,0,s,c);
        return ans;
    }
    void help(List<List<String>>ans,List<String>t,int i,String s,StringBuilder c){
		if(i==s.length()) {
			ans.add(new ArrayList<>(t));
			return;
		}
        for(int j=i;j<s.length();j++){
            String cur=c.substring(i,j+1);
            if(check(cur)) {
            	t.add(cur);
            	help(ans,t,j+1,s,c);
            	t.remove(t.size()-1);
            }
        }
    }
	boolean check(String s) {
		for(int i=0;i<=(s.length()-1)/2;i++) {
			if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
		}
		return true;
	}
}