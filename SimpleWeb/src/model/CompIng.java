package model;

public class CompIng {
	private int comp_id;
	private int id;
    private String component;
    private int ing_numb;
    private String unit;


    public CompIng(int comp_id, int id, String component, Integer ing_numb, String unit){
    	this.comp_id = comp_id;
    	this.id = id;
        this.component = component;
        this.ing_numb = ing_numb;
        this.unit = unit;
    }

    public int getIng_numb() {
        return ing_numb;
    }

    public void setIng_numb(int ing_numb) {
        this.ing_numb = ing_numb;
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

	public int getComp_id() {
		return comp_id;
	}

	public void setComp_id(int comp_id) {
		this.comp_id = comp_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

