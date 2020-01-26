package com.oyorjuelar.amazonviewer.dao;

import java.sql.*;
import java.util.ArrayList;
import static com.oyorjuelar.amazonviewer.db.DataBase.*;


import com.oyorjuelar.amazonviewer.db.DbConecction;
import com.oyorjuelar.amazonviewer.model.Movie;

public interface MovieDAO extends DbConecction {

    default Movie setMovieViewed(Movie movie){
        try(Connection cnx = connectToDB()){
            Statement st = cnx.createStatement();
            String query = "INSERT INTO " + VIEWED + "(" + VIEWED_material + "," + VIEWED_element + "," + VIEWED_user + ") VALUES(" +
                    ID_materials[0] + "," + movie.getId() + "," + USER_id + ")" ;

            if(st.executeUpdate(query) > 0){
                System.out.println("Se marcó en visto");
            }

        }catch (SQLException e){
            System.out.println(e);
        }

        return movie;
    }

    default ArrayList<Movie> read(){
        ArrayList<Movie> movies = new ArrayList();
        String query = "SELECT * FROM " + MOVIE;
        try(Connection cnx = connectToDB()){
            PreparedStatement ps = cnx.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
            Movie movie = new Movie(rs.getString(MOVIE_title),
                    rs.getString(MOVIE_genre),
                    rs.getString(MOVIE_creator),
                    rs.getInt(MOVIE_duration),
                    rs.getShort(MOVIE_year));
            movie.setId(rs.getInt(MOVIE_id));
            movie.setViewed(getMovieViewed(ps,cnx,movie.getId()));
            movies.add(movie);
            }
        }catch(SQLException e){
            System.out.println(e);
        }

        return movies;
    }



    private boolean getMovieViewed(PreparedStatement ps, Connection cnx, int id_movie){
        boolean viewed = false;
        String query = "SELECT * FROM " + VIEWED + " WHERE " + VIEWED_material + " = ? AND " + VIEWED_element + " = ? AND " + VIEWED_user + " = ?";
        ResultSet rs = null;

        try{
            ps = cnx.prepareStatement(query);
            ps.setInt(1, ID_materials[0]);
            ps.setInt(2,id_movie);
            ps.setInt(3,USER_id);

            rs = ps.executeQuery();
            viewed = rs.next();
        }catch (SQLException e){
            System.out.println(e);
        }

        return viewed;
    }

}
