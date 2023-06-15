package org.example.chain;

public class ChainExampleTwo extends Chain{
    @Override
    public void doChain(String s) {
        s+=" Chain 2 Execution";
        checkNext(s);
    }
}
