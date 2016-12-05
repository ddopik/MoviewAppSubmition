package io.realm;


import android.util.JsonReader;
import io.realm.RealmObjectSchema;
import io.realm.internal.ColumnInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>();
        modelClasses.add(com.example.new_one.Model.MoviesReviews.class);
        modelClasses.add(com.example.new_one.Model.MoviePages.class);
        modelClasses.add(com.example.new_one.Model.Movies.class);
        modelClasses.add(com.example.new_one.Model.MoviesTrailer.class);
        modelClasses.add(com.example.new_one.Model.MoviesFavourates.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Table createTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm) {
        checkClass(clazz);

        if (clazz.equals(com.example.new_one.Model.MoviesReviews.class)) {
            return io.realm.MoviesReviewsRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.example.new_one.Model.MoviePages.class)) {
            return io.realm.MoviePagesRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.example.new_one.Model.Movies.class)) {
            return io.realm.MoviesRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.example.new_one.Model.MoviesTrailer.class)) {
            return io.realm.MoviesTrailerRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.example.new_one.Model.MoviesFavourates.class)) {
            return io.realm.MoviesFavouratesRealmProxy.initTable(sharedRealm);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema realmSchema) {
        checkClass(clazz);

        if (clazz.equals(com.example.new_one.Model.MoviesReviews.class)) {
            return io.realm.MoviesReviewsRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.example.new_one.Model.MoviePages.class)) {
            return io.realm.MoviePagesRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.example.new_one.Model.Movies.class)) {
            return io.realm.MoviesRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.example.new_one.Model.MoviesTrailer.class)) {
            return io.realm.MoviesTrailerRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.example.new_one.Model.MoviesFavourates.class)) {
            return io.realm.MoviesFavouratesRealmProxy.createRealmObjectSchema(realmSchema);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        checkClass(clazz);

        if (clazz.equals(com.example.new_one.Model.MoviesReviews.class)) {
            return io.realm.MoviesReviewsRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.example.new_one.Model.MoviePages.class)) {
            return io.realm.MoviePagesRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.example.new_one.Model.Movies.class)) {
            return io.realm.MoviesRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.example.new_one.Model.MoviesTrailer.class)) {
            return io.realm.MoviesTrailerRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.example.new_one.Model.MoviesFavourates.class)) {
            return io.realm.MoviesFavouratesRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.example.new_one.Model.MoviesReviews.class)) {
            return io.realm.MoviesReviewsRealmProxy.getFieldNames();
        } else if (clazz.equals(com.example.new_one.Model.MoviePages.class)) {
            return io.realm.MoviePagesRealmProxy.getFieldNames();
        } else if (clazz.equals(com.example.new_one.Model.Movies.class)) {
            return io.realm.MoviesRealmProxy.getFieldNames();
        } else if (clazz.equals(com.example.new_one.Model.MoviesTrailer.class)) {
            return io.realm.MoviesTrailerRealmProxy.getFieldNames();
        } else if (clazz.equals(com.example.new_one.Model.MoviesFavourates.class)) {
            return io.realm.MoviesFavouratesRealmProxy.getFieldNames();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.example.new_one.Model.MoviesReviews.class)) {
            return io.realm.MoviesReviewsRealmProxy.getTableName();
        } else if (clazz.equals(com.example.new_one.Model.MoviePages.class)) {
            return io.realm.MoviePagesRealmProxy.getTableName();
        } else if (clazz.equals(com.example.new_one.Model.Movies.class)) {
            return io.realm.MoviesRealmProxy.getTableName();
        } else if (clazz.equals(com.example.new_one.Model.MoviesTrailer.class)) {
            return io.realm.MoviesTrailerRealmProxy.getTableName();
        } else if (clazz.equals(com.example.new_one.Model.MoviesFavourates.class)) {
            return io.realm.MoviesFavouratesRealmProxy.getTableName();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.example.new_one.Model.MoviesReviews.class)) {
                return clazz.cast(new io.realm.MoviesReviewsRealmProxy());
            } else if (clazz.equals(com.example.new_one.Model.MoviePages.class)) {
                return clazz.cast(new io.realm.MoviePagesRealmProxy());
            } else if (clazz.equals(com.example.new_one.Model.Movies.class)) {
                return clazz.cast(new io.realm.MoviesRealmProxy());
            } else if (clazz.equals(com.example.new_one.Model.MoviesTrailer.class)) {
                return clazz.cast(new io.realm.MoviesTrailerRealmProxy());
            } else if (clazz.equals(com.example.new_one.Model.MoviesFavourates.class)) {
                return clazz.cast(new io.realm.MoviesFavouratesRealmProxy());
            } else {
                throw getMissingProxyClassException(clazz);
            }
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.example.new_one.Model.MoviesReviews.class)) {
            return clazz.cast(io.realm.MoviesReviewsRealmProxy.copyOrUpdate(realm, (com.example.new_one.Model.MoviesReviews) obj, update, cache));
        } else if (clazz.equals(com.example.new_one.Model.MoviePages.class)) {
            return clazz.cast(io.realm.MoviePagesRealmProxy.copyOrUpdate(realm, (com.example.new_one.Model.MoviePages) obj, update, cache));
        } else if (clazz.equals(com.example.new_one.Model.Movies.class)) {
            return clazz.cast(io.realm.MoviesRealmProxy.copyOrUpdate(realm, (com.example.new_one.Model.Movies) obj, update, cache));
        } else if (clazz.equals(com.example.new_one.Model.MoviesTrailer.class)) {
            return clazz.cast(io.realm.MoviesTrailerRealmProxy.copyOrUpdate(realm, (com.example.new_one.Model.MoviesTrailer) obj, update, cache));
        } else if (clazz.equals(com.example.new_one.Model.MoviesFavourates.class)) {
            return clazz.cast(io.realm.MoviesFavouratesRealmProxy.copyOrUpdate(realm, (com.example.new_one.Model.MoviesFavourates) obj, update, cache));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.example.new_one.Model.MoviesReviews.class)) {
            io.realm.MoviesReviewsRealmProxy.insert(realm, (com.example.new_one.Model.MoviesReviews) object, cache);
        } else if (clazz.equals(com.example.new_one.Model.MoviePages.class)) {
            io.realm.MoviePagesRealmProxy.insert(realm, (com.example.new_one.Model.MoviePages) object, cache);
        } else if (clazz.equals(com.example.new_one.Model.Movies.class)) {
            io.realm.MoviesRealmProxy.insert(realm, (com.example.new_one.Model.Movies) object, cache);
        } else if (clazz.equals(com.example.new_one.Model.MoviesTrailer.class)) {
            io.realm.MoviesTrailerRealmProxy.insert(realm, (com.example.new_one.Model.MoviesTrailer) object, cache);
        } else if (clazz.equals(com.example.new_one.Model.MoviesFavourates.class)) {
            io.realm.MoviesFavouratesRealmProxy.insert(realm, (com.example.new_one.Model.MoviesFavourates) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new IdentityHashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.example.new_one.Model.MoviesReviews.class)) {
                io.realm.MoviesReviewsRealmProxy.insert(realm, (com.example.new_one.Model.MoviesReviews) object, cache);
            } else if (clazz.equals(com.example.new_one.Model.MoviePages.class)) {
                io.realm.MoviePagesRealmProxy.insert(realm, (com.example.new_one.Model.MoviePages) object, cache);
            } else if (clazz.equals(com.example.new_one.Model.Movies.class)) {
                io.realm.MoviesRealmProxy.insert(realm, (com.example.new_one.Model.Movies) object, cache);
            } else if (clazz.equals(com.example.new_one.Model.MoviesTrailer.class)) {
                io.realm.MoviesTrailerRealmProxy.insert(realm, (com.example.new_one.Model.MoviesTrailer) object, cache);
            } else if (clazz.equals(com.example.new_one.Model.MoviesFavourates.class)) {
                io.realm.MoviesFavouratesRealmProxy.insert(realm, (com.example.new_one.Model.MoviesFavourates) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.example.new_one.Model.MoviesReviews.class)) {
                    io.realm.MoviesReviewsRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.example.new_one.Model.MoviePages.class)) {
                    io.realm.MoviePagesRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.example.new_one.Model.Movies.class)) {
                    io.realm.MoviesRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.example.new_one.Model.MoviesTrailer.class)) {
                    io.realm.MoviesTrailerRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.example.new_one.Model.MoviesFavourates.class)) {
                    io.realm.MoviesFavouratesRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.example.new_one.Model.MoviesReviews.class)) {
            io.realm.MoviesReviewsRealmProxy.insertOrUpdate(realm, (com.example.new_one.Model.MoviesReviews) obj, cache);
        } else if (clazz.equals(com.example.new_one.Model.MoviePages.class)) {
            io.realm.MoviePagesRealmProxy.insertOrUpdate(realm, (com.example.new_one.Model.MoviePages) obj, cache);
        } else if (clazz.equals(com.example.new_one.Model.Movies.class)) {
            io.realm.MoviesRealmProxy.insertOrUpdate(realm, (com.example.new_one.Model.Movies) obj, cache);
        } else if (clazz.equals(com.example.new_one.Model.MoviesTrailer.class)) {
            io.realm.MoviesTrailerRealmProxy.insertOrUpdate(realm, (com.example.new_one.Model.MoviesTrailer) obj, cache);
        } else if (clazz.equals(com.example.new_one.Model.MoviesFavourates.class)) {
            io.realm.MoviesFavouratesRealmProxy.insertOrUpdate(realm, (com.example.new_one.Model.MoviesFavourates) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new IdentityHashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.example.new_one.Model.MoviesReviews.class)) {
                io.realm.MoviesReviewsRealmProxy.insertOrUpdate(realm, (com.example.new_one.Model.MoviesReviews) object, cache);
            } else if (clazz.equals(com.example.new_one.Model.MoviePages.class)) {
                io.realm.MoviePagesRealmProxy.insertOrUpdate(realm, (com.example.new_one.Model.MoviePages) object, cache);
            } else if (clazz.equals(com.example.new_one.Model.Movies.class)) {
                io.realm.MoviesRealmProxy.insertOrUpdate(realm, (com.example.new_one.Model.Movies) object, cache);
            } else if (clazz.equals(com.example.new_one.Model.MoviesTrailer.class)) {
                io.realm.MoviesTrailerRealmProxy.insertOrUpdate(realm, (com.example.new_one.Model.MoviesTrailer) object, cache);
            } else if (clazz.equals(com.example.new_one.Model.MoviesFavourates.class)) {
                io.realm.MoviesFavouratesRealmProxy.insertOrUpdate(realm, (com.example.new_one.Model.MoviesFavourates) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.example.new_one.Model.MoviesReviews.class)) {
                    io.realm.MoviesReviewsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.example.new_one.Model.MoviePages.class)) {
                    io.realm.MoviePagesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.example.new_one.Model.Movies.class)) {
                    io.realm.MoviesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.example.new_one.Model.MoviesTrailer.class)) {
                    io.realm.MoviesTrailerRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.example.new_one.Model.MoviesFavourates.class)) {
                    io.realm.MoviesFavouratesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.example.new_one.Model.MoviesReviews.class)) {
            return clazz.cast(io.realm.MoviesReviewsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.example.new_one.Model.MoviePages.class)) {
            return clazz.cast(io.realm.MoviePagesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.example.new_one.Model.Movies.class)) {
            return clazz.cast(io.realm.MoviesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.example.new_one.Model.MoviesTrailer.class)) {
            return clazz.cast(io.realm.MoviesTrailerRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.example.new_one.Model.MoviesFavourates.class)) {
            return clazz.cast(io.realm.MoviesFavouratesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.example.new_one.Model.MoviesReviews.class)) {
            return clazz.cast(io.realm.MoviesReviewsRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.example.new_one.Model.MoviePages.class)) {
            return clazz.cast(io.realm.MoviePagesRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.example.new_one.Model.Movies.class)) {
            return clazz.cast(io.realm.MoviesRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.example.new_one.Model.MoviesTrailer.class)) {
            return clazz.cast(io.realm.MoviesTrailerRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.example.new_one.Model.MoviesFavourates.class)) {
            return clazz.cast(io.realm.MoviesFavouratesRealmProxy.createUsingJsonStream(realm, reader));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.example.new_one.Model.MoviesReviews.class)) {
            return clazz.cast(io.realm.MoviesReviewsRealmProxy.createDetachedCopy((com.example.new_one.Model.MoviesReviews) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.example.new_one.Model.MoviePages.class)) {
            return clazz.cast(io.realm.MoviePagesRealmProxy.createDetachedCopy((com.example.new_one.Model.MoviePages) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.example.new_one.Model.Movies.class)) {
            return clazz.cast(io.realm.MoviesRealmProxy.createDetachedCopy((com.example.new_one.Model.Movies) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.example.new_one.Model.MoviesTrailer.class)) {
            return clazz.cast(io.realm.MoviesTrailerRealmProxy.createDetachedCopy((com.example.new_one.Model.MoviesTrailer) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.example.new_one.Model.MoviesFavourates.class)) {
            return clazz.cast(io.realm.MoviesFavouratesRealmProxy.createDetachedCopy((com.example.new_one.Model.MoviesFavourates) realmObject, 0, maxDepth, cache));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

}
