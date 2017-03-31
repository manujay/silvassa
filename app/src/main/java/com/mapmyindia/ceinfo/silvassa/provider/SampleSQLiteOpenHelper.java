package com.mapmyindia.ceinfo.silvassa.provider;

// @formatter:off
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.mapmyindia.ceinfo.silvassa.BuildConfig;
import com.mapmyindia.ceinfo.silvassa.provider.criteria.CriteriaColumns;
import com.mapmyindia.ceinfo.silvassa.provider.occupier.OccupierColumns;
import com.mapmyindia.ceinfo.silvassa.provider.owner.OwnerColumns;
import com.mapmyindia.ceinfo.silvassa.provider.payment.PaymentColumns;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertyColumns;
import com.mapmyindia.ceinfo.silvassa.provider.taxdetail.TaxdetailColumns;
import com.mapmyindia.ceinfo.silvassa.provider.zone.ZoneColumns;

public class SampleSQLiteOpenHelper extends SQLiteOpenHelper {
    public static final String DATABASE_FILE_NAME = "silvassa.db";
    public static final String SQL_CREATE_TABLE_CRITERIA = "CREATE TABLE IF NOT EXISTS "
            + CriteriaColumns.TABLE_NAME + " ( "
            + CriteriaColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CriteriaColumns.OCCUPIERNAME + " TEXT NOT NULL, "
            + CriteriaColumns.PROPID + " TEXT NOT NULL, "
            + CriteriaColumns.OWNERNAME + " TEXT NOT NULL "
            + " );";
    public static final String SQL_CREATE_TABLE_OCCUPIER = "CREATE TABLE IF NOT EXISTS "
            + OccupierColumns.TABLE_NAME + " ( "
            + OccupierColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + OccupierColumns.OCCUPIERNAME + " TEXT NOT NULL "
            + " );";
    public static final String SQL_CREATE_TABLE_OWNER = "CREATE TABLE IF NOT EXISTS "
            + OwnerColumns.TABLE_NAME + " ( "
            + OwnerColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + OwnerColumns.OWNERNAME + " TEXT NOT NULL "
            + " );";
    public static final String SQL_CREATE_TABLE_PAYMENT = "CREATE TABLE IF NOT EXISTS "
            + PaymentColumns.TABLE_NAME + " ( "
            + PaymentColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PaymentColumns.USERID + " TEXT NOT NULL, "
            + PaymentColumns.PROPERTYUNIQUEID + " TEXT NOT NULL, "
            + PaymentColumns.TAXNO + " TEXT NOT NULL, "
            + PaymentColumns.MODE + " TEXT NOT NULL, "
            + PaymentColumns.AMOUNT + " TEXT NOT NULL, "
            + PaymentColumns.PDATE + " TEXT NOT NULL "
            + " );";
    public static final String SQL_CREATE_TABLE_PROPERTY = "CREATE TABLE IF NOT EXISTS "
            + PropertyColumns.TABLE_NAME + " ( "
            + PropertyColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PropertyColumns.PROPERTYUNIQUEID + " TEXT NOT NULL, "
            + PropertyColumns.PROPERTYOWNER + " TEXT, "
            + PropertyColumns.PROPERTYOCCUPIERNAME + " TEXT, "
            + PropertyColumns.PROPERTYRELATIONOWNER + " TEXT, "
            + PropertyColumns.ZONEID + " TEXT, "
            + PropertyColumns.WARD + " TEXT, "
            + PropertyColumns.PROPERTYSUBLOCALITY + " TEXT, "
            + PropertyColumns.EMAIL + " TEXT, "
            + PropertyColumns.PHONE + " TEXT, "
            + PropertyColumns.PROPERTYLANDMARK + " TEXT, "
            + PropertyColumns.PROPERTYPLOTNO + " TEXT, "
            + PropertyColumns.PROPERTYHOUSENO + " TEXT, "
            + PropertyColumns.PROPERTYROAD + " TEXT, "
            + PropertyColumns.PROPERTYPINCODE + " TEXT, "
            + PropertyColumns.PROPERTYBUILDINGNAME + " TEXT "
            + " );";
    public static final String SQL_CREATE_TABLE_TAXDETAIL = "CREATE TABLE IF NOT EXISTS "
            + TaxdetailColumns.TABLE_NAME + " ( "
            + TaxdetailColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TaxdetailColumns.TAXNO + " TEXT, "
            + TaxdetailColumns.PROPERTYID + " TEXT NOT NULL, "
            + TaxdetailColumns.FINANCIALYEAR + " TEXT, "
            + TaxdetailColumns.PROPERTYTAX + " TEXT, "
            + TaxdetailColumns.WATERTAX + " TEXT, "
            + TaxdetailColumns.CONSERVANCYTAX + " TEXT, "
            + TaxdetailColumns.WATERSEWERAGECHARGE + " TEXT, "
            + TaxdetailColumns.WATERMETERBILLAMOUNT + " TEXT, "
            + TaxdetailColumns.ARREARAMOUNT + " TEXT, "
            + TaxdetailColumns.ADVANCEPAIDAMOUNT + " TEXT, "
            + TaxdetailColumns.REBATEAMOUNT + " TEXT, "
            + TaxdetailColumns.ADJUSTMENTAMOUNT + " TEXT, "
            + TaxdetailColumns.TOTALPROPERTYTAX + " TEXT, "
            + TaxdetailColumns.SERVICETAX + " TEXT, "
            + TaxdetailColumns.OTHERTAX + " TEXT, "
            + TaxdetailColumns.GRANDTOTAL + " TEXT, "
            + TaxdetailColumns.DELAYPAYMENTCHARGES + " TEXT, "
            + TaxdetailColumns.PAYABLEAMOUNT + " TEXT, "
            + TaxdetailColumns.DUEDATE + " TEXT, "
            + TaxdetailColumns.NOTICEGENERATED + " TEXT, "
            + TaxdetailColumns.OBJECTIONSTATUS + " TEXT "
            + " );";
    public static final String SQL_CREATE_TABLE_ZONE = "CREATE TABLE IF NOT EXISTS "
            + ZoneColumns.TABLE_NAME + " ( "
            + ZoneColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ZoneColumns.ZONEID + " TEXT NOT NULL, "
            + ZoneColumns.ZONENAME + " TEXT NOT NULL "
            + " );";
    private static final String TAG = SampleSQLiteOpenHelper.class.getSimpleName();
    private static final int DATABASE_VERSION = 1;
    private static SampleSQLiteOpenHelper sInstance;
    private final Context mContext;
    private final SampleSQLiteOpenHelperCallbacks mOpenHelperCallbacks;


