package org.example.abstractfacade;

import org.example.facade.Video;

import java.io.IOException;

public class CodecTypeMP3Handler extends Codec {

    public void extract(Video video) throws IOException {
        super.extract(video);
        System.out.println("==========Extracting==========");
        System.out.println("==========Codec Type MP3======");
    }
}
