package command.impl;

import command.Command;
import model.EditorModel;

import constants.CommandType;

/**
 * @author 刘佳兴
 * @date 2020/10/23 10:33
 * mail 1260968291@qq.com
 */
public class ShowCommand implements Command {

    private EditorModel model;

    public ShowCommand(String argus, EditorModel model){
        this.model = model;
    }

    public ShowCommand(){}

    @Override
    public String execute() {
        return this.model.get();
    }

    @Override
    public int type() {
        return CommandType.CAT_COMMAND;
    }
}
