package org.example.chain;

import java.util.List;

public abstract class Chain {
    private Chain chain;

    public static Chain setChain(Chain headOfChain, List<Chain> chains) {
        Chain head = headOfChain;
        for (var a : chains) {
            head.chain = a;
            head = a;
        }
        return headOfChain;
    }


    public abstract void doChain(String s);

    protected void checkNext(String s) {
        if (chain == null) {
            return;
        }
        chain.doChain(s);
    }
}
