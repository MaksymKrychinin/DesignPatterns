package org.example;

import org.example.builder.CarBuilder;
import org.example.chain.Chain;
import org.example.chain.ChainExampleOne;
import org.example.chain.ChainExampleTwo;
import org.example.facade.Codec;
import org.example.facade.CodecFactory;
import org.example.facade.Video;
import org.example.listChain.AutowireNewChains;
import org.example.listChain.TesterForChange;
import org.example.builder.Car;


import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public static void facade() {
        Video videoMp4 = new Video("someVideoFile.mp3.mp4");
        CodecFactory codecFactory = new CodecFactory();
        Codec codec = codecFactory.getCodec(videoMp4);
        codec.extract();
        Video videoMp3 = new Video("someVideoFile.mp3");
        codec = codecFactory.getCodec(videoMp3);
        codec.extract();
    }

    public static void abstractFacade() {
        Video facadeVideoMp4 =
                new Video("someVideoFile.mp3.mp4");
        Video facadeVideoMp3 =
                new Video("someVideoFile.mp3");
        org.example.abstractfacade.CodecFactory facadeCodecFactory =
                new org.example.abstractfacade.CodecFactory();
        org.example.abstractfacade.Codec abstractCodec = facadeCodecFactory.getCodec(facadeVideoMp4);
        try {
            abstractCodec.extract(facadeVideoMp3);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            abstractCodec.extract(facadeVideoMp4);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void chain(Chain head, List<Chain> chainList) {
        Chain chain = new ChainExampleOne();
        Chain chain1 = new ChainExampleTwo();
        Chain chain2 = new Chain() {
            @Override
            public void doChain(String s) {
                s+="Chain 3";
                checkNext(s);
            }
        };
        chain(chain, List.of(chain1,chain2));

        Chain starterChain = Chain.setChain(head, chainList);
        String startString = "Start string";
        starterChain.doChain(startString);
        System.out.println(startString);
    }

    public static CarBuilder builder() {
        return Car.builder();
    }

    public static void ListChain(List<org.example.listChain.Chain> list, Object objectToChange) {
        AutowireNewChains autowireNewChains = new AutowireNewChains(list);
        TesterForChange testerForChange = new TesterForChange(objectToChange);
        autowireNewChains.doChain(testerForChange);
        System.out.println(testerForChange);
    }

    public static void outObject(Object object) {
        System.out.println(object.getClass() + " " + object);
    }
}