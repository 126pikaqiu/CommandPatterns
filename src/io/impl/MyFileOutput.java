package io.impl;

import io.MyOutput;

import java.io.*;

/**
 * @author 刘佳兴
 * @date 2020/10/27 1:05
 * mail 1260968291@qq.com
 */
public class MyFileOutput implements MyOutput {

    private File file;
    private BufferedWriter bw;
    public MyFileOutput(File file) throws IOException {
        this.file = file;
        if(this.file.exists()){
            this.file.delete();
        }
        this.bw = new BufferedWriter(new FileWriter(this.file, true));
    }

    @Override
    public void writeContent(String line) {
        BufferedWriter bw = null;
        try {
            this.bw.write(line + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {
        bw.close();
    }
}
