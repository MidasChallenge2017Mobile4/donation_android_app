package com.midas.donation_android_app.database;

import android.provider.BaseColumns;

/**
 * Created by ichaeeun on 2017. 5. 27..
 */
public final class DataBases {

    public static final class CreateVtTable implements BaseColumns {
        public static final String _ID = "_id";
        public static final String TITLE = "title";
        public static final String CONTENT = "content";
        public static final String IMAGE = "image";
        public static final String DATE = "date";
        public static final String ISCHECKED = "isChecked";
        public static final String STATUS = "status";
        public static final String _TABLENAME = "memoinfo";

        public static final String _CREATE =
                "create table "+_TABLENAME+"("
                        +_ID+" integer primary key autoincrement, "
                        +DATE+" text not null,"
                        +TITLE+" text , "
                        +CONTENT+" text , "
                        +IMAGE+" text , "
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
    /* 마이페이지
    * */

    public static final class CreatePHistoryTable implements BaseColumns {
        public static final String _ID = "_id";
        public static final String User_ID = "User_id";
        public static final String DATE = "date";
        public static final String STATUS = "status";
        public static final String POINT = "point";
        public static final String _TABLENAME = "PHistoryinfo";

        public static final String _CREATE =
                "create table IF NOT EXISTS "+_TABLENAME+"("
                        +_ID+" integer primary key autoincrement, "
                        +User_ID+" integer,"
                        +DATE+" text not null,"
                        +STATUS+" integer,"
                        +POINT+" integer);";
    }

    public static final class CreateUserTable implements BaseColumns {
        public static final String _ID = "_id";
        public static final String User_ID = "User_id";
        public static final String RICE = "rice";
        public static final String EXERCISE = "exercise";
        public static final String ATTENDENCE = "attendence";
        public static final String _TABLENAME = "Userinfo";

        public static final String _CREATE =
                "create table "+_TABLENAME+"("
                        +_ID+" integer primary key autoincrement, "
                        +User_ID+" integer,"
                        +RICE+" int,"
                        +EXERCISE+" int,"
                        +ATTENDENCE+" int);";
    }

    public static final class CreateDonateHistoryTable implements BaseColumns {
        public static final String _ID = "_id";
        public static final String User_ID = "User_id";
        public static final String Do_ID = "Do_id";
        public static final String AMOUNT = "amount";
        public static final String _TABLENAME = "DonateHistoryinfo";

        public static final String _CREATE =
                "create table "+_TABLENAME+"("
                        +_ID+" integer primary key autoincrement, "
                        +User_ID+" integer,"
                        +Do_ID+" integer,"
                        +AMOUNT+" int);";
    }
    
}
