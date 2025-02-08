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
        saab.gas(0.6);
        saab.gas(0.6);
        saab.move();

        Assert.assertThrows(IllegalArgumentException.class, () -> cartransport.load(saab));
    }

    @Test
    void TestManeuverOnTransport(){
        saab.turnRight();
        saab.turnRight();
        saab.move();
        cartransport.setPlatform();
        cartransport.load(saab);

        assertEquals(Color.red, cartransport.loadCar.getCargo().get(0).getColor());
        assertEquals(cartransport.getPosition()[0] , saab.getPosition()[0]);
        assertEquals(cartransport.getPosition()[1] , saab.getPosition()[1]);
        Assert.assertThrows(IllegalArgumentException.class, () -> cartransport.move());
    }


    Saab95 saab1 = new Saab95();
    Saab95 saab2 = new Saab95();
    Volvo240 volvo1 = new Volvo240();
    Volvo240 volvo2 = new Volvo240();
    Volvo240 volvo3 = new Volvo240();

    @Test
    void TestSpecialWorkshop(){

        CarWorkshop<Volvo240> VolvoWorkshop = new CarWorkshop<>(new double[]{-0.5,-0.5}, 2);
        
        VolvoWorkshop.load(volvo1);
        VolvoWorkshop.load(volvo2);
        Assert.assertThrows(IllegalArgumentException.class, () -> VolvoWorkshop.load(volvo1));
        Assert.assertThrows(IllegalArgumentException.class, () -> VolvoWorkshop.load(volvo3));
        VolvoWorkshop.unload(volvo2);
        //Assert.assertThrows(IllegalArgumentException.class, () -> VolvoWorkshop.load(saab1)); //CompileTimeError
        VolvoWorkshop.unload(volvo1);
    }

    @Test
    void TestAllWorkshop(){

        CarWorkshop<Car> GenericWorkshop = new CarWorkshop<>(new double[]{0.5,0.5}, 5);

        volvo1.gas(0.5);
        volvo1.move();
        GenericWorkshop.load(volvo1); 
        GenericWorkshop.load(volvo2);
        GenericWorkshop.load(volvo3);
        GenericWorkshop.load(saab1);
        GenericWorkshop.load(saab2);
        //Assert.assertThrows(IllegalArgumentException.class, () -> VolvoWorkshop.load(saab2)); //CompileTimeError
        assertEquals(GenericWorkshop.getPosition()[1], volvo1.getPosition()[1]);
        GenericWorkshop.unload(volvo1);
        volvo1.move();
        assertEquals(1.25, volvo1.getPosition()[1]);
        
    }
}

