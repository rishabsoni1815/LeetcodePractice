class Solution {
    public boolean validateStackSequences(int[] push, int[] pop) {
        int n=push.length;
        HashSet<Integer>h=new HashSet<>();
        Stack<Integer>s=new Stack<>();
        int i=0,j=0;
        while(j<n){
            if(h.contains(pop[j])==false){
                // System.out.println(i+" p "+j);
                while(i<n && h.contains(pop[j])==false){
                    s.push(push[i]);
                    h.add(push[i]);
                    i++;
                }
                if(h.contains(pop[j])==false) return false;
            }else{
                // System.out.println(i+" n "+j);
                if(s.peek()!=pop[j]) return false;
                else{
                    s.pop();
                    j++;
                }
            }
        }
        return true;
    }
}