    private SampleSQLiteOpenHelper(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
        mContext = context;
        mOpenHelperCallbacks = new SampleSQLiteOpenHelperCallbacks();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private SampleSQLiteOpenHelper(Context context, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, errorHandler);
        mContext = context;
        mOpenHelperCallbacks = new SampleSQLiteOpenHelperCallbacks();
    }

    public static SampleSQLiteOpenHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = newInstance(context.getApplicationContext());
        }
        return sInstance;
    }

    private static SampleSQLiteOpenHelper newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }

    /*
     * Pre Honeycomb.
     */
    private static SampleSQLiteOpenHelper newInstancePreHoneycomb(Context context) {
        return new SampleSQLiteOpenHelper(context);
    }

    /*
     * Post Honeycomb.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static SampleSQLiteOpenHelper newInstancePostHoneycomb(Context context) {
        return new SampleSQLiteOpenHelper(context, new DefaultDatabaseErrorHandler());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate");
        mOpenHelperCallbacks.onPreCreate(mContext, db);
        db.execSQL(SQL_CREATE_TABLE_CRITERIA);
        db.execSQL(SQL_CREATE_TABLE_OCCUPIER);
        db.execSQL(SQL_CREATE_TABLE_OWNER);
        db.execSQL(SQL_CREATE_TABLE_PAYMENT);
        db.execSQL(SQL_CREATE_TABLE_PROPERTY);
        db.execSQL(SQL_CREATE_TABLE_TAXDETAIL);
        db.execSQL(SQL_CREATE_TABLE_ZONE);
        mOpenHelperCallbacks.onPostCreate(mContext, db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            setForeignKeyConstraintsEnabled(db);
        }
        mOpenHelperCallbacks.onOpen(mContext, db);
    }

    private void setForeignKeyConstraintsEnabled(SQLiteDatabase db) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            setForeignKeyConstraintsEnabledPreJellyBean(db);
        } else {
            setForeignKeyConstraintsEnabledPostJellyBean(db);
        }
    }

    private void setForeignKeyConstraintsEnabledPreJellyBean(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setForeignKeyConstraintsEnabledPostJellyBean(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mOpenHelperCallbacks.onUpgrade(mContext, db, oldVersion, newVersion);
    }
}
