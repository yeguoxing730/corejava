package com.oracleaq;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 4/21/17
 * Time: 5:21 PM
 * To change this template use File | Settings | File Templates.
 */

import oracle.jdbc.driver.OracleConnection;
import oracle.jdbc.internal.OracleTypes;
import oracle.jpub.runtime.MutableStruct;
import oracle.sql.CustomDatum;
import oracle.sql.CustomDatumFactory;
import oracle.sql.Datum;
import oracle.sql.STRUCT;

import java.sql.SQLException;

@SuppressWarnings("deprecation")
public class QUEUE_MESSAGE_TYPE implements CustomDatum, CustomDatumFactory {
    public static final String _SQL_NAME = "QUEUE_MESSAGE_TYPE";
    public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

    MutableStruct _struct;
    // 12表示字符串
    static int[] _sqlType = {12};
    static CustomDatumFactory[] _factory = new CustomDatumFactory[1];
    static final QUEUE_MESSAGE_TYPE _MessageFactory = new QUEUE_MESSAGE_TYPE();

    public static CustomDatumFactory getFactory() {
        return _MessageFactory;
    }

    public QUEUE_MESSAGE_TYPE() {
        _struct = new MutableStruct(new Object[1], _sqlType, _factory);
    }

    public Datum toDatum(OracleConnection c) throws SQLException {
        return _struct.toDatum(c, _SQL_NAME);
    }

    public CustomDatum create(Datum d, int sqlType) throws SQLException {
        if (d == null)
            return null;
        QUEUE_MESSAGE_TYPE o = new QUEUE_MESSAGE_TYPE();
        o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
        return o;
    }

    public String getContent() throws SQLException {
        return (String) _struct.getAttribute(0);
    }
}
