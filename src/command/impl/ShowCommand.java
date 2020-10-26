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

    private EditorModel model = EditorModel.getInstance();

    public ShowCommand(String argus){

    }

    public ShowCommand(){}

    @Override
    public String execute() {
        return EditorModel.getInstance().get();
    }

    @Override
    public int type() {
        return CommandType.CAT_COMMAND;
    }
}
