package CREATIONAL.Singleton.model;

public class MySingleton {

    private MySingleton(){
        System.out.println("Main .....");
    }

    private static class InstanceContainer{
        static MySingleton obj= new MySingleton();
    }

    public static MySingleton getInstance(){
        return InstanceContainer.obj;
    }

}
