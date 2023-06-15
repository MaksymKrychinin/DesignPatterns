package org.example.facade;

public class CodecFactory {
    public Codec getCodec(Video video) {
        String codecType = video.getCodecType();
        Codec codec;
        try {
            Class<? extends Codec> aClass = (Class<Codec>) Class.forName("org.example.facade.CodecType" + codecType.toUpperCase() + "Handler");
            codec = aClass.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return codec;
    }
}
