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

public class MoviesReviewsRealmProxy extends com.example.new_one.Model.MoviesReviews
    implements RealmObjectProxy, MoviesReviewsRealmProxyInterface {

    static final class MoviesReviewsColumnInfo extends ColumnInfo
        implements Cloneable {

        public long revIdIndex;
        public long authorIndex;
        public long contentIndex;
        public long movieIDIndex;

        MoviesReviewsColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(4);
            this.revIdIndex = getValidColumnIndex(path, table, "MoviesReviews", "revId");
            indicesMap.put("revId", this.revIdIndex);
            this.authorIndex = getValidColumnIndex(path, table, "MoviesReviews", "author");
            indicesMap.put("author", this.authorIndex);
            this.contentIndex = getValidColumnIndex(path, table, "MoviesReviews", "content");
            indicesMap.put("content", this.contentIndex);
            this.movieIDIndex = getValidColumnIndex(path, table, "MoviesReviews", "movieID");
            indicesMap.put("movieID", this.movieIDIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final MoviesReviewsColumnInfo otherInfo = (MoviesReviewsColumnInfo) other;
            this.revIdIndex = otherInfo.revIdIndex;
            this.authorIndex = otherInfo.authorIndex;
            this.contentIndex = otherInfo.contentIndex;
            this.movieIDIndex = otherInfo.movieIDIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final MoviesReviewsColumnInfo clone() {
            return (MoviesReviewsColumnInfo) super.clone();
        }

    }
    private MoviesReviewsColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("revId");
        fieldNames.add("author");
        fieldNames.add("content");
        fieldNames.add("movieID");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    MoviesReviewsRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MoviesReviewsColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.example.new_one.Model.MoviesReviews.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$revId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.revIdIndex);
    }

    public void realmSet$revId(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'revId' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$author() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.authorIndex);
    }

    public void realmSet$author(String value) {
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
                throw new IllegalArgumentException("Trying to set non-nullable field 'author' to null.");
            }
            row.getTable().setString(columnInfo.authorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'author' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.authorIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$content() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.contentIndex);
    }

    public void realmSet$content(String value) {
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
                throw new IllegalArgumentException("Trying to set non-nullable field 'content' to null.");
            }
            row.getTable().setString(columnInfo.contentIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'content' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.contentIndex, value);
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
        if (!realmSchema.contains("MoviesReviews")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("MoviesReviews");
            realmObjectSchema.add(new Property("revId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("author", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("content", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("movieID", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("MoviesReviews");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_MoviesReviews")) {
            Table table = sharedRealm.getTable("class_MoviesReviews");
            table.addColumn(RealmFieldType.STRING, "revId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "author", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "content", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "movieID", Table.NOT_NULLABLE);
            table.addSearchIndex(table.getColumnIndex("revId"));
            table.setPrimaryKey("revId");
            return table;
        }
        return sharedRealm.getTable("class_MoviesReviews");
    }

    public static MoviesReviewsColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_MoviesReviews")) {
            Table table = sharedRealm.getTable("class_MoviesReviews");
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

            final MoviesReviewsColumnInfo columnInfo = new MoviesReviewsColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("revId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'revId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("revId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'revId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.revIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'revId' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("revId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'revId' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("revId"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'revId' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("author")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'author' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("author") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'author' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.authorIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'author' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'author' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("content")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'content' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("content") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'content' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.contentIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'content' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'content' or migrate using RealmObjectSchema.setNullable().");
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
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'MoviesReviews' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_MoviesReviews";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.new_one.Model.MoviesReviews createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.new_one.Model.MoviesReviews obj = null;
        if (update) {
            Table table = realm.getTable(com.example.new_one.Model.MoviesReviews.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("revId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("revId"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.new_one.Model.MoviesReviews.class), false, Collections.<String> emptyList());
                    obj = new io.realm.MoviesReviewsRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("revId")) {
                if (json.isNull("revId")) {
                    obj = (io.realm.MoviesReviewsRealmProxy) realm.createObjectInternal(com.example.new_one.Model.MoviesReviews.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.MoviesReviewsRealmProxy) realm.createObjectInternal(com.example.new_one.Model.MoviesReviews.class, json.getString("revId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'revId'.");
            }
        }
        if (json.has("author")) {
            if (json.isNull("author")) {
                ((MoviesReviewsRealmProxyInterface) obj).realmSet$author(null);
            } else {
                ((MoviesReviewsRealmProxyInterface) obj).realmSet$author((String) json.getString("author"));
            }
        }
        if (json.has("content")) {
            if (json.isNull("content")) {
                ((MoviesReviewsRealmProxyInterface) obj).realmSet$content(null);
            } else {
                ((MoviesReviewsRealmProxyInterface) obj).realmSet$content((String) json.getString("content"));
            }
        }
        if (json.has("movieID")) {
            if (json.isNull("movieID")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'movieID' to null.");
            } else {
                ((MoviesReviewsRealmProxyInterface) obj).realmSet$movieID((int) json.getInt("movieID"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.new_one.Model.MoviesReviews createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.example.new_one.Model.MoviesReviews obj = new com.example.new_one.Model.MoviesReviews();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("revId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MoviesReviewsRealmProxyInterface) obj).realmSet$revId(null);
                } else {
                    ((MoviesReviewsRealmProxyInterface) obj).realmSet$revId((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("author")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MoviesReviewsRealmProxyInterface) obj).realmSet$author(null);
                } else {
                    ((MoviesReviewsRealmProxyInterface) obj).realmSet$author((String) reader.nextString());
                }
            } else if (name.equals("content")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MoviesReviewsRealmProxyInterface) obj).realmSet$content(null);
                } else {
                    ((MoviesReviewsRealmProxyInterface) obj).realmSet$content((String) reader.nextString());
                }
            } else if (name.equals("movieID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'movieID' to null.");
                } else {
                    ((MoviesReviewsRealmProxyInterface) obj).realmSet$movieID((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'revId'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.example.new_one.Model.MoviesReviews copyOrUpdate(Realm realm, com.example.new_one.Model.MoviesReviews object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.new_one.Model.MoviesReviews) cachedRealmObject;
        } else {
            com.example.new_one.Model.MoviesReviews realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.example.new_one.Model.MoviesReviews.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((MoviesReviewsRealmProxyInterface) object).realmGet$revId();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.new_one.Model.MoviesReviews.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.MoviesReviewsRealmProxy();
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

    public static com.example.new_one.Model.MoviesReviews copy(Realm realm, com.example.new_one.Model.MoviesReviews newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.new_one.Model.MoviesReviews) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.example.new_one.Model.MoviesReviews realmObject = realm.createObjectInternal(com.example.new_one.Model.MoviesReviews.class, ((MoviesReviewsRealmProxyInterface) newObject).realmGet$revId(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((MoviesReviewsRealmProxyInterface) realmObject).realmSet$author(((MoviesReviewsRealmProxyInterface) newObject).realmGet$author());
            ((MoviesReviewsRealmProxyInterface) realmObject).realmSet$content(((MoviesReviewsRealmProxyInterface) newObject).realmGet$content());
            ((MoviesReviewsRealmProxyInterface) realmObject).realmSet$movieID(((MoviesReviewsRealmProxyInterface) newObject).realmGet$movieID());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.example.new_one.Model.MoviesReviews object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.new_one.Model.MoviesReviews.class);
        long tableNativePtr = table.getNativeTablePointer();
        MoviesReviewsColumnInfo columnInfo = (MoviesReviewsColumnInfo) realm.schema.getColumnInfo(com.example.new_one.Model.MoviesReviews.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((MoviesReviewsRealmProxyInterface) object).realmGet$revId();
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
        String realmGet$author = ((MoviesReviewsRealmProxyInterface)object).realmGet$author();
        if (realmGet$author != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
        }
        String realmGet$content = ((MoviesReviewsRealmProxyInterface)object).realmGet$content();
        if (realmGet$content != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.movieIDIndex, rowIndex, ((MoviesReviewsRealmProxyInterface)object).realmGet$movieID(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.new_one.Model.MoviesReviews.class);
        long tableNativePtr = table.getNativeTablePointer();
        MoviesReviewsColumnInfo columnInfo = (MoviesReviewsColumnInfo) realm.schema.getColumnInfo(com.example.new_one.Model.MoviesReviews.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.new_one.Model.MoviesReviews object = null;
        while (objects.hasNext()) {
            object = (com.example.new_one.Model.MoviesReviews) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((MoviesReviewsRealmProxyInterface) object).realmGet$revId();
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
                String realmGet$author = ((MoviesReviewsRealmProxyInterface)object).realmGet$author();
                if (realmGet$author != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
                }
                String realmGet$content = ((MoviesReviewsRealmProxyInterface)object).realmGet$content();
                if (realmGet$content != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.movieIDIndex, rowIndex, ((MoviesReviewsRealmProxyInterface)object).realmGet$movieID(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.new_one.Model.MoviesReviews object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.new_one.Model.MoviesReviews.class);
        long tableNativePtr = table.getNativeTablePointer();
        MoviesReviewsColumnInfo columnInfo = (MoviesReviewsColumnInfo) realm.schema.getColumnInfo(com.example.new_one.Model.MoviesReviews.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((MoviesReviewsRealmProxyInterface) object).realmGet$revId();
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
        String realmGet$author = ((MoviesReviewsRealmProxyInterface)object).realmGet$author();
        if (realmGet$author != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.authorIndex, rowIndex, false);
        }
        String realmGet$content = ((MoviesReviewsRealmProxyInterface)object).realmGet$content();
        if (realmGet$content != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.contentIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.movieIDIndex, rowIndex, ((MoviesReviewsRealmProxyInterface)object).realmGet$movieID(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.new_one.Model.MoviesReviews.class);
        long tableNativePtr = table.getNativeTablePointer();
        MoviesReviewsColumnInfo columnInfo = (MoviesReviewsColumnInfo) realm.schema.getColumnInfo(com.example.new_one.Model.MoviesReviews.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.new_one.Model.MoviesReviews object = null;
        while (objects.hasNext()) {
            object = (com.example.new_one.Model.MoviesReviews) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((MoviesReviewsRealmProxyInterface) object).realmGet$revId();
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
                String realmGet$author = ((MoviesReviewsRealmProxyInterface)object).realmGet$author();
                if (realmGet$author != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.authorIndex, rowIndex, false);
                }
                String realmGet$content = ((MoviesReviewsRealmProxyInterface)object).realmGet$content();
                if (realmGet$content != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.contentIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.movieIDIndex, rowIndex, ((MoviesReviewsRealmProxyInterface)object).realmGet$movieID(), false);
            }
        }
    }

    public static com.example.new_one.Model.MoviesReviews createDetachedCopy(com.example.new_one.Model.MoviesReviews realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.new_one.Model.MoviesReviews unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.new_one.Model.MoviesReviews)cachedObject.object;
            } else {
                unmanagedObject = (com.example.new_one.Model.MoviesReviews)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.example.new_one.Model.MoviesReviews();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((MoviesReviewsRealmProxyInterface) unmanagedObject).realmSet$revId(((MoviesReviewsRealmProxyInterface) realmObject).realmGet$revId());
        ((MoviesReviewsRealmProxyInterface) unmanagedObject).realmSet$author(((MoviesReviewsRealmProxyInterface) realmObject).realmGet$author());
        ((MoviesReviewsRealmProxyInterface) unmanagedObject).realmSet$content(((MoviesReviewsRealmProxyInterface) realmObject).realmGet$content());
        ((MoviesReviewsRealmProxyInterface) unmanagedObject).realmSet$movieID(((MoviesReviewsRealmProxyInterface) realmObject).realmGet$movieID());
        return unmanagedObject;
    }

    static com.example.new_one.Model.MoviesReviews update(Realm realm, com.example.new_one.Model.MoviesReviews realmObject, com.example.new_one.Model.MoviesReviews newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((MoviesReviewsRealmProxyInterface) realmObject).realmSet$author(((MoviesReviewsRealmProxyInterface) newObject).realmGet$author());
        ((MoviesReviewsRealmProxyInterface) realmObject).realmSet$content(((MoviesReviewsRealmProxyInterface) newObject).realmGet$content());
        ((MoviesReviewsRealmProxyInterface) realmObject).realmSet$movieID(((MoviesReviewsRealmProxyInterface) newObject).realmGet$movieID());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("MoviesReviews = [");
        stringBuilder.append("{revId:");
        stringBuilder.append(realmGet$revId() != null ? realmGet$revId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{author:");
        stringBuilder.append(realmGet$author());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{content:");
        stringBuilder.append(realmGet$content());
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
        MoviesReviewsRealmProxy aMoviesReviews = (MoviesReviewsRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aMoviesReviews.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMoviesReviews.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aMoviesReviews.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
