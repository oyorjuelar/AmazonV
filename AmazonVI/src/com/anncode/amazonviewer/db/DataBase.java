package com.anncode.amazonviewer.db;

public class DataBase {
    public static final String URL              = "jdbc:mysql://localhost:3306/";
    public static final String DB               = "AmazonView";
    public static final String USER             = "root";
    public static final String PASSWORD         = "";

    public static final String MOVIE            = "movie";
    public static final String MOVIE_id         = "id";
    public static final String MOVIE_title      = "title";
    public static final String MOVIE_genre      = "genre";
    public static final String MOVIE_creator    = "creator";
    public static final String MOVIE_duration   = "duration";
    public static final String MOVIE_year       = "year";

    public static final String MATERIAL         = "material";
    public static final int[] ID_materials      = {1,2,3,4,5};

    public static final String TUSER             = "user";
    public static final int USER_id             = 1;

    public static final String VIEWED           = "viewed";
    public static final String VIEWED_id        = "id";
    public static final String VIEWED_material  = "id_material";
    public static final String VIEWED_element   = "id_element";
    public static final String VIEWED_user      = "id_user";

}
