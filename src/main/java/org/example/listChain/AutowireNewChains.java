package org.example.listChain;


import java.util.List;

public class AutowireNewChains {
    List<Chain> chainList;

    public AutowireNewChains(List<Chain> chainList) {
        this.chainList = chainList;
    }

    public void doChain(TesterForChange a) {
        chainList.forEach(chain -> chain.execute(a));
    }
}
