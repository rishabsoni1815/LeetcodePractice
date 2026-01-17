class Solution {
    public int[] nextGreaterElement(int[] a, int[] b) {
        HashMap<Integer,Integer>h=new HashMap<>();
        for(int i=0;i<b.length;i++){
            h.put(b[i],i);
        }
        int ng[]=new int[b.length];
        Arrays.fill(ng,-1);
        Stack<Integer>s=new Stack<>();
        int i=b.length-1;
        while(i>=0){
            while(s.size()>0 && s.peek()<b[i]){
                s.pop();
            }
            if(s.size()>0) ng[i]=s.peek();
            s.push(b[i]);
            i--;
        }
        for(i=0;i<a.length;i++){
            a[i]=ng[h.get(a[i])];
        }
        return a;
    }
}