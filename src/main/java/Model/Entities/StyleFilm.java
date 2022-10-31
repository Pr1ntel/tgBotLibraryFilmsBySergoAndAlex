package Model.Entities;

public class StyleFilm {
    private int id;
    private String styleFilm;

    public StyleFilm(int id, String styleFilm) {
        this.id = id;
        this.styleFilm = styleFilm;
    }

    public int getId() {
        return id;
    }

    public String getStyleFilm() {
        return styleFilm;
    }
}
