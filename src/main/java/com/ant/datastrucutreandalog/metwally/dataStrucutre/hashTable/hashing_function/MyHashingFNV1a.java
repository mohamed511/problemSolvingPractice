package com.ant.datastrucutreandalog.metwally.dataStrucutre.hashTable.hashing_function;

import java.nio.charset.StandardCharsets;

/**
 * ***********************************************************
 * ***************** Hash function ***************************
 * ********************* FNV-1a ******************************
 * ***********************************************************
 * */
public class MyHashingFNV1a {
    private static final long OFF_SET_BASIC_32 = 2166136261L;
    private static final int OFF_SET_BASIC_32_hex = 0x811c9dc5;
    private static final int FNV1_PRIME_32 = 16777619;

    private static final long OFF_SET_BASIC_64_hex = 0xcbf29ce484222325L;
    private static final long FNV1_PRIME_64 = 1099511628211L;
    // private static final long OFF_SET_BASIC_64 = 14695981039346656037;

    public int hash32(String str) {
        byte[] data = str.getBytes(StandardCharsets.US_ASCII);
        int hash = OFF_SET_BASIC_32_hex;
        for (int i = 0; i < data.length; i++) {
            hash = hash ^ data[i];
            // hash = 0xff ^ data[i];
            hash = hash * FNV1_PRIME_32;
        }
        System.out.println("===> in method hash32 ");
        System.out.println(str + " - " + hash + " - " + Integer.toHexString(hash));
        return hash;
    }

    public long hash64(String str) {
        byte[] data = str.getBytes(StandardCharsets.US_ASCII);
        long hash = OFF_SET_BASIC_64_hex;
        for (int i = 0; i < data.length; i++) {
            hash = hash ^ data[i];
            // hash = 0xff ^ data[i];
            hash = hash * FNV1_PRIME_64;
        }
        System.out.println("===> in method hash64 ");
        System.out.println(str + " - " + hash + " - " + Long.toHexString(hash));
        return hash;
    }

    public static void main(String[] args) {
        String value = "This is Original Text";
        MyHashingFNV1a s = new MyHashingFNV1a();
        // result should be => 3591082917, d60b93a5
        System.out.println("===> Hash 32");
        s.hash32(value);
        // result should be => 12313285910960374725, aae1944c249d83c5
        System.out.println("===> Hash 64");
        s.hash64(value);
        // 2332089041 - 8b00dad1
        // 6133458162749176891 - aae1944c249d83c5
        // 6133458162749176891

        // Git Implementation
        byte[] data = value.getBytes(StandardCharsets.US_ASCII);
        int hubValue32 = GitHubHashing.hash32(data);
        long hubValue64 = GitHubHashing.hash64(data);
        System.out.println("32 Git Implementation" + " -> " + hubValue32);
        System.out.println("64 Git Implementation" + " -> " + hubValue64);

    }
}
