package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Intake;
import frc.robot.Constants.Direction;
import frc.robot.subsystems.Feeder;
import frc.robot.commands.RunIntake;
import frc.robot.commands.RunFeeder;

public class IntakeAndFeeder extends ParallelCommandGroup {
    private Intake intake;
    private Feeder feeder;

    public IntakeAndFeeder (Intake intake, Feeder feeder) {
        this.intake = intake;
        this.feeder = feeder;

        addCommands(
            new RunIntake(intake, Direction.FORWARDS),
            new RunFeeder(feeder, Direction.FORWARDS)
        );
    }
}