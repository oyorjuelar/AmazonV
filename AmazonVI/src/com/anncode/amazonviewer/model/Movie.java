package com.anncode.amazonviewer.model;

import com.anncode.amazonviewer.dao.MovieDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Hereda de {@link Film}
 * Implementa de {@link IVisualizable}
 */

public class Movie extends Film implements IVisualizable, MovieDAO {

    private int id;
    private int timeViewed;


    public Movie(String title, String genre, String creator, int duration, short year) {
        super(title, genre, creator, duration);
        setYear(year);
    }

    public Movie(){
        super();
    };


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimeViewed() {
        return timeViewed;
    }
    public void setTimeViewed(int timeViewed) {
        this.timeViewed = timeViewed;
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return  "\n :: MOVIE ::" +
                "\n Title: " + getTitle() +
                "\n Genero: " + getGenre() +
                "\n Year: " + getYear() +
                "\n Creator: " + getCreator() +
                "\n Duration: " + getDuration();
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public Date startToSee(Date dateI) {
        // TODO Auto-generated method stub
        return dateI;
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public void stopToSee(Date dateI, Date dateF) {
        // TODO Auto-generated method stub

        if (dateF.getTime() > dateI.getTime()) {
            setTimeViewed((int)(dateF.getTime() - dateI.getTime()));
        }else {
            setTimeViewed(0);
        }


    }

    public static ArrayList<Movie> makeMoviesList() {
        Movie movie = new Movie();
        return movie.read();
    }


    /**
     * {@InheritDoc}
     */
    @Override
    public void view() {
        setViewed(true);
        Movie movie = new Movie();
        movie.setMovieViewed(this);
        Date dateI = startToSee(new Date());

        for (int i = 0; i < 100000; i++) {
            System.out.println("..........");
        }

        //Termine de verla
        stopToSee(dateI, new Date());
        System.out.println();
        System.out.println("Viste: " + toString());
        System.out.println("Por: " + getTimeViewed() + " milisegundos");

    }
}
