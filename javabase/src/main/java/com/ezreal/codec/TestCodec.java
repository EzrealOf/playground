//package com.ezreal.codec;
//
//import com.google.common.collect.Lists;
//import org.apache.commons.codec.DecoderException;
//import org.apache.commons.codec.binary.Hex;
//import org.apache.commons.lang3.StringUtils;
//
//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//import java.util.List;
//
//public class TestCodec {
//
//
//    public static void main(String[] args) throws CipherException, DecoderException {
////        String key = OptimusConfig.getValue("aes.key");
////        String iv = OptimusConfig.getValue("aes.iv");
//        String key = "01234567890123450123456789012345";
//        String iv = "0123456789012345";
////        AESUtils aesUtils = AESUtils.getInstance().algorithmMode(AESUtils.AlgorithmMode.CBC).key(key.getBytes(StandardCharsets.UTF_8)).paddingMode(AESUtils.PaddingMode.PKCS5Padding).iv(iv.getBytes(StandardCharsets.UTF_8));
//        AESUtils aesUtils = AESUtils.getInstance().algorithmMode(AESUtils.AlgorithmMode.ECB).key(key.getBytes(StandardCharsets.UTF_8)).paddingMode(AESUtils.PaddingMode.PKCS5Padding);
//
////        List<String> needed = Lists.newArrayList("450323197912258335","371525196401166738","411327201201269351","500155199702123137","110114199903258476","420502197702140770","530425195503191255","450224200409140095","150702196703252978","43092219890116375X");
////        List<String> needed = Lists.newArrayList("62220209728258623211", "62220225611240122114", "62220260831040451176", "62220275922311541796", "62220299898119518487");
//        List<String> needed = Lists.newArrayList("110101196403071319");
//        for (String str : needed) {
//            // 加密
//            byte[] encrypt = aesUtils.encrypt(str.getBytes(StandardCharsets.UTF_8));
//            String encodeHexString = Hex.encodeHexString(encrypt);
//            byte[] encode = Base64.getEncoder().encode(encrypt);
//            System.out.println(encrypt);
//            String base64 = Base64.getEncoder().encodeToString(encrypt);
//            String base64byte = new String(encode);
//            System.out.println(str.length());
//
//            System.out.println(encodeHexString + '\t' + encodeHexString.length());
//            System.out.println(base64 + '\t' + base64.length());
//            System.out.println(base64byte + '\t' + base64byte.length());
//
//
//            // 解密
//            byte[] bytes = Hex.decodeHex(encodeHexString);
//
//            String decryptToString = aesUtils.decryptToString(bytes, StandardCharsets.UTF_8.name());
//            String base64Decrypt = aesUtils.decryptToString(base64, StandardCharsets.UTF_8.name());
//            if (!StringUtils.equals(decryptToString, str)) {
//                System.out.println(str);
//            }
//            if (!StringUtils.equals(base64Decrypt, str)) {
//                System.out.println(str);
//            }
//        }
//
//
//    }
//
//}
