import java.awt.*;

    public class Biltransport extends Lastbilar{
        private Car[] cargo;
        private int maxNumberCars = 6;

        public Biltransport(){
            super(2, 120, Color.GREEN, "Mercedes-Benz Actros", 0);
        }

        private void load(){
            if (getPlatform() == 0 && cargo.length != maxNumberCars){

            }
            else{
                throw new IllegalArgumentException("Maximum number of cars have been loaded");
            }
        }
    }
