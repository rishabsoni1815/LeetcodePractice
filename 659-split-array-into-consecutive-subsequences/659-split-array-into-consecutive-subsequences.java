class Solution {
    public boolean isPossible(int[] a) {
        int n=a.length;
        HashMap<Integer,Integer>available=new HashMap<>();
        HashMap<Integer,Integer>needed=new HashMap<>();
        for(int i=0;i<n;i++){
            available.put(a[i],available.getOrDefault(a[i],0)+1);
        }
        for(int i=0;i<n;i++){
           if(available.containsKey(a[i])==false) continue;
           else if(needed.containsKey(a[i])){
                available.put(a[i],available.get(a[i])-1);
                needed.put(a[i],needed.get(a[i])-1);
                if(available.get(a[i])==0) available.remove(a[i]);
                if(needed.get(a[i])==0) needed.remove(a[i]);
                needed.put(a[i]+1,needed.getOrDefault(a[i]+1,0)+1);
            }
        else if(available.containsKey(a[i])&&available.containsKey(a[i]+2)&&available.containsKey(a[i]+1)){
                    available.put(a[i],available.get(a[i])-1);
                    available.put(a[i]+1,available.get(a[i]+1)-1);
                    available.put(a[i]+2,available.get(a[i]+2)-1);
                    if(available.get(a[i])==0) available.remove(a[i]);
                    if(available.get(a[i]+1)==0) available.remove(a[i]+1);
                    if(available.get(a[i]+2)==0) available.remove(a[i]+2);
                    needed.put(a[i]+3,needed.getOrDefault(a[i]+3,0)+1);
            }else{
                return false;
            }
        }
        return true;
    }
}