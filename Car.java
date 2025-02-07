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
    
    @Override
    public void move(){
        if(!this.Loaded){
            super.move();
        }
        else{
            throw new IllegalArgumentException("Car cannot move while loaded");
        }
    }

    @Override
    public void turnLeft(){
        if(!this.Loaded){
            super.turnLeft();
        }
        else{
            throw new IllegalArgumentException("Car cannot turn left while loaded");
        }
    }

    @Override
    public void turnRight(){
        if(!this.Loaded){
            super.turnRight();
        }
        else{
            throw new IllegalArgumentException("Car cannot turn right while loaded");
        }
    }

    @Override
    public void gas(double amount){
        if(!this.Loaded){
            super.gas(amount);
        }
        else{
            throw new IllegalArgumentException("Car cannot gas while loaded");
        }
    }

    @Override
    public void brake(double amount){
        if(!this.Loaded){
            super.brake(amount);
        }
        else{
            throw new IllegalArgumentException("Car cannot brake while loaded");
        }
    }
}

