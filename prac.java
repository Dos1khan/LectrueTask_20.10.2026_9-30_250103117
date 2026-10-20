package Soft_lp;
//Custom Pizza Builder (Decorator Pattern)
//Create a base PlainPizza (Price: $5, Description: "Plain Dough & Sauce").
//Create topping decorators: Cheese (+$2), Olives (+$1), and Pineapple (+$1.5) that can wrap any pizza.
//Challenge: Stack at least 3 toppings and print the final description and total cost without using if/else.

interface Pizza{
    String getDescription();
    float getprice();
}

class PlainPizza implements Pizza{
    @Override
    public String getDescription(){
        return "Plain Dough & Sauce";
    }
    @Override
    public float getprice(){
        return 5;
    }
}

abstract class PizzaDecorator implements Pizza{
    protected Pizza decoratedPizza;
    public PizzaDecorator(Pizza pizza){
        this.decoratedPizza = pizza;
    }
    @Override
    public String getDescription(){
        return decoratedPizza.getDescription();
    }
    @Override
    public float getprice(){
        return decoratedPizza.getprice();
    }
}

class CheeseDecorator extends PizzaDecorator{
    public CheeseDecorator(Pizza pizza){super(pizza);}
    @Override
    public String getDescription(){return super.getDescription() + ", Cheese";}

    @Override
    public float getprice(){return super.getprice() + 2;}

}

class OlivesDecorator extends PizzaDecorator{
    public OlivesDecorator(Pizza pizza){super(pizza);}
    @Override
    public String getDescription(){return super.getDescription() + ", Olives";}

    @Override
    public float getprice(){return super.getprice() + 1;}

}

class PineappleDecorator extends PizzaDecorator{
    public PineappleDecorator(Pizza pizza){super(pizza);}
    @Override
    public String getDescription(){return super.getDescription() + ", Pineapple";}

    @Override
    public float getprice(){return (float) (super.getprice() + 1.5);}

}
public class prac {
    public static void main(String[] args){
        Pizza p = new PlainPizza();
        p = new CheeseDecorator(p);
        p = new OlivesDecorator(p);
        p = new PineappleDecorator(p);
        System.out.println(p.getDescription() + " -> " + p.getprice());
    }

}
