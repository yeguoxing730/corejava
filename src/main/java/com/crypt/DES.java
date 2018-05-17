package com.crypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DES {
    private static String strkey ="deskeyhh";



    public static String encryptToBase64(String message, String key)throws Exception{
        byte[] cipherStr =   encrypt(message,key);
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(cipherStr);
    }
    public static String encryptToHex(String message, String key )throws Exception{
        byte[] cipherStr =   encrypt(message,key);
        return  toHexString(cipherStr);
    }
    public static byte[] encrypt(String message, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        return cipher.doFinal(message.getBytes("UTF-8"));
    }

    public static String decrypt(byte[] bytesrc, String key) throws Exception {
//        byte[] bytesrc = decodeBase64(message);//convertHexString(message);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        byte[] retByte = cipher.doFinal(bytesrc);
        return new String(retByte);
    }
    public static String decryptBase64(String base64String, String key)throws Exception{
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] bytes =   base64Decoder.decodeBuffer(base64String);
        return decrypt(bytes,key);
    }
    public static String decryptHex(String base64String, String key)throws Exception{
        byte[] bytes =  hexStringToBytes(base64String);
        return decrypt(bytes,key);
    }

    public static String toHexString(byte b[]) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String plainText = Integer.toHexString(0xff & b[i]);
            if (plainText.length() < 2)
                plainText = "0" + plainText;
            hexString.append(plainText);
        }
        return hexString.toString();
    }


    public static String encodeBase64(byte[] b) {
        BASE64Encoder base64Encoder = new BASE64Encoder();
//        System.out.println(b.length);
//        StringBuilder sb = new StringBuilder();
//        for(int i=0;i<b.length;i++){
//            sb.append
//        }

        return toHexString(b);//base64Encoder.encode(b);
//        return Base64.encodeToString(b, Base64.DEFAULT);
    }

    public static byte[] decodeBase64(String base64String) throws Exception{
        BASE64Decoder base64Decoder = new BASE64Decoder();
        return  base64Decoder.decodeBuffer(base64String);
    }
    public final static String DES_KEY_STRING = "1iwuajqu";
    public static void main(String[] args)throws Exception{
        String encryptStr = "longlongtextlongtesttagshjasjas asaasldksd";
        String res = encryptToBase64(encryptStr,DES_KEY_STRING);
        System.out.println(res);
        System.out.println(res.length());
        String convet = decryptBase64(res,DES_KEY_STRING);
        System.out.println(convet);

        String encryptHex = encryptToHex(encryptStr,DES_KEY_STRING);
        System.out.println(encryptHex);
        System.out.println(encryptHex.length());
        String convet2 = decryptHex(res,DES_KEY_STRING);
        System.out.println(convet2);
    }

    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }
    public static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

}
