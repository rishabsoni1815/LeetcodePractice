public class Pair{
    int key;
    int value;
     Pair(int key,int value){
         this.key=key;
         this.value=value;
     }
}
class Solution {
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        
 //   using heap 
    
//         List<Integer>ans=new ArrayList<>();
//         PriorityQueue<Pair>p=new PriorityQueue<>(new Comparator<Pair>(){
//          public int compare(Pair a,Pair b){
//               return b.key-a.key;
//           }   
//         });
//         for(int i=0;i<k;i++){
//           p.add(new Pair(Math.abs(x-a[i]),a[i]));
//         }
//         for(int i=k;i<a.length;i++){
//             if(p.peek().key>Math.abs(x-a[i])){
//                 p.poll();
//                 p.add(new Pair(Math.abs(x-a[i]),a[i]));
//             }
//         }
//         while(!p.isEmpty())
//     {
//         ans.add(p.poll().value);
//     }
//        Collections.sort(ans);
//         return ans;
//     }
    
    //We can initialize two pointers L=0 and R=n-1. Now our window size is n and contains excess elements. We will keep reducing the [L, R] window size till it becomes exactly equal to k. We can do this based on the condition - x - arr[L] <= arr[R] - x. If it is true, then it means arr[R] is farther away from x than arr[L] and thus we will eliminate arr[R]. Otherwise, we will eliminate arr[L].
        //o(N) sol.
        int lo = 0;
		int hi = arr.length - 1;
		while (hi - lo >= k) {
            if (x - arr[lo] <= arr[hi] - x) hi--;
            else lo++;
		}
		List<Integer> result = new ArrayList<>(k);
		for (int i = lo; i <= hi; i++) {
			result.add(arr[i]);
		}
		return result;
    }
}