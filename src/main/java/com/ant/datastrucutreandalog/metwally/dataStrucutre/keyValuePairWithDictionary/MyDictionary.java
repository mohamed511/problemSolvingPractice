package com.ant.datastrucutreandalog.metwally.dataStrucutre.keyValuePairWithDictionary;

public class MyDictionary<TKey, TValue> {
    // KeyValuePair[] entries;
    KeyValuePairTest<TKey, TValue>[] entries;
    int initialSize;
    int entriesCount;

    public MyDictionary() {
        this.initialSize = 3;
        // this casting to generate an array from generic class
        // this.entries = (KeyValuePair[]) new Object[this.initialSize];
        this.entries = new KeyValuePairTest[this.initialSize];
    }

    public void resizeOrNot() {
        if (this.entriesCount < this.entries.length - 1) {
            return;
        }
        int newSize = this.initialSize + this.entries.length;
        System.out.println("===> resize: from " + this.entries.length + " to " + newSize);
        //KeyValuePair[] newArr = (KeyValuePair[]) new Object[newSize];
        KeyValuePairTest[] newArr = new KeyValuePairTest[newSize];
        System.arraycopy(this.entries, 0, newArr, 0, this.entries.length);
        this.entries = newArr;
        System.out.println("===> new size is: " + this.entries.length);
    }

    public void set(TKey key, TValue value) {
        // check if the key already exist
        for (int i = 0; i < this.entries.length; i++) {
            // if the key exit update the value
            if (this.entries[i] != null && this.entries[i]._key == key) {
                this.entries[i]._value = value;
                return;
            }
        }
        // check if need to resize
        this.resizeOrNot();
        // add new key to the array
        // KeyValuePair newKeyValue = new KeyValuePair(key, value);
        KeyValuePairTest newKeyValue = new KeyValuePairTest(key, value);
        this.entries[this.entriesCount] = newKeyValue;
        this.entriesCount++;
    }

    public TValue get(TKey k) {
        for (int i = 0; i < this.entries.length; i++) {
            if (this.entries[i] != null && this.entries[i]._key == k) {
                return this.entries[i].get_value();
            }
        }
        return null;
    }

    public Boolean remove(TKey k) {
        for (int i = 0; i < this.entries.length; i++) {
            if (this.entries[i] != null && this.entries[i]._key == k) {
                this.entries[i] = this.entries[this.entriesCount - 1];
                this.entries[this.entriesCount - 1] = null;
                this.entriesCount--;
                return true;
            }
        }
        return false;
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
        System.out.println("---------------------------------------------------");
    }

    public int size() {
        return this.entriesCount;
    }

    /**
     * KeyValuePair Class
     */
//    class KeyValuePair {
//        TKey _key;
//        TValue _value;
//
//        public KeyValuePair(TKey _key, TValue _value) {
//            this._key = _key;
//            this._value = _value;
//        }
//
//        public TKey get_key() {
//            return _key;
//        }
//
//        public TValue get_value() {
//            return _value;
//        }
//
//        public void set_value(TValue _value) {
//            this._value = _value;
//        }
//    } // end KeyValuePair class

} // end KeyValuePair class
