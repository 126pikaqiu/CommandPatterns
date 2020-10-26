package command.impl;

import command.Command;
import constants.CommandType;
import model.EditorModel;

/**
 * @author 刘佳兴
 * @date 2020/10/23 10:20
 * mail 1260968291@qq.com
 */
public class DeleteAfterCommand implements Command {
    private String argus;
    private String deletedString;

    private EditorModel model = EditorModel.getInstance();

    @Override
    public String execute() {
        int count = Integer.parseInt(this.argus.split(" ")[1].trim());
        String before  = this.model.getInnerValue();
        this.deletedString = before.substring(Math.max(0,before.length() - count));
        this.model.deleteAfter(count);
        return this.model.get();
    }

    @Override
    public String undo() {
        this.model.addAfter(this.deletedString);
        return this.model.get();
    }

    public DeleteAfterCommand(String argus) {
        this.argus = argus;
    }

    @Override
    public int type() {
        return CommandType.MODIFY_COMMAND;
    }

    @Override
    public Command myClone() {
        return new DeleteAfterCommand(this.argus);
    }

    @Override
    public String toString() {
        return this.argus;
    }
}
