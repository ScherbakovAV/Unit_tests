import Ex2.Car;
import Ex2.Motorcycle;
import Ex2.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VehicleTest {
    private Car car;
    private Motorcycle motorbike;
    @BeforeEach
    void setup() {
        car = new Car("Dodge", "Ram", 2010);
        motorbike = new Motorcycle("Harley", "Davidson", 2015);
    }

    /**Проверка того, что экземпляр объекта Car также является экземпляром транспортного средства*/
    @Test
    public void testCarIsInstanceOfVehicle() {
        assertTrue(car instanceof Vehicle);
    }

    /**Проверка того, что объект Car создается с 4-мя колесами*/
    @Test
    public void testNumberOfCarWheels() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    /**Проверка того, что объект Motorcycle создается с 2-мя колесами*/
    @Test
    public void testNumberOfMotorcycleWheels() {
        assertThat(motorbike.getNumWheels()).isEqualTo(2);
    }

    /**Проверка того, что объект Car развивает скорость 60 в режиме тестового вождения*/
    @Test
    public void testCarSpeedInTestDrive() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    /**Проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения*/
    @Test
    public void testMotorcycleSpeedInTestDrive() {
        motorbike.testDrive();
        assertThat(motorbike.getSpeed()).isEqualTo(75);
    }

    /**Проверка того, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается*/
    @Test
    public void testCarSpeedAfterParking() {
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    /**Проверка того, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) мотоцикл останавливается*/
    @Test
    public void testMotorcycleSpeedAfterParking() {
        motorbike.testDrive();
        motorbike.park();
        assertThat(motorbike.getSpeed()).isEqualTo(0);
    }
}