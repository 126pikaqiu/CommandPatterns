package command.impl;

import command.Command;
import constants.CommandType;
import model.EditorModel;

/**
 * @author 刘佳兴
 * @date 2020/10/20 22:43
 * mail 1260968291@qq.com
 */
public class AddAfterCommand implements Command {

    private String argus;
    private EditorModel model = EditorModel.getInstance();

    public AddAfterCommand(String argus){
        this.argus = argus;
    }

    @Override
    public String execute() {
        String addValue = this.argus.replace("\"","").substring(this.argus.replace("\"","").indexOf(" ")+1);
        this.model.addAfter(addValue);
        return this.model.get();
    }


    @Override
    public int type() {
        return CommandType.MODIFY_COMMAND;
    }

    @Override
    public Command myClone() {
        return new AddAfterCommand(this.argus);
    }

    @Override
    public String undo() {
        String addValue = this.argus.replace("\"","").substring(this.argus.replace("\"","").indexOf(" ")+1);
        this.model.undoAddAfter(addValue);
        return this.model.get();
    }

    @Override
    public String toString() {
        return this.argus;
    }
}
