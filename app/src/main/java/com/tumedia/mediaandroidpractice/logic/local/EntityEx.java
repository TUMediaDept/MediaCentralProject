package com.tumedia.mediaandroidpractice.logic.local;

import java.io.Serializable;

import androidx.room.Entity;

/**
 * Created by Ximon on 2020-02-29
 *
 * Entity class
 */

//  1. 테이블 이름 설정
//  2. 데이터베이스에 저장할 데이터의 형식을 정함

// 1.
@Entity(tableName = "tableName")
public class EntityEx implements Serializable {
    // 2.
    // Entity 클래스의 field가 object인 경우 @Embeded 설정
}
