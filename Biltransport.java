import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Biltransport extends Lastbilar{
        private List<Car> cargo;
        private int maxNumberCars = 6;

        public Biltransport(){
            super(2, 120, 6000,Color.GREEN, "Mercedes-Benz Actros", 0);
            cargo = new ArrayList<Car>();
        }

        private void load(Car input){
                if (getPlatform() == 0){
                    if (cargo.size() != maxNumberCars){
                        if (input.weight <= 2000){
                            cargo.add(input);
                        }else{
                            throw new IllegalArgumentException("Car weight exceeds 2 tons");
                        }
                    }else{
                        throw new IllegalArgumentException("Maximum number of cars have been loaded");
                    }
                } else{
                    throw new IllegalArgumentException("Platform needs to be down to load cargo");
                }
        }

        private void unload(){
            if(getPlatform() == 0){
                for (int i = 0; i < cargo.size();i++){
                    cargo.removeLast();
                }
            } else{
                throw new IllegalArgumentException("Platform needs to be down to unload cargo");
            }
        }
    }
