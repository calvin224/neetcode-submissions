class Solution {

    public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();

    for (String s : strs) {
        sb.append(s.length())
          .append("#")
          .append(s);
    }

    return sb.toString();
}

    public List<String> decode(String str) {
    List<String> strs = new ArrayList<>();

    int i = 0;

    while (i < str.length()) {

        int j = i;

        // find #
        while (str.charAt(j) != '#') {
            j++;
        }

        // get length
        int length = Integer.parseInt(str.substring(i, j));

        // move past #
        j++;

        // get actual string
        String word = str.substring(j, j + length);

        strs.add(word);

        // move to next encoded string
        i = j + length;
    }

    return strs;
}
}