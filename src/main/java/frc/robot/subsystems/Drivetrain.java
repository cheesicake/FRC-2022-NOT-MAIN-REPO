package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import com.ctre.phoenix.sensors.Pigeon2;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveTrainConstants;
import frc.robot.commands.Drive;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends SubsystemBase {
    private WPI_TalonFX rightFrontTalon;
    private WPI_TalonFX rightRearTalon;
    private WPI_TalonFX leftFrontTalon;
    private WPI_TalonFX leftRearTalon;
    private MotorControllerGroup leftMotors;
    private MotorControllerGroup rightMotors;

    private PigeonIMU pigeon;

    private final DifferentialDrive drive;
    //private final DifferentialDriveOdometry odometry;

    private DifferentialDrive drive;
    private DifferentialDriveKinematics kinematics;
    private DifferentialDriveOdometry odometry;
    private SimpleMotorFeedforward feedforward;
    private Pose2d pose;

    private PIDController leftPID, rightPID;


    public Drivetrain() {
        rightFrontTalon = new WPI_TalonFX(Constants.CanIds.rightFrontTalon);
        rightRearTalon = new WPI_TalonFX(Constants.CanIds.rightRearTalon);
        leftFrontTalon = new WPI_TalonFX(Constants.CanIds.leftFrontTalon);
        leftRearTalon = new WPI_TalonFX(Constants.CanIds.leftRearTalon);

        leftMotors = new MotorControllerGroup(leftFrontTalon, leftRearTalon);
        rightMotors = new MotorControllerGroup(rightFrontTalon, rightRearTalon);
        

        //TODO: Need to See Which Ones Are Inverted

<<<<<<< HEAD
        drive = new DifferentialDrive(leftMotors, rightMotors);

        pigeon = new PigeonIMU(Constants.CanIds.pigeonId);
=======
        
        
        pigeon = new WPI_PigeonIMU(Constants.CanIds.pigeonId);
>>>>>>> 50024466d6cace26f3538f652189a34f6aee5285

        // TODO: Need to See Which Ones Are Inverted
        leftMotors.setInverted(true);
        rightMotors.setInverted(false);


        //Kinematics parameter is the distance between the wheels aka track width.
        drive = new DifferentialDrive(leftMotors, rightMotors);
        kinematics = new DifferentialDriveKinematics(Constants.DriveTrainConstants.trackWidth);
        feedforward = new SimpleMotorFeedforward(DriveTrainConstants.ksVolts, DriveTrainConstants.kvVoltSecondsPerMeter, DriveTrainConstants.kaVoltSecondsSquaredPerMeter);
        odometry = new DifferentialDriveOdometry(pigeon.getRotation2d());
        leftPID = new PIDController(DriveTrainConstants.kPDriveVel, 0,0);
        rightPID = new PIDController(DriveTrainConstants.kPDriveVel, 0,0);

        zeroSensors();
    }

    public void drive(double leftSpeed, double rightSpeed) {
        leftMotors.set(leftSpeed);
        rightMotors.set(rightSpeed);
    }

    public void stop(){
        leftMotors.set(0);
        rightMotors.set(0);
    }

    @Override
    public void periodic() {
        pose = odometry.update(getRotation(), getLeftPosition(), getRightPosition());
        drive = new DifferentialDrive(leftMotors, rightMotors);
    }
    

    public void zeroSensors() {
        zeroEncoders();
        pigeon.reset();
    }

    public void zeroEncoders() {
        leftFrontTalon.setSelectedSensorPosition(0);
        rightFrontTalon.setSelectedSensorPosition(0);
    }

    public void arcadeDrive(double fwd, double rot) {
        drive.arcadeDrive(fwd, rot);
      }

    public void tankDriveVolts(double leftVolts, double rightVolts) {
        leftMotors.setVoltage(leftVolts);
        rightMotors.setVoltage(rightVolts);
        drive.feed();
      }

    public double getAverageEncoderDistance() {
        return (getLeftPosition() + getRightPosition()) / 2.0;
    }

    public void zeroHeading() {
        pigeon.reset();
    }
    
    public double getTurnRate() {
        return -pigeon.getRate();
    }
    

    public void resetOdometry() {
        odometry.resetPosition(pose, pigeon.getRotation2d());
    }

    public MotorControllerGroup getLeftMotors() {
        return leftMotors;
    }

    public MotorControllerGroup getRightMotors() {
        return rightMotors;
    }

    //Return Position from Integrated Encoders from TalonFXs 

    /*
        Need to Check How Accurate This Is
    */
    public double getLeftPosition() {
<<<<<<< HEAD
        return leftFrontTalon.getSelectedSensorPosition() * Constants.DriveTrainConstants.metersPerRev;
    }

    public double getRightPosition() {
        return rightFrontTalon.getSelectedSensorPosition() * Constants.DriveTrainConstants.metersPerRev;
=======
        return leftFrontTalon.getSelectedSensorPosition() * Constants.DriveTrainConstants.wheelCircumference / (Constants.DriveTrainConstants.gearRatio * Constants.DriveTrainConstants.encoderEdgesPerRev);
    }

    public double getRightPosition() {
        return rightFrontTalon.getSelectedSensorPosition() * Constants.DriveTrainConstants.wheelCircumference / (Constants.DriveTrainConstants.gearRatio * Constants.DriveTrainConstants.encoderEdgesPerRev);
>>>>>>> 50024466d6cace26f3538f652189a34f6aee5285
    }

    public double getRightVelocity() {
        return rightFrontTalon.getSelectedSensorVelocity() *   Constants.DriveTrainConstants.wheelCircumference / (Constants.DriveTrainConstants.gearRatio * Constants.DriveTrainConstants.encoderEdgesPerRev);
    }

    public double getLeftVelocity() {
        return leftFrontTalon.getSelectedSensorVelocity() * Constants.DriveTrainConstants.wheelCircumference / (Constants.DriveTrainConstants.gearRatio * Constants.DriveTrainConstants.encoderEdgesPerRev);
    }

    
    //Use Pigeon to get angle
    public Rotation2d getRotation(){
        //Need to double check the reading from this later.
        return Rotation2d.fromDegrees(pigeon.getCompassHeading() * -1);
    }

    public DifferentialDriveKinematics getDifferentialDriveKinematics(){
        return kinematics;
    }
    
    public Pose2d getPose(){
        return odometry.getPoseMeters();
    }

    public SimpleMotorFeedforward getMotorFeedForward(){
        return feedforward;
    }
    
    public DifferentialDriveWheelSpeeds getVelocities(){
        //I suspect we might have to do RPM motor to RPM wheel before converting to m/time
        //So we might need gear ratios? => sensorVelocity / GEAR_RATIO *2PI * m/min / 60s
        return new DifferentialDriveWheelSpeeds(
            getLeftPosition(),
            getRightPosition()
        );
    }
<<<<<<< HEAD
    public PIDController getLeftPIDController(){return leftPID;}
    public PIDController getRightPIDController(){return rightPID;}
}
=======
    public PIDController getLeftPIDController() {
        return leftPID;
    }
    public PIDController getRightPIDController() {
        return rightPID;
    }
>>>>>>> 50024466d6cace26f3538f652189a34f6aee5285


}