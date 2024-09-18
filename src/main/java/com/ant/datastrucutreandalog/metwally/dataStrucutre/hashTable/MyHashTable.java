package com.ant.datastrucutreandalog.metwally.dataStrucutre.hashTable;

import com.ant.data.structure.metwally.dataStrucutre.keyValuePairWithDictionary.KeyValuePairTest;

public class MyHashTable<TKey, TValue> {
    KeyValuePairTest<TKey, TValue>[] entries;
    int initialSize;
    int entriesCount;

    public MyHashTable() {
        this.initialSize = 3;
        this.entries = new KeyValuePairTest[this.initialSize];
    }

    private int getHash(TKey key) {
        /** ============== ERROR =============
         * the hashing FNV1a is always return mins value
         * and this is not working
         * **/
//        long OFF_SET_BASIC_32 = 2166136261L;
//        final int OFF_SET_BASIC_32_hex = 0x811c9dc5;
//        final int FNV1_PRIME_32 = 16777619;
//
//        byte[] data = key.toString().getBytes(StandardCharsets.US_ASCII);
//        int hash = OFF_SET_BASIC_32_hex;
//        for (int i = 0; i < data.length; i++) {
//            hash = hash ^ data[i];
//            hash = hash * FNV1_PRIME_32;
//        }
//        System.out.println(key + " - " + hash + " - " + Integer.toHexString(hash) +
//                " - " + hash % this.entries.length);
//          return hash % this.entries.length;
        System.out.println("[Hashing]" + key + " = " + key.toString().length() % this.entries.length);
        return key.toString().length() % this.entries.length;
    }

    public void print() {
        System.out.println("===========start=======================");
        System.out.println("- Size = " + this.size());
        for (int i = 0; i < this.entries.length; i++) {
            if (this.entries[i] == null) {
                System.out.println("[" + i + "]");
                continue;
            } else {
                System.out.println("[" + i + "] " + this.entries[i].get_key() + " : " + this.entries[i].get_value());
            }
        }
        System.out.println("----------------end-----------------------------------");
    }

    public int size() {
        return this.entriesCount;
    }

    /**
     * resize the array
     **/
    private void resizeOrNot() throws Exception {
        if (this.entriesCount < this.entries.length) {
            return;
        }
        System.out.println("[resize] => current: " + this.entries.length);
        int newSize = this.entries.length * 2;
        // copy the entries array in new array
        KeyValuePairTest<TKey, TValue>[] entriesCopy = new KeyValuePairTest[this.entries.length];
        System.arraycopy(this.entries, 0, entriesCopy, 0, this.entries.length);
        // resize the entries array
        this.entries = new KeyValuePairTest[newSize];
        this.entriesCount = 0;
        // loop on entriesArrayValues and add it again to the entries array with rehashing
        for (int i = 0; i < entriesCopy.length; i++) {
            if (entriesCopy[i] == null) {
                continue;
            } else {
                this.addEntries(entriesCopy[i].get_key(), entriesCopy[i].get_value());
            }
        }
    }

    /**
     * collision handling using linear probing
     **/
    private int collisionHandling(TKey key, int hash, boolean set) {
        int newHash;
        for (int i = 1; i < this.entries.length; i++) {
            newHash = (hash + i) % this.entries.length;
            if (set && (this.entries[newHash] == null || this.entries[newHash].get_key() == key)) {
                System.out.println("[Collision] " + key + " => old: " + hash + " newHash: " + newHash);
                return newHash;
            } else if (!set && (this.entries[newHash].get_key() == key)) {
                System.out.println("[Collision] " + key + " => old: " + hash + " newHash: " + newHash);
                return newHash;
            }
        }
        System.out.println("[Collision] " + key + hash + " ==> failed!");
        return -1;
    }

    /**
     * add new key value pair
     **/
    private void addEntries(TKey key, TValue value) throws Exception {
        int hash = getHash(key);
        // if this condition is true mean we have collision
        if (this.entries[hash] != null && this.entries[hash].get_key() != key) {
            // handle the collision
            // true = we are in set mod
            hash = collisionHandling(key, hash, true);
        }
        // incase failed to get a hash
        if (hash == -1) {
            throw new Exception("===> invalid hashtable!!!");
        }
        // incase the slot is empty
        if (this.entries[hash] == null) {
            KeyValuePairTest<TKey, TValue> newKeyValuePair = new KeyValuePairTest<>(key, value);
            this.entries[hash] = newKeyValuePair;
            this.entriesCount++;
        } else if (this.entries[hash] == key) {
            this.entries[hash].set_value(value);
        } else {
            throw new Exception("===> something wrong!!!");
        }
    }

    /**
     * set new key value pair
     **/
    public void set(TKey key, TValue value) throws Exception {
        this.resizeOrNot();
        this.addEntries(key, value);
    }

    /**
     * get key value pair
     **/
    public TValue get(TKey key) throws Exception {
        int hash = getHash(key);
        // if this condition is true mean we have collision
        if (this.entries[hash] != null && !this.entries[hash].get_key().equals(key)) {
            // handle the collision
            // false = we are in get mod
            hash = collisionHandling(key, hash, false);
        }
        // incase failed to get a hash or the slot is empty
        if (hash == -1 || this.entries[hash] == null) {
            return null;
        }
        if (this.entries[hash].get_key().equals(key)) {
            return this.entries[hash].get_value();
        } else {
            throw new Exception("===> hash not exist and this is not true!!!");
        }
    }

    public void delete(){

    }
}
