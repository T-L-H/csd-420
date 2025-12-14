package app.db;

public class Fan {
    private final int id;
    private String firstname;
    private String lastname;
    private String favoriteteam;

    public Fan(int id, String firstname, String lastname, String favoriteteam) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.favoriteteam = favoriteteam;
    }

    public int getId() { return id; }
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public String getFavoriteteam() { return favoriteteam; }

    public void setFirstname(String firstname) { this.firstname = firstname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setFavoriteteam(String favoriteteam) { this.favoriteteam = favoriteteam; }
}
