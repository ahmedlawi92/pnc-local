package org.jboss.pnc.localspi;

import org.jboss.pnc.model.BuildRecord;
import org.jboss.pnc.model.User;
import org.jboss.pnc.spi.datastore.Datastore;
import org.jboss.pnc.spi.datastore.DatastoreException;

/**
 * Created by aabulawi on 24/06/15.
 */
public class MockDatastore implements Datastore {
    @Override
    public void storeCompletedBuild(BuildRecord buildRecord) throws DatastoreException {

    }

    @Override
    public User retrieveUserByUsername(String s) {
        return null;
    }

    @Override
    public void createNewUser(User user) {

    }

    @Override
    public int getNextBuildRecordId() {
        return 0;
    }

    @Override
    public int getNextBuildConfigSetRecordId() {
        return 0;
    }
}