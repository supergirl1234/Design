package com;

/**
 * Author:Fanleilei
 * Created:2019/2/16 0016
 */

//工厂模式
//工厂方法模式是针对每个产品提供一个工厂类，在客户端中判断使用哪个工厂类去创建对象

//对于工厂方法模式而言，是通过扩展来新增具体类的，符合开闭原则，但是在客户端就必须要感知到具体的
//工厂类，也就是将判断逻辑由简单工厂的工厂类挪到客户端
public class Test3 {

    public static void main(String[] args) {
        Cilent3 cilent3=new Cilent3();

        Factory macbookProFactory=new MacbookProFactory();
        cilent3.buyComputer(macbookProFactory.createComputer());

        Factory surfaceFactory=new SurfaceFactory();
        cilent3.buyComputer(surfaceFactory.createComputer());
    }
}
interface Computer3{

    void printComputer();
}

class MacbookProComputer3 implements Computer3{

    @Override
    public void printComputer() {
        System.out.println("这是一台MacbookProComputer");

    }
}

class SurfaceComputer3 implements Computer3{
    @Override
    public void printComputer(){
        System.out.println("这是一台 SurfaceComputer");

    }
}
interface Factory{
    Computer3 createComputer();
}
class MacbookProFactory implements Factory{


    @Override
    public Computer3 createComputer() {
        return new MacbookProComputer3();
    }
}
class SurfaceFactory implements Factory{


    @Override
    public Computer3 createComputer() {
        return new SurfaceComputer3();
    }
}

class Cilent3{

    public void buyComputer(Computer3 computer3){

        computer3.printComputer();

    }
}
