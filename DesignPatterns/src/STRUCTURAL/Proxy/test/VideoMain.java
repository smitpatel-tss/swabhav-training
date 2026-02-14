package STRUCTURAL.Proxy.test;

import STRUCTURAL.Proxy.model.VideoService;
import STRUCTURAL.Proxy.model.VideoServiceProxy;

public class VideoMain {
    public static void main(String[] args) {
        VideoService videoService1=new VideoServiceProxy("PREMIUM");
        VideoService videoService2=new VideoServiceProxy("SASTA");

        videoService1.playVideo();
        videoService2.playVideo();
    }
}
