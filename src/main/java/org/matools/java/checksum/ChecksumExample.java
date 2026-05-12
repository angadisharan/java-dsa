package org.matools.java.checksum;

import java.security.MessageDigest;
import java.util.zip.CRC32;

public class ChecksumExample {
    public static void main(String[] args) throws Exception {
        String input = "Hello";

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(input.getBytes());

        StringBuilder hex = new StringBuilder();
        for (byte b : digest) {
            hex.append(String.format("%02x", b));
        }
        System.out.println("MD5: " + hex.toString());




        md = MessageDigest.getInstance("SHA-256");
        digest = md.digest(input.getBytes());

        for (byte b : digest) {
            hex.append(String.format("%02x", b));
        }

        System.out.println("SHA-256: " + hex.toString());

        md = MessageDigest.getInstance("SHA-512");
        digest = md.digest(input.getBytes());

        hex = new StringBuilder();
        for (byte b : digest) {
            hex.append(String.format("%02x", b));
        }

        System.out.println("SHA-512: " + hex.toString());



        CRC32 crc = new CRC32();
        crc.update(input.getBytes());

        long checksum = crc.getValue();
        System.out.println("CRC32: " + checksum);
    }
}