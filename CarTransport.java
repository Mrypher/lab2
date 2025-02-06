import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarTransport extends Trucks{
        private List<Car> cargo;
        LoadCar loadCar = new LoadCar();

        public CarTransport(){
            super(2, 120, 6000,Color.GREEN, "Mercedes-Benz Actros", 0);
            cargo = new ArrayList<Car>();
        }

        public List<Car> getCargo() {
            return cargo;
        }

        public void load(Car car){
            if (this.getPlatform() == 0){
                this.loadCar.load(car);
            }
            else{
                throw new IllegalArgumentException("Angle of platform must be 0");
            }
        }

    
}
