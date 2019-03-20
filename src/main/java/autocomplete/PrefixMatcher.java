package autocomplete;

import java.util.Set;

/**
 * corejava
 * 2019/3/20 9:35
 * SPI测试
 * 1.新建接口
 * 2.在META-INF/services下建立接口的全名文件 如 autocomplete.PREfixMatcher
 * 3.在文件里面写入接口的实现类 1到n个
 * 4.通过SPI 技术加载这些实现类
 * @author gxye
 * @since
 **/
public interface PrefixMatcher {
    Set<String> obtainMatchedWords(String inputText);
}
