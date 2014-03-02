package com.google.leafcoin.core;

import com.google.leafcoin.core.NetworkParameters;
import com.google.leafcoin.store.BlockStoreException;
import com.google.leafcoin.store.FullPrunedBlockStore;
import com.google.leafcoin.store.MemoryFullPrunedBlockStore;

/**
 * A MemoryStore implementation of the FullPrunedBlockStoreTest
 */
public class MemoryFullPrunedBlockChainTest extends AbstractFullPrunedBlockChainTest
{
    @Override
    public FullPrunedBlockStore createStore(NetworkParameters params, int blockCount) throws BlockStoreException
    {
        return new MemoryFullPrunedBlockStore(params, blockCount);
    }

    @Override
    public void resetStore(FullPrunedBlockStore store) throws BlockStoreException
    {
        //No-op for memory store, because it's not persistent
    }
}
