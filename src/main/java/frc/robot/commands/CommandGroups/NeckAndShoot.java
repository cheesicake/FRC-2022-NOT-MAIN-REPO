package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.RunFeeder;
import frc.robot.commands.Shoot;
import frc.robot.Constants;
import frc.robot.Constants.Direction;

<<<<<<< HEAD:src/main/java/frc/robot/commands/CommandGroups/FeederAndShoot.java
public class FeederAndShoot extends ParallelCommandGroup {
    private Feeder feeder;
    private Shooter shooter;

    public FeederAndShoot (Feeder feeder, Shooter shooter) {
        this.feeder = feeder;
        this.shooter = shooter;

        addCommands(
            new RunFeeder(feeder, Direction.FORWARDS),
            new Shoot(shooter)
=======
public class NeckAndShoot extends SequentialCommandGroup {
    private Neck neck;
    private Shooter shooter;
    private Feeder feeder;



    public NeckAndShoot (Feeder feeder, Neck neck, Shooter shooter) {
        this.feeder = feeder;
        this.neck = neck;
        this.shooter = shooter;


        addCommands(
            new Shoot(shooter).withTimeout(0.2),
            new ParallelCommandGroup(
                new Shoot(shooter),
                new RunNeck(neck, Direction.FORWARDS),
                new RunFeeder(feeder, Direction.FORWARDS)
            )
>>>>>>> 50024466d6cace26f3538f652189a34f6aee5285:src/main/java/frc/robot/commands/CommandGroups/NeckAndShoot.java
        );
    }
}
