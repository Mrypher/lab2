
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
        car.move();
        assertEquals(new double[]{0.0, 60.0}[1], car.getPosition()[1]);
        car.turnLeft();
        car.move();
        assertEquals(new double[]{-60.0, 60.0}[0], car.getPosition()[0]);
    }

    @Test
    void TestInterval() {
        car.gas(0.5);
        assertEquals(60.6, car.getCurrentSpeed());
        car.brake(0.5);
        assertEquals(60, car.getCurrentSpeed());
        for(int i = 0; i < 10000; i++)
        {
            car.gas(0.5);
        }
        assertEquals(120, car.getCurrentSpeed());
    }
    
    @Test
    void TestIllegalArgument() {
        Assert.assertThrows(IllegalArgumentException.class, () -> car.brake(2));
        Assert.assertThrows(IllegalArgumentException.class, () -> car.gas(2));
        Assert.assertThrows(IllegalArgumentException.class, () -> car.brake(-0.5));
    }
}

