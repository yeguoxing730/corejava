package autocomplete;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * corejava
 * 2019/3/20 9:46
 *
 * @author gxye
 * @since
 **/
public class PrefixMatcherTest {
    public static void main(String[] args) {
        ServiceLoader<PrefixMatcher> matcher = ServiceLoader.load(PrefixMatcher.class);
        Iterator<PrefixMatcher> matcherIter = matcher.iterator();
        while (matcherIter.hasNext()) {
            PrefixMatcher wordMatcher = matcherIter.next();
            System.out.println(wordMatcher.getClass().getName());
            String[] prefixes = new String[] {"a", "b", "c", "d", "e", "f", "g", "i",
                    "l", "n", "p", "r", "s", "t", "v", "w", "do", "finally"};
            for (String prefix: prefixes) {
                System.out.println(wordMatcher.obtainMatchedWords(prefix));
            }
        }

    }
}
