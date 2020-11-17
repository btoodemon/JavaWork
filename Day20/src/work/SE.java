package work;

public class SE extends Employee implements Comparable<SE>{


    public SE(Integer id, String name) {
        super(id, name);
    }
    /**
     * 比较方法
     * @param o
     * @return
     */
    @Override
    public int compareTo(SE o) {
        int i = this.getId().compareTo(o.getId());
        if(i == 0){
            i = this.getName().compareTo(o.getName());
        }
        return i;
    }

    @Override
    public void show() {
        System.out.println("程序员信息 : [编号 : " + getId() + " 名称:" + getName()+"]");
    }
}
