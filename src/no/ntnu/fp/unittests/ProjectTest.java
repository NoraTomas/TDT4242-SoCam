import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Project;
import org.junit.Assert;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    private Project project;
    private ArrayList<Person> persons;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        project = new Project();
        persons = new ArrayList<Person>();

        persons.add(new Person(1));
        persons.add(new Person(5));
        persons.add(new Person(-3));
        persons.add(new Person(0));

        persons.get(0).setName("Anna Jones");
        persons.get(1).setName("Joshua Miles");
        persons.get(2).setName("Josh Smith");
        persons.get(3).setName("Ørjan Kim");

        persons.get(0).setVehicleID("1");
        persons.get(1).setVehicleID("2");
        persons.get(2).setVehicleID("3");
        persons.get(3).setVehicleID("4");


        for(Person person : persons){
            project.addPerson(person);
        }
    }

    @org.junit.jupiter.api.Test
    void getPersonCount_returns_correct_number_of_persons(){
        Assert.assertEquals(persons.size(), 4);
    }

    @org.junit.jupiter.api.Test
    void getLargestCustId_returns_largest_id() {
        Assert.assertEquals(project.getLargestCustId(), 5);
    }

    @org.junit.jupiter.api.Test
    void checkLargestCustID_returns_zero_on_empty_list(){
        for(Person person : persons){
            project.removePerson(person);
        }
        Assert.assertEquals(project.getLargestCustId(), 0);
    }

    @org.junit.jupiter.api.Test
    void getPerson_returns_correct_person_object(){
        Person firstPersonInPersonList = persons.get(1);
        Person firstPersonInProject = project.getPerson(1);

        Assert.assertEquals(firstPersonInPersonList, firstPersonInProject);
    }

    @org.junit.jupiter.api.Test
    void getPersonIndex_returns_correct_persons(){
        ArrayList<Integer> personsSearch = project.getPersonIndex("Josh");
        int firstPersonInSearchResultID = personsSearch.get(0);
        int secondPersonInSearchResultIT = personsSearch.get(1);

        Assert.assertEquals(5, firstPersonInSearchResultID);
        Assert.assertEquals(-3, secondPersonInSearchResultIT);

    }

    @org.junit.jupiter.api.Test
    void getPersonIndex_returns_correct_veichle_owner(){
        int personThatOwnsVehicleID = project.getPersonIndex(2);

        //ViechleID=2 was assigned to Joshua Miles which has custID=5
        //Therefore, the ID of the veichle owner should be 5

        Assert.assertEquals(5, personThatOwnsVehicleID);

    }

    @org.junit.jupiter.api.Test
    void getPersonIndex_returns_minus_one_when_no_person_is_found(){
        int nonExistingIndex = project.getPersonIndex(10);

        Assert.assertEquals(-1, nonExistingIndex);
    }

    @org.junit.jupiter.api.Test
    void indexOf_returns_correct_index(){
        Person indexOne = persons.get(0);
        Person indexOneFromPorject = project.getPerson(0);

        Assert.assertEquals(indexOne, indexOneFromPorject);
    }

    @org.junit.jupiter.api.Test
    void iterator_returns_correct_iterator(){
        //Finn ut hvordan man skriver dette
    }

    @org.junit.jupiter.api.Test
    void addPerson_adds_person(){
        project.addPerson(persons.get(0));

        Assert.assertEquals(project.getPerson(0), persons.get(0));
    }

    @org.junit.jupiter.api.Test
    void contains_contains_added_person(){
        Assert.assertEquals(project.contains(persons.get(0)), true);
    }

    @org.junit.jupiter.api.Test
    void removePerson_removes_person(){
        Person toBeRemoved = project.getPerson(0);
        project.removePerson(toBeRemoved);

        Assert.assertEquals(project.contains(toBeRemoved), false);
    }

    @org.junit.jupiter.api.Test
    void add_propertyChangeListener_adds_listener(){

    }

    @org.junit.jupiter.api.Test
    void equals_returns_different_object(){
        Project toBeCompared = new Project();

        toBeCompared.addPerson(new Person(1));
        toBeCompared.addPerson(new Person(2));
        toBeCompared.addPerson(new Person(3));
        toBeCompared.addPerson(new Person(4));


        Assert.assertEquals(false, toBeCompared.equals(project));

    }

    @org.junit.jupiter.api.Test
    void toString_returns_correct_string(){
        for (Person person : persons){
            project.removePerson(person);
        }

        project.addPerson(new Person(1));

        String projectString = "project:\n" +
                "Name: ; Email: ; Street: \n" +
                "";

        Assert.assertEquals(projectString, project.toString());
    }




    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
}