class Dog extends Animal implement pet{
    Dog(String name){
        super (name);
    }

    @override
    void makeSound(){
        System.out.println(name + "says : woof !");
    }
    
    @override
    public void play(){
        System.out.println(name + " is playing fetch ");
    }
}