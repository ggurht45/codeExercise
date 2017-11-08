package exercise;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

//all this set up should happen when boot is called.

public class Planes {

    //buckets of queues to store planes
    private ConcurrentMap<Integer, ConcurrentLinkedQueue<AC>> planeBuckets = new ConcurrentHashMap<>();

    //ids in order of precedence; keyset order will not change
    private Map<Integer, String> idsBucketNamesMap = new LinkedHashMap<>();

    //initialize buckets to contain empty queues for planes
    public Planes() {
        //mappings from ids to name of buckets
        initializeIdMap();

        //initialize empty queues
        for (int id : idsBucketNamesMap.keySet()) {
            planeBuckets.put(id, new ConcurrentLinkedQueue<>());
        }
    }

    //show current number of planes in different buckets
    public String planesQueueState() {
        StringBuffer sBuffer = new StringBuffer("Plane Queues:\n");
        for (int id : idsBucketNamesMap.keySet()) {
            sBuffer.append(idsBucketNamesMap.get(id)+ ":\n\t" + planeBuckets.get(id) + "\n");
        }
        return sBuffer.toString();
    }


    //for every combination of type and size of plane a unique hashcode id is computed.
    private void initializeIdMap() {
        //create ids
        for (AC_Type t : AC_Type.values()) {
            for (AC_Size s : AC_Size.values()) {
                int id = getPlaneBucketId(t, s);
                String bucketName = t.toString() + "+" + s.toString();
                idsBucketNamesMap.put(id, bucketName);
            }
        }
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
        for (int id : idsBucketNamesMap.keySet()) {
            if (planeBuckets.get(id).peek() != null) {
                return planeBuckets.get(id).poll();
            }
        }
        return null; //no plane found in any of the buckets
    }
}

