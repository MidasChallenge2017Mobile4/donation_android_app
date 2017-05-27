package com.midas.donation_android_app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;


import com.midas.donation_android_app.Donation;
import com.midas.donation_android_app.Info.DonateHistoryInfo;
import com.midas.donation_android_app.Info.PointHistoryInfo;

import com.midas.donation_android_app.R;
import com.midas.donation_android_app.volunteer.VtListData;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by ichaeeun on 2017. 5. 27..
 */
public class DbOpenHelper {

    private static final String DATABASE_NAME = "memolist.db";
    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase mDB;
    private DatabaseHelper mDBHelper;
    private Context mCtx;

    private ArrayList<VtListData> itemDatas = null;

    public class DatabaseHelper extends SQLiteOpenHelper {

        // 생성자
        public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        // 최초 DB를 만들때 한번만 호출된다.
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DataBases.CreateVtTable._CREATE);
            db.execSQL(DataBases.CreateDoTable._CREATE);
            db.execSQL(DataBases.CreatePHistoryTable._CREATE);
            db.execSQL(DataBases.CreateUserTable._CREATE);
            db.execSQL(DataBases.CreateDonateHistoryTable._CREATE);

            VtListData vtListData1 = new VtListData(0, "어르신 정서/주거환경 돌보미", "d","\"어르신 정서/주거환경 돌보미", "성남 지역의 노인 요양원을 방문"
            , "치매노인분들의 말벗 해드리기","함께 산책하기 등의 정서치료와 실내외 청소","안정적이고 쾌적한 주거 환경을 조성"
            , R.drawable.nursinghome_ex1, R.drawable.nursinghome_ex2, R.drawable.nursinghome_ex3, R.drawable.nursinghome_ex4
            , R.drawable.nursinghome_ex5, "2017.06.03", "진행중", false
                    );

            VtListData vtListData2 = new VtListData(1, "마이다스 나눔가게, 사랑의 의류나눔", "d","\"마이다스 나눔가게, 사랑의 의류나눔\"", "마이다스 나눔가게와 사랑의 헌옷나눔 행사가 열립니다"
                    , "가전제품, 장난감 등을 판매한 수익금으로는","어려운 이웃들의 난방비를 후원하며,","기부해주신 성인 남성용 의복은 노숙인분들이 따뜻한 겨울을 나실 수 있도록 선물합니다"
                    , R.drawable.clothes_ex1, R.drawable.clothes_ex_2, R.drawable.clothes_ex_3, R.drawable.clothes_ex_4
                    , R.drawable.clothes_ex1, "2017.06.10", "진행중", false
            );

            VtListData vtListData3 = new VtListData(2, "사랑의 김장나눔", "d","\"사랑의 김장나눔\"", "독거어르신들이 "
                    , "건강한 겨울을 나실 수 있도록","김치를 버무리고 포장하여","어르신들께 선물합시다"
                    , R.drawable.kimchi_explain1, R.drawable.kimchi_explain2, R.drawable.kimchi_exmplain3, R.drawable.kimchi_explain1
                    , R.drawable.kimchi_explain2, "2017.06.17", "진행중", false
            );

