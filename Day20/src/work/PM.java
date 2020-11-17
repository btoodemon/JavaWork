package work;

public class PM extends Employee {

    public PM(Integer id, String name) {
        super(id, name);
    }

    @Override
    public void show() {
        System.out.println("产品经理信息 : [编号 : " + getId() + " 名称:" + getName()+"]");
    }
}
