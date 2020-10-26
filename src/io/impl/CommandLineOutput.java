package io.impl;

import io.MyOutput;

import java.io.IOException;

/**
 * @author 刘佳兴
 * @date 2020/10/21 0:12
 * mail 1260968291@qq.com
 */
public class CommandLineOutput implements MyOutput {

    @Override
    public void writeContent(String line) {
        System.out.println(line);
    }

    @Override
    public void close() throws IOException {
        System.out.flush();
    }
}
