package model;

public class Addition {
    private int add_id;
    private String complement;
    private String type;

    public Addition(Integer add_id, String complement, String type){
        this.add_id = add_id;
        this.complement = complement;
        this.type = type;
    }

    public int getAdd_id() {
        return add_id;
    }

    public void setAdd_id(Integer add_id) {
        this.add_id = add_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
