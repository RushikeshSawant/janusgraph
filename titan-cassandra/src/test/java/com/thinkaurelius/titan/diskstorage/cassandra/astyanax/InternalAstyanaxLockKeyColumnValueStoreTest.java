package com.thinkaurelius.titan.diskstorage.cassandra.astyanax;

import com.thinkaurelius.titan.CassandraStorageSetup;
import com.thinkaurelius.titan.diskstorage.LockKeyColumnValueStoreTest;
import com.thinkaurelius.titan.diskstorage.StorageException;
import com.thinkaurelius.titan.diskstorage.cassandra.embedded.CassandraDaemonWrapper;
import com.thinkaurelius.titan.diskstorage.keycolumnvalue.KeyColumnValueStoreManager;
import org.apache.commons.configuration.Configuration;
import org.junit.BeforeClass;

public class InternalAstyanaxLockKeyColumnValueStoreTest extends LockKeyColumnValueStoreTest {

    @BeforeClass
    public static void startCassandra() {
        CassandraDaemonWrapper.start(CassandraStorageSetup.cassandraYamlPath);
    }

    @Override
    public KeyColumnValueStoreManager openStorageManager(int idx) throws StorageException {
        Configuration sc = CassandraStorageSetup.getCassandraStorageConfiguration();
        return new AstyanaxStoreManager(sc);
    }
}