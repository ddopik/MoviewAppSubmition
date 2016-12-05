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

public class MoviesTrailerRealmProxy extends com.example.new_one.Model.MoviesTrailer
    implements RealmObjectProxy, MoviesTrailerRealmProxyInterface {

    static final class MoviesTrailerColumnInfo extends ColumnInfo
        implements Cloneable {

        public long trailIDIndex;
        public long trailKeyIndex;
        public long trailNameIndex;
        public long movieIDIndex;

        MoviesTrailerColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(4);
            this.trailIDIndex = getValidColumnIndex(path, table, "MoviesTrailer", "trailID");
            indicesMap.put("trailID", this.trailIDIndex);
            this.trailKeyIndex = getValidColumnIndex(path, table, "MoviesTrailer", "trailKey");
            indicesMap.put("trailKey", this.trailKeyIndex);
            this.trailNameIndex = getValidColumnIndex(path, table, "MoviesTrailer", "trailName");
            indicesMap.put("trailName", this.trailNameIndex);
            this.movieIDIndex = getValidColumnIndex(path, table, "MoviesTrailer", "movieID");
            indicesMap.put("movieID", this.movieIDIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final MoviesTrailerColumnInfo otherInfo = (MoviesTrailerColumnInfo) other;
            this.trailIDIndex = otherInfo.trailIDIndex;
            this.trailKeyIndex = otherInfo.trailKeyIndex;
            this.trailNameIndex = otherInfo.trailNameIndex;
            this.movieIDIndex = otherInfo.movieIDIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final MoviesTrailerColumnInfo clone() {
            return (MoviesTrailerColumnInfo) super.clone();
        }

    }
    private MoviesTrailerColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("trailID");
        fieldNames.add("trailKey");
        fieldNames.add("trailName");
        fieldNames.add("movieID");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    MoviesTrailerRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MoviesTrailerColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.example.new_one.Model.MoviesTrailer.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$trailID() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.trailIDIndex);
    }

    public void realmSet$trailID(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'trailID' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$trailKey() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.trailKeyIndex);
    }

    public void realmSet$trailKey(String value) {
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
                throw new IllegalArgumentException("Trying to set non-nullable field 'trailKey' to null.");
            }
            row.getTable().setString(columnInfo.trailKeyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'trailKey' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.trailKeyIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$trailName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.trailNameIndex);
    }

    public void realmSet$trailName(String value) {
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
                throw new IllegalArgumentException("Trying to set non-nullable field 'trailName' to null.");
            }
            row.getTable().setString(columnInfo.trailNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'trailName' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.trailNameIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$movieID() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.movieIDIndex);
    }

    public void realmSet$movieID(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.movieIDIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.movieIDIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("MoviesTrailer")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("MoviesTrailer");
            realmObjectSchema.add(new Property("trailID", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("trailKey", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("trailName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("movieID", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("MoviesTrailer");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_MoviesTrailer")) {
            Table table = sharedRealm.getTable("class_MoviesTrailer");
            table.addColumn(RealmFieldType.STRING, "trailID", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "trailKey", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "trailName", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "movieID", Table.NOT_NULLABLE);
            table.addSearchIndex(table.getColumnIndex("trailID"));
            table.setPrimaryKey("trailID");
            return table;
        }
        return sharedRealm.getTable("class_MoviesTrailer");
    }

    public static MoviesTrailerColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_MoviesTrailer")) {
            Table table = sharedRealm.getTable("class_MoviesTrailer");
            final long columnCount = table.getColumnCount();
            if (columnCount != 4) {
                if (columnCount < 4) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 4 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 4 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 4 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 4; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final MoviesTrailerColumnInfo columnInfo = new MoviesTrailerColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("trailID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'trailID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("trailID") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'trailID' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.trailIDIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'trailID' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("trailID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'trailID' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("trailID"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'trailID' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("trailKey")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'trailKey' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("trailKey") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'trailKey' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.trailKeyIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'trailKey' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'trailKey' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("trailName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'trailName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("trailName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'trailName' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.trailNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'trailName' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'trailName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("movieID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'movieID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("movieID") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'movieID' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.movieIDIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'movieID' does support null values in the existing Realm file. Use corresponding boxed type for field 'movieID' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'MoviesTrailer' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_MoviesTrailer";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.new_one.Model.MoviesTrailer createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.new_one.Model.MoviesTrailer obj = null;
        if (update) {
            Table table = realm.getTable(com.example.new_one.Model.MoviesTrailer.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("trailID")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("trailID"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.new_one.Model.MoviesTrailer.class), false, Collections.<String> emptyList());
                    obj = new io.realm.MoviesTrailerRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("trailID")) {
                if (json.isNull("trailID")) {
                    obj = (io.realm.MoviesTrailerRealmProxy) realm.createObjectInternal(com.example.new_one.Model.MoviesTrailer.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.MoviesTrailerRealmProxy) realm.createObjectInternal(com.example.new_one.Model.MoviesTrailer.class, json.getString("trailID"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'trailID'.");
            }
        }
        if (json.has("trailKey")) {
            if (json.isNull("trailKey")) {
                ((MoviesTrailerRealmProxyInterface) obj).realmSet$trailKey(null);
            } else {
                ((MoviesTrailerRealmProxyInterface) obj).realmSet$trailKey((String) json.getString("trailKey"));
            }
        }
        if (json.has("trailName")) {
            if (json.isNull("trailName")) {
                ((MoviesTrailerRealmProxyInterface) obj).realmSet$trailName(null);
            } else {
                ((MoviesTrailerRealmProxyInterface) obj).realmSet$trailName((String) json.getString("trailName"));
            }
        }
        if (json.has("movieID")) {
            if (json.isNull("movieID")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'movieID' to null.");
            } else {
                ((MoviesTrailerRealmProxyInterface) obj).realmSet$movieID((int) json.getInt("movieID"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.new_one.Model.MoviesTrailer createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.example.new_one.Model.MoviesTrailer obj = new com.example.new_one.Model.MoviesTrailer();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("trailID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MoviesTrailerRealmProxyInterface) obj).realmSet$trailID(null);
                } else {
                    ((MoviesTrailerRealmProxyInterface) obj).realmSet$trailID((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("trailKey")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MoviesTrailerRealmProxyInterface) obj).realmSet$trailKey(null);
                } else {
                    ((MoviesTrailerRealmProxyInterface) obj).realmSet$trailKey((String) reader.nextString());
                }
            } else if (name.equals("trailName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MoviesTrailerRealmProxyInterface) obj).realmSet$trailName(null);
                } else {
                    ((MoviesTrailerRealmProxyInterface) obj).realmSet$trailName((String) reader.nextString());
                }
            } else if (name.equals("movieID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'movieID' to null.");
                } else {
                    ((MoviesTrailerRealmProxyInterface) obj).realmSet$movieID((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'trailID'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.example.new_one.Model.MoviesTrailer copyOrUpdate(Realm realm, com.example.new_one.Model.MoviesTrailer object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.new_one.Model.MoviesTrailer) cachedRealmObject;
        } else {
            com.example.new_one.Model.MoviesTrailer realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.example.new_one.Model.MoviesTrailer.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((MoviesTrailerRealmProxyInterface) object).realmGet$trailID();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.new_one.Model.MoviesTrailer.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.MoviesTrailerRealmProxy();
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

    public static com.example.new_one.Model.MoviesTrailer copy(Realm realm, com.example.new_one.Model.MoviesTrailer newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.new_one.Model.MoviesTrailer) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.example.new_one.Model.MoviesTrailer realmObject = realm.createObjectInternal(com.example.new_one.Model.MoviesTrailer.class, ((MoviesTrailerRealmProxyInterface) newObject).realmGet$trailID(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((MoviesTrailerRealmProxyInterface) realmObject).realmSet$trailKey(((MoviesTrailerRealmProxyInterface) newObject).realmGet$trailKey());
            ((MoviesTrailerRealmProxyInterface) realmObject).realmSet$trailName(((MoviesTrailerRealmProxyInterface) newObject).realmGet$trailName());
            ((MoviesTrailerRealmProxyInterface) realmObject).realmSet$movieID(((MoviesTrailerRealmProxyInterface) newObject).realmGet$movieID());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.example.new_one.Model.MoviesTrailer object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.new_one.Model.MoviesTrailer.class);
        long tableNativePtr = table.getNativeTablePointer();
        MoviesTrailerColumnInfo columnInfo = (MoviesTrailerColumnInfo) realm.schema.getColumnInfo(com.example.new_one.Model.MoviesTrailer.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((MoviesTrailerRealmProxyInterface) object).realmGet$trailID();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$trailKey = ((MoviesTrailerRealmProxyInterface)object).realmGet$trailKey();
        if (realmGet$trailKey != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.trailKeyIndex, rowIndex, realmGet$trailKey, false);
        }
        String realmGet$trailName = ((MoviesTrailerRealmProxyInterface)object).realmGet$trailName();
        if (realmGet$trailName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.trailNameIndex, rowIndex, realmGet$trailName, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.movieIDIndex, rowIndex, ((MoviesTrailerRealmProxyInterface)object).realmGet$movieID(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.new_one.Model.MoviesTrailer.class);
        long tableNativePtr = table.getNativeTablePointer();
        MoviesTrailerColumnInfo columnInfo = (MoviesTrailerColumnInfo) realm.schema.getColumnInfo(com.example.new_one.Model.MoviesTrailer.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.new_one.Model.MoviesTrailer object = null;
        while (objects.hasNext()) {
            object = (com.example.new_one.Model.MoviesTrailer) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((MoviesTrailerRealmProxyInterface) object).realmGet$trailID();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$trailKey = ((MoviesTrailerRealmProxyInterface)object).realmGet$trailKey();
                if (realmGet$trailKey != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.trailKeyIndex, rowIndex, realmGet$trailKey, false);
                }
                String realmGet$trailName = ((MoviesTrailerRealmProxyInterface)object).realmGet$trailName();
                if (realmGet$trailName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.trailNameIndex, rowIndex, realmGet$trailName, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.movieIDIndex, rowIndex, ((MoviesTrailerRealmProxyInterface)object).realmGet$movieID(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.new_one.Model.MoviesTrailer object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.new_one.Model.MoviesTrailer.class);
        long tableNativePtr = table.getNativeTablePointer();
        MoviesTrailerColumnInfo columnInfo = (MoviesTrailerColumnInfo) realm.schema.getColumnInfo(com.example.new_one.Model.MoviesTrailer.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((MoviesTrailerRealmProxyInterface) object).realmGet$trailID();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        }
        cache.put(object, rowIndex);
        String realmGet$trailKey = ((MoviesTrailerRealmProxyInterface)object).realmGet$trailKey();
        if (realmGet$trailKey != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.trailKeyIndex, rowIndex, realmGet$trailKey, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.trailKeyIndex, rowIndex, false);
        }
        String realmGet$trailName = ((MoviesTrailerRealmProxyInterface)object).realmGet$trailName();
        if (realmGet$trailName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.trailNameIndex, rowIndex, realmGet$trailName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.trailNameIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.movieIDIndex, rowIndex, ((MoviesTrailerRealmProxyInterface)object).realmGet$movieID(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.new_one.Model.MoviesTrailer.class);
        long tableNativePtr = table.getNativeTablePointer();
        MoviesTrailerColumnInfo columnInfo = (MoviesTrailerColumnInfo) realm.schema.getColumnInfo(com.example.new_one.Model.MoviesTrailer.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.new_one.Model.MoviesTrailer object = null;
        while (objects.hasNext()) {
            object = (com.example.new_one.Model.MoviesTrailer) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((MoviesTrailerRealmProxyInterface) object).realmGet$trailID();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                }
                cache.put(object, rowIndex);
                String realmGet$trailKey = ((MoviesTrailerRealmProxyInterface)object).realmGet$trailKey();
                if (realmGet$trailKey != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.trailKeyIndex, rowIndex, realmGet$trailKey, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.trailKeyIndex, rowIndex, false);
                }
                String realmGet$trailName = ((MoviesTrailerRealmProxyInterface)object).realmGet$trailName();
                if (realmGet$trailName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.trailNameIndex, rowIndex, realmGet$trailName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.trailNameIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.movieIDIndex, rowIndex, ((MoviesTrailerRealmProxyInterface)object).realmGet$movieID(), false);
            }
        }
    }

    public static com.example.new_one.Model.MoviesTrailer createDetachedCopy(com.example.new_one.Model.MoviesTrailer realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.new_one.Model.MoviesTrailer unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.new_one.Model.MoviesTrailer)cachedObject.object;
            } else {
                unmanagedObject = (com.example.new_one.Model.MoviesTrailer)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.example.new_one.Model.MoviesTrailer();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((MoviesTrailerRealmProxyInterface) unmanagedObject).realmSet$trailID(((MoviesTrailerRealmProxyInterface) realmObject).realmGet$trailID());
        ((MoviesTrailerRealmProxyInterface) unmanagedObject).realmSet$trailKey(((MoviesTrailerRealmProxyInterface) realmObject).realmGet$trailKey());
        ((MoviesTrailerRealmProxyInterface) unmanagedObject).realmSet$trailName(((MoviesTrailerRealmProxyInterface) realmObject).realmGet$trailName());
        ((MoviesTrailerRealmProxyInterface) unmanagedObject).realmSet$movieID(((MoviesTrailerRealmProxyInterface) realmObject).realmGet$movieID());
        return unmanagedObject;
    }

    static com.example.new_one.Model.MoviesTrailer update(Realm realm, com.example.new_one.Model.MoviesTrailer realmObject, com.example.new_one.Model.MoviesTrailer newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((MoviesTrailerRealmProxyInterface) realmObject).realmSet$trailKey(((MoviesTrailerRealmProxyInterface) newObject).realmGet$trailKey());
        ((MoviesTrailerRealmProxyInterface) realmObject).realmSet$trailName(((MoviesTrailerRealmProxyInterface) newObject).realmGet$trailName());
        ((MoviesTrailerRealmProxyInterface) realmObject).realmSet$movieID(((MoviesTrailerRealmProxyInterface) newObject).realmGet$movieID());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("MoviesTrailer = [");
        stringBuilder.append("{trailID:");
        stringBuilder.append(realmGet$trailID() != null ? realmGet$trailID() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{trailKey:");
        stringBuilder.append(realmGet$trailKey());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{trailName:");
        stringBuilder.append(realmGet$trailName());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{movieID:");
        stringBuilder.append(realmGet$movieID());
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
        MoviesTrailerRealmProxy aMoviesTrailer = (MoviesTrailerRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aMoviesTrailer.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMoviesTrailer.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aMoviesTrailer.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
