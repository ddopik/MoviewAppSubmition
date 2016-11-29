package com.example.new_one.Model;

/**
 * Created by ddopik on 27/10/2016.
 */
        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.MatrixCursor;
        import android.database.SQLException;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.util.Log;

        import com.example.new_one.TestClasses.MyShow;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;



public class MyDataBaseContract extends SQLiteOpenHelper {

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

    public MyDataBaseContract(Context context) {
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
        Log.e("Tracing_point--->","DataBase Called");
    }


    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_Shows_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + Show_ID + " INTEGER PRIMARY KEY," + SHOW_TYPE + " TEXT,"
                + Show_orgin +"TEXT"+")" ;

        /////Creating Movies Table
        String CREATE_Movies_TABLE ="CREATE TABLE Movies (" +
                                                   "Moview_id INTEGER PRIMARY KEY,"+
                                                   "Movie_Name TEXT NOT NULL," +
                                                   "Movie_TiTle TEXT," +
                                                   "Movie_Overview TEXT," +
                                                   "Movie_Img TEXT," +
                                                   "Movie_Gener TEXT," +
                                                   "Moview_Rating Text,"+
                                                   "Moview_Year,"+
                                                   "Movie_LastUpdate datetime default current_timestamp"+")";

        db.execSQL(CREATE_Movies_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
     //   db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        db.execSQL("DROP TABLE IF EXISTS " + "Movies");

        // Create tables again
        onCreate(db);
    }

    public void dropTable(String  tableName)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
    }



    public void addMovie(List<Map<String,String>> listMapMovies)
    {
      SQLiteDatabase db=this.getReadableDatabase();
       ContentValues value=new ContentValues();
        int i = 0;

        while (i < listMapMovies.size())
        {
            Map<String, String> single_row = listMapMovies.get(i);
            value.put("Movie_Img",single_row.get("Movie_Img"));
            value.put("Movie_Overview",single_row.get("Movie_Overview"));
            value.put("Movie_Name",single_row.get("Movie_Name"));
            value.put("Moview_Rating",single_row.get("Moview_Rating"));
            value.put("Moview_Year",single_row.get("Moview_year"));
            db.insert("Movies",null,value);
            i++;
        }

        db.close();
    }

    public List<Map<String,String>> getAllMovies()    ///get all rows
    {
        List<Map<String,String>> listMapData=new ArrayList<Map<String,String>>();
        int i=0;
           String tableName="Movies";
//        String[] selectQuery=new String[""];
        String selectQuery="SELECT * FROM Movies  ";
//        String whereArgumnet="";
//        String[]  whereValues=new String[]{};
//        String orderBy="Moview_Year DESC";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()) {
            do{
                HashMap<String,String> hashMap=new HashMap<String,String>();

                int Movie_Name=cursor.getColumnIndex("Movie_Name");
                int Movie_Gener=cursor.getColumnIndex("Movie_Gener");
                int Moview_Rating=cursor.getColumnIndex("Moview_Rating");
                int Moview_Year=cursor.getColumnIndex("Moview_Year");
                int Movie_LastUpdate=cursor.getColumnIndex("Movie_LastUpdate");
                int Movie_Img=cursor.getColumnIndex("Movie_Img");


                hashMap.put("Movie_Name",cursor.getString(Movie_Name));
                hashMap.put("Movie_Gener",cursor.getString(Movie_Gener));
                hashMap.put("Moview_Rating",cursor.getString(Moview_Rating));
                hashMap.put("Moview_Year",cursor.getString(Moview_Year));
                hashMap.put("Movie_Img",cursor.getString(Movie_Img));
                hashMap.put("Movie_LastUpdate",cursor.getString(Movie_LastUpdate));
                listMapData.add(i,hashMap);
             i++;
            } while (cursor.moveToNext());
            cursor.close();
        }
    return listMapData;
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



    public ArrayList<Cursor> getData(String Query){
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[] { "mesage" };
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2= new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);


        try{
            String maxQuery = Query ;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);


            //add value to cursor2
            Cursor2.addRow(new Object[] { "Success" });

            alc.set(1,Cursor2);
            if (null != c && c.getCount() > 0) {


                alc.set(0,c);
                c.moveToFirst();

                return alc ;
            }
            return alc;
        } catch(SQLException sqlEx){
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+sqlEx.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        } catch(Exception ex){

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+ex.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        }


    }

}
