package com.example.item.ui.me.click;

import android.content.Context;

import java.security.SecureRandom;

import io.realm.RealmConfiguration;

public class Realms {
    public static io.realm.Realm getRealm(Context context){
       byte[] bytes= new byte[1024];
       new SecureRandom().nextBytes(bytes);
       io.realm.Realm.init(context);

        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("myrealm.realm")
                .schemaVersion(2)
                .build();
        return io.realm.Realm.getInstance(configuration);
    }
}

