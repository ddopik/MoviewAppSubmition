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

public class MoviesFavouratesRealmProxy extends com.example.new_one.Model.MoviesFavourates
    implements RealmObjectProxy, MoviesFavouratesRealmProxyInterface {

    static final class MoviesFavouratesColumnInfo extends ColumnInfo
        implements Cloneable {

        public long Movie_IDIndex;
        public long Favourates_MoviesIndex;
        public long MovieIndex;

        MoviesFavouratesColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(3);
            this.Movie_IDIndex = getValidColumnIndex(path, table, "MoviesFavourates", "Movie_ID");
            indicesMap.put("Movie_ID", this.Movie_IDIndex);
            this.Favourates_MoviesIndex = getValidColumnIndex(path, table, "MoviesFavourates", "Favourates_Movies");
            indicesMap.put("Favourates_Movies", this.Favourates_MoviesIndex);
            this.MovieIndex = getValidColumnIndex(path, table, "MoviesFavourates", "Movie");
            indicesMap.put("Movie", this.MovieIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final MoviesFavouratesColumnInfo otherInfo = (MoviesFavouratesColumnInfo) other;
            this.Movie_IDIndex = otherInfo.Movie_IDIndex;
            this.Favourates_MoviesIndex = otherInfo.Favourates_MoviesIndex;
            this.MovieIndex = otherInfo.MovieIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final MoviesFavouratesColumnInfo clone() {
            return (MoviesFavouratesColumnInfo) super.clone();
        }

    }
    private MoviesFavouratesColumnInfo columnInfo;
    private ProxyState proxyState;
    private RealmList<com.example.new_one.Model.Movies> MovieRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("Movie_ID");
        fieldNames.add("Favourates_Movies");
        fieldNames.add("Movie");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    MoviesFavouratesRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MoviesFavouratesColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.example.new_one.Model.MoviesFavourates.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public int realmGet$Movie_ID() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.Movie_IDIndex);
    }

    public void realmSet$Movie_ID(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'Movie_ID' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public Boolean realmGet$Favourates_Movies() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.Favourates_MoviesIndex);
    }

    public void realmSet$Favourates_Movies(Boolean value) {
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
                throw new IllegalArgumentException("Trying to set non-nullable field 'Favourates_Movies' to null.");
            }
            row.getTable().setBoolean(columnInfo.Favourates_MoviesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'Favourates_Movies' to null.");
        }
        proxyState.getRow$realm().setBoolean(columnInfo.Favourates_MoviesIndex, value);
    }

    public RealmList<com.example.new_one.Model.Movies> realmGet$Movie() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (MovieRealmList != null) {
            return MovieRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.MovieIndex);
            MovieRealmList = new RealmList<com.example.new_one.Model.Movies>(com.example.new_one.Model.Movies.class, linkView, proxyState.getRealm$realm());
            return MovieRealmList;
        }
    }

    public void realmSet$Movie(RealmList<com.example.new_one.Model.Movies> value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("Movie")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.example.new_one.Model.Movies> original = value;
                value = new RealmList<com.example.new_one.Model.Movies>();
                for (com.example.new_one.Model.Movies item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.MovieIndex);
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
        if (!realmSchema.contains("MoviesFavourates")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("MoviesFavourates");
            realmObjectSchema.add(new Property("Movie_ID", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("Favourates_Movies", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            if (!realmSchema.contains("Movies")) {
                MoviesRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add(new Property("Movie", RealmFieldType.LIST, realmSchema.get("Movies")));
            return realmObjectSchema;
        }
        return realmSchema.get("MoviesFavourates");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_MoviesFavourates")) {
            Table table = sharedRealm.getTable("class_MoviesFavourates");
            table.addColumn(RealmFieldType.INTEGER, "Movie_ID", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "Favourates_Movies", Table.NOT_NULLABLE);
            if (!sharedRealm.hasTable("class_Movies")) {
                MoviesRealmProxy.initTable(sharedRealm);
            }
            table.addColumnLink(RealmFieldType.LIST, "Movie", sharedRealm.getTable("class_Movies"));
            table.addSearchIndex(table.getColumnIndex("Movie_ID"));
            table.setPrimaryKey("Movie_ID");
            return table;
        }
        return sharedRealm.getTable("class_MoviesFavourates");
    }

    public static MoviesFavouratesColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_MoviesFavourates")) {
            Table table = sharedRealm.getTable("class_MoviesFavourates");
            final long columnCount = table.getColumnCount();
            if (columnCount != 3) {
                if (columnCount < 3) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 3 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 3 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 3 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 3; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final MoviesFavouratesColumnInfo columnInfo = new MoviesFavouratesColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("Movie_ID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'Movie_ID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("Movie_ID") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'Movie_ID' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.Movie_IDIndex) && table.findFirstNull(columnInfo.Movie_IDIndex) != TableOrView.NO_MATCH) {
                throw new IllegalStateException("Cannot migrate an object with null value in field 'Movie_ID'. Either maintain the same type for primary key field 'Movie_ID', or remove the object with null value before migration.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("Movie_ID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'Movie_ID' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("Movie_ID"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'Movie_ID' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("Favourates_Movies")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'Favourates_Movies' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("Favourates_Movies") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'Favourates_Movies' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.Favourates_MoviesIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'Favourates_Movies' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'Favourates_Movies' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("Movie")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'Movie'");
            }
            if (columnTypes.get("Movie") != RealmFieldType.LIST) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Movies' for field 'Movie'");
            }
            if (!sharedRealm.hasTable("class_Movies")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_Movies' for field 'Movie'");
            }
            Table table_2 = sharedRealm.getTable("class_Movies");
            if (!table.getLinkTarget(columnInfo.MovieIndex).hasSameSchema(table_2)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'Movie': '" + table.getLinkTarget(columnInfo.MovieIndex).getName() + "' expected - was '" + table_2.getName() + "'");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'MoviesFavourates' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_MoviesFavourates";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.new_one.Model.MoviesFavourates createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.example.new_one.Model.MoviesFavourates obj = null;
        if (update) {
            Table table = realm.getTable(com.example.new_one.Model.MoviesFavourates.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (!json.isNull("Movie_ID")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("Movie_ID"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.new_one.Model.MoviesFavourates.class), false, Collections.<String> emptyList());
                    obj = new io.realm.MoviesFavouratesRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("Movie")) {
                excludeFields.add("Movie");
            }
            if (json.has("Movie_ID")) {
                if (json.isNull("Movie_ID")) {
                    obj = (io.realm.MoviesFavouratesRealmProxy) realm.createObjectInternal(com.example.new_one.Model.MoviesFavourates.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.MoviesFavouratesRealmProxy) realm.createObjectInternal(com.example.new_one.Model.MoviesFavourates.class, json.getInt("Movie_ID"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'Movie_ID'.");
            }
        }
        if (json.has("Favourates_Movies")) {
            if (json.isNull("Favourates_Movies")) {
                ((MoviesFavouratesRealmProxyInterface) obj).realmSet$Favourates_Movies(null);
            } else {
                ((MoviesFavouratesRealmProxyInterface) obj).realmSet$Favourates_Movies((boolean) json.getBoolean("Favourates_Movies"));
            }
        }
        if (json.has("Movie")) {
            if (json.isNull("Movie")) {
                ((MoviesFavouratesRealmProxyInterface) obj).realmSet$Movie(null);
            } else {
                ((MoviesFavouratesRealmProxyInterface) obj).realmGet$Movie().clear();
                JSONArray array = json.getJSONArray("Movie");
                for (int i = 0; i < array.length(); i++) {
                    com.example.new_one.Model.Movies item = MoviesRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((MoviesFavouratesRealmProxyInterface) obj).realmGet$Movie().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.new_one.Model.MoviesFavourates createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.example.new_one.Model.MoviesFavourates obj = new com.example.new_one.Model.MoviesFavourates();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("Movie_ID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'Movie_ID' to null.");
                } else {
                    ((MoviesFavouratesRealmProxyInterface) obj).realmSet$Movie_ID((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("Favourates_Movies")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MoviesFavouratesRealmProxyInterface) obj).realmSet$Favourates_Movies(null);
                } else {
                    ((MoviesFavouratesRealmProxyInterface) obj).realmSet$Favourates_Movies((boolean) reader.nextBoolean());
                }
            } else if (name.equals("Movie")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MoviesFavouratesRealmProxyInterface) obj).realmSet$Movie(null);
                } else {
                    ((MoviesFavouratesRealmProxyInterface) obj).realmSet$Movie(new RealmList<com.example.new_one.Model.Movies>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.example.new_one.Model.Movies item = MoviesRealmProxy.createUsingJsonStream(realm, reader);
                        ((MoviesFavouratesRealmProxyInterface) obj).realmGet$Movie().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'Movie_ID'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.example.new_one.Model.MoviesFavourates copyOrUpdate(Realm realm, com.example.new_one.Model.MoviesFavourates object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.new_one.Model.MoviesFavourates) cachedRealmObject;
        } else {
            com.example.new_one.Model.MoviesFavourates realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.example.new_one.Model.MoviesFavourates.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((MoviesFavouratesRealmProxyInterface) object).realmGet$Movie_ID());
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.new_one.Model.MoviesFavourates.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.MoviesFavouratesRealmProxy();
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

    public static com.example.new_one.Model.MoviesFavourates copy(Realm realm, com.example.new_one.Model.MoviesFavourates newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.new_one.Model.MoviesFavourates) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.example.new_one.Model.MoviesFavourates realmObject = realm.createObjectInternal(com.example.new_one.Model.MoviesFavourates.class, ((MoviesFavouratesRealmProxyInterface) newObject).realmGet$Movie_ID(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((MoviesFavouratesRealmProxyInterface) realmObject).realmSet$Favourates_Movies(((MoviesFavouratesRealmProxyInterface) newObject).realmGet$Favourates_Movies());

            RealmList<com.example.new_one.Model.Movies> MovieList = ((MoviesFavouratesRealmProxyInterface) newObject).realmGet$Movie();
            if (MovieList != null) {
                RealmList<com.example.new_one.Model.Movies> MovieRealmList = ((MoviesFavouratesRealmProxyInterface) realmObject).realmGet$Movie();
                for (int i = 0; i < MovieList.size(); i++) {
                    com.example.new_one.Model.Movies MovieItem = MovieList.get(i);
                    com.example.new_one.Model.Movies cacheMovie = (com.example.new_one.Model.Movies) cache.get(MovieItem);
                    if (cacheMovie != null) {
                        MovieRealmList.add(cacheMovie);
                    } else {
                        MovieRealmList.add(MoviesRealmProxy.copyOrUpdate(realm, MovieList.get(i), update, cache));
                    }
                }
            }

            return realmObject;
        }
    }

    public static long insert(Realm realm, com.example.new_one.Model.MoviesFavourates object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.new_one.Model.MoviesFavourates.class);
        long tableNativePtr = table.getNativeTablePointer();
        MoviesFavouratesColumnInfo columnInfo = (MoviesFavouratesColumnInfo) realm.schema.getColumnInfo(com.example.new_one.Model.MoviesFavourates.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((MoviesFavouratesRealmProxyInterface) object).realmGet$Movie_ID();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MoviesFavouratesRealmProxyInterface) object).realmGet$Movie_ID());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((MoviesFavouratesRealmProxyInterface) object).realmGet$Movie_ID(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Boolean realmGet$Favourates_Movies = ((MoviesFavouratesRealmProxyInterface)object).realmGet$Favourates_Movies();
        if (realmGet$Favourates_Movies != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.Favourates_MoviesIndex, rowIndex, realmGet$Favourates_Movies, false);
        }

        RealmList<com.example.new_one.Model.Movies> MovieList = ((MoviesFavouratesRealmProxyInterface) object).realmGet$Movie();
        if (MovieList != null) {
            long MovieNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.MovieIndex, rowIndex);
            for (com.example.new_one.Model.Movies MovieItem : MovieList) {
                Long cacheItemIndexMovie = cache.get(MovieItem);
                if (cacheItemIndexMovie == null) {
                    cacheItemIndexMovie = MoviesRealmProxy.insert(realm, MovieItem, cache);
                }
                LinkView.nativeAdd(MovieNativeLinkViewPtr, cacheItemIndexMovie);
            }
            LinkView.nativeClose(MovieNativeLinkViewPtr);
        }

        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.new_one.Model.MoviesFavourates.class);
        long tableNativePtr = table.getNativeTablePointer();
        MoviesFavouratesColumnInfo columnInfo = (MoviesFavouratesColumnInfo) realm.schema.getColumnInfo(com.example.new_one.Model.MoviesFavourates.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.new_one.Model.MoviesFavourates object = null;
        while (objects.hasNext()) {
            object = (com.example.new_one.Model.MoviesFavourates) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((MoviesFavouratesRealmProxyInterface) object).realmGet$Movie_ID();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MoviesFavouratesRealmProxyInterface) object).realmGet$Movie_ID());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((MoviesFavouratesRealmProxyInterface) object).realmGet$Movie_ID(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                Boolean realmGet$Favourates_Movies = ((MoviesFavouratesRealmProxyInterface)object).realmGet$Favourates_Movies();
                if (realmGet$Favourates_Movies != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.Favourates_MoviesIndex, rowIndex, realmGet$Favourates_Movies, false);
                }

                RealmList<com.example.new_one.Model.Movies> MovieList = ((MoviesFavouratesRealmProxyInterface) object).realmGet$Movie();
                if (MovieList != null) {
                    long MovieNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.MovieIndex, rowIndex);
                    for (com.example.new_one.Model.Movies MovieItem : MovieList) {
                        Long cacheItemIndexMovie = cache.get(MovieItem);
                        if (cacheItemIndexMovie == null) {
                            cacheItemIndexMovie = MoviesRealmProxy.insert(realm, MovieItem, cache);
                        }
                        LinkView.nativeAdd(MovieNativeLinkViewPtr, cacheItemIndexMovie);
                    }
                    LinkView.nativeClose(MovieNativeLinkViewPtr);
                }

            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.new_one.Model.MoviesFavourates object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.new_one.Model.MoviesFavourates.class);
        long tableNativePtr = table.getNativeTablePointer();
        MoviesFavouratesColumnInfo columnInfo = (MoviesFavouratesColumnInfo) realm.schema.getColumnInfo(com.example.new_one.Model.MoviesFavourates.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((MoviesFavouratesRealmProxyInterface) object).realmGet$Movie_ID();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MoviesFavouratesRealmProxyInterface) object).realmGet$Movie_ID());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((MoviesFavouratesRealmProxyInterface) object).realmGet$Movie_ID(), false);
        }
        cache.put(object, rowIndex);
        Boolean realmGet$Favourates_Movies = ((MoviesFavouratesRealmProxyInterface)object).realmGet$Favourates_Movies();
        if (realmGet$Favourates_Movies != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.Favourates_MoviesIndex, rowIndex, realmGet$Favourates_Movies, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.Favourates_MoviesIndex, rowIndex, false);
        }

        long MovieNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.MovieIndex, rowIndex);
        LinkView.nativeClear(MovieNativeLinkViewPtr);
        RealmList<com.example.new_one.Model.Movies> MovieList = ((MoviesFavouratesRealmProxyInterface) object).realmGet$Movie();
        if (MovieList != null) {
            for (com.example.new_one.Model.Movies MovieItem : MovieList) {
                Long cacheItemIndexMovie = cache.get(MovieItem);
                if (cacheItemIndexMovie == null) {
                    cacheItemIndexMovie = MoviesRealmProxy.insertOrUpdate(realm, MovieItem, cache);
                }
                LinkView.nativeAdd(MovieNativeLinkViewPtr, cacheItemIndexMovie);
            }
        }
        LinkView.nativeClose(MovieNativeLinkViewPtr);

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.new_one.Model.MoviesFavourates.class);
        long tableNativePtr = table.getNativeTablePointer();
        MoviesFavouratesColumnInfo columnInfo = (MoviesFavouratesColumnInfo) realm.schema.getColumnInfo(com.example.new_one.Model.MoviesFavourates.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.new_one.Model.MoviesFavourates object = null;
        while (objects.hasNext()) {
            object = (com.example.new_one.Model.MoviesFavourates) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((MoviesFavouratesRealmProxyInterface) object).realmGet$Movie_ID();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MoviesFavouratesRealmProxyInterface) object).realmGet$Movie_ID());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((MoviesFavouratesRealmProxyInterface) object).realmGet$Movie_ID(), false);
                }
                cache.put(object, rowIndex);
                Boolean realmGet$Favourates_Movies = ((MoviesFavouratesRealmProxyInterface)object).realmGet$Favourates_Movies();
                if (realmGet$Favourates_Movies != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.Favourates_MoviesIndex, rowIndex, realmGet$Favourates_Movies, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.Favourates_MoviesIndex, rowIndex, false);
                }

                long MovieNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.MovieIndex, rowIndex);
                LinkView.nativeClear(MovieNativeLinkViewPtr);
                RealmList<com.example.new_one.Model.Movies> MovieList = ((MoviesFavouratesRealmProxyInterface) object).realmGet$Movie();
                if (MovieList != null) {
                    for (com.example.new_one.Model.Movies MovieItem : MovieList) {
                        Long cacheItemIndexMovie = cache.get(MovieItem);
                        if (cacheItemIndexMovie == null) {
                            cacheItemIndexMovie = MoviesRealmProxy.insertOrUpdate(realm, MovieItem, cache);
                        }
                        LinkView.nativeAdd(MovieNativeLinkViewPtr, cacheItemIndexMovie);
                    }
                }
                LinkView.nativeClose(MovieNativeLinkViewPtr);

            }
        }
    }

    public static com.example.new_one.Model.MoviesFavourates createDetachedCopy(com.example.new_one.Model.MoviesFavourates realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.new_one.Model.MoviesFavourates unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.new_one.Model.MoviesFavourates)cachedObject.object;
            } else {
                unmanagedObject = (com.example.new_one.Model.MoviesFavourates)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.example.new_one.Model.MoviesFavourates();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((MoviesFavouratesRealmProxyInterface) unmanagedObject).realmSet$Movie_ID(((MoviesFavouratesRealmProxyInterface) realmObject).realmGet$Movie_ID());
        ((MoviesFavouratesRealmProxyInterface) unmanagedObject).realmSet$Favourates_Movies(((MoviesFavouratesRealmProxyInterface) realmObject).realmGet$Favourates_Movies());

        // Deep copy of Movie
        if (currentDepth == maxDepth) {
            ((MoviesFavouratesRealmProxyInterface) unmanagedObject).realmSet$Movie(null);
        } else {
            RealmList<com.example.new_one.Model.Movies> managedMovieList = ((MoviesFavouratesRealmProxyInterface) realmObject).realmGet$Movie();
            RealmList<com.example.new_one.Model.Movies> unmanagedMovieList = new RealmList<com.example.new_one.Model.Movies>();
            ((MoviesFavouratesRealmProxyInterface) unmanagedObject).realmSet$Movie(unmanagedMovieList);
            int nextDepth = currentDepth + 1;
            int size = managedMovieList.size();
            for (int i = 0; i < size; i++) {
                com.example.new_one.Model.Movies item = MoviesRealmProxy.createDetachedCopy(managedMovieList.get(i), nextDepth, maxDepth, cache);
                unmanagedMovieList.add(item);
            }
        }
        return unmanagedObject;
    }

    static com.example.new_one.Model.MoviesFavourates update(Realm realm, com.example.new_one.Model.MoviesFavourates realmObject, com.example.new_one.Model.MoviesFavourates newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((MoviesFavouratesRealmProxyInterface) realmObject).realmSet$Favourates_Movies(((MoviesFavouratesRealmProxyInterface) newObject).realmGet$Favourates_Movies());
        RealmList<com.example.new_one.Model.Movies> MovieList = ((MoviesFavouratesRealmProxyInterface) newObject).realmGet$Movie();
        RealmList<com.example.new_one.Model.Movies> MovieRealmList = ((MoviesFavouratesRealmProxyInterface) realmObject).realmGet$Movie();
        MovieRealmList.clear();
        if (MovieList != null) {
            for (int i = 0; i < MovieList.size(); i++) {
                com.example.new_one.Model.Movies MovieItem = MovieList.get(i);
                com.example.new_one.Model.Movies cacheMovie = (com.example.new_one.Model.Movies) cache.get(MovieItem);
                if (cacheMovie != null) {
                    MovieRealmList.add(cacheMovie);
                } else {
                    MovieRealmList.add(MoviesRealmProxy.copyOrUpdate(realm, MovieList.get(i), true, cache));
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
        StringBuilder stringBuilder = new StringBuilder("MoviesFavourates = [");
        stringBuilder.append("{Movie_ID:");
        stringBuilder.append(realmGet$Movie_ID());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Favourates_Movies:");
        stringBuilder.append(realmGet$Favourates_Movies());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Movie:");
        stringBuilder.append("RealmList<Movies>[").append(realmGet$Movie().size()).append("]");
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
        MoviesFavouratesRealmProxy aMoviesFavourates = (MoviesFavouratesRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aMoviesFavourates.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMoviesFavourates.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aMoviesFavourates.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
