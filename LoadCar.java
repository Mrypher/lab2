import java.util.ArrayList;
import java.util.List;

public class LoadCar {
    public List<Car> cargo = new ArrayList<Car>();
    final int maxcars = 6;
    public double[] position = new double[2];

protected void load(Car car){
    if (cargo.size() < maxcars){
        if (car.weight < 2000){
            double[] distance = {car.getPosition()[0]-position[0],car.getPosition()[1]-position[1]};
            if (distance[0] > -1 && distance[0] < 1 && distance[1] > -1 && distance[1] < 1){
            cargo.add(car);
            car.position = this.position;
            }
            else{
                throw new IllegalArgumentException("Car is not close enough to Biltransport");
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
    }
}
