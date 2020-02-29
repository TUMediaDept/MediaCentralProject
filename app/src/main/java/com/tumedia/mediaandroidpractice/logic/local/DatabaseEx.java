package com.tumedia.mediaandroidpractice.logic.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Created by Ximon on 2020-02-29
 *
 * Room Database class
 */
    // 룸 데이터 베이스 생성
    // 데이터베이스에서 사용하는 엔티티와 버전 지정
    @Database(entities = {EntityEx.class}, version = 1)
public abstract class DatabaseEx extends RoomDatabase {

        // 데이터베이스와 연결할 데이터 접근 객체 정의
        public abstract EntityDao getEntityDao();
}
