package com.fourteen.piao.test;

import com.fourteen.piao.service.DBOpenHelper;
import  android.test.AndroidTestCase;

/**
 * Created by Administrator on 2014/5/29.
 */
public class ConcertServiceTest {

    public  void testCreateDB() throws Exception{
        //context 字面理解就是上下文，可以理解为应用程序的句柄。在android里只有activity和service里提供了context的实现。
        //在DB管理模块里去getcontext是不可能的。如果要用context，可以从activity或者service中把context传过去。
//        DBOpenHelper dbOpenHelper = new DBOpenHelper(getContext());
//        dbOpenHelper.getWritableDatabase();
    }
}
