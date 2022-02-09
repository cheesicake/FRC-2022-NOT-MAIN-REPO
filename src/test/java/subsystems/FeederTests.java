package subsystems;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import frc.robot.Constants;
import frc.robot.Dir;
import frc.robot.commands.RunFeeder;
import frc.robot.subsystems.Feeder;

import static org.junit.Assert.assertEquals;

public class FeederTests {
    private static final double delta = 0.01;
    Feeder feeder;


    @Before
    public void setup() {
        feeder = new Feeder();
    }

    @Test
    public void feederCommandTest(){
        System.out.println("when runFeederCommand, will the feederSpark run at the speeds the Constants define");
        RunFeeder runFeeder = new RunFeeder(feeder,Dir.FORWARDS);
        runFeeder.execute();
        assertEquals(Constants.FeederConstants.feederSpeed, feeder.getMotor().get(), delta);
    }

    @After
    public void shutdown() {
        feeder.close();
    }

}
