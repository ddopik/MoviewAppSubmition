package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MoviesRealmProxy extends com.example.new_one.Model.Movies
    implements RealmObjectProxy, MoviesRealmProxyInterface {

    static final class MoviesColumnInfo extends ColumnInfo
        implements Cloneable {

        public long idIndex;
        public long Movie_NameIndex;
        public long Movie_OverviewIndex;
        public long Movie_ImgIndex;
        public long Moview_YearIndex;
        public long Favorate_MovieIndex;
        public long Movie_TypeIndex;
        public long Moview_RatingIndex;
        public long MovieDurationIndex;
        public long moviesTrailerIndex;
        public long moviesReviewsIndex;

        MoviesColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(11);
            this.idIndex = getValidColumnIndex(path, table, "Movies", "id");
            indicesMap.put("id", this.idIndex);
            this.Movie_NameIndex = getValidColumnIndex(path, table, "Movies", "Movie_Name");
            indicesMap.put("Movie_Name", this.Movie_NameIndex);
            this.Movie_OverviewIndex = getValidColumnIndex(path, table, "Movies", "Movie_Overview");
            indicesMap.put("Movie_Overview", this.Movie_OverviewIndex);
            this.Movie_ImgIndex = getValidColumnIndex(path, table, "Movies", "Movie_Img");
            indicesMap.put("Movie_Img", this.Movie_ImgIndex);
            this.Moview_YearIndex = getValidColumnIndex(path, table, "Movies", "Moview_Year");
            indicesMap.put("Moview_Year", this.Moview_YearIndex);
            this.Favorate_MovieIndex = getValidColumnIndex(path, table, "Movies", "Favorate_Movie");
            indicesMap.put("Favorate_Movie", this.Favorate_MovieIndex);
            this.Movie_TypeIndex = getValidColumnIndex(path, table, "Movies", "Movie_Type");
            indicesMap.put("Movie_Type", this.Movie_TypeIndex);
            this.Moview_RatingIndex = getValidColumnIndex(path, table, "Movies", "Moview_Rating");
            indicesMap.put("Moview_Rating", this.Moview_RatingIndex);
            this.MovieDurationIndex = getValidColumnIndex(path, table, "Movies", "MovieDuration");
            indicesMap.put("MovieDuration", this.MovieDurationIndex);
            this.moviesTrailerIndex = getValidColumnIndex(path, table, "Movies", "moviesTrailer");
            indicesMap.put("moviesTrailer", this.moviesTrailerIndex);
            this.moviesReviewsIndex = getValidColumnIndex(path, table, "Movies", "moviesReviews");
            indicesMap.put("moviesReviews", this.moviesReviewsIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final MoviesColumnInfo otherInfo = (MoviesColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.Movie_NameIndex = otherInfo.Movie_NameIndex;
            this.Movie_OverviewIndex = otherInfo.Movie_OverviewIndex;
            this.Movie_ImgIndex = otherInfo.Movie_ImgIndex;
            this.Moview_YearIndex = otherInfo.Moview_YearIndex;
            this.Favorate_MovieIndex = otherInfo.Favorate_MovieIndex;
            this.Movie_TypeIndex = otherInfo.Movie_TypeIndex;
            this.Moview_RatingIndex = otherInfo.Moview_RatingIndex;
            this.MovieDurationIndex = otherInfo.MovieDurationIndex;
            this.moviesTrailerIndex = otherInfo.moviesTrailerIndex;
            this.moviesReviewsIndex = otherInfo.moviesReviewsIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final MoviesColumnInfo clone() {
            return (MoviesColumnInfo) super.clone();
        }

    }
    private MoviesColumnInfo columnInfo;
    private ProxyState proxyState;
    private RealmList<com.example.new_one.Model.MoviesTrailer> moviesTrailerRealmList;
    private RealmList<com.example.new_one.Model.MoviesReviews> moviesReviewsRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("Movie_Name");
        fieldNames.add("Movie_Overview");
        fieldNames.add("Movie_Img");
        fieldNames.add("Moview_Year");
        fieldNames.add("Favorate_Movie");
        fieldNames.add("Movie_Type");
        fieldNames.add("Moview_Rating");
        fieldNames.add("MovieDuration");
        fieldNames.add("moviesTrailer");
        fieldNames.add("moviesReviews");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    MoviesRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MoviesColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.example.new_one.Model.Movies.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public int realmGet$id() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    public void realmSet$id(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$Movie_Name() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.Movie_NameIndex);
    }

    public void realmSet$Movie_Name(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'Movie_Name' to null.");
            }
            row.getTable().setString(columnInfo.Movie_NameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'Movie_Name' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.Movie_NameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$Movie_Overview() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.Movie_OverviewIndex);
    }

    public void realmSet$Movie_Overview(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'Movie_Overview' to null.");
            }
            row.getTable().setString(columnInfo.Movie_OverviewIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'Movie_Overview' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.Movie_OverviewIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$Movie_Img() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.Movie_ImgIndex);
    }

    public void realmSet$Movie_Img(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'Movie_Img' to null.");
            }
            row.getTable().setString(columnInfo.Movie_ImgIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'Movie_Img' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.Movie_ImgIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$Moview_Year() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.Moview_YearIndex);
    }

    public void realmSet$Moview_Year(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.Moview_YearIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.Moview_YearIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.Moview_YearIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.Moview_YearIndex, value);
    }

    @SuppressWarnings("cast")
    public boolean realmGet$Favorate_Movie() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.Favorate_MovieIndex);
    }

    public void realmSet$Favorate_Movie(boolean value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.Favorate_MovieIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.Favorate_MovieIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$Movie_Type() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.Movie_TypeIndex);
    }

    public void realmSet$Movie_Type(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'Movie_Type' to null.");
            }
            row.getTable().setString(columnInfo.Movie_TypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'Movie_Type' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.Movie_TypeIndex, value);
    }

    @SuppressWarnings("cast")
    public float realmGet$Moview_Rating() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (float) proxyState.getRow$realm().getFloat(columnInfo.Moview_RatingIndex);
    }

    public void realmSet$Moview_Rating(float value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setFloat(columnInfo.Moview_RatingIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setFloat(columnInfo.Moview_RatingIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$MovieDuration() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.MovieDurationIndex);
    }

    public void realmSet$MovieDuration(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.MovieDurationIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.MovieDurationIndex, value);
    }

    public RealmList<com.example.new_one.Model.MoviesTrailer> realmGet$moviesTrailer() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (moviesTrailerRealmList != null) {
            return moviesTrailerRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.moviesTrailerIndex);
            moviesTrailerRealmList = new RealmList<com.example.new_one.Model.MoviesTrailer>(com.example.new_one.Model.MoviesTrailer.class, linkView, proxyState.getRealm$realm());
            return moviesTrailerRealmList;
        }
    }

    public void realmSet$moviesTrailer(RealmList<com.example.new_one.Model.MoviesTrailer> value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("moviesTrailer")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.example.new_one.Model.MoviesTrailer> original = value;
                value = new RealmList<com.example.new_one.Model.MoviesTrailer>();
                for (com.example.new_one.Model.MoviesTrailer item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.moviesTrailerIndex);
        links.clear();
        if (value == null) {
            return;
        }
        for (RealmModel linkedObject : (RealmList<? extends RealmModel>) value) {
            if (!(RealmObject.isManaged(linkedObject) && RealmObject.isValid(linkedObject))) {
                throw new IllegalArgumentException("Each element of 'value' must be a valid managed object.");
            }
            if (((RealmObjectProxy)linkedObject).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("Each element of 'value' must belong to the same Realm.");
            }
            links.add(((RealmObjectProxy)linkedObject).realmGet$proxyState().getRow$realm().getIndex());
        }
    }

    public RealmList<com.example.new_one.Model.MoviesReviews> realmGet$moviesReviews() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (moviesReviewsRealmList != null) {
            return moviesReviewsRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.moviesReviewsIndex);
            moviesReviewsRealmList = new RealmList<com.example.new_one.Model.MoviesReviews>(com.example.new_one.Model.MoviesReviews.class, linkView, proxyState.getRealm$realm());
            return moviesReviewsRealmList;
        }
    }

    public void realmSet$moviesReviews(RealmList<com.example.new_one.Model.MoviesReviews> value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("moviesReviews")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.example.new_one.Model.MoviesReviews> original = value;
                value = new RealmList<com.example.new_one.Model.MoviesReviews>();
                for (com.example.new_one.Model.MoviesReviews item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.moviesReviewsIndex);
        links.clear();
        if (value == null) {
            return;
        }
        for (RealmModel linkedObject : (RealmList<? extends RealmModel>) value) {
            if (!(RealmObject.isManaged(linkedObject) && RealmObject.isValid(linkedObject))) {
                throw new IllegalArgumentException("Each element of 'value' must be a valid managed object.");
            }
            if (((RealmObjectProxy)linkedObject).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("Each element of 'value' must belong to the same Realm.");
            }
            links.add(((RealmObjectProxy)linkedObject).realmGet$proxyState().getRow$realm().getIndex());
        }
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Movies")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Movies");
            realmObjectSchema.add(new Property("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("Movie_Name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("Movie_Overview", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("Movie_Img", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("Moview_Year", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("Favorate_Movie", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("Movie_Type", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("Moview_Rating", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("MovieDuration", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            if (!realmSchema.contains("MoviesTrailer")) {
                MoviesTrailerRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add(new Property("moviesTrailer", RealmFieldType.LIST, realmSchema.get("MoviesTrailer")));
            if (!realmSchema.contains("MoviesReviews")) {
                MoviesReviewsRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add(new Property("moviesReviews", RealmFieldType.LIST, realmSchema.get("MoviesReviews")));
            return realmObjectSchema;
        }
        return realmSchema.get("Movies");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_Movies")) {
            Table table = sharedRealm.getTable("class_Movies");
            table.addColumn(RealmFieldType.INTEGER, "id", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "Movie_Name", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "Movie_Overview", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "Movie_Img", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "Moview_Year", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "Favorate_Movie", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "Movie_Type", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.FLOAT, "Moview_Rating", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "MovieDuration", Table.NOT_NULLABLE);
            if (!sharedRealm.hasTable("class_MoviesTrailer")) {
                MoviesTrailerRealmProxy.initTable(sharedRealm);
            }
            table.addColumnLink(RealmFieldType.LIST, "moviesTrailer", sharedRealm.getTable("class_MoviesTrailer"));
            if (!sharedRealm.hasTable("class_MoviesReviews")) {
                MoviesReviewsRealmProxy.initTable(sharedRealm);
            }
            table.addColumnLink(RealmFieldType.LIST, "moviesReviews", sharedRealm.getTable("class_MoviesReviews"));
            table.addSearchIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return sharedRealm.getTable("class_Movies");
    }

    public static MoviesColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_Movies")) {
            Table table = sharedRealm.getTable("class_Movies");
            final long columnCount = table.getColumnCount();
            if (columnCount != 11) {
                if (columnCount < 11) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 11 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 11 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 11 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 11; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final MoviesColumnInfo columnInfo = new MoviesColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("id") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'id' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.idIndex) && table.findFirstNull(columnInfo.idIndex) != TableOrView.NO_MATCH) {
                throw new IllegalStateException("Cannot migrate an object with null value in field 'id'. Either maintain the same type for primary key field 'id', or remove the object with null value before migration.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("id")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("id"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("Movie_Name")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'Movie_Name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("Movie_Name") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'Movie_Name' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.Movie_NameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'Movie_Name' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'Movie_Name' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("Movie_Overview")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'Movie_Overview' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("Movie_Overview") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'Movie_Overview' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.Movie_OverviewIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'Movie_Overview' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'Movie_Overview' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("Movie_Img")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'Movie_Img' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("Movie_Img") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'Movie_Img' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.Movie_ImgIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'Movie_Img' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'Movie_Img' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("Moview_Year")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'Moview_Year' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("Moview_Year") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'Moview_Year' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.Moview_YearIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'Moview_Year' is required. Either set @Required to field 'Moview_Year' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("Favorate_Movie")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'Favorate_Movie' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("Favorate_Movie") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'Favorate_Movie' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.Favorate_MovieIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'Favorate_Movie' does support null values in the existing Realm file. Use corresponding boxed type for field 'Favorate_Movie' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("Movie_Type")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'Movie_Type' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("Movie_Type") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'Movie_Type' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.Movie_TypeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'Movie_Type' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'Movie_Type' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("Moview_Rating")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'Moview_Rating' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("Moview_Rating") != RealmFieldType.FLOAT) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'float' for field 'Moview_Rating' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.Moview_RatingIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'Moview_Rating' does support null values in the existing Realm file. Use corresponding boxed type for field 'Moview_Rating' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("MovieDuration")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'MovieDuration' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("MovieDuration") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'MovieDuration' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.MovieDurationIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'MovieDuration' does support null values in the existing Realm file. Use corresponding boxed type for field 'MovieDuration' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("moviesTrailer")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'moviesTrailer'");
            }
            if (columnTypes.get("moviesTrailer") != RealmFieldType.LIST) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'MoviesTrailer' for field 'moviesTrailer'");
            }
            if (!sharedRealm.hasTable("class_MoviesTrailer")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_MoviesTrailer' for field 'moviesTrailer'");
            }
            Table table_9 = sharedRealm.getTable("class_MoviesTrailer");
            if (!table.getLinkTarget(columnInfo.moviesTrailerIndex).hasSameSchema(table_9)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'moviesTrailer': '" + table.getLinkTarget(columnInfo.moviesTrailerIndex).getName() + "' expected - was '" + table_9.getName() + "'");
            }
            if (!columnTypes.containsKey("moviesReviews")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'moviesReviews'");
            }
            if (columnTypes.get("moviesReviews") != RealmFieldType.LIST) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'MoviesReviews' for field 'moviesReviews'");
            }
            if (!sharedRealm.hasTable("class_MoviesReviews")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_MoviesReviews' for field 'moviesReviews'");
            }
            Table table_10 = sharedRealm.getTable("class_MoviesReviews");
            if (!table.getLinkTarget(columnInfo.moviesReviewsIndex).hasSameSchema(table_10)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'moviesReviews': '" + table.getLinkTarget(columnInfo.moviesReviewsIndex).getName() + "' expected - was '" + table_10.getName() + "'");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Movies' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Movies";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.new_one.Model.Movies createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(2);
        com.example.new_one.Model.Movies obj = null;
        if (update) {
            Table table = realm.getTable(com.example.new_one.Model.Movies.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.new_one.Model.Movies.class), false, Collections.<String> emptyList());
                    obj = new io.realm.MoviesRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("moviesTrailer")) {
                excludeFields.add("moviesTrailer");
            }
            if (json.has("moviesReviews")) {
                excludeFields.add("moviesReviews");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.MoviesRealmProxy) realm.createObjectInternal(com.example.new_one.Model.Movies.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.MoviesRealmProxy) realm.createObjectInternal(com.example.new_one.Model.Movies.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("Movie_Name")) {
            if (json.isNull("Movie_Name")) {
                ((MoviesRealmProxyInterface) obj).realmSet$Movie_Name(null);
            } else {
                ((MoviesRealmProxyInterface) obj).realmSet$Movie_Name((String) json.getString("Movie_Name"));
            }
        }
        if (json.has("Movie_Overview")) {
            if (json.isNull("Movie_Overview")) {
                ((MoviesRealmProxyInterface) obj).realmSet$Movie_Overview(null);
            } else {
                ((MoviesRealmProxyInterface) obj).realmSet$Movie_Overview((String) json.getString("Movie_Overview"));
            }
        }
        if (json.has("Movie_Img")) {
            if (json.isNull("Movie_Img")) {
                ((MoviesRealmProxyInterface) obj).realmSet$Movie_Img(null);
            } else {
                ((MoviesRealmProxyInterface) obj).realmSet$Movie_Img((String) json.getString("Movie_Img"));
            }
        }
        if (json.has("Moview_Year")) {
            if (json.isNull("Moview_Year")) {
                ((MoviesRealmProxyInterface) obj).realmSet$Moview_Year(null);
            } else {
                ((MoviesRealmProxyInterface) obj).realmSet$Moview_Year((String) json.getString("Moview_Year"));
            }
        }
        if (json.has("Favorate_Movie")) {
            if (json.isNull("Favorate_Movie")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'Favorate_Movie' to null.");
            } else {
                ((MoviesRealmProxyInterface) obj).realmSet$Favorate_Movie((boolean) json.getBoolean("Favorate_Movie"));
            }
        }
        if (json.has("Movie_Type")) {
            if (json.isNull("Movie_Type")) {
                ((MoviesRealmProxyInterface) obj).realmSet$Movie_Type(null);
            } else {
                ((MoviesRealmProxyInterface) obj).realmSet$Movie_Type((String) json.getString("Movie_Type"));
            }
        }
        if (json.has("Moview_Rating")) {
            if (json.isNull("Moview_Rating")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'Moview_Rating' to null.");
            } else {
                ((MoviesRealmProxyInterface) obj).realmSet$Moview_Rating((float) json.getDouble("Moview_Rating"));
            }
        }
        if (json.has("MovieDuration")) {
            if (json.isNull("MovieDuration")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'MovieDuration' to null.");
            } else {
                ((MoviesRealmProxyInterface) obj).realmSet$MovieDuration((int) json.getInt("MovieDuration"));
            }
        }
        if (json.has("moviesTrailer")) {
            if (json.isNull("moviesTrailer")) {
                ((MoviesRealmProxyInterface) obj).realmSet$moviesTrailer(null);
            } else {
                ((MoviesRealmProxyInterface) obj).realmGet$moviesTrailer().clear();
                JSONArray array = json.getJSONArray("moviesTrailer");
                for (int i = 0; i < array.length(); i++) {
                    com.example.new_one.Model.MoviesTrailer item = MoviesTrailerRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((MoviesRealmProxyInterface) obj).realmGet$moviesTrailer().add(item);
                }
            }
        }
        if (json.has("moviesReviews")) {
            if (json.isNull("moviesReviews")) {
                ((MoviesRealmProxyInterface) obj).realmSet$moviesReviews(null);
            } else {
                ((MoviesRealmProxyInterface) obj).realmGet$moviesReviews().clear();
                JSONArray array = json.getJSONArray("moviesReviews");
                for (int i = 0; i < array.length(); i++) {
                    com.example.new_one.Model.MoviesReviews item = MoviesReviewsRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((MoviesRealmProxyInterface) obj).realmGet$moviesReviews().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.new_one.Model.Movies createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.example.new_one.Model.Movies obj = new com.example.new_one.Model.Movies();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((MoviesRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("Movie_Name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MoviesRealmProxyInterface) obj).realmSet$Movie_Name(null);
                } else {
                    ((MoviesRealmProxyInterface) obj).realmSet$Movie_Name((String) reader.nextString());
                }
            } else if (name.equals("Movie_Overview")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MoviesRealmProxyInterface) obj).realmSet$Movie_Overview(null);
                } else {
                    ((MoviesRealmProxyInterface) obj).realmSet$Movie_Overview((String) reader.nextString());
                }
            } else if (name.equals("Movie_Img")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MoviesRealmProxyInterface) obj).realmSet$Movie_Img(null);
                } else {
                    ((MoviesRealmProxyInterface) obj).realmSet$Movie_Img((String) reader.nextString());
                }
            } else if (name.equals("Moview_Year")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MoviesRealmProxyInterface) obj).realmSet$Moview_Year(null);
                } else {
                    ((MoviesRealmProxyInterface) obj).realmSet$Moview_Year((String) reader.nextString());
                }
            } else if (name.equals("Favorate_Movie")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'Favorate_Movie' to null.");
                } else {
                    ((MoviesRealmProxyInterface) obj).realmSet$Favorate_Movie((boolean) reader.nextBoolean());
                }
            } else if (name.equals("Movie_Type")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MoviesRealmProxyInterface) obj).realmSet$Movie_Type(null);
                } else {
                    ((MoviesRealmProxyInterface) obj).realmSet$Movie_Type((String) reader.nextString());
                }
            } else if (name.equals("Moview_Rating")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'Moview_Rating' to null.");
                } else {
                    ((MoviesRealmProxyInterface) obj).realmSet$Moview_Rating((float) reader.nextDouble());
                }
            } else if (name.equals("MovieDuration")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'MovieDuration' to null.");
                } else {
                    ((MoviesRealmProxyInterface) obj).realmSet$MovieDuration((int) reader.nextInt());
                }
            } else if (name.equals("moviesTrailer")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MoviesRealmProxyInterface) obj).realmSet$moviesTrailer(null);
                } else {
                    ((MoviesRealmProxyInterface) obj).realmSet$moviesTrailer(new RealmList<com.example.new_one.Model.MoviesTrailer>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.example.new_one.Model.MoviesTrailer item = MoviesTrailerRealmProxy.createUsingJsonStream(realm, reader);
                        ((MoviesRealmProxyInterface) obj).realmGet$moviesTrailer().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("moviesReviews")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MoviesRealmProxyInterface) obj).realmSet$moviesReviews(null);
                } else {
                    ((MoviesRealmProxyInterface) obj).realmSet$moviesReviews(new RealmList<com.example.new_one.Model.MoviesReviews>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.example.new_one.Model.MoviesReviews item = MoviesReviewsRealmProxy.createUsingJsonStream(realm, reader);
                        ((MoviesRealmProxyInterface) obj).realmGet$moviesReviews().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.example.new_one.Model.Movies copyOrUpdate(Realm realm, com.example.new_one.Model.Movies object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.new_one.Model.Movies) cachedRealmObject;
        } else {
            com.example.new_one.Model.Movies realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.example.new_one.Model.Movies.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((MoviesRealmProxyInterface) object).realmGet$id());
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.new_one.Model.Movies.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.MoviesRealmProxy();
                        cache.put(object, (RealmObjectProxy) realmObject);
                    } finally {
                        objectContext.clear();
                    }
                } else {
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            } else {
                return copy(realm, object, update, cache);
            }
        }
    }

    public static com.example.new_one.Model.Movies copy(Realm realm, com.example.new_one.Model.Movies newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.new_one.Model.Movies) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.example.new_one.Model.Movies realmObject = realm.createObjectInternal(com.example.new_one.Model.Movies.class, ((MoviesRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((MoviesRealmProxyInterface) realmObject).realmSet$Movie_Name(((MoviesRealmProxyInterface) newObject).realmGet$Movie_Name());
            ((MoviesRealmProxyInterface) realmObject).realmSet$Movie_Overview(((MoviesRealmProxyInterface) newObject).realmGet$Movie_Overview());
            ((MoviesRealmProxyInterface) realmObject).realmSet$Movie_Img(((MoviesRealmProxyInterface) newObject).realmGet$Movie_Img());
            ((MoviesRealmProxyInterface) realmObject).realmSet$Moview_Year(((MoviesRealmProxyInterface) newObject).realmGet$Moview_Year());
            ((MoviesRealmProxyInterface) realmObject).realmSet$Favorate_Movie(((MoviesRealmProxyInterface) newObject).realmGet$Favorate_Movie());
            ((MoviesRealmProxyInterface) realmObject).realmSet$Movie_Type(((MoviesRealmProxyInterface) newObject).realmGet$Movie_Type());
            ((MoviesRealmProxyInterface) realmObject).realmSet$Moview_Rating(((MoviesRealmProxyInterface) newObject).realmGet$Moview_Rating());
            ((MoviesRealmProxyInterface) realmObject).realmSet$MovieDuration(((MoviesRealmProxyInterface) newObject).realmGet$MovieDuration());

            RealmList<com.example.new_one.Model.MoviesTrailer> moviesTrailerList = ((MoviesRealmProxyInterface) newObject).realmGet$moviesTrailer();
            if (moviesTrailerList != null) {
                RealmList<com.example.new_one.Model.MoviesTrailer> moviesTrailerRealmList = ((MoviesRealmProxyInterface) realmObject).realmGet$moviesTrailer();
                for (int i = 0; i < moviesTrailerList.size(); i++) {
                    com.example.new_one.Model.MoviesTrailer moviesTrailerItem = moviesTrailerList.get(i);
                    com.example.new_one.Model.MoviesTrailer cachemoviesTrailer = (com.example.new_one.Model.MoviesTrailer) cache.get(moviesTrailerItem);
                    if (cachemoviesTrailer != null) {
                        moviesTrailerRealmList.add(cachemoviesTrailer);
                    } else {
                        moviesTrailerRealmList.add(MoviesTrailerRealmProxy.copyOrUpdate(realm, moviesTrailerList.get(i), update, cache));
                    }
                }
            }


            RealmList<com.example.new_one.Model.MoviesReviews> moviesReviewsList = ((MoviesRealmProxyInterface) newObject).realmGet$moviesReviews();
            if (moviesReviewsList != null) {
                RealmList<com.example.new_one.Model.MoviesReviews> moviesReviewsRealmList = ((MoviesRealmProxyInterface) realmObject).realmGet$moviesReviews();
                for (int i = 0; i < moviesReviewsList.size(); i++) {
                    com.example.new_one.Model.MoviesReviews moviesReviewsItem = moviesReviewsList.get(i);
                    com.example.new_one.Model.MoviesReviews cachemoviesReviews = (com.example.new_one.Model.MoviesReviews) cache.get(moviesReviewsItem);
                    if (cachemoviesReviews != null) {
                        moviesReviewsRealmList.add(cachemoviesReviews);
                    } else {
                        moviesReviewsRealmList.add(MoviesReviewsRealmProxy.copyOrUpdate(realm, moviesReviewsList.get(i), update, cache));
                    }
                }
            }

            return realmObject;
        }
    }

    public static long insert(Realm realm, com.example.new_one.Model.Movies object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.new_one.Model.Movies.class);
        long tableNativePtr = table.getNativeTablePointer();
        MoviesColumnInfo columnInfo = (MoviesColumnInfo) realm.schema.getColumnInfo(com.example.new_one.Model.Movies.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((MoviesRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MoviesRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((MoviesRealmProxyInterface) object).realmGet$id(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$Movie_Name = ((MoviesRealmProxyInterface)object).realmGet$Movie_Name();
        if (realmGet$Movie_Name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Movie_NameIndex, rowIndex, realmGet$Movie_Name, false);
        }
        String realmGet$Movie_Overview = ((MoviesRealmProxyInterface)object).realmGet$Movie_Overview();
        if (realmGet$Movie_Overview != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Movie_OverviewIndex, rowIndex, realmGet$Movie_Overview, false);
        }
        String realmGet$Movie_Img = ((MoviesRealmProxyInterface)object).realmGet$Movie_Img();
        if (realmGet$Movie_Img != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Movie_ImgIndex, rowIndex, realmGet$Movie_Img, false);
        }
        String realmGet$Moview_Year = ((MoviesRealmProxyInterface)object).realmGet$Moview_Year();
        if (realmGet$Moview_Year != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Moview_YearIndex, rowIndex, realmGet$Moview_Year, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.Favorate_MovieIndex, rowIndex, ((MoviesRealmProxyInterface)object).realmGet$Favorate_Movie(), false);
        String realmGet$Movie_Type = ((MoviesRealmProxyInterface)object).realmGet$Movie_Type();
        if (realmGet$Movie_Type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Movie_TypeIndex, rowIndex, realmGet$Movie_Type, false);
        }
        Table.nativeSetFloat(tableNativePtr, columnInfo.Moview_RatingIndex, rowIndex, ((MoviesRealmProxyInterface)object).realmGet$Moview_Rating(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.MovieDurationIndex, rowIndex, ((MoviesRealmProxyInterface)object).realmGet$MovieDuration(), false);

        RealmList<com.example.new_one.Model.MoviesTrailer> moviesTrailerList = ((MoviesRealmProxyInterface) object).realmGet$moviesTrailer();
        if (moviesTrailerList != null) {
            long moviesTrailerNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.moviesTrailerIndex, rowIndex);
            for (com.example.new_one.Model.MoviesTrailer moviesTrailerItem : moviesTrailerList) {
                Long cacheItemIndexmoviesTrailer = cache.get(moviesTrailerItem);
                if (cacheItemIndexmoviesTrailer == null) {
                    cacheItemIndexmoviesTrailer = MoviesTrailerRealmProxy.insert(realm, moviesTrailerItem, cache);
                }
                LinkView.nativeAdd(moviesTrailerNativeLinkViewPtr, cacheItemIndexmoviesTrailer);
            }
            LinkView.nativeClose(moviesTrailerNativeLinkViewPtr);
        }


        RealmList<com.example.new_one.Model.MoviesReviews> moviesReviewsList = ((MoviesRealmProxyInterface) object).realmGet$moviesReviews();
        if (moviesReviewsList != null) {
            long moviesReviewsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.moviesReviewsIndex, rowIndex);
            for (com.example.new_one.Model.MoviesReviews moviesReviewsItem : moviesReviewsList) {
                Long cacheItemIndexmoviesReviews = cache.get(moviesReviewsItem);
                if (cacheItemIndexmoviesReviews == null) {
                    cacheItemIndexmoviesReviews = MoviesReviewsRealmProxy.insert(realm, moviesReviewsItem, cache);
                }
                LinkView.nativeAdd(moviesReviewsNativeLinkViewPtr, cacheItemIndexmoviesReviews);
            }
            LinkView.nativeClose(moviesReviewsNativeLinkViewPtr);
        }

        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.new_one.Model.Movies.class);
        long tableNativePtr = table.getNativeTablePointer();
        MoviesColumnInfo columnInfo = (MoviesColumnInfo) realm.schema.getColumnInfo(com.example.new_one.Model.Movies.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.new_one.Model.Movies object = null;
        while (objects.hasNext()) {
            object = (com.example.new_one.Model.Movies) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((MoviesRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MoviesRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((MoviesRealmProxyInterface) object).realmGet$id(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$Movie_Name = ((MoviesRealmProxyInterface)object).realmGet$Movie_Name();
                if (realmGet$Movie_Name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.Movie_NameIndex, rowIndex, realmGet$Movie_Name, false);
                }
                String realmGet$Movie_Overview = ((MoviesRealmProxyInterface)object).realmGet$Movie_Overview();
                if (realmGet$Movie_Overview != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.Movie_OverviewIndex, rowIndex, realmGet$Movie_Overview, false);
                }
                String realmGet$Movie_Img = ((MoviesRealmProxyInterface)object).realmGet$Movie_Img();
                if (realmGet$Movie_Img != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.Movie_ImgIndex, rowIndex, realmGet$Movie_Img, false);
                }
                String realmGet$Moview_Year = ((MoviesRealmProxyInterface)object).realmGet$Moview_Year();
                if (realmGet$Moview_Year != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.Moview_YearIndex, rowIndex, realmGet$Moview_Year, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.Favorate_MovieIndex, rowIndex, ((MoviesRealmProxyInterface)object).realmGet$Favorate_Movie(), false);
                String realmGet$Movie_Type = ((MoviesRealmProxyInterface)object).realmGet$Movie_Type();
                if (realmGet$Movie_Type != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.Movie_TypeIndex, rowIndex, realmGet$Movie_Type, false);
                }
                Table.nativeSetFloat(tableNativePtr, columnInfo.Moview_RatingIndex, rowIndex, ((MoviesRealmProxyInterface)object).realmGet$Moview_Rating(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.MovieDurationIndex, rowIndex, ((MoviesRealmProxyInterface)object).realmGet$MovieDuration(), false);

                RealmList<com.example.new_one.Model.MoviesTrailer> moviesTrailerList = ((MoviesRealmProxyInterface) object).realmGet$moviesTrailer();
                if (moviesTrailerList != null) {
                    long moviesTrailerNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.moviesTrailerIndex, rowIndex);
                    for (com.example.new_one.Model.MoviesTrailer moviesTrailerItem : moviesTrailerList) {
                        Long cacheItemIndexmoviesTrailer = cache.get(moviesTrailerItem);
                        if (cacheItemIndexmoviesTrailer == null) {
                            cacheItemIndexmoviesTrailer = MoviesTrailerRealmProxy.insert(realm, moviesTrailerItem, cache);
                        }
                        LinkView.nativeAdd(moviesTrailerNativeLinkViewPtr, cacheItemIndexmoviesTrailer);
                    }
                    LinkView.nativeClose(moviesTrailerNativeLinkViewPtr);
                }


                RealmList<com.example.new_one.Model.MoviesReviews> moviesReviewsList = ((MoviesRealmProxyInterface) object).realmGet$moviesReviews();
                if (moviesReviewsList != null) {
                    long moviesReviewsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.moviesReviewsIndex, rowIndex);
                    for (com.example.new_one.Model.MoviesReviews moviesReviewsItem : moviesReviewsList) {
                        Long cacheItemIndexmoviesReviews = cache.get(moviesReviewsItem);
                        if (cacheItemIndexmoviesReviews == null) {
                            cacheItemIndexmoviesReviews = MoviesReviewsRealmProxy.insert(realm, moviesReviewsItem, cache);
                        }
                        LinkView.nativeAdd(moviesReviewsNativeLinkViewPtr, cacheItemIndexmoviesReviews);
                    }
                    LinkView.nativeClose(moviesReviewsNativeLinkViewPtr);
                }

            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.new_one.Model.Movies object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.new_one.Model.Movies.class);
        long tableNativePtr = table.getNativeTablePointer();
        MoviesColumnInfo columnInfo = (MoviesColumnInfo) realm.schema.getColumnInfo(com.example.new_one.Model.Movies.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((MoviesRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MoviesRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((MoviesRealmProxyInterface) object).realmGet$id(), false);
        }
        cache.put(object, rowIndex);
        String realmGet$Movie_Name = ((MoviesRealmProxyInterface)object).realmGet$Movie_Name();
        if (realmGet$Movie_Name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Movie_NameIndex, rowIndex, realmGet$Movie_Name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.Movie_NameIndex, rowIndex, false);
        }
        String realmGet$Movie_Overview = ((MoviesRealmProxyInterface)object).realmGet$Movie_Overview();
        if (realmGet$Movie_Overview != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Movie_OverviewIndex, rowIndex, realmGet$Movie_Overview, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.Movie_OverviewIndex, rowIndex, false);
        }
        String realmGet$Movie_Img = ((MoviesRealmProxyInterface)object).realmGet$Movie_Img();
        if (realmGet$Movie_Img != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Movie_ImgIndex, rowIndex, realmGet$Movie_Img, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.Movie_ImgIndex, rowIndex, false);
        }
        String realmGet$Moview_Year = ((MoviesRealmProxyInterface)object).realmGet$Moview_Year();
        if (realmGet$Moview_Year != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Moview_YearIndex, rowIndex, realmGet$Moview_Year, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.Moview_YearIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.Favorate_MovieIndex, rowIndex, ((MoviesRealmProxyInterface)object).realmGet$Favorate_Movie(), false);
        String realmGet$Movie_Type = ((MoviesRealmProxyInterface)object).realmGet$Movie_Type();
        if (realmGet$Movie_Type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Movie_TypeIndex, rowIndex, realmGet$Movie_Type, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.Movie_TypeIndex, rowIndex, false);
        }
        Table.nativeSetFloat(tableNativePtr, columnInfo.Moview_RatingIndex, rowIndex, ((MoviesRealmProxyInterface)object).realmGet$Moview_Rating(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.MovieDurationIndex, rowIndex, ((MoviesRealmProxyInterface)object).realmGet$MovieDuration(), false);

        long moviesTrailerNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.moviesTrailerIndex, rowIndex);
        LinkView.nativeClear(moviesTrailerNativeLinkViewPtr);
        RealmList<com.example.new_one.Model.MoviesTrailer> moviesTrailerList = ((MoviesRealmProxyInterface) object).realmGet$moviesTrailer();
        if (moviesTrailerList != null) {
            for (com.example.new_one.Model.MoviesTrailer moviesTrailerItem : moviesTrailerList) {
                Long cacheItemIndexmoviesTrailer = cache.get(moviesTrailerItem);
                if (cacheItemIndexmoviesTrailer == null) {
                    cacheItemIndexmoviesTrailer = MoviesTrailerRealmProxy.insertOrUpdate(realm, moviesTrailerItem, cache);
                }
                LinkView.nativeAdd(moviesTrailerNativeLinkViewPtr, cacheItemIndexmoviesTrailer);
            }
        }
        LinkView.nativeClose(moviesTrailerNativeLinkViewPtr);


        long moviesReviewsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.moviesReviewsIndex, rowIndex);
        LinkView.nativeClear(moviesReviewsNativeLinkViewPtr);
        RealmList<com.example.new_one.Model.MoviesReviews> moviesReviewsList = ((MoviesRealmProxyInterface) object).realmGet$moviesReviews();
        if (moviesReviewsList != null) {
            for (com.example.new_one.Model.MoviesReviews moviesReviewsItem : moviesReviewsList) {
                Long cacheItemIndexmoviesReviews = cache.get(moviesReviewsItem);
                if (cacheItemIndexmoviesReviews == null) {
                    cacheItemIndexmoviesReviews = MoviesReviewsRealmProxy.insertOrUpdate(realm, moviesReviewsItem, cache);
                }
                LinkView.nativeAdd(moviesReviewsNativeLinkViewPtr, cacheItemIndexmoviesReviews);
            }
        }
        LinkView.nativeClose(moviesReviewsNativeLinkViewPtr);

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.new_one.Model.Movies.class);
        long tableNativePtr = table.getNativeTablePointer();
        MoviesColumnInfo columnInfo = (MoviesColumnInfo) realm.schema.getColumnInfo(com.example.new_one.Model.Movies.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.new_one.Model.Movies object = null;
        while (objects.hasNext()) {
            object = (com.example.new_one.Model.Movies) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((MoviesRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MoviesRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((MoviesRealmProxyInterface) object).realmGet$id(), false);
                }
                cache.put(object, rowIndex);
                String realmGet$Movie_Name = ((MoviesRealmProxyInterface)object).realmGet$Movie_Name();
                if (realmGet$Movie_Name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.Movie_NameIndex, rowIndex, realmGet$Movie_Name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.Movie_NameIndex, rowIndex, false);
                }
                String realmGet$Movie_Overview = ((MoviesRealmProxyInterface)object).realmGet$Movie_Overview();
                if (realmGet$Movie_Overview != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.Movie_OverviewIndex, rowIndex, realmGet$Movie_Overview, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.Movie_OverviewIndex, rowIndex, false);
                }
                String realmGet$Movie_Img = ((MoviesRealmProxyInterface)object).realmGet$Movie_Img();
                if (realmGet$Movie_Img != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.Movie_ImgIndex, rowIndex, realmGet$Movie_Img, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.Movie_ImgIndex, rowIndex, false);
                }
                String realmGet$Moview_Year = ((MoviesRealmProxyInterface)object).realmGet$Moview_Year();
                if (realmGet$Moview_Year != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.Moview_YearIndex, rowIndex, realmGet$Moview_Year, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.Moview_YearIndex, rowIndex, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.Favorate_MovieIndex, rowIndex, ((MoviesRealmProxyInterface)object).realmGet$Favorate_Movie(), false);
                String realmGet$Movie_Type = ((MoviesRealmProxyInterface)object).realmGet$Movie_Type();
                if (realmGet$Movie_Type != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.Movie_TypeIndex, rowIndex, realmGet$Movie_Type, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.Movie_TypeIndex, rowIndex, false);
                }
                Table.nativeSetFloat(tableNativePtr, columnInfo.Moview_RatingIndex, rowIndex, ((MoviesRealmProxyInterface)object).realmGet$Moview_Rating(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.MovieDurationIndex, rowIndex, ((MoviesRealmProxyInterface)object).realmGet$MovieDuration(), false);

                long moviesTrailerNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.moviesTrailerIndex, rowIndex);
                LinkView.nativeClear(moviesTrailerNativeLinkViewPtr);
                RealmList<com.example.new_one.Model.MoviesTrailer> moviesTrailerList = ((MoviesRealmProxyInterface) object).realmGet$moviesTrailer();
                if (moviesTrailerList != null) {
                    for (com.example.new_one.Model.MoviesTrailer moviesTrailerItem : moviesTrailerList) {
                        Long cacheItemIndexmoviesTrailer = cache.get(moviesTrailerItem);
                        if (cacheItemIndexmoviesTrailer == null) {
                            cacheItemIndexmoviesTrailer = MoviesTrailerRealmProxy.insertOrUpdate(realm, moviesTrailerItem, cache);
                        }
                        LinkView.nativeAdd(moviesTrailerNativeLinkViewPtr, cacheItemIndexmoviesTrailer);
                    }
                }
                LinkView.nativeClose(moviesTrailerNativeLinkViewPtr);


                long moviesReviewsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.moviesReviewsIndex, rowIndex);
                LinkView.nativeClear(moviesReviewsNativeLinkViewPtr);
                RealmList<com.example.new_one.Model.MoviesReviews> moviesReviewsList = ((MoviesRealmProxyInterface) object).realmGet$moviesReviews();
                if (moviesReviewsList != null) {
                    for (com.example.new_one.Model.MoviesReviews moviesReviewsItem : moviesReviewsList) {
                        Long cacheItemIndexmoviesReviews = cache.get(moviesReviewsItem);
                        if (cacheItemIndexmoviesReviews == null) {
                            cacheItemIndexmoviesReviews = MoviesReviewsRealmProxy.insertOrUpdate(realm, moviesReviewsItem, cache);
                        }
                        LinkView.nativeAdd(moviesReviewsNativeLinkViewPtr, cacheItemIndexmoviesReviews);
                    }
                }
                LinkView.nativeClose(moviesReviewsNativeLinkViewPtr);

            }
        }
    }

    public static com.example.new_one.Model.Movies createDetachedCopy(com.example.new_one.Model.Movies realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.new_one.Model.Movies unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.new_one.Model.Movies)cachedObject.object;
            } else {
                unmanagedObject = (com.example.new_one.Model.Movies)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.example.new_one.Model.Movies();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((MoviesRealmProxyInterface) unmanagedObject).realmSet$id(((MoviesRealmProxyInterface) realmObject).realmGet$id());
        ((MoviesRealmProxyInterface) unmanagedObject).realmSet$Movie_Name(((MoviesRealmProxyInterface) realmObject).realmGet$Movie_Name());
        ((MoviesRealmProxyInterface) unmanagedObject).realmSet$Movie_Overview(((MoviesRealmProxyInterface) realmObject).realmGet$Movie_Overview());
        ((MoviesRealmProxyInterface) unmanagedObject).realmSet$Movie_Img(((MoviesRealmProxyInterface) realmObject).realmGet$Movie_Img());
        ((MoviesRealmProxyInterface) unmanagedObject).realmSet$Moview_Year(((MoviesRealmProxyInterface) realmObject).realmGet$Moview_Year());
        ((MoviesRealmProxyInterface) unmanagedObject).realmSet$Favorate_Movie(((MoviesRealmProxyInterface) realmObject).realmGet$Favorate_Movie());
        ((MoviesRealmProxyInterface) unmanagedObject).realmSet$Movie_Type(((MoviesRealmProxyInterface) realmObject).realmGet$Movie_Type());
        ((MoviesRealmProxyInterface) unmanagedObject).realmSet$Moview_Rating(((MoviesRealmProxyInterface) realmObject).realmGet$Moview_Rating());
        ((MoviesRealmProxyInterface) unmanagedObject).realmSet$MovieDuration(((MoviesRealmProxyInterface) realmObject).realmGet$MovieDuration());

        // Deep copy of moviesTrailer
        if (currentDepth == maxDepth) {
            ((MoviesRealmProxyInterface) unmanagedObject).realmSet$moviesTrailer(null);
        } else {
            RealmList<com.example.new_one.Model.MoviesTrailer> managedmoviesTrailerList = ((MoviesRealmProxyInterface) realmObject).realmGet$moviesTrailer();
            RealmList<com.example.new_one.Model.MoviesTrailer> unmanagedmoviesTrailerList = new RealmList<com.example.new_one.Model.MoviesTrailer>();
            ((MoviesRealmProxyInterface) unmanagedObject).realmSet$moviesTrailer(unmanagedmoviesTrailerList);
            int nextDepth = currentDepth + 1;
            int size = managedmoviesTrailerList.size();
            for (int i = 0; i < size; i++) {
                com.example.new_one.Model.MoviesTrailer item = MoviesTrailerRealmProxy.createDetachedCopy(managedmoviesTrailerList.get(i), nextDepth, maxDepth, cache);
                unmanagedmoviesTrailerList.add(item);
            }
        }

        // Deep copy of moviesReviews
        if (currentDepth == maxDepth) {
            ((MoviesRealmProxyInterface) unmanagedObject).realmSet$moviesReviews(null);
        } else {
            RealmList<com.example.new_one.Model.MoviesReviews> managedmoviesReviewsList = ((MoviesRealmProxyInterface) realmObject).realmGet$moviesReviews();
            RealmList<com.example.new_one.Model.MoviesReviews> unmanagedmoviesReviewsList = new RealmList<com.example.new_one.Model.MoviesReviews>();
            ((MoviesRealmProxyInterface) unmanagedObject).realmSet$moviesReviews(unmanagedmoviesReviewsList);
            int nextDepth = currentDepth + 1;
            int size = managedmoviesReviewsList.size();
            for (int i = 0; i < size; i++) {
                com.example.new_one.Model.MoviesReviews item = MoviesReviewsRealmProxy.createDetachedCopy(managedmoviesReviewsList.get(i), nextDepth, maxDepth, cache);
                unmanagedmoviesReviewsList.add(item);
            }
        }
        return unmanagedObject;
    }

    static com.example.new_one.Model.Movies update(Realm realm, com.example.new_one.Model.Movies realmObject, com.example.new_one.Model.Movies newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((MoviesRealmProxyInterface) realmObject).realmSet$Movie_Name(((MoviesRealmProxyInterface) newObject).realmGet$Movie_Name());
        ((MoviesRealmProxyInterface) realmObject).realmSet$Movie_Overview(((MoviesRealmProxyInterface) newObject).realmGet$Movie_Overview());
        ((MoviesRealmProxyInterface) realmObject).realmSet$Movie_Img(((MoviesRealmProxyInterface) newObject).realmGet$Movie_Img());
        ((MoviesRealmProxyInterface) realmObject).realmSet$Moview_Year(((MoviesRealmProxyInterface) newObject).realmGet$Moview_Year());
        ((MoviesRealmProxyInterface) realmObject).realmSet$Favorate_Movie(((MoviesRealmProxyInterface) newObject).realmGet$Favorate_Movie());
        ((MoviesRealmProxyInterface) realmObject).realmSet$Movie_Type(((MoviesRealmProxyInterface) newObject).realmGet$Movie_Type());
        ((MoviesRealmProxyInterface) realmObject).realmSet$Moview_Rating(((MoviesRealmProxyInterface) newObject).realmGet$Moview_Rating());
        ((MoviesRealmProxyInterface) realmObject).realmSet$MovieDuration(((MoviesRealmProxyInterface) newObject).realmGet$MovieDuration());
        RealmList<com.example.new_one.Model.MoviesTrailer> moviesTrailerList = ((MoviesRealmProxyInterface) newObject).realmGet$moviesTrailer();
        RealmList<com.example.new_one.Model.MoviesTrailer> moviesTrailerRealmList = ((MoviesRealmProxyInterface) realmObject).realmGet$moviesTrailer();
        moviesTrailerRealmList.clear();
        if (moviesTrailerList != null) {
            for (int i = 0; i < moviesTrailerList.size(); i++) {
                com.example.new_one.Model.MoviesTrailer moviesTrailerItem = moviesTrailerList.get(i);
                com.example.new_one.Model.MoviesTrailer cachemoviesTrailer = (com.example.new_one.Model.MoviesTrailer) cache.get(moviesTrailerItem);
                if (cachemoviesTrailer != null) {
                    moviesTrailerRealmList.add(cachemoviesTrailer);
                } else {
                    moviesTrailerRealmList.add(MoviesTrailerRealmProxy.copyOrUpdate(realm, moviesTrailerList.get(i), true, cache));
                }
            }
        }
        RealmList<com.example.new_one.Model.MoviesReviews> moviesReviewsList = ((MoviesRealmProxyInterface) newObject).realmGet$moviesReviews();
        RealmList<com.example.new_one.Model.MoviesReviews> moviesReviewsRealmList = ((MoviesRealmProxyInterface) realmObject).realmGet$moviesReviews();
        moviesReviewsRealmList.clear();
        if (moviesReviewsList != null) {
            for (int i = 0; i < moviesReviewsList.size(); i++) {
                com.example.new_one.Model.MoviesReviews moviesReviewsItem = moviesReviewsList.get(i);
                com.example.new_one.Model.MoviesReviews cachemoviesReviews = (com.example.new_one.Model.MoviesReviews) cache.get(moviesReviewsItem);
                if (cachemoviesReviews != null) {
                    moviesReviewsRealmList.add(cachemoviesReviews);
                } else {
                    moviesReviewsRealmList.add(MoviesReviewsRealmProxy.copyOrUpdate(realm, moviesReviewsList.get(i), true, cache));
                }
            }
        }
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Movies = [");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Movie_Name:");
        stringBuilder.append(realmGet$Movie_Name());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Movie_Overview:");
        stringBuilder.append(realmGet$Movie_Overview());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Movie_Img:");
        stringBuilder.append(realmGet$Movie_Img());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Moview_Year:");
        stringBuilder.append(realmGet$Moview_Year() != null ? realmGet$Moview_Year() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Favorate_Movie:");
        stringBuilder.append(realmGet$Favorate_Movie());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Movie_Type:");
        stringBuilder.append(realmGet$Movie_Type());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Moview_Rating:");
        stringBuilder.append(realmGet$Moview_Rating());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{MovieDuration:");
        stringBuilder.append(realmGet$MovieDuration());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{moviesTrailer:");
        stringBuilder.append("RealmList<MoviesTrailer>[").append(realmGet$moviesTrailer().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{moviesReviews:");
        stringBuilder.append("RealmList<MoviesReviews>[").append(realmGet$moviesReviews().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesRealmProxy aMovies = (MoviesRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aMovies.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMovies.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aMovies.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
