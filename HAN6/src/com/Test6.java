package com;

/**
 * Author:Fanleilei
 * Created:2019/2/16 0016
 */

//代理设计模式
//两个子类共同实现一个接口，其中一个子类负责真实业务实现，另外一个子类完成辅助真实业务主题的操作。
//代理模式的本质：所有的真实业务操作都会有一个与之辅助的工具类（功能类）共同完成。
public class Test6 {

    public static void main(String[] args) {
        BoyFriendSendGift boyFriendSendGift=new BoyFriendSendGift("张三","Tom");
        ProxySendGift proxySendGift=new ProxySendGift(boyFriendSendGift);
        proxySendGift.send();
    }
}
//业务接口
interface SendGift{

    void send();
}
//业务类
class BoyFriendSendGift implements SendGift{

    private  String boyFriendName;
    private  String girlFriendName;

    public BoyFriendSendGift(String boyFriendName, String girlFriendName) {
        this.boyFriendName = boyFriendName;
        this.girlFriendName = girlFriendName;
    }

    @Override
    public void send() {
        System.out.println(this.boyFriendName+"送礼物给"+this.girlFriendName);
    }
}

//代理类

class ProxySendGift implements SendGift{

    private final SendGift target;
    public ProxySendGift(SendGift target){

        this.target = target;
    }

    @Override
    public void send() {
        System.out.println("快递员打电话给客户");
        this.target.send();//调用真正业务
        System.out.println("客户签收");

    }
}