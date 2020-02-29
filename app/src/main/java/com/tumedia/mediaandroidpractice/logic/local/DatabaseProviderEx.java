package com.tumedia.mediaandroidpractice.logic.local;

import android.content.Context;

import androidx.room.Room;

/**
 * Created by Ximon on 2020-02-29
 * <p>
 * DataBase 객체
 */
// 싱글톤 패턴을 사용하여 데이터베이스 객체 제공
public class DatabaseProviderEx {
    private volatile static DatabaseEx mInstance = null;

    private DatabaseProviderEx(){ }

    public static DatabaseEx getInstance(Context context){
//        if(mInstance == null) {
//            synchronized (DatabaseEx.class) {
//                mInstance = Room.databaseBuilder(
//                        context,
//                        DatabaseEx.class,
//                        "black_jin.db")
//                        .build();
//            }
//        }

        return mInstance;
    }
}
