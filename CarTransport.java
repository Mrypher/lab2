import java.awt.*;


public class CarTransport extends Trucks{
        LoadCar loadCar;

        public CarTransport(){
            super(2, 120, 6000,Color.GREEN, "Mercedes-Benz Actros");
            loadCar = new LoadCar(6, this.position);
        }

        public void load(Car car){
            if (this.getPlatform() == 70){
                double[] distance = {car.getPosition()[0]-position[0],car.getPosition()[1]-position[1]};
                if (distance[0] > -1 && distance[0] < 1 && distance[1] > -1 && distance[1] < 1){
                this.loadCar.load(car);
                }
                else{
                    throw new IllegalArgumentException("Car is not close enough to CarTransport");
                }
            }
            else{
                throw new IllegalArgumentException("Angle of platform must be 70");
            }
        } 
}
