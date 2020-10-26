package command.impl;

import command.Command;
import constants.CommandType;

import java.util.List;

/**
 * @author 刘佳兴
 * @date 2020/10/20 23:05
 * mail 1260968291@qq.com
 */
public class MacroEditorCommand implements Command {

    private List<Command> commandList;
    private String argus;
    public MacroEditorCommand(String argus, List<Command> commandList){
        this.argus = argus;
        this.commandList = commandList;
    }
    @Override
    public String execute() {
        String result = null;
        for (Command command : commandList) {
            result = command.execute();
        }
        return result;
    }

    @Override
    public String undo() {
        String result = null;
        for(int index = commandList.size() - 1; index >= 0; index--){
            result = commandList.get(index).undo();
        }
        return result;
    }

    @Override
    public int type() {
        return CommandType.MODIFY_COMMAND;
    }

    @Override
    public String toString() {
        return this.argus;
    }
}
