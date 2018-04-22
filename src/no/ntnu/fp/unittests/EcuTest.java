import no.ntnu.fp.model.Ecu;
import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Project;
import org.junit.Assert;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EcuTest {

    private Ecu ecuOne;
    private Ecu ecuTwo;
    private Ecu ecuThree;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        ecuOne = new Ecu(1);
        ecuTwo = new Ecu(2, -3, 4);
        ecuThree = new Ecu(4, 10, 7, true, 9);
    }

    @org.junit.jupiter.api.Test
    void get_ecuID_returns_ID(){
        Assert.assertEquals(1, ecuOne.getEcuId());
    }

    @org.junit.jupiter.api.AfterEach
    void setEcuID_changes_EcuID(){
        ecuOne.setEcuId(30);
        Assert.assertEquals(30, ecuOne.getEcuId());
    }

    @org.junit.jupiter.api.AfterEach
    void getISwId_returns_SWID(){
        Assert.assertEquals(-3 , ecuTwo.getSwId());
    }

    @org.junit.jupiter.api.AfterEach
    void swtSwId_changes_SwId(){
        ecuOne.setSwId(40);
        Assert.assertEquals(40, ecuOne.getSwId());
    }

    @org.junit.jupiter.api.AfterEach
    void getSubSwId_returns_SwID(){
        Assert.assertEquals(7, ecuThree.getSubSwId());
    }

    @org.junit.jupiter.api.AfterEach
    void setSubSwId_sets_new_subSwId(){
        ecuThree.setSubSwId(50);
        Assert.assertEquals(50, ecuThree.getSubSwId());
    }

    @org.junit.jupiter.api.AfterEach
    void isNewest_retuns_newest_boolean(){
        Assert.assertEquals(true, ecuThree.isNewest());
    }

    @org.junit.jupiter.api.AfterEach
    void setNewest_changes_isNewest(){
        ecuThree.setNewest(false);
        Assert.assertEquals(false, ecuThree.ge);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }


}

