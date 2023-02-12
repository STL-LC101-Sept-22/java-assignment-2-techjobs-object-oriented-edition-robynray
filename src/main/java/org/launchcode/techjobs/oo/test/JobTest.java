package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    //Test the Empty Constructor 4.1
    @Test
    public void testSettingJobId() {
        String spec = "a jobId is set";

        // Calling empty constructor
        Job job1 = new Job();
        Job job2 = new Job();
        // Use the getId() method to return the unique job id
        int expected = (job1.getId());
        int actual = (job2.getId());
        assertNotEquals(spec, expected, actual);
    }


    @Test
    public void testJobConstructorSetsAllFields(){
       Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //Job Name
        assertTrue(true);
        assertEquals("Product tester" , job3.getName());
        //Job Employer
        assertTrue(job3.getEmployer() instanceof Employer);
        assertEquals("ACME", job3.getEmployer().getValue());
        //Job Location
        assertTrue(job3.getLocation() instanceof Location);
        assertEquals("Desert",job3.getLocation().getValue());
        //Job PositionType
        assertTrue(job3.getPositionType()instanceof PositionType);
        assertEquals("Quality control",job3.getPositionType().getValue());
        //Job CoreCompetency
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence",job3.getCoreCompetency().getValue());


    }
    @Test
    public void testJobsForEquality(){
      //  String spec = "two identical Job objects have different Id's";

        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job4.equals(job5) );
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        char firstChar = job.toString().charAt(0);
        char lastChar = job.toString().charAt(job.toString().length()-1);

//        assertEquals(job.toString().charAt(0), firstChar);
//        assertEquals(job.toString().length()-1, lastChar);
        assertEquals('\n', firstChar);
        assertEquals('\n', lastChar);
//        assertEquals('\n', firstChar[0]);
//        assertEquals('\n', lastChar[lastChar.length - 1]);

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String label =
                "\nID: " + job.getId() + "\n" +
                        "Name: " + job.getName() + "\n" +
                        "Employer: " + job.getEmployer() + "\n" +
                        "Location: " + job.getLocation() + "\n" +
                        "Position Type: " + job.getPositionType() + "\n" +
                        "Core Competency: " + job.getCoreCompetency() + "\n";

                        assertEquals(job.toString(), label);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       String unavailable =  job.toString();
        assertEquals(job.toString(), unavailable);



    }


}
