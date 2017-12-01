package java.clone;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 10/17/17
 * Time: 3:47 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract  class BeanUtil {
    @SuppressWarnings("unchecked")
    public static  Object cloneTo(Object src) throws RuntimeException {

        ByteArrayOutputStream memoryBuffer = new ByteArrayOutputStream();

        ObjectOutputStream out = null;

        ObjectInputStream in = null;

        Object dist = null;

        try {

            out = new ObjectOutputStream(memoryBuffer);

            out.writeObject(src);

            out.flush();

            in = new ObjectInputStream(new ByteArrayInputStream(memoryBuffer.toByteArray()));

            dist = (Object) in.readObject();

        } catch (Exception e) {

            throw new RuntimeException(e);

        } finally {

            if (out != null)

                try {

                    out.close();

                    out = null;

                } catch (IOException e) {

                    throw new RuntimeException(e);

                }

            if (in != null)

                try {

                    in.close();

                    in = null;

                } catch (IOException e) {

                    throw new RuntimeException(e);

                }

        }

        return dist;

    }
}
