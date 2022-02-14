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

//Does Nothing
public class ZeroAuto extends CommandBase{
    // private Drivetrain drivetrain;
    // private Arm arm;
    // private Intake intake;
    // private Feeder feeder;
    // private Shooter shooter;
    // private Trajectories trajectories = new Trajectories();
    // private Trajectory trajectory;



    // public ZeroAuto(Drivetrain drivetrain, Arm arm, Intake intake, Feeder feeder, Shooter shooter) {
    //     this.drivetrain = drivetrain;
    //     this.arm = arm;
    //     this.intake = intake;
    //     this.feeder = feeder;
    //     this.shooter = shooter;
    //     trajectory =  trajectories.loadTrajectory("Path"); //The "Path" should refer to the location of the pathweaver json file in this project

    // Any number below is in seconds. KEEP IN MIND THAT AUTO IS 15 SECONDS, which is why line 50 says 15.

    //     new ParallelCommandGroup(
    //       trajectories.followTrajectory(drivetrain, trajectory),
    //       new SequentialCommandGroup(
    //           new Shoot(shooter),
    //           new WaitCommand(5),
    //           new ArmAndIntake(arm, intake).withTimeout(5),
    //           new RunFeeder(feeder, Direction.FORWARDS),
    //           new WaitCommand(5)
    //       )  
    //     ).withTimeout(15);


    // }
}

