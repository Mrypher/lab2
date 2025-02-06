import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarWorkshop {
    ArrayList<Object> carSpecs = new ArrayList<Object>();
    private boolean acceptAllCars;
    private Object carType;
    private int maxCars;

    LoadCar loadCar;
    public CarWorkshop(Object carType, int maxCars, boolean acceptAllCars){
        this.carType = carType;
        loadCar = new LoadCar(maxCars, null);
        this.acceptAllCars = acceptAllCars;

    }


   public List<Object> unload(Car car){
        if (this.loadCar.cargo.contains(car)) {
            carSpecs.add(car.getNrDoors());
            carSpecs.add(car.getColor());
            carSpecs.add(car.getEnginePower());
            carSpecs.add(car.modelName);
            carSpecs.add(car.weight);
            this.loadCar.cargo.remove(car);

            return carSpecs;
        }else{
            throw new IllegalArgumentException("Cannot unload car that do not exist");
        }
   }

   public void load(Car car){

            if ( !acceptAllCars ){
                if ( carType == car){
                    this.loadCar.load(car);
                }else {
                    throw new IllegalArgumentException("Car can not have this car type");
                }
            } else if (acceptAllCars) {
                this.loadCar.load(car);
            }
        }
}
