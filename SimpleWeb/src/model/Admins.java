package model;

public class Admins {
    private int adm_id;
    private String login;
    private String password;

    public Admins(Integer adm_id, String login, String password){
        this.adm_id = adm_id;
        this.login = login;
        this.password = password;
    }

    public Admins() {
    	
    }
    public Admins(String login){
        this.login = login;
    }

    public int getAdm_id() {
        return adm_id;
    }

    public void setAdm_id (int adm_id) {
        this.adm_id = adm_id;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
