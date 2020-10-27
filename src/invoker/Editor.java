package invoker;

import command.Command;

/**
 * @author 刘佳兴
 * @date 2020/10/20 23:45
 * mail 1260968291@qq.com
 */

public class Editor {

    public String executeCommand(Command command){
        return command.execute();
    }
}
