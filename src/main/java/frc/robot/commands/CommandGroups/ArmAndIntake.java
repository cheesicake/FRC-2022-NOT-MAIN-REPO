package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Arm.ArmState;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Intake.Direction;
import frc.robot.commands.MoveArm;
import frc.robot.commands.RunIntake;

public class ArmAndIntake extends ParallelCommandGroup{
    private Arm arm;
    private Intake intake;

    public ArmAndIntake (Arm arm, Intake intake) {
        this.arm = arm;
        this.intake = intake;

        addCommands(
            new MoveArm(arm, ArmState.LOW),
            new RunIntake(intake, Direction.FORWARD)
        );
    }
}
