package ui;

public class Container {
    Platform platform;

    //Singleton
    private static Container instance;
    private Container(){}
    public static Container getInstance(){
        if(instance == null){
            instance = new Container();
        }
        return instance;
    }

    public void setPlatform(Platform platform){
        this.platform = platform;
    }
    public Platform getPlatform(){
        return platform;
    }
    public void runPlatform(Platform platform) {
        Container container = Container.getInstance();
        container.setPlatform(platform);
        container.getPlatform().runDriver();
    }
}
