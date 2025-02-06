import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarTransport extends Trucks{
        private List<Car> cargo;
        private int maxNumberCars = 6;

        public CarTransport(){
            super(2, 120, 6000,Color.GREEN, "Mercedes-Benz Actros", 0);
            cargo = new ArrayList<Car>();
        }

        private void load(Car car){
                if (getPlatform() == 0){
                    if (cargo.size() != maxNumberCars){
                        if (car.weight <= 2000){
                            double[] distance = {car.getPosition()[0]-this.getPosition()[0],car.getPosition()[1]-this.getPosition()[1]};
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
                } else{
                    throw new IllegalArgumentException("Platform needs to be down to load cargo");
                }
        }

        private void unload(Car car){
            if(getPlatform() == 0){
                cargo.remove(car);
            } else{
                throw new IllegalArgumentException("Platform needs to be down to unload cargo");
            }
        }

        @Override
        public void move(){
            if(this.getPlatform() == 0){
            switch(this.getDirection()){
                case "n": this.position[1]=this.position[1]+this.getCurrentSpeed(); break;
                case "e": this.position[0]=this.position[0]+this.getCurrentSpeed(); break;
                case "w": this.position[0]=this.position[0]-this.getCurrentSpeed(); break;
                case "s": this.position[1]=this.position[1]-this.getCurrentSpeed(); break;
            }
            }
            for(int i=0; i< cargo.size();i++){
                cargo.get(i).position = this.position;
            }

    }
}
