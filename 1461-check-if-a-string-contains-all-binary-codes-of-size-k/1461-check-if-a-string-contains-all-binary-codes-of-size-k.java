class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<Integer>h=new HashSet<>();
        for(int i=0;i+k<=s.length();i++){
            String binaryString= s.substring(i,i+k);
            h.add(Integer.parseInt(binaryString,2));
        }
        // System.out.println(h);
        for(int i=0;i<Math.pow(2,k);i++){
            // System.out.println(i);
            if(h.contains(i)==false) return false;
        }
        return true;
    }
}