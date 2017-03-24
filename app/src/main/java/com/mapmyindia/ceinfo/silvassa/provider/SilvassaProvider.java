package com.mapmyindia.ceinfo.silvassa.provider;

// @formatter:off

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.mapmyindia.ceinfo.silvassa.BuildConfig;
import com.mapmyindia.ceinfo.silvassa.provider.base.BaseContentProvider;
import com.mapmyindia.ceinfo.silvassa.provider.criteria.CriteriaColumns;
import com.mapmyindia.ceinfo.silvassa.provider.occupier.OccupierColumns;
import com.mapmyindia.ceinfo.silvassa.provider.owner.OwnerColumns;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertyColumns;
import com.mapmyindia.ceinfo.silvassa.provider.taxdetail.TaxdetailColumns;
import com.mapmyindia.ceinfo.silvassa.provider.zone.ZoneColumns;

import java.util.Arrays;

public class SilvassaProvider extends BaseContentProvider {
    public static final String AUTHORITY = "com.mapmyindia.ceinfo.silvassa.provider";
    public static final String CONTENT_URI_BASE = "content://" + AUTHORITY;
    private static final String TAG = SilvassaProvider.class.getSimpleName();
    private static final boolean DEBUG = BuildConfig.DEBUG;
    private static final String TYPE_CURSOR_ITEM = "vnd.android.cursor.item/";
    private static final String TYPE_CURSOR_DIR = "vnd.android.cursor.dir/";
    private static final int URI_TYPE_CRITERIA = 0;
    private static final int URI_TYPE_CRITERIA_ID = 1;

    private static final int URI_TYPE_OCCUPIER = 2;
    private static final int URI_TYPE_OCCUPIER_ID = 3;

    private static final int URI_TYPE_OWNER = 4;
    private static final int URI_TYPE_OWNER_ID = 5;

    private static final int URI_TYPE_PROPERTY = 6;
    private static final int URI_TYPE_PROPERTY_ID = 7;

    private static final int URI_TYPE_TAXDETAIL = 8;
    private static final int URI_TYPE_TAXDETAIL_ID = 9;

