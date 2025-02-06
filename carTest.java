
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CarTest{

    Car car = new Car(20,120.0,1000,Color.red,"Nissan"){};

    @Test
    void TestConstructor() {
        assertEquals(Color.red, car.getColor());
        assertEquals(20, car.getNrDoors());
    }

    @Test
    void TestMove() {
        car.turnLeft();
        assertEquals("w", car.getDirection());
        car.turnRight();
        assertEquals("n", car.getDirection());
        car.gas(0.5);
        car.move();
        assertEquals(new double[]{0.0, 0.6}[1], car.getPosition()[1]);
        car.turnLeft();
        car.move();
        assertEquals(new double[]{-0.6, 60.0}[0], car.getPosition()[0]);
    }

    @Test
    void TestInterval() {
        car.gas(0.5);
        assertEquals(0.6, car.getCurrentSpeed());
        car.brake(0.5);
        assertEquals(0.0, car.getCurrentSpeed());
        for(int i = 0; i < 10000; i++)
        {
            car.gas(0.5);
        }
        car.move();
        assertEquals(120, car.getCurrentSpeed());
    }
    
    @Test
    void TestIllegalArgument() {
        Assert.assertThrows(IllegalArgumentException.class, () -> car.brake(2));
        Assert.assertThrows(IllegalArgumentException.class, () -> car.gas(2));
        Assert.assertThrows(IllegalArgumentException.class, () -> car.brake(-0.5));
    }


    CarTransport cartransport = new CarTransport();
    Saab95 saab = new Saab95();

    @Test
    void TestLoad(){
        cartransport.setPlatform();
        saab.gas(0.6);
        saab.gas(0.6);
        saab.move();

        Assert.assertThrows(IllegalArgumentException.class, () -> cartransport.load(saab));

        saab.turnRight();
        saab.turnRight();
        saab.move();
        cartransport.load(saab);

        assertEquals(Color.red, cartransport.loadCar.cargo.get(0).getColor());
        assertEquals(new double[]{0.0,0.0}[0] , saab.getPosition()[0]);
        assertEquals(new double[]{0.0,0.0}[1] , saab.getPosition()[1]);
        Assert.assertThrows(IllegalArgumentException.class, () -> cartransport.move());
        
    }

}

