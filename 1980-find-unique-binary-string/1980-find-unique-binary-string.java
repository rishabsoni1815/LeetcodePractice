class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        for(String s:nums) set.add(s);
        for(int i=0;i<=Math.pow(nums.length,2);i++) {
            String s = convertToBinary(i, nums.length);
            if(!set.contains(s)) return s;
        }
        return null;
    }
    private String convertToBinary(int n, int digits) {
        StringBuilder sb = new StringBuilder();
        for(int i=digits-1;i>=0;i--) 
            sb.append((n&1<<i) !=0 ?"1":"0");
        return sb.toString();
    }
}