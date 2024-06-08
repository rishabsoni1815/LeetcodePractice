class Solution {
    public String replaceWords(List<String> d, String s) {
       HashSet<String>h=new HashSet<String>();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<d.size();i++) h.add(d.get(i));
        String a[]=s.split(" ");
        for(int i=0;i<a.length;i++){
            String t="";
            for(int j=0;j<a[i].length();j++){
                t+=a[i].charAt(j);
                if(h.contains(t)){
                    a[i]=t;
                    break;
                }
            }
            if(i!=0) sb.append(" "+a[i]);
            else sb.append(a[i]);
        }
      String str = sb.toString();
        return str;
    }
}