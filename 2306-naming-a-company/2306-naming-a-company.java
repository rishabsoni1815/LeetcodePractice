/*

set c = {"offee", "hord", "ome", ...}
set b = {"offee", "ee", "uffalo", ...}

For two words A = a + suffix_a, B = b + suffix_b with different initials a, b, if the suffix of A (suffix_a) appears in both sets, they can't form a valid name. Thus we just need to find out the number of unique suffix from set A and set B .

"offee" appears in both sets thus it can't form a valid name.
"hord", "ome", "ee" and "uffalo" are unique suffixes.
""hord" with "ee", "hord" with "uffalo", "ome" with "ee", "ome" with "uffalo", thus we can make a total of 2 * 2 valid names. Consider we can change the order to double the valid words, multiply the answer by 2.
*/
class Solution {
       public long distinctNames(String[] ideas) {
        HashSet<String>[] count = new HashSet[26];
        for (int i = 0; i < 26; ++i)
            count[i] = new HashSet<>();
        for (String s : ideas)
            count[s.charAt(0) - 'a'].add(s.substring(1));
        long res = 0;
        for (int i = 0; i < 26; ++i)
            for (int j = i + 1; j < 26; ++j) {
                long c1 = 0, c2 = 0;
                for (String c : count[i])
                    if (!count[j].contains(c)) c1++;
                for (String c : count[j])
                    if (!count[i].contains(c)) c2++;
                res += c1 * c2;
            }
        return res * 2;
    }
}