            VtListData vtListData4 = new VtListData(3, "어르신 정서/주거환경 돌보미", "d","\"어르신 정서/주거환경 돌보미\"", "성남 지역의 노인 요양원을 방문하여"
                    , "치매노인분들의 말벗 해드리기","함께 산책하기 등의 정서치료와 실내외 청소를 통해","안정적이고 쾌적한 주거 환경을 조성해드립시다"
                    , R.drawable.nursinghome_ex1, R.drawable.nursinghome_ex2, R.drawable.nursinghome_ex3, R.drawable.nursinghome_ex4
                    , R.drawable.nursinghome_ex5, "2017.05.13", "완료", false
            );
            DbInsert(db, vtListData1);
            DbInsert(db, vtListData2);
            DbInsert(db, vtListData3);
            DbInsert(db, vtListData4);






        }

        // 버전이 업데이트 되었을 경우 DB를 다시 만들어 준다.
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+ DataBases.CreateVtTable._TABLENAME);
            onCreate(db);
        }
    }

    public DbOpenHelper(Context context){
        this.mCtx = context;
    }

    public DbOpenHelper open() throws SQLException {
        mDBHelper = new DatabaseHelper(mCtx, DATABASE_NAME, null, DATABASE_VERSION);
        mDB = mDBHelper.getWritableDatabase();
        return this;
    }
    /**
     * DB에 데이터 추가
    */
    public void DbInsert(SQLiteDatabase db, VtListData itemData){


        ContentValues values = new ContentValues();
        values.put("date",itemData.date);
        values.put("title",itemData.title);
        values.put("url",itemData.title);
        values.put("content1",itemData.content1);
        values.put("content2",itemData.content2);
        values.put("content3",itemData.content3);
        values.put("content4",itemData.content4);
        values.put("content5",itemData.content5);
        values.put("image1",itemData.image1);
        values.put("image2",itemData.image2);
        values.put("image3",itemData.image3);
        values.put("image4",itemData.image4);
        values.put("image5",itemData.image5);
        values.put("isChecked", String.valueOf(itemData.isChecked));

        db.insert("memoinfo",null,values);

    }



    /** DB항목 업그레이드 - 참여했는지 참여하기 버튼누르거나 하트누를때 */
     public boolean DbUpdateChk(int id, Boolean isChecked){

     ContentValues values = new ContentValues();
     values.put("isChecked", String.valueOf(isChecked));


     int result = mDB.update("memoinfo", values, "_id=?", new String[]{String.valueOf(id)});
        if(result > 0) {
            return true;
        }

         return false;
     }









    /**
     * DB항목 업그레이드2 - EditText 에서 수정할 때 사용
     */
//    public void DbUpdate(VtListData itemData){
//
//        mDB = mDBHelper.getWritableDatabase();
//        int id = itemData.getId();
//        ContentValues values = new ContentValues();
//        values.put("title",itemData.getTitle());
//        values.put("content",itemData.getContent());
//        values.put("image",itemData.getImage());
//
//        mDB.update("memoinfo", values, "_id=?", new String[]{String.valueOf(id)});
//
//    }


    public int getCountByDate(String mDate) {
        int count = 0;
        String sql = "select _id from memoinfo where date="+"'"+mDate+"'";
        Cursor cursor = mDB.rawQuery(sql,null);
        count = cursor.getCount();
        return count;
    }

