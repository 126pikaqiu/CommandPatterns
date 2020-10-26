package command.impl;

import command.Command;
import constants.CommandType;
import model.EditorModel;

/**
 * @author 刘佳兴
 * @date 2020/10/20 22:43
 * mail 1260968291@qq.com
 */
public class DeleteBeforeCommand implements Command {
    private String argus;
    private String deletedString;

    public DeleteBeforeCommand(String argus) {
        this.argus = argus;
    }

    private EditorModel model = EditorModel.getInstance();

    @Override
    public String execute() {
        int count = Integer.parseInt(this.argus.split(" ")[1].trim());
        assert count != -1;
        String before  = this.model.getInnerValue();
        this.deletedString = before.substring(0,Math.min(count,before.length()));
        this.model.deleteBefore(count);
        return this.model.get();
    }

    @Override
    public String undo() {
        this.model.addBefore(this.deletedString);
        return this.model.get();
    }

    @Override
    public int type() {
        return CommandType.MODIFY_COMMAND;
    }

    @Override
    public Command myClone() {
        return new DeleteBeforeCommand(this.argus);
    }

    @Override
    public String toString() {
        return this.argus;
    }
}
