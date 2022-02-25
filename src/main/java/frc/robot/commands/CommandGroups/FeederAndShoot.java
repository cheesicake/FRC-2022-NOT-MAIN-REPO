package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Neck;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.RunFeeder;
import frc.robot.commands.RunNeck;
import frc.robot.commands.Shoot;
import frc.robot.Constants.Direction;

public class FeederAndShoot extends ParallelCommandGroup {
    private Feeder feeder;
    private Shooter shooter;
    private Neck neck;

    public FeederAndShoot (Feeder feeder, Neck neck, Shooter shooter) {
        this.feeder = feeder;
        this.shooter = shooter;
        this.neck = neck;

        addCommands(
            new RunFeeder(feeder, Direction.FORWARDS),
            new RunNeck(neck, Direction. FORWARDS),
            new Shoot(neck, shooter, 10)
        );
    }
}
