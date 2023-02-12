package com.selfstudy.oopextends;

public class Test {
    public static void main(String[] args) {
        Ragdoll rd = new Ragdoll("布偶猫");
        rd.eat();
        rd.drink();
        rd.catchMouse();

        Husky h = new Husky();
        h.eat();
        h.lookHome();
    }
}
