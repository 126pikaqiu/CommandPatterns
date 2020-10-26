package io;

import java.io.IOException;

/**
 * @author 刘佳兴
 * @date 2020/10/21 0:02
 * mail 1260968291@qq.com
 */
public interface MyOutput {
    /**
     * 输出内容
     * @param line 输入的内容
     */
    void writeContent(String line);

    /**
     * 关闭输出流
     * @throws IOException 捕获异常
     */
    void close() throws IOException;
}
