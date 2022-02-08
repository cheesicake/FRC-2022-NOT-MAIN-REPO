package subsystems;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import frc.robot.commands.RunFeeder;
import frc.robot.subsystems.Feeder;

import static org.junit.Assert.assertEquals;

public class FeederTests {
    private static final double delta = 0.01;
    Feeder feeder;

    @Before
    public void setup() {
        this.feeder = new Feeder();
    }

    @Test
    public void feederTest() {
        System.out.println("when runFeeder, will the feederSpark run at the speeds the Constants define");
        feeder.set(true);
        assertEquals(0.3, feeder.getMotor().get(), delta);
    }
    @After
    public void shutdown() {
        feeder.stop();
    }

}