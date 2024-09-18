package com.ant.datastrucutreandalog.metwally.dataStrucutre.keyValuePairWithDictionary;

public class KeyValuePairTest<TKey, TValue> {
    TKey _key;
    TValue _value;

    public KeyValuePairTest(TKey _key, TValue _value) {
        this._key = _key;
        this._value = _value;
    }

    public TKey get_key() {
        return _key;
    }

    public TValue get_value() {
        return _value;
    }

    public void set_value(TValue _value) {
        this._value = _value;
    }
}
