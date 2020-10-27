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
    private String argus ;
    private EditorModel model;

    public HelpCommand(EditorModel model){
        this.model = model;
        this.argus = model.get();
    }

    public HelpCommand(String argus){
        this.argus = argus;
    }
    public HelpCommand(){}
    @Override
    public String execute() {
        return this.argus;
    }

    @Override
    public int type() {
        return CommandType.HELP_COMMAND;
    }
}
