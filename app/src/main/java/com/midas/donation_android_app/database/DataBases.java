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






}
