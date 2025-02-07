import java.util.ArrayList;
import java.util.List;

public class CarWorkshop {
    ArrayList<Object> carSpecs = new ArrayList<Object>();
    private boolean acceptAllCars;
    private Object carType;

    LoadCar loadCar;
    public CarWorkshop(Car carType, int maxCars, boolean acceptAllCars){
        this.carType = carType;
        loadCar = new LoadCar(Math.abs(maxCars), new double[]{5000,5000});
        this.acceptAllCars = acceptAllCars;
    }

   public List<Object> unload(Car car){
        if (this.loadCar.cargo.contains(car)) {
            carSpecs.add(car.getNrDoors());
            carSpecs.add(car.getColor());
            carSpecs.add(car.getEnginePower());
            carSpecs.add(car.modelName);
            carSpecs.add(car.weight);
            this.loadCar.unload(car);
            carSpecs.add(car.getPosition());
            return carSpecs;
        }
        else {
            throw new IllegalArgumentException("Cannot unload car that do not exist");
        }
   }

   public void load(Car car){
            if (!acceptAllCars){
                if (carType.getClass() == car.getClass()){
                    this.loadCar.load(car);
                }
                else {
                    throw new IllegalArgumentException("Car type cannot be accepted");
                }
            } else if (acceptAllCars) {
                this.loadCar.load(car);
            }
        }
}
