class SnapshotArray {
    
    int snapId = 0;
    TreeMap<Integer, Integer>[] snapshots;
    

    public SnapshotArray(int length) {
        snapshots = new TreeMap[length];
        
        for (int i = 0; i < length; i++) {
            snapshots[i] = new TreeMap<Integer, Integer>();
            snapshots[i].put(0, 0);
        }        
    }
    
    public void set(int index, int val) {
        snapshots[index].put(snapId, val);
    }
    
    public int snap() {
        snapId++;
        return snapId-1;
    }
    
    public int get(int index, int snap_id) {
        return snapshots[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */