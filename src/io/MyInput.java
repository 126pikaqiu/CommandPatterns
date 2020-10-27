package io;

import java.io.IOException;

/**
 * @author 刘佳兴
 * @date 2020/10/21 0:02
 * mail 1260968291@qq.com
 */
public interface MyInput {
    /**
     * 获得输入
     * @return 输入的内容
     */
    String nextLine();

    /**
     * 关闭输入流
     * @throws IOException 捕获异常
     */
    void close() throws IOException;
}
