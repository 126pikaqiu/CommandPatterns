package model;

/**
 * @author 刘佳兴
 * @date 2020/10/20 23:15
 * mail 1260968291@qq.com
 */
public class EditorModel {
    private String text = "";

    private EditorModel(){}

    private static EditorModel instance = new EditorModel();

    public static EditorModel getInstance(){
        return instance;
    }

    public void addBefore(String s){
        s += text;
        text = s;
    }
    public void undoAddBefore(String s){
        this.deleteBefore(s.length());
    }
    public void undoAddAfter(String s){
        this.deleteAfter(s.length());
    }

    public void addAfter(String s){
        text += s;
    }
    public String get(){
        return "\"" + text + "\"";
    }
    public String getInnerValue(){
        return text;
    }

    public void deleteBefore(int len){
        len = Math.min(len, text.length());
        text = text.substring(len);
    }

    public void deleteAfter(int len){
        text = text.substring(0,Math.max(0,text.length() - len));
    }

    public void flush(){
        this.text = "";
    }
}
