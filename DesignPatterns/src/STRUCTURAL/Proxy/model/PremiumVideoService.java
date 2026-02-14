package STRUCTURAL.Proxy.model;

public class PremiumVideoService implements VideoService{
    @Override
    public void playVideo() {
        loadVideo();
        System.out.println("Playing Video...");
    }
    private void loadVideo(){
        System.out.println("Loading Video...");
    }
}
