public class example_1_2 {
    static int count;
    static{
        System.out.println("First static block is executed");
        count = 10;
    }

    static {
        System.out.println("Second static block is executed");
        count = count+5;
    }

    example_1_2(){
        this("Nittyansh","Software Engineer");
        System.out.println("No arg constructor is called");
    }

    example_1_2(String name,String designation){
        System.out.println("Parameterized constructor is executed");
    }

    public static void main(String[] args){
        System.out.println("Lets test the Static block");
        System.out.println("Value of count :: "+count);
    }

}
