//package com.tumedia.mediaandroidpractice.logic.local;
//
//import android.content.Context;
//
//import androidx.room.Room;
//
///**
// * Created by Ximon on 2020-02-29
// * <p>
// * DataBase 객체
// */
//// 싱글톤 패턴을 사용하여 데이터베이스 객체 제공
//public class DatabaseProviderEx {
//    /**
//     * volatile: Java변수를 Main Memory에 저장하겠다는 것을 명시
//     *
//     *  ∴ 매번 변수의 값을 Read할 때마다 CPU cache에 저장된 값이 아닌 Main Memory에서 읽는 것
//     *  ∴ 또한 변수의 값을 Write할 때마다 Main Memory에 까지 작성하는 것
//     *
//     *  ∴ 즉, 변수를 Main Memory에 저장하고 불러오기 때문에 변수 값 불일치 문제 해결 가능
//     */
//    private volatile static DatabaseEx mInstance = null;
//
//    private DatabaseProviderEx(){ }
//
//    // Main Memory에 쓰기연산(Write)를 여러 쓰레드에서 해야할 경우 Synchronized 구현 요망
//    public static DatabaseEx getInstance(Context context){
////        if(mInstance == null) {
////            synchronized (DatabaseEx.class) {
////                mInstance = Room.databaseBuilder(
////                        context,
////                        DatabaseEx.class,
////                        "black_jin.db")
////                        .build();
////            }
////        }
//
//        return mInstance;
//    }
//}
