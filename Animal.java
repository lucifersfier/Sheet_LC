//abstract class example ->

abstract class Animal{
    String name;

    Animal(String name){
        this.name = name;
    }

    //abstract method(no body)
    abstract void makeSound();

    //concrete method
    void sleep(){
        System.out.println(name + "is sleeping......");
    }
}