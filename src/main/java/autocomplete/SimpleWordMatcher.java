package autocomplete;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * corejava
 * 2019/3/20 9:41
 *
 * @author gxye
 * @since
 **/
public class SimpleWordMatcher extends AbstractPrefixMatcher {

    public SimpleWordMatcher() {
        prefixMatchers = buildPrefixMatchers(javaKeywords);
    }

    /**
     * 将输入的单词组转化为前缀匹配的映射
     * @param keywords
     * @return
     *
     * eg. {"abc", "acd", "bcd"} ===>
     * {"a": ["abc", "acd"], "ab": ["abc"], "abc": ["abc"],
     *  "ac": ["acd"], "acd": ["acd"],  "b": ["bcd"], "bc": ["bcd"], "bcd": ["bcd"]
     * }
     */
    public Map<String, Set<String>> buildPrefixMatchers(String[] keywords) {
        HashMap<String, Set<String>> prefixMatchers = new HashMap<String, Set<String>>();

        for (String keyword: keywords) {
            int wordLen = keyword.length();
            for (int i=1; i < wordLen; i++) {
                String prefix = keyword.substring(0, i);
                for (String keyword2: javaKeywords) {
                    if (keyword2.startsWith(prefix)) {
                        Set<String> matchers = prefixMatchers.get(prefix);
                        if (matchers == null) {
                            matchers = new HashSet<String>();
                        }
                        matchers.add(keyword2);
                        prefixMatchers.put(prefix, matchers);
                    }
                }
            }
        }
        return prefixMatchers;
    }



    public static void main(String[] args) {
        SimpleWordMatcher wordMatcher = new SimpleWordMatcher();
//        MapUtil.printMap(wordMatcher.obtainPrefixMatchers());
        String[] prefixes = new String[] {"a", "b", "c", "d", "e", "f", "g", "i",
                "l", "n", "p", "r", "s", "t", "v", "w", "do", "finally"};
        for (String prefix: prefixes) {
            System.out.println(wordMatcher.obtainMatchedWords(prefix));
        }
    }

    @Override
    void dynamicAddNew(String inputText) {
    }

}
