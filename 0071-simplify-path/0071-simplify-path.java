class Solution {
    public String simplifyPath(String path) {
        String a[]=path.split("/");
        Stack<String>st=new Stack<>();
        String ans="";
        for(int i=0;i<a.length;i++){
            if(st.size()>0 && a[i].equals("..")) st.pop();
            else if(!a[i].equals(".") && !a[i].equals("") && !a[i].equals("..")){
                st.add(a[i]);
            }
        }
        if(st.size()==0) return "/";
        while(st.size()>0){
            ans=("/"+st.pop()+ans);
        }
        return ans;
    }
}