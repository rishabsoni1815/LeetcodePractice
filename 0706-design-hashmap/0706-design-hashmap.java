class MyHashMap {
    MyHashMaps<Integer, Integer> map;

    public MyHashMap() {
         map = new MyHashMaps<>(2);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    public int get(int key) {
        return map.get(key)==null ? -1 : map.get(key);
    }

    public void remove(int key) {
        map.remove(key);
    }
}

class MyHashMaps<K, V> {
    double load_factor = 0.75f;
    int curSize;
    Entry<K, V>[] map;

    public MyHashMaps(int cap) {
        int size = getSize(cap);
        map = new Entry[size];
        this.curSize = 0;
    }

    int getSize(int cap) {//getting nearest power of 2 >= cap
        int size = 1;
        while (size < cap)
            size <<= 1;
        return size;
    }

    void put(K key, V value) {
        int idx = getIndex(key);
        Entry<K, V> entry = map[idx];
        boolean found = false;
        Entry prev = null;
        while (entry != null) {
            if (entry.key.equals(key)) {
                entry.value = value;
                found = true;
                break;
            }
            prev = entry;
            entry = entry.next;
        }
        if (!found) {
            if (prev == null)
                map[idx] = new Entry<>(key, value);
            else
                prev.next = new Entry<>(key, value);
            curSize++;
        }
        if (curSize > map.length * load_factor)
            resize();
    }

    void resize() {
        Entry<K, V>[] oldMap = map;
        curSize = 0;
        map = new Entry[map.length * 2];
        for (Entry<K, V> entry : oldMap) {
            while (entry != null) {
                this.put(entry.key, entry.value);
                entry = entry.next;
            }
        }
    }

    V get(K key) {
        int idx = getIndex(key);
        Entry<K, V> entry = map[idx];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    void remove(K key) {
        int idx = getIndex(key);
        Entry<K, V> entry = map[idx];
        boolean found = false;
        Entry prev = null;
        while (entry != null) {
            if (entry.key.equals(key)) {
                Entry next = entry.next;
                if (prev != null)
                    prev.next = next;
                else
                    map[idx] = next;
                entry = null;
                curSize--;
                return;
            }
            prev = entry;
            entry = entry.next;
        }
    }

    int getIndex(K key) {
        int hash = Math.abs(key.hashCode()) % map.length;
        return hash;
        //            return hash&(map.length-1); & also return btw 1 to 2^n since size is power of 2
    }

    class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */