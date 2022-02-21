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

public class SecondAuto extends CommandBase{
     Drivetrain drivetrain;
     Arm arm;
     Intake intake;
     Feeder feeder;
     Shooter shooter;
     Trajectories trajectories = new Trajectories();
     Trajectory trajectory;


     public BlueAuto(Drivetrain drivetrain, Arm arm, Intake intake, Feeder feeder, Shooter shooter) {
         this.drivetrain = drivetrain;
         this.arm = arm;
         this.intake = intake;
         this.feeder = feeder;
         this.shooter = shooter;
         trajectory =  trajectories.loadTrajectory("../trajectories/output/BlueAuto2.wpilib.json");

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

     public RedAuto(Drivetrain drivetrain, Arm arm, Intake intake, Feeder feeder, Shooter shooter) {
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
