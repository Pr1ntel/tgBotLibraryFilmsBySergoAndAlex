package Model.Entities;

public class StyleFilms {
    private int id;
    private String styleFilm;

    public StyleFilms(int id, String styleFilm) {
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
