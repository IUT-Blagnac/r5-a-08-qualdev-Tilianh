package dojo;

import java.util.ArrayList;
import java.util.List;


public class Order {

    private String owner = "";
    private String target = "";
    private final List<String> cocktails = new ArrayList<String>();

    public void declareOwner(String owner) {
        this.owner = owner;
    }

    public void declareTarget(String target) {
        this.target = target;
    }

    public void addCocktail(String cocktail) {
        this.cocktails.add(cocktail);
    }

    public void removeCocktail(String cocktail) {
        this.cocktails.remove(cocktail);
    }

    public String getOwner() {
        return this.owner;
    }

    public String getTarget() {
        return this.target;
    }

    public List<String> getCocktails() {
        return this.cocktails;
    }

}
