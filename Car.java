import java.awt.*;

public abstract class Car extends VehicleFramework{
    private boolean Loaded;

    public Car(int nrDoors, double enginePower, int weight, Color color, String modelname){
        super(nrDoors, enginePower, weight, color, modelname);
        this.Loaded = false;
        stopEngine();
    }

    public void setLoaded(){
        if (Loaded){
            this.Loaded = false;
        }
        else{
            this.Loaded = true;
        }
    }

    public boolean getLoaded(){
        return this.Loaded;
    }
}

