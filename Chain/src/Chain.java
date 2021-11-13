import java.util.Scanner;

public class Chain {
     Processor chain;

    public Chain(){
        buildChain();
    }

    private void buildChain(){
        chain = new MinusProcessor(new MultiplyProcessor(new SumProcessor(new DivisionProcessor(null))));
    }

    public void process(Sign request, Number number){
        chain.process(request, number);
    }
}

abstract class Processor{
    private Processor processor;

    public Processor(Processor processor){
        this.processor = processor;
    };

    public void process(Sign request, Number number){
        if (processor != null)
            processor.process(request, number);
    };
}

class Number{
    private int number1;
    private int number2;

    Number(int number1, int number2){
        this.number1 = number1;
        this.number2 = number2;
    }

    public int getNumber1(){
        return number1;
    }
    public int getNumber2(){
        return number2;
    }
}

class Sign{
    private String sign;

    Sign(String sign){
        this.sign = sign;
    }

    public String getSign(){
        return sign;
    }
}

class MinusProcessor extends Processor{
    public MinusProcessor(Processor processor){
        super(processor);
    }

    public void process(Sign request, Number request1){
        int subtraction = 0;
        if(request.getSign().equals("-")){
            subtraction = request1.getNumber1() - request1.getNumber2();
            System.out.println("Subtraction : " + request1.getNumber1() + " - " + request1.getNumber2() + " = " + subtraction);
        }else {
            super.process(request, request1);
        }
    }
}

class MultiplyProcessor extends  Processor{
    public MultiplyProcessor(Processor processor){
        super(processor);
    }

    public void process(Sign request, Number request1){
        int multiplication = 0;
        if (request.getSign().equals("*")){
            multiplication = request1.getNumber1() * request1.getNumber2();
            System.out.println("Multiplication : " + request1.getNumber1() + " * " + request1.getNumber2() + " = " + multiplication);
        }else {
            super.process(request, request1);
        }
    }
}

class SumProcessor extends  Processor{
    public SumProcessor(Processor processor){
        super(processor);
    }

    public void process(Sign request, Number request1){
        int sum = 0;
        if (request.getSign().equals("+")){
            sum = request1.getNumber1() + request1.getNumber2();
            System.out.println("Sum : " + request1.getNumber1() + " + " + request1.getNumber2() + " = " + sum);
        }else {
            super.process(request, request1);
        }
    }
}

class DivisionProcessor extends  Processor{
    public DivisionProcessor(Processor processor){
        super(processor);
    }

    public void process(Sign request, Number request1){
        int division = 0;
        if (request.getSign().equals("/")){
            if (request1.getNumber2() == 0){
                System.out.println("Cannot divide by zero");
            }else {
                division = request1.getNumber1() / request1.getNumber2();
                System.out.println("Division : " + request1.getNumber1() + " / " + request1.getNumber2() + " = " + division);
            }
        }else {
            super.process(request, request1);
        }
    }
}

class TestChain{
    public static void main(String[] args){
        Chain chain = new Chain();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sign: ");
        String sign = sc.nextLine();
        System.out.println("Enter the number1: ");
        int number1 = sc.nextInt();
        System.out.println("Enter the number2: ");
        int number2 = sc.nextInt();
        chain.process(new Sign(sign), new Number(number1, number2));
    }
}




