package io.impl;

import io.MyInput;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author 刘佳兴
 * @date 2020/10/21 0:05
 * mail 1260968291@qq.com
 */
public class CommandLineInput implements MyInput {

    Scanner s = new Scanner(System.in);
    String endLine = "q";

    @Override
    public String nextLine() {
        System.out.print("$ ");
        String line = s.nextLine();
        if(line != null && endLine.equals(line.trim())){
            line = null;
        }
        return line;
    }

    @Override
    public void close() throws IOException {
        System.in.close();
    }
}
