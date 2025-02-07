import java.util.ArrayList;
import java.util.List;

public class LoadCar {
    public List<Car> cargo = new ArrayList<Car>();
    private int maxcars;
    protected double[] position;
    protected List<double[]> savepos;
    protected List<Car> saveindex;

    public LoadCar(int maxcars, double[] position){
        this.maxcars = maxcars;
        this.position = position;
        savepos = new ArrayList<double[]>();
        saveindex = new ArrayList<Car>();
    }

    protected void load(Car car){
        if (cargo.size() < this.maxcars){
            if (car.weight < 2000){
                if(!car.getLoaded()){
                cargo.add(car);
                savepos.add(new double[]{car.getPosition()[0], car.getPosition()[1]});
                saveindex.add(car);
                car.position = this.position;
                car.setLoaded();
                }
                else{
                    throw new IllegalArgumentException("Car cannot be loaded if loaded");
                }
            }
            else{
                throw new IllegalArgumentException("Car weight exceeds 2 tons");
            }
        }
        else{
            throw new IllegalArgumentException("Maximum number of cars have been loaded");
        }

    }

    protected void unload(Car car){
        cargo.remove(car);
        car.setLoaded();
        car.position = savepos.get(saveindex.indexOf(car));
        saveindex.remove(savepos.get(saveindex.indexOf(car)));
        savepos.remove(savepos.get(saveindex.indexOf(car)));
    }
}
