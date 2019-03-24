package model;

public class Ingredients {

    private int comp_id;
    private String component;
    private String unit;


    public Ingredients(Integer comp_id, String component, String unit){
        this.comp_id = comp_id;
        this.component = component;
        this.unit = unit;
    }

    public int getComp_id() {
        return comp_id;
    }

    public void setComp_id(int comp_id) {
        this.comp_id = comp_id;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}

