package com;

/**
 * Author:Fanleilei
 * Created:2019/2/16 0016
 */
//抽象工厂模式

//抽象工厂模式：提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。

//工厂方法模式和抽象工厂模式基本类似，可以这么理解：当工厂只生产一个产品的时候，即为工厂方法模式，而工
//厂如果生产两个或以上的商品即变为抽象工厂模式

//抽象工厂模式进一步扩展了工厂方法模式，它把原先的工厂方法模式中只能有一个抽象产品不能添加产品族
//的缺点克服了，抽象工厂模式不仅仅遵循了OCP原则，而且可以添加更多产品(抽象产品),具体工厂也不仅仅
//可以生成单一产品，而是生成一组产品，抽象工厂也是声明一组产品，对应扩展更加灵活，但是要是扩展族
//系就会很笨重
public class Test4 {

    public static void main(String[] args) {

        Cilent4 cilent4=new Cilent4();
        Factory4 macbookProFactory4=new MacbookProFactory4();
        cilent4.buyComputer(macbookProFactory4.createComputer());
        cilent4.use(macbookProFactory4.createSystem());

        System.out.println("-------");

        Factory4 surfaceFactory4=new SurfaceFactory4();
        Computer4 computer41=surfaceFactory4.createComputer();
        cilent4.buyComputer(computer41);
        OperatingSystem4 operatingSystem41=surfaceFactory4.createSystem();
        cilent4.use(operatingSystem41);

    }
}
//电脑
interface Computer4{

    void printComputer();

}

class MacbookProComputer4 implements Computer4{

    @Override
    public void printComputer() {
        System.out.println("这是一台MacbookProComputer");

    }


}

class SurfaceComputer4 implements Computer4{
    @Override
    public void printComputer(){
        System.out.println("这是一台 SurfaceComputer");

    }
}


//操作系统
interface OperatingSystem4 {
    void printSystem();
}
class MacOsSystem4 implements OperatingSystem4 {
    public void printSystem() {
        System.out.println("This is a mac os");
    }
}
class Windows8System4 implements OperatingSystem4 {
    public void printSystem() {
        System.out.println("This is a window 8");
    }
}
//工厂
interface Factory4{
    Computer4 createComputer();
    OperatingSystem4 createSystem();
}
class MacbookProFactory4 implements Factory4{


    @Override
    public Computer4 createComputer() {
        return new MacbookProComputer4();
    }

    @Override
    public OperatingSystem4 createSystem() {
        return new MacOsSystem4();
    }
}
class SurfaceFactory4 implements Factory4{


    @Override
    public Computer4 createComputer() {
        return new SurfaceComputer4();
    }

    @Override
    public OperatingSystem4 createSystem() {
        return new Windows8System4();
    }
}

class Cilent4{

    public void buyComputer(Computer4 computer4){

        computer4.printComputer();

    }
    public void use(OperatingSystem4 system4){
        system4.printSystem();
    }
}

