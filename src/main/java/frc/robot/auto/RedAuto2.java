package frc.robot.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants.Direction;
import frc.robot.commands.RunFeeder;
import frc.robot.commands.Shoot;
import frc.robot.commands.CommandGroups.ArmAndIntake;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.trajectories.Trajectories;

public class RedAuto2 extends ParallelCommandGroup{
     private Drivetrain drivetrain;
     private Arm arm;
     private Intake intake;
     private Feeder feeder;
     private Shooter shooter;
     private Trajectories trajectories = new Trajectories();
     private Trajectory trajectory;



     public RedAuto2(Drivetrain drivetrain, Arm arm, Intake intake, Feeder feeder, Shooter shooter) {
        this.drivetrain = drivetrain;
        this.arm = arm;
        this.intake = intake;
        this.feeder = feeder;
        this.shooter = shooter;
        trajectory =  trajectories.loadTrajectory("../trajectories/output/RedAuto2.wpilib.json");

        new ParallelCommandGroup(
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
}

