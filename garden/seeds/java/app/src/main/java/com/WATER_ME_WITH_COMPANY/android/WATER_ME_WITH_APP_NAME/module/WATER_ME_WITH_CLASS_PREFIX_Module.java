package com.{{company_name}}.android.{{app_package_name_prefix}}.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.{{company_name}}.android.{{app_package_name_prefix}}.{{app_class_prefix}}App;
import com.{{company_name}}.android.{{app_package_name_prefix}}.data.AppSettings;
import com.{{company_name}}.android.{{app_package_name_prefix}}.util.manager.DialogManager;
import com.{{company_name}}.android.{{app_package_name_prefix}}.BuildConfig;
import com.{{company_name}}.{{app_package_name_prefix}}.network.NetworkDataSource;
import com.lacronicus.easydatastorelib.DatastoreBuilder;

import com.squareup.leakcanary.RefWatcher;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import com.google.android.gms.tagmanager.TagManager;


/**
 * Dagger module to provide dependency injection
 */
@SuppressWarnings("unused")
@Module
public class {{app_class_prefix}}Module {
    private {{app_class_prefix}}App mApplication;
    private final TagManager mTagManager;

    public {{app_class_prefix}}Module({{app_class_prefix}}App app, TagManager tagManager) {
        mApplication = app;
        mTagManager = tagManager;
    }

    @Provides
    @Singleton
    {{app_class_prefix}}App providesApp() {
        return mApplication;
    }

    @Provides
    Context providesContext() {
        return mApplication;
    }

    @Provides
    RefWatcher providesRefWatcher({{app_class_prefix}}App app) {
        return app.getRefWatcher();
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
    AppSettings providesAppSettings(SharedPreferences prefs) {
        return new DatastoreBuilder(prefs).create(AppSettings.class);
    }

    @Provides
    @Singleton
    NetworkDataSource providesDataSource() {
        return new NetworkDataSource(BuildConfig.BASE_URL);
    }

    @Provides
    @Singleton
    DialogManager providesDialogManager() {
        return new DialogManager();
    }

    @Provides
    @Singleton
    public TagManager provideTagManager() {
        return mTagManager;
    }
}
