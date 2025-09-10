class Solution {
    public int minimumTeachings(int n, int[][] l, int[][] f) {
        HashMap<Integer,HashSet<Integer>>h=new HashMap<>();
        for(int i=0;i<l.length;i++){
            h.put(i+1,new HashSet<>());
            for(int j=0;j<l[i].length;j++){
                h.get(i+1).add(l[i][j]);
            }
        }
        int min=Integer.MAX_VALUE;
        HashSet<Integer>lf=new HashSet<>();
        for(int i=0;i<f.length;i++){
                int f1=f[i][0];
                int f2=f[i][1];
                if(check(f1,f2,h)==false){
                    lf.add(i);
                }
        }

        for(int i=1;i<=n;i++){
            HashSet<Integer>c=new HashSet<>();
            for(int j:lf){
                int f1=f[j][0];
                int f2=f[j][1];
                if(!h.get(f1).contains(i)) {
                    c.add(f1);
                }
                if(!h.get(f2).contains(i)) {
                    c.add(f2);
                }
            }
            min=Math.min(min,c.size());
        } 
        return min;
    }
    boolean check(int f1,int f2,HashMap<Integer,HashSet<Integer>>h){
        for(int k:h.get(f1)){
            if(h.get(f2).contains(k)) return true;
        }
        return false;
    }
}