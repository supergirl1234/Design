package com;

import java.util.Scanner;

/**
 * Author:Fanleilei
 * Created:2019/2/16 0016
 */
//简单工厂方式

//这里我们相当于是创建生产电脑的工厂，客户需要购买什么样的电脑，只要输入类型编号就可以获取该电脑。将类
//的实例化交给工厂易于解耦

//对于简单工厂模式而言，创建对象的逻辑判断放在了工厂类中，客户不感知具体的类，但是其违背了开闭原
//则，如果要增加新的具体类，就必须修改工厂类。
public class Test2 {

    public static void main(String[] args) {
        Cilent2 cilent2=new Cilent2();

        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入电脑型号：Macos、Surface");
        String type=scanner.nextLine();

        Computer2 computer2= ComputerFactory.createComputer(type);
        cilent2.buyComputer(computer2);
    }
}


interface Computer2{

    void printComputer();
}

class MacbookProComputer2 implements Computer2{

    @Override
    public void printComputer() {
        System.out.println("这是一台MacbookProComputer");

    }
}

class SurfaceComputer2 implements Computer2{
    @Override
    public void printComputer(){
        System.out.println("这是一台 SurfaceComputer");

    }
}

class ComputerFactory{

    public static Computer2 createComputer(String type){

        switch(type){

            case "Macos":
                return new MacbookProComputer2();

            case "Surface":
                return   new SurfaceComputer2();

            default:

                System.out.println("输入的型号不对");;
        }
        return null;
    }
}

class Cilent2{

    public void buyComputer(Computer2 computer2){

        computer2.printComputer();

    }
}

//在这种方式下，如果想增加一种电脑，就需要增加一个类，且修改ComputerFactory类，改动代码；
