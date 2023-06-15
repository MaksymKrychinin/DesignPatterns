package org.example.abstractfacade;

import lombok.ToString;
import org.example.facade.Video;

import java.io.IOException;

@ToString
public abstract class Codec {
    String codecType;

    public void extract(Video video) throws IOException {
        if (!video.getCodecType().equals(codecType))
            throw new IOException("Incomparable codec format");
    }
}
