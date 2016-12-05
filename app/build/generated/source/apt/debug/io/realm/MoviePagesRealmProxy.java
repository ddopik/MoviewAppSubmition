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

public class MoviePagesRealmProxy extends com.example.new_one.Model.MoviePages
    implements RealmObjectProxy, MoviePagesRealmProxyInterface {

    static final class MoviePagesColumnInfo extends ColumnInfo
        implements Cloneable {

        public long page_idIndex;
        public long PageNumberIndex;

        MoviePagesColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(2);
            this.page_idIndex = getValidColumnIndex(path, table, "MoviePages", "page_id");
            indicesMap.put("page_id", this.page_idIndex);
            this.PageNumberIndex = getValidColumnIndex(path, table, "MoviePages", "PageNumber");
            indicesMap.put("PageNumber", this.PageNumberIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final MoviePagesColumnInfo otherInfo = (MoviePagesColumnInfo) other;
            this.page_idIndex = otherInfo.page_idIndex;
            this.PageNumberIndex = otherInfo.PageNumberIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final MoviePagesColumnInfo clone() {
            return (MoviePagesColumnInfo) super.clone();
        }

    }
    private MoviePagesColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("page_id");
        fieldNames.add("PageNumber");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    MoviePagesRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MoviePagesColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.example.new_one.Model.MoviePages.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public int realmGet$page_id() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.page_idIndex);
    }

    public void realmSet$page_id(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'page_id' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public int realmGet$PageNumber() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.PageNumberIndex);
    }

    public void realmSet$PageNumber(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.PageNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.PageNumberIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("MoviePages")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("MoviePages");
            realmObjectSchema.add(new Property("page_id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("PageNumber", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("MoviePages");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_MoviePages")) {
            Table table = sharedRealm.getTable("class_MoviePages");
            table.addColumn(RealmFieldType.INTEGER, "page_id", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "PageNumber", Table.NOT_NULLABLE);
            table.addSearchIndex(table.getColumnIndex("page_id"));
            table.setPrimaryKey("page_id");
            return table;
        }
        return sharedRealm.getTable("class_MoviePages");
    }

    public static MoviePagesColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_MoviePages")) {
            Table table = sharedRealm.getTable("class_MoviePages");
            final long columnCount = table.getColumnCount();
            if (columnCount != 2) {
                if (columnCount < 2) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 2 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 2 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 2 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 2; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final MoviePagesColumnInfo columnInfo = new MoviePagesColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("page_id")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'page_id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("page_id") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'page_id' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.page_idIndex) && table.findFirstNull(columnInfo.page_idIndex) != TableOrView.NO_MATCH) {
                throw new IllegalStateException("Cannot migrate an object with null value in field 'page_id'. Either maintain the same type for primary key field 'page_id', or remove the object with null value before migration.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("page_id")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'page_id' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("page_id"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'page_id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("PageNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'PageNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("PageNumber") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'PageNumber' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.PageNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'PageNumber' does support null values in the existing Realm file. Use corresponding boxed type for field 'PageNumber' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'MoviePages' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_MoviePages";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.new_one.Model.MoviePages createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.new_one.Model.MoviePages obj = null;
        if (update) {
            Table table = realm.getTable(com.example.new_one.Model.MoviePages.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (!json.isNull("page_id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("page_id"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.new_one.Model.MoviePages.class), false, Collections.<String> emptyList());
                    obj = new io.realm.MoviePagesRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("page_id")) {
                if (json.isNull("page_id")) {
                    obj = (io.realm.MoviePagesRealmProxy) realm.createObjectInternal(com.example.new_one.Model.MoviePages.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.MoviePagesRealmProxy) realm.createObjectInternal(com.example.new_one.Model.MoviePages.class, json.getInt("page_id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'page_id'.");
            }
        }
        if (json.has("PageNumber")) {
            if (json.isNull("PageNumber")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'PageNumber' to null.");
            } else {
                ((MoviePagesRealmProxyInterface) obj).realmSet$PageNumber((int) json.getInt("PageNumber"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.new_one.Model.MoviePages createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.example.new_one.Model.MoviePages obj = new com.example.new_one.Model.MoviePages();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("page_id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'page_id' to null.");
                } else {
                    ((MoviePagesRealmProxyInterface) obj).realmSet$page_id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("PageNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'PageNumber' to null.");
                } else {
                    ((MoviePagesRealmProxyInterface) obj).realmSet$PageNumber((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'page_id'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.example.new_one.Model.MoviePages copyOrUpdate(Realm realm, com.example.new_one.Model.MoviePages object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.new_one.Model.MoviePages) cachedRealmObject;
        } else {
            com.example.new_one.Model.MoviePages realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.example.new_one.Model.MoviePages.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((MoviePagesRealmProxyInterface) object).realmGet$page_id());
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.new_one.Model.MoviePages.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.MoviePagesRealmProxy();
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

    public static com.example.new_one.Model.MoviePages copy(Realm realm, com.example.new_one.Model.MoviePages newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.new_one.Model.MoviePages) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.example.new_one.Model.MoviePages realmObject = realm.createObjectInternal(com.example.new_one.Model.MoviePages.class, ((MoviePagesRealmProxyInterface) newObject).realmGet$page_id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((MoviePagesRealmProxyInterface) realmObject).realmSet$PageNumber(((MoviePagesRealmProxyInterface) newObject).realmGet$PageNumber());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.example.new_one.Model.MoviePages object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.new_one.Model.MoviePages.class);
        long tableNativePtr = table.getNativeTablePointer();
        MoviePagesColumnInfo columnInfo = (MoviePagesColumnInfo) realm.schema.getColumnInfo(com.example.new_one.Model.MoviePages.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((MoviePagesRealmProxyInterface) object).realmGet$page_id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MoviePagesRealmProxyInterface) object).realmGet$page_id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((MoviePagesRealmProxyInterface) object).realmGet$page_id(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.PageNumberIndex, rowIndex, ((MoviePagesRealmProxyInterface)object).realmGet$PageNumber(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.new_one.Model.MoviePages.class);
        long tableNativePtr = table.getNativeTablePointer();
        MoviePagesColumnInfo columnInfo = (MoviePagesColumnInfo) realm.schema.getColumnInfo(com.example.new_one.Model.MoviePages.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.new_one.Model.MoviePages object = null;
        while (objects.hasNext()) {
            object = (com.example.new_one.Model.MoviePages) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((MoviePagesRealmProxyInterface) object).realmGet$page_id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MoviePagesRealmProxyInterface) object).realmGet$page_id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((MoviePagesRealmProxyInterface) object).realmGet$page_id(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.PageNumberIndex, rowIndex, ((MoviePagesRealmProxyInterface)object).realmGet$PageNumber(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.new_one.Model.MoviePages object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.new_one.Model.MoviePages.class);
        long tableNativePtr = table.getNativeTablePointer();
        MoviePagesColumnInfo columnInfo = (MoviePagesColumnInfo) realm.schema.getColumnInfo(com.example.new_one.Model.MoviePages.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((MoviePagesRealmProxyInterface) object).realmGet$page_id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MoviePagesRealmProxyInterface) object).realmGet$page_id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((MoviePagesRealmProxyInterface) object).realmGet$page_id(), false);
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.PageNumberIndex, rowIndex, ((MoviePagesRealmProxyInterface)object).realmGet$PageNumber(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.new_one.Model.MoviePages.class);
        long tableNativePtr = table.getNativeTablePointer();
        MoviePagesColumnInfo columnInfo = (MoviePagesColumnInfo) realm.schema.getColumnInfo(com.example.new_one.Model.MoviePages.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.new_one.Model.MoviePages object = null;
        while (objects.hasNext()) {
            object = (com.example.new_one.Model.MoviePages) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((MoviePagesRealmProxyInterface) object).realmGet$page_id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MoviePagesRealmProxyInterface) object).realmGet$page_id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((MoviePagesRealmProxyInterface) object).realmGet$page_id(), false);
                }
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.PageNumberIndex, rowIndex, ((MoviePagesRealmProxyInterface)object).realmGet$PageNumber(), false);
            }
        }
    }

    public static com.example.new_one.Model.MoviePages createDetachedCopy(com.example.new_one.Model.MoviePages realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.new_one.Model.MoviePages unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.new_one.Model.MoviePages)cachedObject.object;
            } else {
                unmanagedObject = (com.example.new_one.Model.MoviePages)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.example.new_one.Model.MoviePages();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((MoviePagesRealmProxyInterface) unmanagedObject).realmSet$page_id(((MoviePagesRealmProxyInterface) realmObject).realmGet$page_id());
        ((MoviePagesRealmProxyInterface) unmanagedObject).realmSet$PageNumber(((MoviePagesRealmProxyInterface) realmObject).realmGet$PageNumber());
        return unmanagedObject;
    }

    static com.example.new_one.Model.MoviePages update(Realm realm, com.example.new_one.Model.MoviePages realmObject, com.example.new_one.Model.MoviePages newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((MoviePagesRealmProxyInterface) realmObject).realmSet$PageNumber(((MoviePagesRealmProxyInterface) newObject).realmGet$PageNumber());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("MoviePages = [");
        stringBuilder.append("{page_id:");
        stringBuilder.append(realmGet$page_id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{PageNumber:");
        stringBuilder.append(realmGet$PageNumber());
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
        MoviePagesRealmProxy aMoviePages = (MoviePagesRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aMoviePages.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMoviePages.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aMoviePages.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
