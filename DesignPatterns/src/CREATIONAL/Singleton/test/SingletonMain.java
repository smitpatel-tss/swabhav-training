package CREATIONAL.Singleton.test;

import CREATIONAL.Singleton.model.MySingleton;

public class SingletonMain {
    public static void main(String[] args) {
        MySingleton obj1=MySingleton.getInstance();
        MySingleton obj2=MySingleton.getInstance();

        System.out.println(obj1);
        System.out.println(obj2);
    }
}
