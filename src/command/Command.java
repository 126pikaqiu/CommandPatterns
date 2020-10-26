package command;

/**
 * @author 刘佳兴
 * @date 2020/10/20 22:26
 * mail 1260968291@qq.com
 */
public interface Command {
    /**
     * 命令执行
     * @return 执行结果
     */
    String execute();

    /**
     * 撤销命令执行
     * @return 执行结果
     */
    default String undo(){
        return "";
    }

    /**
     * 再次执行命令
     * @return 执行结果
     */
    default String redo(){
        return this.execute();
    };


    /**
     * 获得命令类型
     * @return 命令类型
     */
    int type();

    /**
     * 自拷贝
     * @return 返回值
     */
    default Command myClone(){
        return this;
    }
}
