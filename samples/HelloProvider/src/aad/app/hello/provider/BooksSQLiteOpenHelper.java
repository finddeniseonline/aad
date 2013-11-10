package aad.app.hello.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BooksSQLiteOpenHelper extends SQLiteOpenHelper {

    private final static String DB_NAME = "books";
    private final static int DB_VERSION = 1;

    private final static String TABLE_NAME = Books.Book.TABLE_NAME;
    private final static String TABLE_ROW_ID = Books.Book.ID;
    private final static String TABLE_ROW_NAME = Books.Book.NAME;
    private final static String TABLE_ROW_ISBN = Books.Book.ISBN;

    public BooksSQLiteOpenHelper(Context context) {

        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableQueryString = 
                        "CREATE TABLE " + 
                        TABLE_NAME + " (" + 
                        TABLE_ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + 
                        TABLE_ROW_NAME + " TEXT, " + 
                        TABLE_ROW_ISBN + " TEXT" + ");";
        
        db.execSQL(createTableQueryString);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
