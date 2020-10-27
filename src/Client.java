import command.Command;
import command.impl.*;
import constants.CommandType;
import invoker.Editor;
import io.MyInput;
import io.MyOutput;
import model.EditorModel;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author 刘佳兴
 * @date 2020/10/20 23:36
 * mail 1260968291@qq.com
 */
public class Client {

    private Stack<Command> past;
    private Stack<Command> undo;
    private Map<String, Command> macros;
    private Map<Character, String> commandMaps;
    private EditorModel model;

    public Client(Map<Character, String> commandMaps){
        past = new Stack<>();
        undo = new Stack<>();
        this.macros = new HashMap<>();
        this.commandMaps = commandMaps;
        this.model = new EditorModel();
    }

    public void start(MyInput input, MyOutput output) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException,
            InvocationTargetException, IOException {
        Editor editor = new Editor();
        String line;
        Command cmd;
        while((line = input.nextLine()) != null){
            if((cmd = parseCommand(line)) != null){
                String result = editor.executeCommand(cmd);
                if(cmd.type() == CommandType.MODIFY_COMMAND){
                    past.push(cmd);
                }
                if(result != null){
                    output.writeContent(result);
                }
            }
        }
        input.close();
        output.close();
    }

    public Command parseCommand(String s) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 不解析非法字符串
        char c = s.charAt(0);
        Command cmd;

        if(this.commandMaps.get(c) != null){
            Class<?> classBook = Class.forName(this.commandMaps.get(c));
            Constructor<?> declaredConstructorBook = classBook.getDeclaredConstructor(String.class,EditorModel.class);
            cmd = (Command) declaredConstructorBook.newInstance(s, model);
            return cmd;
        }

        switch (c){
            case 'r':
                if(!this.undo.empty()){
                    Command undo = this.undo.pop();
                    undo.redo();
                    past.push(undo);
                }
                cmd = new HelpCommand(model); break;
            case 'u':
                if(!this.past.empty()){
                    Command tmp = this.past.pop();
                    tmp.undo();
                    undo.push(tmp);
                }
                cmd = new HelpCommand(model); break;
            case 'l':
                cmd = handleListCommand(s.trim());
                break;
            case 'm':
                cmd = handleDefineMacro(s.trim());
                break;
            case '$':
                String macroName = s.substring(1).trim();
                if(macros.get(macroName) != null){
                    cmd = macros.get(macroName);
                    break;
                }
            default:
                cmd = null;
        }
        return cmd;
    }

    private Command handleListCommand(String s){
        int count = Integer.parseInt(s.split(" ")[1]);
        StringBuilder ls = new StringBuilder();
        Stack<Command> tmp = new Stack<>();
        int popCount = 0;
        while(!past.empty() && popCount < count){
            tmp.push(past.pop());
            ls.append(popCount + 1).append(" ").append(tmp.peek().toString()).append("\n");
            popCount ++;
        }
        while (!tmp.empty()){
            past.push(tmp.pop());
        }
        String result = ls.toString();
        return new HelpCommand(result.length()>0 ? result.substring(0,result.length() - 1):result);
    }

    private Command handleDefineMacro(String s){
        int count = Integer.parseInt(s.split(" ")[1]);
        String name = s.split(" ")[2];
        List<Command> commandList = new ArrayList<>();
        Stack<Command> tmp = new Stack<>();
        int popCount = 0;
        while(!past.empty() && popCount < count){
            tmp.push(past.pop());
            popCount ++;
        }
        while (!tmp.empty()){
            past.push(tmp.pop());
            commandList.add(past.peek().myClone());
        }
        macros.put(name,new MacroEditorCommand(name,commandList));
        return new HelpCommand();
    }

    public void flush(){
        past = new Stack<>();
        undo = new Stack<>();
        macros = new HashMap<>();
        new FlushCommand(this.model).execute();
    }
}
