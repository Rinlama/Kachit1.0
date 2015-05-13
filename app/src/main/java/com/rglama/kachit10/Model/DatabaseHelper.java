package com.rglama.kachit10.Model;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.rglama.kachit10.Controller.UserAcct;

/**
 * Created by MVargas on 5/11/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "useracct.db";
    private static final String TABLE_NAME = "useracct";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_UNAME = "username";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null ," +
            "username text not null , email text not null , password text not null);";

    public DatabaseHelper(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */

    public void insertContacts(UserAcct u){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from" + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_UNAME, u.getUname());
        values.put(COLUMN_EMAIL, u.getEmail());
        values.put(COLUMN_PASSWORD, u.getPassword());

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public String searchPass(String uname){

        db = this.getReadableDatabase();
        String query = "select uname, pass from" + TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);

        String u,p;
        p = "not found";

        if(cursor.moveToFirst())
            do{
                u = cursor.getString(0);

                if(u.equals(uname)){

                    p = cursor.getString(1);
                    break;
                }

            }while (cursor.moveToNext());

        return p;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * <p/>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query = "DROP TABLE IF EXISTS" + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
