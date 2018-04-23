import no.ntnu.fp.model.Ecu;
import no.ntnu.fp.model.Software;
import no.ntnu.fp.model.Vehicle;
import org.junit.Assert;

import java.util.ArrayList;

public class VehicleTest {

    private Vehicle vehicleOne;
    private Ecu ecuOne;
    private Ecu ecuTwo;

    private ArrayList<Ecu> ecus;

    @org.junit.jupiter.api.BeforeEach
    void setUp(){
        vehicleOne = new Vehicle("5", "History", ecus, "Series 1");

        ecuOne = new Ecu(88);
        ecuTwo = new Ecu(70);

        ecus = new ArrayList<>();
        ecus.add(ecuOne);
        ecus.add(ecuTwo);

        vehicleOne.setEcus(ecus);
    }

    @org.junit.jupiter.api.Test
    void getEcuCount_returns_ecuCount(){
        Assert.assertEquals(2, vehicleOne.getEcuCount());
    }

    @org.junit.jupiter.api.Test
    void getEcu_returns_correct_Ecu(){
        Assert.assertEquals(ecuOne, vehicleOne.getEcu(0));
    }

    @org.junit.jupiter.api.Test
    void addECU_adds_ECU(){
        Ecu toBeAdded = new Ecu(100);
        vehicleOne.addEcu(toBeAdded);
        Assert.assertEquals(toBeAdded, vehicleOne.getEcu(2));
    }

    @org.junit.jupiter.api.Test
    void removeECU_removes_ECU(){
        vehicleOne.removeEcu(ecuOne);
        Assert.assertEquals(ecuTwo, vehicleOne.getEcu(0));
    }

    @org.junit.jupiter.api.Test
    void getLargest_Ecu_Id_returns_largest_Id(){
        int largestID = vehicleOne.getLargestEcuId();
        Assert.assertEquals(88, largestID);
    }

    @org.junit.jupiter.api.Test
    void containEcu_checks_if_Ecu_exists(){
        Assert.assertEquals(true, vehicleOne.contains(ecuOne));
    }

    @org.junit.jupiter.api.Test
    void findDot_correctly_finds_dot(){
        Assert.assertEquals(-1, vehicleOne.findDot("No dot"));
    }

    @org.junit.jupiter.api.Test
    void getHistoryLog_returns_history_log(){
        Assert.assertEquals("History", vehicleOne.getHistoryLog());
    }

    @org.junit.jupiter.api.Test
    void setHistoryLog_changes_history_log(){
        vehicleOne.setHistoryLog("New History");
        Assert.assertEquals("New History", vehicleOne.getHistoryLog());
    }

    @org.junit.jupiter.api.Test
    void getEcus_returns_ecus(){
        Assert.assertEquals(ecus, vehicleOne.getEcus());
    }

    @org.junit.jupiter.api.Test
    void setEcus_changes_ecus(){
        ArrayList<Ecu> newEcus = new ArrayList<>();
        vehicleOne.setEcus(newEcus);
        Assert.assertEquals(newEcus, vehicleOne.getEcus());
    }

    @org.junit.jupiter.api.Test
    void indexOf_ecu_returns_correct_index(){
        Assert.assertEquals(0, vehicleOne.indexOf(ecuOne));
    }



    @org.junit.jupiter.api.AfterEach
    void tearDown(){

    }
}
