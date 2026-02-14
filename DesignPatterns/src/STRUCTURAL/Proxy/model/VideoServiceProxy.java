package STRUCTURAL.Proxy.model;

public class VideoServiceProxy implements VideoService{
    private String userType;
    private PremiumVideoService premiumVideoService;
    public VideoServiceProxy(String userType){
        this.userType=userType;
    }
    @Override
    public void playVideo() {


        if(!userType.equals("PREMIUM")){
            System.out.println("You Don't have access!!!");
            return;
        }

        //--------can put multiple other checks here also-------

        if(premiumVideoService==null){
            premiumVideoService=new PremiumVideoService();
        }
        premiumVideoService.playVideo();

    }
}
