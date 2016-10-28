package com.example.new_one;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

/**
 * Created by ddopik on 27/10/2016.
 */

public class ShowTypeHandler extends SQLiteOpenHelper {


    public ShowTypeHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "MovieApp";

    // Contacts table name
    private static final String TABLE_CONTACTS = "ShowType";

    // Contacts Table Columns names
    private static final String Show_ID = "Show_ID";
    private static final String SHOW_TYPE = "Show_Type";
    private static final String Show_orgin = "Show_orgin";


    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + Show_ID + " INTEGER PRIMARY KEY," + SHOW_TYPE + " TEXT,"
                + Show_orgin + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }

    public void addSohow(MyShow show)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("SHOW_TYPE",show.getShowType());
        values.put("Show_orgin",show.getShowOrigin());
        db.insert(TABLE_CONTACTS,null,values);
        db.close();
    }

    public List<Map<String,String>> getAllShows()
    {
        List<Map<String,String>> listMapData=new ArrayList<Map<String,String>>();
        String selectQuery="SELECT * FROM "+TABLE_CONTACTS;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        int i=0;
        if(cursor.moveToFirst())
        do{
            MyShow show=new MyShow();
           show.setShowID(Integer.parseInt(cursor.getString(0)));
           show.setShowType(cursor.getString(1));
           show.setShowOrigin(cursor.getString(2));
            Map<String,String> mapData = new HashMap<String,String>();
            mapData.put("Show_ID",show.getShowID()+"");
            mapData.put("SHOW_TYPE",show.getShowType());
            mapData.put("Show_orgin",show.getShowOrigin());

            listMapData.add(i,mapData);
            i=i+1;
        }while(cursor.moveToNext());
       return listMapData;
    };


    public List<Map<String,String>> getSingleShows()
    {
        List<Map<String,String>> listMapData=new ArrayList<Map<String,String>>();
        String selectQuery="SELECT * FROM "+TABLE_CONTACTS;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        int i=0;
        if(cursor.moveToFirst())
            do{
                MyShow show=new MyShow();
                show.setShowID(Integer.parseInt(cursor.getString(0)));
                show.setShowType(cursor.getString(1));
                show.setShowOrigin(cursor.getString(2));
                Map<String,String> mapData = new HashMap<String,String>();
                mapData.put("Show_ID",show.getShowID()+"");
                mapData.put("SHOW_TYPE",show.getShowType());
                mapData.put("Show_orgin",show.getShowOrigin());

                listMapData.add(i,mapData);
                i=i+1;
            }while(cursor.moveToNext());
        return listMapData;
    };

}