//    public VtListData getDayView(String mDate) {
//        SQLiteDatabase mDB;
//        mDB = mDBHelper.getReadableDatabase();
//        String sql = "select title, image from memoinfo where date="+"'"+mDate+"' and isChecked='true'";
//        Cursor cursor = mDB.rawQuery(sql,null);
//        int count = cursor.getCount();
//        if (count == 0) {
//            return null;
//        } else {
//            cursor.moveToNext();
//
//            String title = cursor.getString(cursor.getColumnIndex("title"));
//            int image = cursor.getColumnIndex("image");
//            VtListData itemData = new VtListData();
//            itemData.title = title;
//            itemData.image = image;
//            return itemData;
//        }
//    }


    /**
     * 항목 삭제하는 함수
     */
    public boolean DbDelete(int id) {
        try {
            int result = mDB.delete("memoinfo", "_id=?", new String[]{String.valueOf(id)});
            if(result > 0){
                return true;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }



    public int getMaxId() {

        mDB = mDBHelper.getReadableDatabase();
        final SQLiteStatement stmt = mDB
                .compileStatement("select MAX(_id) from memoinfo");

        return (int) stmt.simpleQueryForLong();
    }




    /** 진행중인 봉사목록 */
    public ArrayList<VtListData> DbMainSelect(){
        SQLiteDatabase getDb;
        getDb = mDBHelper.getReadableDatabase();
        Cursor c = getDb.rawQuery( "select * from memoinfo" , null);

        itemDatas = new ArrayList<VtListData>();
//
//        Log.i("myTag" , "갯수 : " + String.valueOf(c.getCount()));

        while(c.moveToNext()){
            String date = c.getString(c.getColumnIndex("date"));
            String title = c.getString(c.getColumnIndex("title"));
            String content1 = c.getString(c.getColumnIndex("content1"));
            String content2 = c.getString(c.getColumnIndex("content2"));
            String content3 = c.getString(c.getColumnIndex("content3"));
            String content4 = c.getString(c.getColumnIndex("content4"));
            String content5 = c.getString(c.getColumnIndex("content5"));
            int image1 = c.getInt(c.getColumnIndex("image1"));
            int image2 = c.getInt(c.getColumnIndex("image2"));
            int image3 = c.getInt(c.getColumnIndex("image3"));
            int image4 = c.getInt(c.getColumnIndex("image4"));
            int image5 = c.getInt(c.getColumnIndex("image5"));


            VtListData listViewItem = new VtListData();

            listViewItem.title = title;
            listViewItem.content1 = content1;
            listViewItem.content2 = content2;
            listViewItem.content3 = content3;
            listViewItem.content4 = content4;
            listViewItem.content5 = content5;
            listViewItem.image1 = image1;
            listViewItem.image2 = image2;
            listViewItem.image3 = image3;
            listViewItem.image4 = image4;
            listViewItem.image5 = image5;
            listViewItem.date = date;


            itemDatas.add(listViewItem);

        }

        return itemDatas;
    }


    /** 진행중인 봉사목록 */
    public VtListData DbVtDetailSelect(String title) {
        SQLiteDatabase getDb;
        getDb = mDBHelper.getReadableDatabase();
        Cursor c = getDb.rawQuery("select * from memoinfo where title="+"'"+title+"'",null);


//
//        Log.i("myTag" , "갯수 : " + String.valueOf(c.getCount()));

        while (c.moveToNext()) {
            String date = c.getString(c.getColumnIndex("date"));
            String content1 = c.getString(c.getColumnIndex("content1"));
            String content2 = c.getString(c.getColumnIndex("content2"));
            String content3 = c.getString(c.getColumnIndex("content3"));
            String content4 = c.getString(c.getColumnIndex("content4"));
            String content5 = c.getString(c.getColumnIndex("content5"));
            int image1 = c.getInt(c.getColumnIndex("image1"));
            int image2 = c.getInt(c.getColumnIndex("image2"));
            int image3 = c.getInt(c.getColumnIndex("image3"));
            int image4 = c.getInt(c.getColumnIndex("image4"));
            int image5 = c.getInt(c.getColumnIndex("image5"));


            VtListData listViewItem = new VtListData();

            listViewItem.title = title;
            listViewItem.content1 = content1;
            listViewItem.content2 = content2;
            listViewItem.content3 = content3;
            listViewItem.content4 = content4;
            listViewItem.content5 = content5;
            listViewItem.image1 = image1;
            listViewItem.image2 = image2;
            listViewItem.image3 = image3;
            listViewItem.image4 = image4;
            listViewItem.image5 = image5;
            listViewItem.date = date;

            return listViewItem;


        }
        return null;
    }






    /** 종료된 봉사목록 */
    public ArrayList<VtListData> DbVtFinishSelect(){
        SQLiteDatabase getDb;
        getDb = mDBHelper.getReadableDatabase();
        Cursor c = getDb.rawQuery( "select * from memoinfo where " , null);

        itemDatas = new ArrayList<VtListData>();
//
//        Log.i("myTag" , "갯수 : " + String.valueOf(c.getCount()));

        while(c.moveToNext()){
            String date = c.getString(c.getColumnIndex("date"));
            String title = c.getString(c.getColumnIndex("title"));
            String content1 = c.getString(c.getColumnIndex("content1"));
            String content2 = c.getString(c.getColumnIndex("content2"));
            String content3 = c.getString(c.getColumnIndex("content3"));
            String content4 = c.getString(c.getColumnIndex("content4"));
            String content5 = c.getString(c.getColumnIndex("content5"));
            int image1 = c.getInt(c.getColumnIndex("image1"));
            int image2 = c.getInt(c.getColumnIndex("image2"));
            int image3 = c.getInt(c.getColumnIndex("image3"));
            int image4 = c.getInt(c.getColumnIndex("image4"));
            int image5 = c.getInt(c.getColumnIndex("image5"));


            VtListData listViewItem = new VtListData();

            listViewItem.title = title;
            listViewItem.content1 = content1;
            listViewItem.content2 = content2;
            listViewItem.content3 = content3;
            listViewItem.content4 = content4;
            listViewItem.content5 = content5;
            listViewItem.image1 = image1;
            listViewItem.image2 = image2;
            listViewItem.image3 = image3;
            listViewItem.image4 = image4;
            listViewItem.image5 = image5;
            listViewItem.date = date;


            itemDatas.add(listViewItem);

        }

        return itemDatas;
    }


    /** 진행중인 봉사목록 */
    public ArrayList<VtListData> DbVtListSelect(){
        SQLiteDatabase getDb;
        getDb = mDBHelper.getReadableDatabase();
        Cursor c = getDb.rawQuery( "select * from memoinfo where " , null);

        itemDatas = new ArrayList<VtListData>();
//
//        Log.i("myTag" , "갯수 : " + String.valueOf(c.getCount()));

        while(c.moveToNext()){
            String date = c.getString(c.getColumnIndex("date"));
            String title = c.getString(c.getColumnIndex("title"));
            String content1 = c.getString(c.getColumnIndex("content1"));
            String content2 = c.getString(c.getColumnIndex("content2"));
            String content3 = c.getString(c.getColumnIndex("content3"));
            String content4 = c.getString(c.getColumnIndex("content4"));
            String content5 = c.getString(c.getColumnIndex("content5"));
            int image1 = c.getInt(c.getColumnIndex("image1"));
            int image2 = c.getInt(c.getColumnIndex("image2"));
            int image3 = c.getInt(c.getColumnIndex("image3"));
            int image4 = c.getInt(c.getColumnIndex("image4"));
            int image5 = c.getInt(c.getColumnIndex("image5"));


            VtListData listViewItem = new VtListData();

            listViewItem.title = title;
            listViewItem.content1 = content1;
            listViewItem.content2 = content2;
            listViewItem.content3 = content3;
            listViewItem.content4 = content4;
            listViewItem.content5 = content5;
            listViewItem.image1 = image1;
            listViewItem.image2 = image2;
            listViewItem.image3 = image3;
            listViewItem.image4 = image4;
            listViewItem.image5 = image5;
            listViewItem.date = date;


            itemDatas.add(listViewItem);

        }

        return itemDatas;
    }

    /** 나의 봉사 내역 */
    public ArrayList<VtListData> DbMyVtSelect(){
        SQLiteDatabase getDb;
        getDb = mDBHelper.getReadableDatabase();
        Cursor c = getDb.rawQuery( "select * from memoinfo where " , null);

        itemDatas = new ArrayList<VtListData>();
//
//        Log.i("myTag" , "갯수 : " + String.valueOf(c.getCount()));

        while(c.moveToNext()){
            String date = c.getString(c.getColumnIndex("date"));
            String title = c.getString(c.getColumnIndex("title"));
            String content1 = c.getString(c.getColumnIndex("content1"));
            String content2 = c.getString(c.getColumnIndex("content2"));
            String content3 = c.getString(c.getColumnIndex("content3"));
            String content4 = c.getString(c.getColumnIndex("content4"));
            String content5 = c.getString(c.getColumnIndex("content5"));
            int image1 = c.getInt(c.getColumnIndex("image1"));
            int image2 = c.getInt(c.getColumnIndex("image2"));
            int image3 = c.getInt(c.getColumnIndex("image3"));
            int image4 = c.getInt(c.getColumnIndex("image4"));
            int image5 = c.getInt(c.getColumnIndex("image5"));


            VtListData listViewItem = new VtListData();

            listViewItem.title = title;
            listViewItem.content1 = content1;
            listViewItem.content2 = content2;
            listViewItem.content3 = content3;
            listViewItem.content4 = content4;
            listViewItem.content5 = content5;
            listViewItem.image1 = image1;
            listViewItem.image2 = image2;
            listViewItem.image3 = image3;
            listViewItem.image4 = image4;
            listViewItem.image5 = image5;
            listViewItem.date = date;


            itemDatas.add(listViewItem);

        }

        return itemDatas;
    }

    /**팝업 recyclerview에 뿌릴 데이터*/
    public ArrayList<VtListData> DbPopupActivity(String mDate){
        SQLiteDatabase getDb;
        getDb = mDBHelper.getReadableDatabase();
        String sql = "select * from memoinfo where date="+"'"+mDate+"'";
        Log.d("1dbPopupActivity",sql);
        Cursor cursor = getDb.rawQuery(sql , null);


        itemDatas = new ArrayList<VtListData>();
//
//        Log.i("myTag" , "갯수 : " + String.valueOf(cursor.getCount()));

        Log.i("myTag" , "갯수 : " + String.valueOf(cursor.getCount()));
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int _id = cursor.getInt(cursor.getColumnIndex("_id"));
                String date = cursor.getString(cursor.getColumnIndex("date"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String content1 = cursor.getString(cursor.getColumnIndex("content1"));
                String content2 = cursor.getString(cursor.getColumnIndex("content2"));
                String content3 = cursor.getString(cursor.getColumnIndex("content3"));
                String content4 = cursor.getString(cursor.getColumnIndex("content4"));
                String content5 = cursor.getString(cursor.getColumnIndex("content5"));
                int image1 = cursor.getInt(cursor.getColumnIndex("image1"));
                int image2 = cursor.getInt(cursor.getColumnIndex("image2"));
                int image3 = cursor.getInt(cursor.getColumnIndex("image3"));
                int image4 = cursor.getInt(cursor.getColumnIndex("image4"));
                int image5 = cursor.getInt(cursor.getColumnIndex("image5"));
                String isChecked = cursor.getString(cursor.getColumnIndex("isChecked"));

                VtListData listViewItem = new VtListData();

                listViewItem.id = _id;
                listViewItem.title = title;
                listViewItem.content1 = content1;
                listViewItem.content2 = content2;
                listViewItem.content3 = content3;
                listViewItem.content4 = content4;
                listViewItem.content5 = content5;
                listViewItem.image1 = image1;
                listViewItem.image2 = image2;
                listViewItem.image3 = image3;
                listViewItem.image4 = image4;
                listViewItem.image5 = image5;
                listViewItem.date = date;
               // listViewItem.isChecked = Boolean.getBoolean(isChecked);
                listViewItem.isChecked = Boolean.valueOf(isChecked).booleanValue();

                itemDatas.add(listViewItem);

            }
        }

        return itemDatas;
    }

// 포인트 획득 내역 읽기
    public PointHistoryInfo getAllPHistory() {
        Log.d("TESTTEST","HIHIHI");
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase getDb = mDBHelper.getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = getDb.rawQuery("SELECT * FROM PHistoryinfo WHERE User_id = " + 1, null);
        int count = cursor.getCount();
        if (count == 0) {
            return null;
        } else {
            cursor.moveToNext();

            String date = cursor.getString(cursor.getColumnIndex("date"));
            int status = cursor.getColumnIndex("status");
            int point = cursor.getColumnIndex("point");
            PointHistoryInfo itemData = new PointHistoryInfo(date, status, point);

            return itemData;
        }
    }

        //    기부 내역 읽기
    public DonateHistoryInfo getAllDonateHistory() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase getDb = mDBHelper.getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        String qry = "SELECT DonateHistoryinfo.amount, doinfo.title, doinfo.status FROM DonateHistoryinfo INNER JOIN doinfo ON DonateHistoryinfo.Do_id=doinfo._id";
        Cursor cursor = getDb.rawQuery(qry, null);
        int count = cursor.getCount();
        if (count == 0) {
            return null;
        } else {
            cursor.moveToNext();

            int amount = cursor.getColumnIndex("amount");
            String title = cursor.getString(cursor.getColumnIndex("title"));
            int status = cursor.getColumnIndex("status");

            DonateHistoryInfo itemData = new DonateHistoryInfo(title,amount,status);

            return itemData;
        }

    }



    public void close(){
        mDB.close();
    }

}
