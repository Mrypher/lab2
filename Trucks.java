import java.awt.*;

public class Lastbilar extends Car{

    private int platform = 0;

    public Lastbilar(int nrDoors, double enginePower, int weight, Color color, String modelname, int platform ) {
        super(nrDoors, enginePower, weight, color, modelname);
        this.platform = platform;
    }

    public int getPlatform(){return platform;}

    protected void setPlatform(){
        if (getCurrentSpeed()==0){
            if(getPlatform() == 0){
                platform = 70;
            }
            else {
                platform = 0;
            }
        }
    }
}
