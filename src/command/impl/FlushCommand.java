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
        this.model.flush();
        return this.model.get();
    }

    private EditorModel model;

    public FlushCommand(EditorModel model){
        this.model = model;
    }

    @Override
    public int type() {
        return CommandType.MODIFY_COMMAND;
    }
}
