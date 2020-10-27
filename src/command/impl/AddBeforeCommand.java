package command.impl;

import command.Command;
import constants.CommandType;
import model.EditorModel;

/**
 * @author 刘佳兴
 * @date 2020/10/20 22:42
 * mail 1260968291@qq.com
 */
public class AddBeforeCommand implements Command {
    private String argus;

    private EditorModel model;

    public AddBeforeCommand(String argus, EditorModel model) {
        this.model = model;
        this.argus = argus;
    }

    @Override
    public String execute() {
        String addValue = this.argus.replace("\"","").substring(this.argus.replace("\"","").indexOf(" ")+1);
        this.model.addBefore(addValue);
        return this.model.get();
    }

    @Override
    public String undo() {
        String addValue = this.argus.replace("\"","").substring(this.argus.replace("\"","").indexOf(" ")+1);
        this.model.undoAddBefore(addValue);
        return this.model.get();
    }

    @Override
    public int type() {
        return CommandType.MODIFY_COMMAND;
    }

    @Override
    public Command myClone() {
        return new AddBeforeCommand(this.argus,this.model);
    }

    @Override
    public String toString() {
        return this.argus;
    }
}
