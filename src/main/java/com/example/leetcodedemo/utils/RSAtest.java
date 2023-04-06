package com.example.leetcodedemo.utils;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @author wc
 * @date 2023/2/21 9:47
 * desc   Stay hungry, stay foolish
 **/
public class RSAtest {
    public static void main(String[] args) throws Exception {
        //获取RSA算法的密钥生成器对象
        KeyPairGenerator keyPairGen  = KeyPairGenerator.getInstance("RSA");
        //设定密钥长度为1024位
        keyPairGen.initialize(1024);
        //生成"密钥对"对象
        KeyPair keyPair = keyPairGen.generateKeyPair();
        //分别获取私钥和公钥对象
        RSAPrivateKey  rsaPrivateKey  = (RSAPrivateKey)keyPair.getPrivate();
        RSAPublicKey rsapublicKey  =(RSAPublicKey) keyPair.getPublic();
        //执行加密和解密过程
        RSAtest encrypt = new RSAtest();
        String encryptText="这是秘密!";
        //得到要加密内容的数组
        byte[] srcData  = encryptText.getBytes();
        //用公钥加密
        byte[] e = encrypt.encrypt(rsapublicKey, srcData);
        System.out.println("加密后的字符串内容"+new String(e));
        //用私钥解密
        byte[] decrypt = encrypt.decrypt(rsaPrivateKey, e);
        System.out.println("私钥解密后的内容："+new String(decrypt));
    }
    protected byte[] encrypt(RSAPublicKey publicKey,byte[] obj)throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        //返回加密后的内容
        return cipher.doFinal(obj);
    }
    protected byte[] decrypt(RSAPrivateKey privateKey,byte[] obj)throws Exception{
        Cipher cipher  = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        //返回解密后的数组
        return cipher.doFinal(obj);
    }

}
