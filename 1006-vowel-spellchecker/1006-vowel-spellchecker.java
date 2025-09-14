class Solution {
    public String[] spellchecker(String[] w, String[] q) {
        HashSet<String>exact=new HashSet<>();
        HashMap<String,Integer>capital=new HashMap<>();
        HashMap<String,Integer>vowel=new HashMap<>();
        for(int i=0;i<w.length;i++){
            exact.add(w[i]);
            String lower=w[i].toLowerCase();
            if(capital.containsKey(lower)==false){
                capital.put(lower,i);
            }
            String v=getVowelRemoved(w[i].toLowerCase());
            if(vowel.containsKey(v)==false){
                vowel.put(v,i);
            }
        }
        String ans[]=new String[q.length];
        for(int i=0;i<q.length;i++){
            String lower=q[i].toLowerCase();
            String v=getVowelRemoved(q[i].toLowerCase());
            String newCur="";
            if(exact.contains(q[i])){
                newCur=q[i];
            }else if(capital.containsKey(lower)){
                newCur=w[capital.get(lower)];
            }else if(vowel.containsKey(v)){
                newCur=w[vowel.get(v)];
            }else{

            }
            ans[i]=newCur;
        }
        return ans;
    }
    String getVowelRemoved(String s){
        char c[]=s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(isVowel(c[i])){
                c[i]='.';
            }
        }
        return String.valueOf(c);
    }
    boolean isVowel(char c){
        return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U');
    }
}