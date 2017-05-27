package com.midas.donation_android_app.database;

import android.provider.BaseColumns;

/**
 * Created by ichaeeun on 2017. 5. 27..
 */
public final class DataBases {

    public static final class CreateVtTable implements BaseColumns {
        public static final String _ID = "_id";
        public static final String TITLE = "title";
        public static final String CONTENT1 = "content1";
        public static final String CONTENT2 = "content2";
        public static final String CONTENT3 = "content3";
        public static final String CONTENT4 = "content4";
        public static final String CONTENT5 = "content5";
        public static final String IMAGE1 = "image1";
        public static final String IMAGE2 = "image2";
        public static final String IMAGE3 = "image3";
        public static final String IMAGE4 = "image4";
        public static final String IMAGE5 = "image5";
        public static final String DATE = "date";
        public static final String ISCHECKED = "isChecked";
        public static final String URL = "url";
        public static final String STATUS = "status";
        public static final String _TABLENAME = "memoinfo";

        public static final String _CREATE =
                "create table "+_TABLENAME+"("
                        +_ID+" integer primary key autoincrement, "
                        +DATE+" text not null,"
                        +TITLE+" text , "
                        +CONTENT1+" text , "
                        +CONTENT2+" text , "
                        +CONTENT3+" text , "
                        +CONTENT4+" text , "
                        +CONTENT5+" text , "
                        +IMAGE1+" text , "
                        +IMAGE2+" text , "
                        +IMAGE3+" text , "
                        +IMAGE4+" text , "
                        +IMAGE5+" text , "
                        +URL+" text , "
                        +STATUS+" text , "
                        +ISCHECKED+" text)";


    }

    public static final class CreateDoTable implements BaseColumns {
        public static final String _ID = "_id";
        public static final String TITLE = "title";
        public static final String CONTENT = "content";
        public static final String IMAGE = "image";
        public static final String DATE = "date";
        public static final String GOAL = "goal";
        public static final String STATUS = "status";
        public static final String _TABLENAME = "doinfo";

        public static final String _CREATE =
                "create table "+_TABLENAME+"("
                        +_ID+" integer primary key autoincrement, "
                        +DATE+" text not null,"
                        +TITLE+" text , "
                        +CONTENT+" text , "
                        +IMAGE+" text , "
                        +STATUS+" text , "
                        +GOAL+" int)";
    }
    public static final class CreateMYDoTable implements BaseColumns {
        public static final String Do_ID = "Do_id";
        public static final String User_ID = "User_id";
        public static final String Do_Mo = "money";
        public static final String _TABLENAME = "MyDoinfo";

        public static final String _CREATE =
                "create table "+_TABLENAME+"("
                        +Do_ID+" integer primary key autoincrement, "
                        +User_ID+" text not null,"
                        +Do_Mo+" int)";
    }

    public static final class CreatePHistoryTable implements BaseColumns {
        public static final String _ID = "_id";
        public static final String User_ID = "User_id";
        public static final String DATE = "date";
        public static final String STATUS = "status";
        public static final String POINT = "point";
        public static final String _TABLENAME = "PHistoryinfo";

        public static final String _CREATE =
                "create table "+_TABLENAME+"("
                        +_ID+" integer primary key autoincrement, "
                        +User_ID+" text not null,"
                        +DATE+" text not null,"
                        +STATUS+" int,"
                        +POINT+" int)";
    }


    
}
