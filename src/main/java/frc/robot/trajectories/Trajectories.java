package frc.robot.trajectories;

import java.io.IOException;
import java.util.Arrays;

import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.trajectory.TrajectoryUtil;
import edu.wpi.first.math.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.math.trajectory.constraint.TrajectoryConstraint;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;
import frc.robot.Constants.DriveTrainConstants;
import frc.robot.commands.Drive;
import frc.robot.subsystems.Drivetrain;

public class Trajectories {
 //Max velocity & acceleration
    public static CommandGroupBase followTrajectory(Drivetrain drivetrain, Trajectory trajectory){

      var autoVoltageConstraint =
      new DifferentialDriveVoltageConstraint(
          new SimpleMotorFeedforward(
              Constants.DriveTrainConstants.ksVolts,
              Constants.DriveTrainConstants.kvVoltSecondsPerMeter,
              Constants.DriveTrainConstants.kaVoltSecondsSquaredPerMeter),
          Constants.DriveTrainConstants.kDriveKinematics,
      10);
        //double maxVoltage = 8;
        //DifferentialDriveVoltageConstraint constraint = new DifferentialDriveVoltageConstraint(drivetrain.getMotorFeedForward(), drivetrain.getDifferentialDriveKinematics(), maxVoltage);
      TrajectoryConfig config = new TrajectoryConfig(Constants.DriveTrainConstants.kMaxSpeedMetersPerSecond, Constants.DriveTrainConstants.kMaxAccelerationMetersPerSecondSquared)
      .setKinematics(Constants.DriveTrainConstants.kDriveKinematics)
      .addConstraint(autoVoltageConstraint);
        
       
      RamseteCommand command = new RamseteCommand(
          trajectory,
          drivetrain::getPose,
          new RamseteController(DriveTrainConstants.kRamseteB, DriveTrainConstants.kRamseteZeta),
          drivetrain.getMotorFeedForward(),
          Constants.DriveTrainConstants.kDriveKinematics,
          drivetrain::getVelocities,
          drivetrain.getLeftPIDController(),
          drivetrain.getRightPIDController(),
          drivetrain::tankDriveVolts,
          drivetrain
      );
     return command.andThen(drivetrain::stop);
 }

    public static Trajectory loadTrajectory(String path) { //JSON path
        try {
          return TrajectoryUtil.fromPathweaverJson(Filesystem.getDeployDirectory().toPath().resolve(path));
        } catch (IOException e) {
          DriverStation.reportError("Trajectory not found. " + path, e.getStackTrace());
          e.printStackTrace();
          return TrajectoryGenerator.generateTrajectory(Arrays.asList(new Pose2d(), new Pose2d()), new TrajectoryConfig(0, 0));
        }
      }
    
}
