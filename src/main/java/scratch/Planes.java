package scratch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

//all this set up should happen when boot is called.

public class Planes {

    //buckets of queues to store planes
    private ConcurrentMap<Integer, ConcurrentLinkedQueue<AC>> planeBuckets = new ConcurrentHashMap<>();

    //ids in order of precedence
    private ArrayList<Integer> idsInOrder;

    //initialize buckets to contain empty queues for planes
    public Planes() {
        System.out.println("initializing plane q's...");
        Set<Integer> ids = getBucketIds();
        for (int id : ids) {
            planeBuckets.put(id, new ConcurrentLinkedQueue<>());
        }
    }

    //for every combination of type and size of plane a unique hashcode id is computed.
    private Set<Integer> getBucketIds() {
        Set<Integer> set = new HashSet<>();
        //create ids
        for (AC_Type t : AC_Type.values()) {
            for (AC_Size s : AC_Size.values()) {
                int id = getPlaneBucketId(t, s);
                set.add(id);
                idsInOrder.add(id);
            }
        }
        return set;
    }

    //helper method to get the id of the bucket in which the plane is stored.
    private int getPlaneBucketId(AC_Type t, AC_Size s) {
        String stringId = t.toString() + s.toString();
        int id = stringId.hashCode();
        return id;
    }

    //add plane to appropriate place
    public void addPlane(AC plane) {
        AC_Type t = plane.getType();
        AC_Size s = plane.getSize();
        int bucketId = getPlaneBucketId(t, s);
        planeBuckets.get(bucketId).add(plane); // add plane to appropriate q
    }


    //remove highest priority plane
    public AC removePlane() {
        //will go through passenger+large plane ids first, then passenger+small, cargo+large, cargo+small
        for (int id : idsInOrder) {
            if (planeBuckets.get(id).peek() != null) {
                return planeBuckets.get(id).poll();
            }
        }
        return null; //no plane found in any of the buckets
    }
}

