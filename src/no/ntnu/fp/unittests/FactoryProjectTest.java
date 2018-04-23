import no.ntnu.fp.model.*;
import org.junit.Assert;

import java.util.ArrayList;

public class FactoryProjectTest {

    private FactoryProject factoryProjectOne;
    private FactoryProject factoryProjectTwo;

    private ArrayList<Vehicle> vehicleList;
    private ArrayList<Software> softwareList;
    private ArrayList<SimpleEcu> simpleEcuList;
    private Vehicle vehicleOne;
    private Vehicle vehicleTwo;
    private Software softwareOne;
    private Software softwareTwo;
    private SimpleEcu simpleEcuOne;
    private SimpleEcu simpleEcuTwo;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        factoryProjectOne = new FactoryProject();

        vehicleList = new ArrayList<>();
        softwareList = new ArrayList<>();
        simpleEcuList = new ArrayList<>();

        vehicleOne = new Vehicle();
        vehicleTwo = new Vehicle();
        vehicleOne.setVehicleID("Searchable");
        vehicleTwo.setVehicleID("Searchable 3");
        softwareOne = new Software();
        softwareTwo = new Software();
        simpleEcuOne = new SimpleEcu();
        simpleEcuTwo = new SimpleEcu();

        vehicleList.add(vehicleOne);
        vehicleList.add(vehicleTwo);

        softwareList.add(softwareOne);
        softwareList.add(softwareTwo);

        simpleEcuList.add(simpleEcuOne);
        simpleEcuList.add(simpleEcuTwo);

        factoryProjectTwo = new FactoryProject(vehicleList, softwareList, simpleEcuList);
    }

    @org.junit.jupiter.api.Test
    void getVehcileCount_returns_correct_vehicle_count(){
        Assert.assertEquals(2, factoryProjectTwo.getVehicleCount());
    }

    @org.junit.jupiter.api.Test
    void getSoftwareCount_returns_correct_software_count(){
        Assert.assertEquals(2, factoryProjectTwo.getSoftwareCount());
    }

    @org.junit.jupiter.api.Test
    void getVehicle_returns_correct_vehicle(){
        Assert.assertEquals(vehicleOne, factoryProjectTwo.getVehicle(0));
    }

    @org.junit.jupiter.api.Test
    void getSoftware_returns_correct_software(){
        Assert.assertEquals(softwareOne, factoryProjectTwo.getSoftware(0));
    }

    @org.junit.jupiter.api.Test
    void getVehicle_returns_vehicle(){
        Assert.assertEquals(vehicleOne, vehicleList.get(0));
    }

    @org.junit.jupiter.api.Test
    void getSoftware_returns_vehicle(){
        Assert.assertEquals(softwareOne, softwareList.get(0));
    }

    @org.junit.jupiter.api.Test
    void getEcuCount_returns_correct_ecuCount(){
        Assert.assertEquals(2, simpleEcuList.size());
    }

    @org.junit.jupiter.api.Test
    void getLatestSoftware_returns_latestSoftware(){
        Assert.assertEquals(softwareTwo, factoryProjectTwo.getLatestSoftware());
    }

    @org.junit.jupiter.api.Test
    void getLatestVehicle_returns_latestVehicle(){
        Assert.assertEquals(vehicleTwo, factoryProjectTwo.getLatestVehicle());
    }

    @org.junit.jupiter.api.Test
    void getLatestEcu_returns_latestEcu(){
        Assert.assertEquals(simpleEcuTwo, factoryProjectTwo.getLatestEcu());
    }

    @org.junit.jupiter.api.Test
    void getSoftwareIndex_returns_correctIndex(){
        Assert.assertEquals(0, factoryProjectTwo.getSoftwareIndex(softwareOne));
    }

    @org.junit.jupiter.api.Test
    void getSoftwareIndex_getEcu_returns_ecu(){
        Assert.assertEquals(simpleEcuOne, factoryProjectTwo.getEcu(0));
    }

    @org.junit.jupiter.api.Test
    void getVehicleIndex_returns_correct_index(){
        Assert.assertEquals(0, factoryProjectTwo.getVehicleIndex("Searchable"));
        Assert.assertEquals(-1, factoryProjectTwo.getVehicleIndex("Should not be found"));
        Assert.assertEquals(1, factoryProjectTwo.getVehicleIndex("Searchable 3"));
    }

    @org.junit.jupiter.api.Test
    void indexOf_object_returns_correct_index(){
        Assert.assertEquals(0, vehicleList.indexOf(vehicleOne));
    }

    @org.junit.jupiter.api.Test
    void addVehicle_adds_vehicle(){
        Vehicle toBeAdded = new Vehicle();
        factoryProjectTwo.addVehicle(toBeAdded);
        Assert.assertEquals(toBeAdded, factoryProjectTwo.getLatestVehicle());
    }

    @org.junit.jupiter.api.Test
    void addSoftware_adds_software(){
        Software toBeAdded = new Software();
        factoryProjectTwo.addSoftware(toBeAdded);
        Assert.assertEquals(toBeAdded, factoryProjectTwo.getLatestSoftware());
    }

    @org.junit.jupiter.api.Test
    void addEcu_adds_eCu(){
        SimpleEcu toBeAdded = new SimpleEcu(5);
        factoryProjectTwo.addEcu(toBeAdded);
        Assert.assertEquals(toBeAdded, factoryProjectTwo.getLatestEcu());
    }

    @org.junit.jupiter.api.Test
    void remove_vehicle_removes_vehicle(){
        factoryProjectTwo.removeVehicle(vehicleTwo);
        Assert.assertEquals(vehicleOne, factoryProjectTwo.getLatestVehicle());
    }

    @org.junit.jupiter.api.Test
    void equal_compares_objects_correctly(){
        FactoryProject toBeCompared = new FactoryProject();
        toBeCompared.addVehicle(new Vehicle());
        toBeCompared.addVehicle(new Vehicle());
        Assert.assertEquals(false, factoryProjectTwo.equals(toBeCompared));
    }

    @org.junit.jupiter.api.Test
    void toString_returns_correct_string(){
        Assert.assertEquals("project:\n", factoryProjectOne.toString());
    }

















    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
}
