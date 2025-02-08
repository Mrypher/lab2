import java.util.ArrayList;


public class CarWorkshop<T extends Car> {
    ArrayList<Object> carSpecs = new ArrayList<Object>();

    LoadCar loadCar;
    public CarWorkshop(double[] position, int maxCars){
        loadCar = new LoadCar(Math.abs(maxCars), position);
    }

   public void unload(T car){
        if (this.loadCar.cargo.contains(car)) {
            this.loadCar.unload(car);
        }
        else {
            throw new IllegalArgumentException("Cannot unload car that do not exist");
        }
   }

   public void load(T car){
            this.loadCar.load(car);
        }

    public double[] getPosition(){
        return loadCar.position;
    }
}
