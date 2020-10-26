package command.impl;

import command.Command;
import constants.CommandType;
import model.EditorModel;

/**
 * @author 刘佳兴
 * @date 2020/10/26 23:25
 * mail 1260968291@qq.com
 */
public class HelpCommand implements Command {
    private String argus = EditorModel.getInstance().get();
    
    public HelpCommand(){}

    public HelpCommand(String argus){
        this.argus = argus;
    }
    @Override
    public String execute() {
        return this.argus;
    }

    @Override
    public int type() {
        return CommandType.HELP_COMMAND;
    }
}
