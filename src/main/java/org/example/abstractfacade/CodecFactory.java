package org.example.abstractfacade;

import org.example.facade.Video;

public class CodecFactory {
    public Codec getCodec(Video video) {
        String codecType = video.getCodecType();
        Codec codec;
        try {
            Class<? extends Codec> aClass = (Class<Codec>) Class.forName("org.example.abstractfacade.CodecType" + codecType.toUpperCase() + "Handler");
            codec = aClass.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        codec.codecType=codecType;
        return codec;
    }
}
