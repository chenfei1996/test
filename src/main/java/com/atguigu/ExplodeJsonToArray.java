package com.atguigu;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.exec.UDFArgumentLengthException;
import org.apache.hadoop.hive.ql.exec.UDFArgumentTypeException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.Collections;
import java.util.List;
import java.util.PrimitiveIterator;

public class ExplodeJsonToArray extends GenericUDTF {

    @Override
    public StructObjectInspector initialize(ObjectInspector[] argOIs) throws UDFArgumentException {
        if(argOIs .length != 1){
            throw new UDFArgumentLengthException("参数个数必须为1！！！");
        }
        if(!argOIs[0].getTypeName().equals("string")){
            throw new UDFArgumentTypeException(0, "参数类型必须为string");
        }

        List colname = Collections.singletonList("jaon");
        List coltype = Collections.singletonList(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        return ObjectInspectorFactory.getStandardStructObjectInspector(colname, coltype);
    }

    @Override
    public void process(Object[] objects)  throws HiveException{
        String line = objects[0].toString();
        JSONArray array = null;
        try {
             array = new JSONArray(line);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < array.length(); i++){
            try {
                String out = array.getString(i);
                Object [] obj = new Object[1];
                obj[0] = out;
                forward(obj);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void close() throws HiveException {

    }
}
