class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] d = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> s = new HashSet<>();
        for (String w : words) {
            StringBuilder sb = new StringBuilder();//as it is mutable unlike string which is immutable which will make the time complexity as n^2
            for (int i = 0; i < w.length(); ++i)
                sb.append(d[w.charAt(i) - 'a']);
            s.add(sb.toString());
        }
        return s.size();
    }
}