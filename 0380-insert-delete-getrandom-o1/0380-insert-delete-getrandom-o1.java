//The List is used to store numbers and serve the getRandom() method. The Map contains the mapping between the value and its index in the ArrayList. The Map helps to check whether a value is already inserted or not. The main trick is when you remove a value. ArrayList's remove method is O(n) if you remove from random location. To overcome that, we swap the values between (randomIndex, lastIndex) and always remove the entry from the end of the list. After the swap, you need to update the new index of the swapped value (which was previously at the end of the list) in the map.

public class RandomizedSet {

    HashMap<Integer, Integer> valToInd;
    List<Integer> list;
    int ind = 0;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        valToInd = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valToInd.containsKey(val)) return false;
        list.add(val);
        valToInd.put(val,list.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int ind = valToInd.getOrDefault(val,-1);
        if(ind == -1) return false;
        //swapping val with last element and updating stuff as removing index from list is o(n) operation except for the last index that is o(1) so swapped val with the lasrt index valuen and then removed val
        Collections.swap(list,ind,list.size()-1);
        int swappedWith = list.get(ind);
        valToInd.put(swappedWith,ind);
        list.remove(list.size()-1);
        valToInd.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int size = list.size();
        int ind = (int)(Math.random()*(size));//get a random no. b/w 0 to 20 i.e (0,20) -> so 0 based indexing in doubles so on int conversion Math.ceil as (int)0.2461 is 0 
        return list.get(ind);
    }
}