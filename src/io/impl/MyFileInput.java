package io.impl;

import io.MyInput;

import java.io.*;

/**
 * @author 刘佳兴
 * @date 2020/10/27 0:59
 * mail 1260968291@qq.com
 */
public class MyFileInput implements MyInput {
    private File file;
    private BufferedReader br;

    public MyFileInput(File file) throws FileNotFoundException {
        this.file = file;
        br = new BufferedReader(new FileReader(this.file));
    }

    @Override
    public String nextLine() {
        if(!this.file.exists()){
            return null;
        }
        String line = null;
        try {
            line = this.br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    @Override
    public void close() throws IOException {
        this.br.close();
    }
}
