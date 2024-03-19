class Solution {//https://www.youtube.com/watch?v=Q9006pUcypI
    public int leastInterval(char[] a, int n) {
        int h[]=new int[26];
        for(int i=0;i<a.length;i++){
            h[a[i]-'A']++;
        }
        Arrays.sort(h);//for collections.reverseOrder we need Integer array so reverse manually
        for(int i=0;i<26/2;i++){
            int t=h[i];
            h[i]=h[25-i];
            h[25-i]=t;
        }
        int id=(h[0]-1)*n;//the places left after putting the max feeq elemtn at extreme places
        for(int i=1;i<26;i++){
            id-=Math.min(h[0]-1,h[i]);//min of the number of empty paces and the freq of this elemt (h[i])
        }
        return a.length+Math.max(0,id);//the total chars + ideal left (if ideal is negative it means no emplty ideal places are left so add 0)
    }
}