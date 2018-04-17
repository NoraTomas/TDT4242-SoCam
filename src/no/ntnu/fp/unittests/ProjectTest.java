package no.ntnu.fp.unittests;

import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Project;
import org.junit.Assert;

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

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
}