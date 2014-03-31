/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.leafcoin.params;


import com.google.leafcoin.core.*;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static com.google.common.base.Preconditions.checkState;

/**
 * Parameters for the main production network on which people trade goods and services.
 */
public class MainNetParams extends NetworkParameters {
    public MainNetParams() {
        super();
        interval = INTERVAL;
        newInterval = INTERVAL_NEW;
        targetTimespan = TARGET_TIMESPAN;
        newTargetTimespan = TARGET_TIMESPAN_NEW;
        proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);
        dumpedPrivateKeyHeader = 223; //This is always addressHeader + 128
        addressHeader = 95;
        //p2shHeader = 5; //We don't have this
        acceptableAddressCodes = new int[] { addressHeader };
        port = 22813;
        
        packetMagic = 0xaaaaaacc;
        genesisBlock.setDifficultyTarget(0x1e0ffff0L);
        genesisBlock.setTime(1388880557L);
        genesisBlock.setNonce(751211697);
        id = ID_MAINNET;
        subsidyDecreaseBlockCount = 100000;
        spendableCoinbaseDepth = 100;
        String genesisHash = genesisBlock.getHashAsString();
        checkState(genesisHash.equals("721abe3814e15f1ab50514c8b7fffa7578c1f35aa915275ee91f4cb8d02be5c4"),
                genesisHash);

        
        // This contains (at a minimum) the blocks which are not BIP30 compliant. BIP30 changed how duplicate
        // transactions are handled. Duplicated transactions could occur in the case where a coinbase had the same
        // extraNonce and the same outputs but appeared at different heights, and greatly complicated re-org handling.
        // Having these here simplifies block connection logic considerably.
        /* checkpoints.put(91722, new Sha256Hash("00000000000271a2dc26e7667f8419f2e15416dc6955e5a6c6cdf3f2574dd08e"));
        checkpoints.put(91812, new Sha256Hash("00000000000af0aed4792b1acee3d966af36cf5def14935db8de83d6f9306f2f"));
        checkpoints.put(91842, new Sha256Hash("00000000000a4d0a398161ffc163c503763b1f4360639393e0e4c8e300e0caec"));
        checkpoints.put(91880, new Sha256Hash("00000000000743f190a18c5577a3c2d2a1f610ae9601ac046a38084ccb7cd721"));
        checkpoints.put(200000, new Sha256Hash("000000000000034a7dedef4a161fa058a2d67a173a90155f3a2fe6fc132e0ebf")); */
        //TODO Get actual Leafcoin checkpoints
     
        /*
        checkpoints.put(10, new Sha256Hash("0xb7d642e9658e13a912685dd5c252da389db91c96e7daffbcae1c630e0243c31a"));
        checkpoints.put(16755, new Sha256Hash("0x7a2d2354ffd776da35061ec983d0e38ffb01cb87a1e0e35ecb1b644f62dc4379"));
        checkpoints.put(17542, new Sha256Hash("0xaa30d8b18eb39522e4f80bcf562abeef9a0db08b6855ebb70d96a9ab396dd8f3"));
        checkpoints.put(18338, new Sha256Hash("0x96fe9464024e09ebe95261f96ff01bfdc01553f7a800fb3656a34da4dfffbd6c"));
        checkpoints.put(18818, new Sha256Hash("0x8057cf460b2b6b375148e4ac9e6c8b0193775d78079e7b2037f6e8d44185afc5"));
        checkpoints.put(18819, new Sha256Hash("0x62e129b02411ae495ba43daa4dd8e87b912175ac5c23745e265f6c774d24b905"));
        checkpoints.put(18900, new Sha256Hash("0x107034123b366f5de7642f75fb84d54c830da86b7c0f531dd843361e31d6fc7b"));
        checkpoints.put(18980, new Sha256Hash("0xda3e72700b01f0c6ae111ba9fb43e0b5f8c2fe473db3a5a4a5ba9c12c8f37046"));
        */
        


        dnsSeeds = new String[] {
                "seed.leafco.in",
                "seed2.leafco.in",
                "seed3.leafco.in",
                "seed4.leafco.in",
                "seed5.leafco.in",
                "seed6.leafco.in",
                "leafcoin.mercuriusgids.nl"
        };
    }

    private static MainNetParams instance;
    public static synchronized MainNetParams get() {
        if (instance == null) {
            instance = new MainNetParams();
        }
        return instance;
    }

    public String getPaymentProtocolId() {
        return PAYMENT_PROTOCOL_ID_MAINNET;
    }
}
