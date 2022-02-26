package frc.robot.auto;

import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.Constants.Direction;
import frc.robot.subsystems.*;
import frc.robot.trajectories.Trajectories;

public class BlueAuto2 extends ParallelCommandGroup{
    Drivetrain drivetrain;
    Arm arm;
    Intake intake;
    Feeder feeder;
    Shooter shooter;
    Trajectories trajectories = new Trajectories();
    Trajectory trajectory;

    public BlueAuto2(Drivetrain drivetrain, Arm arm, Intake intake, Feeder feeder, Shooter shooter) {
        this.drivetrain = drivetrain;
        this.arm = arm;
        this.intake = intake;
        this.feeder = feeder;
        this.shooter = shooter;
        trajectory =  trajectories.loadTrajectory("../trajectories/output/BlueAuto2.wpilib.json");

        addCommands(
            trajectories.followTrajectory(drivetrain, trajectory),
            new SequentialCommandGroup(
                new Shoot(shooter).withTimeout(1),
                new WaitCommand(3),
                new ArmAndIntake(arm, intake).withTimeout(2),
                new RunFeeder(feeder, Direction.FORWARDS),
                new WaitCommand(2),
                new ArmAndIntake(arm, intake).withTimeout(2),
                new RunFeeder(feeder, Direction.FORWARDS),
                new WaitCommand(3),
                new Shoot(shooter).withTimeout(1),
                new Shoot(shooter).withTimeout(1)
            )  
        ).withTimeout(15);

    }

}
