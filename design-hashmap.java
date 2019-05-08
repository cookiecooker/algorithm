class MyHashMap {
    
    private boolean[] keys;
    private int[] values;

    /** Initialize your data structure here. */
    public MyHashMap() {
        keys = new boolean[100];
        values = new int[100];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        if (key >= keys.length) extend(key);
        keys[key] = true;
        values[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return key >= keys.length || !keys[key] ? -1 : values[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if (key < keys.length) keys[key] = false;
    }
    
    private void extend (int key) {
        keys = Arrays.copyOf(keys, key + 1);
        values = Arrays.copyOf(values, key + 1);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */