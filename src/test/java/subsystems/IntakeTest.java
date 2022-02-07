package subsystems;
import org.junit.Test;
import org.junit.Before;
import frc.robot.commands.RunIntake;
import frc.robot.subsystems.Intake;

import static org.junit.Assert.assertEquals;

public class IntakeTest {
    Intake intake;
    @Before
    public void setup() {
        intake = new Intake();
    }
    @Test
    public void test() {
        System.out.println("when runIntake, will the intakeSpark run at the speeds the Constants define");
        intake.runIntake(Intake.Direction.FORWARD);
        assertEquals(0.3, intake.getIntakeSpark().get(),0.1);
    }

}
