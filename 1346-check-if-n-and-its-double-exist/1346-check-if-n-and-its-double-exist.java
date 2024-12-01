class Solution {
    public boolean checkIfExist(int[] a) {
        HashSet<Integer>h=new HashSet<>();
        for(int x:a){
            if(h.contains(x*2) || (x%2==0 && h.contains(x/2))) return true;
            h.add(x);
        }
        return false;
    }
}