    private static final int URI_TYPE_ZONE = 10;
    private static final int URI_TYPE_ZONE_ID = 11;



    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        URI_MATCHER.addURI(AUTHORITY, CriteriaColumns.TABLE_NAME, URI_TYPE_CRITERIA);
        URI_MATCHER.addURI(AUTHORITY, CriteriaColumns.TABLE_NAME + "/#", URI_TYPE_CRITERIA_ID);
        URI_MATCHER.addURI(AUTHORITY, OccupierColumns.TABLE_NAME, URI_TYPE_OCCUPIER);
        URI_MATCHER.addURI(AUTHORITY, OccupierColumns.TABLE_NAME + "/#", URI_TYPE_OCCUPIER_ID);
        URI_MATCHER.addURI(AUTHORITY, OwnerColumns.TABLE_NAME, URI_TYPE_OWNER);
        URI_MATCHER.addURI(AUTHORITY, OwnerColumns.TABLE_NAME + "/#", URI_TYPE_OWNER_ID);
        URI_MATCHER.addURI(AUTHORITY, PropertyColumns.TABLE_NAME, URI_TYPE_PROPERTY);
        URI_MATCHER.addURI(AUTHORITY, PropertyColumns.TABLE_NAME + "/#", URI_TYPE_PROPERTY_ID);
        URI_MATCHER.addURI(AUTHORITY, TaxdetailColumns.TABLE_NAME, URI_TYPE_TAXDETAIL);
        URI_MATCHER.addURI(AUTHORITY, TaxdetailColumns.TABLE_NAME + "/#", URI_TYPE_TAXDETAIL_ID);
        URI_MATCHER.addURI(AUTHORITY, ZoneColumns.TABLE_NAME, URI_TYPE_ZONE);
        URI_MATCHER.addURI(AUTHORITY, ZoneColumns.TABLE_NAME + "/#", URI_TYPE_ZONE_ID);
    }

    @Override
    protected SQLiteOpenHelper createSqLiteOpenHelper() {
        return SampleSQLiteOpenHelper.getInstance(getContext());
    }

    @Override
    protected boolean hasDebug() {
        return DEBUG;
    }

    @Override
    public String getType(Uri uri) {
        int match = URI_MATCHER.match(uri);
        switch (match) {
            case URI_TYPE_CRITERIA:
                return TYPE_CURSOR_DIR + CriteriaColumns.TABLE_NAME;
            case URI_TYPE_CRITERIA_ID:
                return TYPE_CURSOR_ITEM + CriteriaColumns.TABLE_NAME;

            case URI_TYPE_OCCUPIER:
                return TYPE_CURSOR_DIR + OccupierColumns.TABLE_NAME;
            case URI_TYPE_OCCUPIER_ID:
                return TYPE_CURSOR_ITEM + OccupierColumns.TABLE_NAME;

            case URI_TYPE_OWNER:
                return TYPE_CURSOR_DIR + OwnerColumns.TABLE_NAME;
            case URI_TYPE_OWNER_ID:
                return TYPE_CURSOR_ITEM + OwnerColumns.TABLE_NAME;

            case URI_TYPE_PROPERTY:
                return TYPE_CURSOR_DIR + PropertyColumns.TABLE_NAME;
            case URI_TYPE_PROPERTY_ID:
                return TYPE_CURSOR_ITEM + PropertyColumns.TABLE_NAME;

            case URI_TYPE_TAXDETAIL:
                return TYPE_CURSOR_DIR + TaxdetailColumns.TABLE_NAME;
            case URI_TYPE_TAXDETAIL_ID:
                return TYPE_CURSOR_ITEM + TaxdetailColumns.TABLE_NAME;

            case URI_TYPE_ZONE:
                return TYPE_CURSOR_DIR + ZoneColumns.TABLE_NAME;
            case URI_TYPE_ZONE_ID:
                return TYPE_CURSOR_ITEM + ZoneColumns.TABLE_NAME;

        }
        return null;
    }

    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        if (DEBUG) Log.d(TAG, "insert uri=" + uri + " values=" + values);
        return super.insert(uri, values);
    }

    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values) {
        if (DEBUG) Log.d(TAG, "bulkInsert uri=" + uri + " values.length=" + values.length);
        return super.bulkInsert(uri, values);
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        if (DEBUG)
            Log.d(TAG, "update uri=" + uri + " values=" + values + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.update(uri, values, selection, selectionArgs);
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        if (DEBUG)
            Log.d(TAG, "delete uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.delete(uri, selection, selectionArgs);
    }

    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if (DEBUG)
            Log.d(TAG, "query uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs) + " sortOrder=" + sortOrder
                    + " groupBy=" + uri.getQueryParameter(QUERY_GROUP_BY) + " having=" + uri.getQueryParameter(QUERY_HAVING) + " limit=" + uri.getQueryParameter(QUERY_LIMIT));
        return super.query(uri, projection, selection, selectionArgs, sortOrder);
    }

    @Override
    protected QueryParams getQueryParams(Uri uri, String selection, String[] projection) {
        QueryParams res = new QueryParams();
        String id = null;
        int matchedId = URI_MATCHER.match(uri);
        switch (matchedId) {
            case URI_TYPE_CRITERIA:
            case URI_TYPE_CRITERIA_ID:
                res.table = CriteriaColumns.TABLE_NAME;
                res.idColumn = CriteriaColumns._ID;
                res.tablesWithJoins = CriteriaColumns.TABLE_NAME;
                res.orderBy = CriteriaColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_OCCUPIER:
            case URI_TYPE_OCCUPIER_ID:
                res.table = OccupierColumns.TABLE_NAME;
                res.idColumn = OccupierColumns._ID;
                res.tablesWithJoins = OccupierColumns.TABLE_NAME;
                res.orderBy = OccupierColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_OWNER:
            case URI_TYPE_OWNER_ID:
                res.table = OwnerColumns.TABLE_NAME;
                res.idColumn = OwnerColumns._ID;
                res.tablesWithJoins = OwnerColumns.TABLE_NAME;
                res.orderBy = OwnerColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_PROPERTY:
            case URI_TYPE_PROPERTY_ID:
                res.table = PropertyColumns.TABLE_NAME;
                res.idColumn = PropertyColumns._ID;
                res.tablesWithJoins = PropertyColumns.TABLE_NAME;
                res.orderBy = PropertyColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_TAXDETAIL:
            case URI_TYPE_TAXDETAIL_ID:
                res.table = TaxdetailColumns.TABLE_NAME;
                res.idColumn = TaxdetailColumns._ID;
                res.tablesWithJoins = TaxdetailColumns.TABLE_NAME;
                res.orderBy = TaxdetailColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_ZONE:
            case URI_TYPE_ZONE_ID:
                res.table = ZoneColumns.TABLE_NAME;
                res.idColumn = ZoneColumns._ID;
                res.tablesWithJoins = ZoneColumns.TABLE_NAME;
                res.orderBy = ZoneColumns.DEFAULT_ORDER;
                break;

            default:
                throw new IllegalArgumentException("The uri '" + uri + "' is not supported by this ContentProvider");
        }

        switch (matchedId) {
            case URI_TYPE_CRITERIA_ID:
            case URI_TYPE_OCCUPIER_ID:
            case URI_TYPE_OWNER_ID:
            case URI_TYPE_PROPERTY_ID:
            case URI_TYPE_TAXDETAIL_ID:
            case URI_TYPE_ZONE_ID:
                id = uri.getLastPathSegment();
        }
        if (id != null) {
            if (selection != null) {
                res.selection = res.table + "." + res.idColumn + "=" + id + " and (" + selection + ")";
            } else {
                res.selection = res.table + "." + res.idColumn + "=" + id;
            }
        } else {
            res.selection = selection;
        }
        return res;
    }
}
