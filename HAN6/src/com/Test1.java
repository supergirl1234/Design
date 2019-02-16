package com;

/**
 * Author:Fanleilei
 * Created:2019/2/16 0015
 */

//普通方式
public class Test1 {

    public static void main(String[] args) {
        Cilent cilent=new Cilent();

        MacbookProComputer macbookProComputer=new MacbookProComputer();
        cilent.createComputer(macbookProComputer);

        cilent.createComputer(new SurfaceComputer());

    }
}


interface Computer{

    void printComputer();
}

class MacbookProComputer implements Computer{

    @Override
    public void printComputer() {
        System.out.println("这是一台MacbookProComputer");

    }
}

class SurfaceComputer implements Computer{
    @Override
    public void printComputer(){
        System.out.println("这是一台 SurfaceComputer");

    }
}

class Cilent{

    public void createComputer(Computer computer){

         computer.printComputer();

    }
}
