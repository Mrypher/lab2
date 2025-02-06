import java.awt.*;

public class Saab95 extends Car{
    private boolean turboOn=false;

    public Saab95(){
        super(4, 100, 1400, Color.red, "Saab95");
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}

