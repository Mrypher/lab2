public class CarWorkshop<T extends Car> {

    LoadCar loadCar;
    
    public CarWorkshop(double[] position, int maxCars){
        loadCar = new LoadCar(Math.abs(maxCars), position);
    }

    public void unload(T car){
        if (this.loadCar.getCargo().contains(car)) {
            this.loadCar.unload(car);
        }
        else {
            throw new IllegalArgumentException("Cannot unload car that is not loaded");
        }
   }

    public void load(T car){
        this.loadCar.load(car);
    }

    public double[] getPosition(){
        return loadCar.position;
    }
}
