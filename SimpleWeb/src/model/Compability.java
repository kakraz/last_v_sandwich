package model;

public class Compability {
    private int Sandwiches_id;
    private int Addition_add_id;

    public Compability(Integer Sandwiches_id, Integer Addition_add_id){
        this.Sandwiches_id = Sandwiches_id;
        this.Addition_add_id = Addition_add_id;
    }

    public Compability(int Sandwiches_id){
        this.Sandwiches_id = Sandwiches_id;
    }

    public int getSandwiches_id(){
        return Sandwiches_id;
    }

    public void setSandwiches_id(int Sandwiches_id){
        this.Sandwiches_id = Sandwiches_id;
    }

    public int getAddition_add_id() {
        return Addition_add_id;
    }

    public void setAddition_add_id(int Addition_add_id) {
        this.Addition_add_id = Addition_add_id;
    }
}
