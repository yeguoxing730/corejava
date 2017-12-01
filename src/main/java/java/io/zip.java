package java.io;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 4/17/17
 * Time: 10:56 AM
 * To change this template use File | Settings | File Templates.
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
public class zip {
    /**

     * 使用gzip进行压缩
     */
    public static String gzip(String primStr) {
        if (primStr == null || primStr.length() == 0) {
            return primStr;
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        GZIPOutputStream gzip=null;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(primStr.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(gzip!=null){
                try {
                    gzip.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(out.toByteArray().length)    ;
        return new String(out.toByteArray());
//        return new sun.misc.BASE64Encoder().encode(out.toByteArray());
    }

    /**
     *
     * <p>Description:使用gzip进行解压缩</p>
     * @param compressedStr
     * @return
     */
    public static String gunzip(String compressedStr){
        if(compressedStr==null){
            return null;
        }

        ByteArrayOutputStream out= new ByteArrayOutputStream();
        ByteArrayInputStream in=null;
        GZIPInputStream ginzip=null;
        byte[] compressed=null;
        String decompressed = null;
        try {
            compressed = new sun.misc.BASE64Decoder().decodeBuffer(compressedStr);
            in=new ByteArrayInputStream(compressed);
            ginzip=new GZIPInputStream(in);

            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = ginzip.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            decompressed=out.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ginzip != null) {
                try {
                    ginzip.close();
                } catch (IOException e) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }

        return decompressed;
    }

    /**
     * 使用zip进行压缩
     * @param str 压缩前的文本
     * @return 返回压缩后的文本
     */
    public static final String zip(String str) {
        if (str == null)
            return null;
        byte[] compressed;
        ByteArrayOutputStream out = null;
        ZipOutputStream zout = null;
        String compressedStr = null;
        try {
            out = new ByteArrayOutputStream();
            zout = new ZipOutputStream(out);
            zout.putNextEntry(new ZipEntry("0"));
            zout.write(str.getBytes());
            zout.closeEntry();
            compressed = out.toByteArray();
            compressedStr = new sun.misc.BASE64Encoder().encodeBuffer(compressed);
        } catch (IOException e) {
            compressed = null;
        } finally {
            if (zout != null) {
                try {
                    zout.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
        return compressedStr;
    }

    /**
     * 使用zip进行解压缩
     * @param compressedStr 压缩后的文本
     * @return 解压后的字符串
     */
    public static final String unzip(String compressedStr) {
        if (compressedStr == null) {
            return null;
        }

        ByteArrayOutputStream out = null;
        ByteArrayInputStream in = null;
        ZipInputStream zin = null;
        String decompressed = null;
        try {
            byte[] compressed = new sun.misc.BASE64Decoder().decodeBuffer(compressedStr);
            out = new ByteArrayOutputStream();
            in = new ByteArrayInputStream(compressed);
            zin = new ZipInputStream(in);
            zin.getNextEntry();
            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = zin.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            decompressed = out.toString();
        } catch (IOException e) {
            decompressed = null;
        } finally {
            if (zin != null) {
                try {
                    zin.close();
                } catch (IOException e) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
        return decompressed;
    }
    public static void main(String[] args){
//        String msg = "１、葳蕤：枝叶茂盛而纷披。 ２、坐：因而。 ３、本心：天性。 【韵译】： 泽兰逢春茂盛芳馨， 桂花遇秋皎洁清新。 兰桂欣欣生机勃发， 春秋自成佳节良辰。 谁能领悟山中隐士， 闻香深生仰慕之情？ 花卉流香原为天性， 何求美人采撷扬名。 \n" +
//                "\n" +
//                "【评析】： 此诗系张九龄遭谗贬谪后所作《感遇》十二首之冠首。诗借物起兴，自比兰桂， 抒发诗人孤芳自赏，气节清高，不求引用之情感。 \n" +
//                "\n" +
//                "诗一开始用整齐的偶句，以春兰秋桂对举，点出无限生机和清雅高洁之特征。 三、四句，写兰桂充满活力却荣而不媚，不求人知之品质。上半首写兰桂，不写人。 五、六句以“谁知”急转引出与兰桂同调的山中隐者来。末两句点出无心与物相竞的 情怀。 \n" +
//                "\n" +
//                "全诗一面表达了恬淡从容超脱的襟怀，另一面忧谗惧祸的心情也隐然可见。诗以 草木照应，旨诣深刻，于咏物背后，寄寓着生活哲理。";
        String msg ="The list below isn\'t meant to be exclusive, it\'s more so a collection of links that have helped me out along the way (and can hopefully help you). As you\'ll see, I\'ve focused on JavaScript, React, and Node.js. There is also a wealth of information on interview prep and applying to jobs.\r\n\r\nI\'ve still got a lot of bookmarks to go through, so I\'ll be updating and adding links as I go. If you have a contribution, please feel free to submit a PR!";
        System.out.println("origin:"+msg.getBytes().toString());
        System.out.println("origin:"+msg.getBytes().length);
        String rs = gzip(msg);
        System.out.println("3333:"+rs);
        System.out.println("3333:"+rs.getBytes().length);
        System.out.println(rs);
        System.out.println(gunzip(rs));
    }
}
