package ProtostuffTest1.ProtostuffTest1;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

public class Util {
	public Util(){};
	
	public static <T> byte[] serializer(T o) {  
        Schema schema = RuntimeSchema.getSchema(o.getClass());  
        return ProtobufIOUtil.toByteArray(o, schema, LinkedBuffer.allocate(256));  
    }  
  
    public static <T> T deserializer(byte[] bytes, Class<T> clazz) {  
  
        T obj = null;  
        try {  
            obj = clazz.newInstance();  
            Schema schema = RuntimeSchema.getSchema(obj.getClass());  
            ProtostuffIOUtil.mergeFrom(bytes, obj, schema);  
        } catch (InstantiationException e) {  
            e.printStackTrace();  
        } catch (IllegalAccessException e) {  
            e.printStackTrace();  
        }  
  
        return obj;  
    }
    public static int calcSize(java.io.Serializable o) {
        int ret = 0;
        class DumbOutputStream extends OutputStream {
            int count = 0;

            public void write(int b) throws IOException {
                count++; // 只计数，不产生字节转移
            }

        }
        DumbOutputStream buf = new DumbOutputStream();
        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(buf);
            os.writeObject(o);
            ret = buf.count;
        } catch (IOException e) {
           // No need handle this exception
           e.printStackTrace();
           ret = -1;
        } finally {
           try {
               os.close();
           } catch (Exception e) {
           }
        }

        return ret;

    }
}
