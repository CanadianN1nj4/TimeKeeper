package tsutlovic.com.timekeeper.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import tsutlovic.com.timekeeper.model.Action;

public class ActionDb {

    //region Field Variables
    //SQLite variables
    private SQLiteDatabase database;
    private SQLiteOpenHelper openHelper;
    //endregion

    //region Database Info
    //database variables
    private static final String DB_NAME = "event.db";
    private static final int DB_VERSION = 1;

    private static final String ACTION_TABLE = "Actions";

    private static final String ID = "_id";
    private static final int ID_COLUMN = 0;

    private static final String NAME = "name";
    private static final int NAME_COLUMN = 1;

    private static final String CATEGORY = "category";
    private static final int CATEGORY_COLUMN = 2;

    private static final String START = "start";
    private static final int START_COLUMN = 3;

    private static final String ENDT = "endt";
    private static final int END_COLUMN = 4;

    private static final String NUMLINES = "number of lines";
    private static final int NUMLINES_COLUMN = 5;

    //endregion

    //region Database Creation

    private static final String CREATE_ACTIONS_TABLE =
            "CREATE TABLE " + ACTION_TABLE + " (" +
                    ID          + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NAME        + " TEXT, " +
                    CATEGORY    + " TEXT, " +
                    START       + " TEXT, " +
                    ENDT        + " TEXT, " +
                    NUMLINES    + " INTEGER )";

    //endregion

    //region Database setup

    public ActionDb(Context context) {
        openHelper = new DBHelper(context, DB_NAME, DB_VERSION);
    }

    private static class DBHelper extends SQLiteOpenHelper{

        private DBHelper(Context context, String name, int version){
            super(context, name, null, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_ACTIONS_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + ACTION_TABLE);
            onCreate(db);
        }
    }

    //endregion

    //region Methods

    //gets all the events
    public ArrayList<Action> getActions(){

        ArrayList<Action> actions = new ArrayList<>();

        database = openHelper.getReadableDatabase();

        Cursor result = database.query(ACTION_TABLE, null, null, null, null, null, "start asc");

        while (result.moveToNext()){

            long dbId = result.getLong(ID_COLUMN);
            String name = result.getString(NAME_COLUMN);
            String category = result.getString(CATEGORY_COLUMN);
            String start = result.getString(START_COLUMN);
            String end = result.getString(END_COLUMN);
            int numLines = result.getInt(NUMLINES_COLUMN);

            actions.add(new Action(name, category, start, end, numLines));
        }

        result.close();
        database.close();

        return actions;

    }

    public void addAction(Action action){

        database = openHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, action.getName());
        values.put(CATEGORY, action.getCategory());
        values.put(START, action.getStart());
        values.put(ENDT, action.getEnd());
        values.put(NUMLINES, action.getNumLines());

        long dbID = database.insert(ACTION_TABLE, null, values);

        action.setDbId(dbID);

        database.close();
    }

    public void deleteAction(long id){

        database = openHelper.getWritableDatabase();

        String where = "_id=?";
        String[] whereArgs = new String[] {Long.toString(id)};

        database.delete(ACTION_TABLE, where, whereArgs);

        database.close();
    }

    public void editAction(Action action){

        database = openHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, action.getName());
        values.put(CATEGORY, action.getCategory());
        values.put(START, action.getStart());
        values.put(ENDT, action.getEnd());
        values.put(NUMLINES, action.getNumLines());

        String where= "_id=?";
        String[] whereArgs = new String[] {Long.toString(action.getDbId())};

        database.update(ACTION_TABLE, values, where, whereArgs);
    }

    //endregion

}
