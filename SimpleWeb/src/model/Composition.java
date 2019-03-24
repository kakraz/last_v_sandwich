package model;

public class Composition {
    private int Sandwiches_id;
    private int Ingredients_comp_id;
    private int ing_numb;

    public Composition(Integer Sandwiches_id, Integer Ingredients_comp_id, Integer ing_numb){
        this.Sandwiches_id = Sandwiches_id;
        this.Ingredients_comp_id = Ingredients_comp_id;
        this.ing_numb = ing_numb;
    }

    public int getSandwiches_id(){
        return Sandwiches_id;
    }

    public void setSandwiches_id(int Sandwiches_id){
        this.Sandwiches_id = Sandwiches_id;
    }

    public int getIngredients_comp_id() {
        return Ingredients_comp_id;
    }

    public void setIngredients_comp_id(int Ingredients_comp_id) {
        this.Ingredients_comp_id = Ingredients_comp_id;
    }

    public int getIng_numb(){
        return ing_numb;
    }

    public void setIng_numb(int ing_numb){
        this.ing_numb = ing_numb;
    }
}
