class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String>map=new HashMap<>();
        HashSet<String>used=new HashSet<>();
        String a[]=s.split(" ");
        if(a.length!=pattern.length()) return false;
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                if(map.get(pattern.charAt(i)).equals(a[i])==false){
                    return false;
                }
            }else{
                if(used.contains(a[i])){
                    return false; //already used
                }else{
                    used.add(a[i]);
                    map.put(pattern.charAt(i),a[i]);
                }
            }
        }
        return true;
    }
}