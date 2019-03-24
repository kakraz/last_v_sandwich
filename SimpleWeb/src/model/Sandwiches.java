package model;

public class Sandwiches {

    private int id;
    private String name;
    private String type;
    private int minutes;
    private String bread;
    private String comment;


    public Sandwiches(){

    }

    public Sandwiches(Integer id, String name, String type, int minutes, String bread, String comment){
        this.id = id;
        this.name = name;
        this.type = type;
        this.minutes = minutes;
        this.bread = bread;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}


