package seminars.second.hw;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleTest {

    Car car;
    Motorcycle motorcycle;
    @BeforeEach
    void init(){
        car = new Car("BMW", "7", 2005);
        motorcycle = new Motorcycle("BMW", "moto", 2010);
    }
    @AfterEach
    void cleanUp(){
        car = null;
        motorcycle = null;
    }

    @Test
    @DisplayName("Принадлежность экземпляра класса Car к классу Vehicle")
    void carIsVehicle(){
        assertTrue(car instanceof Vehicle);
    }
    @Test
    @DisplayName("Car создается с четырмя колесами")
    void amountWheelsOfCarIsFour(){
        assertEquals(4, car.getNumWheels());
    }
    @Test
    @DisplayName("Motorcycle создается с двумя колесами")
    void amountWheelsOfMotorcycleIsTwo(){
        assertEquals(2, motorcycle.getNumWheels());
    }
    @Test
    @DisplayName("Car имеет скорость 60 при тестовом вождении")
    void carHasSpeedSixtyDuringDriveTest(){
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }
    @Test
    @DisplayName("Motorcycle имеет скорость 75 при тестовом вождении")
    void motorcycleHasSpeedSixtyDuringDriveTest(){
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }
    @Test
    @DisplayName("Car в режиме парковки останавливается после движения")
    void carHasSpeedZeroAfterPark(){
        car.testDrive();
        car.park();
        assertEquals(0, car.getSpeed());
    }
    @Test
    @DisplayName("Motorcycle в режиме парковки останавливается после движения")
    void motorcycleHasSpeedZeroAfterPark(){
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }
}