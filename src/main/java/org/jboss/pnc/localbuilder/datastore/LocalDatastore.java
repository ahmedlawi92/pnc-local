package org.jboss.pnc.localbuilder.datastore;


import org.jboss.pnc.model.*;
import org.jboss.pnc.spi.datastore.Datastore;
import org.jboss.pnc.spi.datastore.DatastoreException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by aabulawi on 24/06/15.
 */
public class LocalDatastore implements Datastore {

    private List<BuildRecord> buildRecords = Collections.synchronizedList(new ArrayList<BuildRecord>());
    private List<BuildConfigSetRecord> buildConfigSetRecords = Collections.synchronizedList(new ArrayList<BuildConfigSetRecord>());

    AtomicInteger buildRecordSequence = new AtomicInteger(0);

    @Override
    public BuildRecord storeCompletedBuild(BuildRecord buildRecord, Set<Integer> set) throws DatastoreException {
        buildRecords.add(buildRecord);
        return buildRecord;
    }

    @Override
    public User retrieveUserByUsername(String username) {
        User user = new User();
        user.setUsername("local-user");
        return user;
    }

    @Override
    public void createNewUser(User user) {
    }

    @Override
    public int getNextBuildRecordId() {
        return buildRecordSequence.incrementAndGet();
    }

    @Override
    public BuildConfigSetRecord saveBuildConfigSetRecord(BuildConfigSetRecord buildConfigSetRecord) {
        buildConfigSetRecords.add(buildConfigSetRecord);
        return buildConfigSetRecord;
    }

    @Override
    public BuildConfigurationAudited getLatestBuildConfigurationAudited(Integer integer) {
        return null;
    }
}
