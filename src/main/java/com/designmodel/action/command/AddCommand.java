package com.designmodel.action.command;

public class AddCommand implements Command {
    /**
     * 命令接受者对象
     */
    public Document doucment;

    /**
     * 构造方法
     *
     * @param document
     */
    public AddCommand(Document document) {
        this.doucment = document;
    }

    @Override
    public void execute() {
// TODO Auto-generated method stub
        this.doucment.add();
    }
}
