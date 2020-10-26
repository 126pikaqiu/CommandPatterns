package command.impl;

import command.Command;
import constants.CommandType;
import model.EditorModel;

/**
 * @author 刘佳兴
 * @date 2020/10/27 1:39
 * mail 1260968291@qq.com
 */
public class FlushCommand implements Command {

    @Override
    public String execute() {
        EditorModel.getInstance().flush();
        return EditorModel.getInstance().get();
    }

    @Override
    public int type() {
        return CommandType.MODIFY_COMMAND;
    }
}
