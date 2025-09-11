/*
 * Design an algorithm to encode a list of Strings to a single Strings.
 * The encoded String is the transmitted or stored.
 * Later, this encoded string is decoded back to the original list of strings.
 */

import java.util.ArrayList;
import java.util.List;

public class encodeAndDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            if (s == null)
                s = "";
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (j < s.length() && s.charAt(j) != '#')
                j++;
            int len = Integer.parseInt(s.substring(i, j));
            j++;
            String str = s.substring(j, j + len);
            result.add(str);
            i = j + len;
        }
        return result;
    }
}

    
/*
 *encode(List<String> strs):

StringBuilder sb = new StringBuilder(); — prepare efficient append buffer.

Loop through each string s in strs.

If s was null, convert to "" (defensive; LeetCode usually gives non-null strings).

sb.append(s.length()).append('#').append(s); — append length, a # delimiter, then the string itself.

Example: "hello" → "5#hello"

Return the concatenated encoded string.

decode(String s):

List<String> result = new ArrayList<>(); — output list.

int i = 0; while (i < s.length()) { ... } — iterate through encoded string.

Find the next # by advancing j from i.

int len = Integer.parseInt(s.substring(i, j)); — parse length.

j++ to skip #.

String str = s.substring(j, j + len); — extract the original string of length len.

result.add(str); and set i = j + len to continue.
 * 
 */
