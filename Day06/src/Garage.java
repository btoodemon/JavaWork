public class Garage {
    String name;
    String address;
    long phone;

    public Garage(String name1,String address1,long phone1){
        name = name1;
        address = address1;
        phone = phone1;
        System.out.println("维修公司:"+name+"\t地址:"+address+"\t电话:"+phone);
    }

    public void carRepairing(){
        System.out.println("您的车已由"+name+"受理检修");
    }
}
