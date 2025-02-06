import java.awt.*;

public class Trucks extends VehicleFramework{

    private int platform = 0;

    public Trucks(int nrDoors, double enginePower, int weight, Color color, String modelname, int platform ) {
        super(nrDoors, enginePower, weight, color, modelname);
        this.platform = platform;
    }

    public int getPlatform(){
        return platform;
    }

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

    @Override
    public void move(){
        if(this.getPlatform() == 0){
            super.move();
        }
        else{
            throw new IllegalArgumentException("Platform must be of angle 0 to drive");
        }
    }
}
