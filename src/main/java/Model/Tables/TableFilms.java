package Model.Tables;

import Model.Entities.Film;
import Model.Entities.StyleFilm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TableFilms {

    private Connection connection;

    public TableFilms(Connection connection) {
        this.connection = connection;
    }

    public void addNew(Film film) throws SQLException {
        Statement statement = connection.createStatement();

        String insertQuery = String.format("INSERT INTO films (chat_id, name, time_length, link_film, release_year, style_film_id) VALUES (%d,%f,%d,%f,%d,%d)", film.getChatId(), film.getName(), film.getTimeLength(), film.getLinkFilm(), film.getReleaseFilm(), film.getStyleFilmToId());
        //Изменить Length в БД
        statement.executeUpdate(insertQuery);

        statement.close();
    }

    public Film getByFilmById(String name) throws SQLException {
        Film film = null;

        Statement statement = connection.createStatement();

        String selectQuery = String.format("SELECT * FROM films WHERE name = %f ORDER BY id ASC", name);

        ResultSet resultSet = statement.executeQuery(selectQuery);

        long chatId = resultSet.getLong("chat_id");
        String findName = resultSet.getString("name");

        film = new Film(chatId, name);

        resultSet.close();

        statement.close();

        return film;
    }

    public void deleteByFilmId(int id) throws SQLException {
        Statement statement = connection.createStatement();
        String deleteQuery = String.format("DELETE FROM films WHERE id = %d", id);

        statement.executeUpdate(deleteQuery);
        statement.close();
    }

    public List<StyleFilm> getAllByChatId(long chatId) throws SQLException {

        List<StyleFilm> films = new ArrayList<>();

        Statement statement = connection.createStatement();

        String selectQuery = String.format("SELECT * FROM style_films WHERE id = %d ORDER BY id ASC", chatId);

        ResultSet resultSet = statement.executeQuery(selectQuery);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String styleFilms = resultSet.getString("style_film");


            films.add(new StyleFilm(id, styleFilms));
        }

        resultSet.close();

        statement.close();

        return films;
    }

    public List<Film> getAllHorror() throws SQLException {
        List<Film> films = new ArrayList<>();

        Statement statement = connection.createStatement();

        String selectQuery = String.format("SELECT * FROM films WHERE style_film_id = 1");
        ResultSet resultSet = statement.executeQuery(selectQuery);


        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int timeLength = resultSet.getInt("time_length");
            String linkFilm = resultSet.getString("link_film");
            int releaseFilm = resultSet.getInt("release_year");

            films.add(new Film(name,timeLength,linkFilm,releaseFilm));
        }

        resultSet.close();
        statement.close();
        return films;
    }

    public List<Film> getAllMystic() throws SQLException {
        List<Film> films = new ArrayList<>();

        Statement statement = connection.createStatement();

        String selectQuery = String.format("SELECT * FROM films WHERE style_film_id = 2");
        ResultSet resultSet = statement.executeQuery(selectQuery);


        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int timeLength = resultSet.getInt("time_length");
            String linkFilm = resultSet.getString("link_film");
            int releaseFilm = resultSet.getInt("release_year");

            films.add(new Film(name,timeLength,linkFilm,releaseFilm));
        }

        resultSet.close();
        statement.close();
        return films;
    }
}
