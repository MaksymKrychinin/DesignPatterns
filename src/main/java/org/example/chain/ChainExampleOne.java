package org.example.chain;

public class ChainExampleOne extends Chain{

    @Override
    public void doChain(String s) {
        s+="Chain 1 Execution";
        checkNext(s);
    }
}
