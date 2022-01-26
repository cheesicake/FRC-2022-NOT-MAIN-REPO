package subsystems;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import frc.robot.commands.Climb;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Climber.ClimberState;

import static org.junit.Assert.assertEquals;


public class ClimberTests {
    private static final double delta = 0.01;
    Climber climber;

    @Before
    public void setup() {
        climber = new Climber();
    }

    @Test
    public void testClimberSpeed() {
        System.out.println("Climber speed should be 0.1");
        climber.runClimber(ClimberState.RAISE);
        assertEquals(climber.getClimberGroup().get(), 0.1, delta);
    }

    @After
    public void shutdown() {
        climber.close();
    }
}
