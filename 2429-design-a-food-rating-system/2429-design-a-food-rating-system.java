class FoodRatings {
        HashMap<String,String>cuisine=new HashMap<>();
        HashMap<String,Integer>rating=new HashMap<>();
        HashMap<String,TreeSet<Pair<Integer,String>>>h=new HashMap<>();
    
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisine=new HashMap<>();
        rating=new HashMap<>();
        h=new HashMap<>();
        for(int i=0;i<foods.length;i++){
            cuisine.put(foods[i],cuisines[i]);
            rating.put(foods[i],ratings[i]);
            Pair<Integer,String>p=new Pair<>(ratings[i],foods[i]);//getKey() gives Integer(rating here) and getValue gives food(String)
            if(h.containsKey(cuisines[i])){
                h.get(cuisines[i]).add(p);
            }else{
                TreeSet<Pair<Integer,String>>t=new TreeSet<>((x,y)->(x.getKey().equals(y.getKey()))?(x.getValue().compareTo(y.getValue())):(y.getKey()-x.getKey()));//.equals in place of == as using Integer class just like string == checks mermoty location and .equals content of Integer
                t.add(p);
                h.put(cuisines[i],t);
            }
        }
    }
    
    public void changeRating(String food, int newRating) {
        Pair<Integer,String>np=new Pair<>(newRating,food);
        Pair<Integer,String>op=new Pair<>(rating.get(food),food);
        h.get(cuisine.get(food)).add(np);
        h.get(cuisine.get(food)).remove(op);
        rating.put(food,newRating);
    }
    
    public String highestRated(String cuisine) {
        return h.get(cuisine).first().getValue();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */