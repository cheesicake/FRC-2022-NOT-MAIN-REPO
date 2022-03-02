package frc.robot;

import com.fasterxml.jackson.databind.util.PrimitiveArrayBuilder;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.auto.FirstAuto;
import frc.robot.auto.SecondAuto;
import frc.robot.auto.ThirdAuto;
import frc.robot.auto.ZeroAuto;
import frc.robot.commands.Climb;
import frc.robot.commands.Drive;
import frc.robot.commands.RunFeeder;
import frc.robot.commands.RunIntake;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Climber.ClimberState;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Intake;
import frc.robot.commands.RunNeck;
import frc.robot.commands.Shoot;
import frc.robot.commands.CommandGroups.ArmAndIntake;
import frc.robot.commands.CommandGroups.ArmIntakeAndFeeder;
import frc.robot.commands.CommandGroups.FeederAndShoot;
import frc.robot.commands.CommandGroups.IntakeAndFeeder;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Arm.ArmState;
import frc.robot.Constants.Direction;


public class RobotContainer {

  //Subsystems
  private final Drivetrain drivetrain = new Drivetrain();
  private final Intake intake = new Intake();
  private final Arm arm = new Arm();
  private final Feeder feeder = new Feeder();
  private final Climber climber = new Climber();
  private final Shooter shooter = new Shooter();

  //Joysticks
  private Joystick leftJoystick = new Joystick(Constants.JoystickConstants.leftJoystickPort);
  private Joystick rightJoystick = new Joystick(Constants.JoystickConstants.rightJoystickPort);
  private Joystick secondaryJoystick = new Joystick(Constants.JoystickConstants.secondaryJoystickPort);


  //Buttons
  private final JoystickButton runIntakeButton = new JoystickButton(secondaryJoystick, Constants.JoystickConstants.SecondaryJoystick.runIntakeForwards);
  private final JoystickButton runIntakeBackwardsButton = new JoystickButton(secondaryJoystick,Constants.JoystickConstants.SecondaryJoystick.runIntakeBackwards);
  private final JoystickButton raiseArmButton = new JoystickButton(secondaryJoystick, Constants.JoystickConstants.SecondaryJoystick.raiseArm);
  private final JoystickButton lowerArmButton = new JoystickButton(secondaryJoystick, Constants.JoystickConstants.SecondaryJoystick.lowerArm);
  private final JoystickButton runFeederForwardsButton = new JoystickButton(secondaryJoystick, Constants.JoystickConstants.SecondaryJoystick.runFeederForwards);
  private final JoystickButton runFeederBackwardsButton= new JoystickButton(secondaryJoystick, Constants.JoystickConstants.SecondaryJoystick.runFeederBackwards);
  private final JoystickButton runNeckButton = new JoystickButton(secondaryJoystick, Constants.JoystickConstants.SecondaryJoystick.runNeck);
  private final JoystickButton shootButton = new JoystickButton(secondaryJoystick, Constants.JoystickConstants.SecondaryJoystick.runShooter);
  private final JoystickButton raiseClimberButton = new JoystickButton(secondaryJoystick, Constants.JoystickConstants.SecondaryJoystick.raiseClimber);
  private final JoystickButton lowerClimberButton = new JoystickButton(secondaryJoystick, Constants.JoystickConstants.SecondaryJoystick.lowerClimber);
  private final JoystickButton lowerArmAndIntakeButton = new JoystickButton(secondaryJoystick,Constants.JoystickConstants.SecondaryJoystick.moveArmAndIntake);
  private final JoystickButton runIntakeAndFeederButton = new JoystickButton(secondaryJoystick, Constants.JoystickConstants.SecondaryJoystick.runIntakeAndFeeder);
  private final JoystickButton runFeederAndShootButton = new JoystickButton(secondaryJoystick, Constants.JoystickConstants.SecondaryJoystick.runFeederAndShoot);
  private final JoystickButton lowerArmIntakeAndFeederButton = new JoystickButton(secondaryJoystick, Constants.JoystickConstants.SecondaryJoystick.moveArmIntakeandShoot);

  // Commands
  private final Drive drive = new Drive(drivetrain, leftJoystick, rightJoystick);
  private final MoveArm lowerArm = new MoveArm(arm, ArmState.LOW);
  private final MoveArm raiseArm = new MoveArm(arm, ArmState.HIGH);
  private final RunIntake runIntakeForwards = new RunIntake(intake, Direction.FORWARDS);
  private final RunIntake runIntakeBackwards = new RunIntake(intake, Direction.BACKWARDS);
  private final RunFeeder runFeederForwards = new RunFeeder(feeder, Direction.FORWARDS);
  private final RunFeeder runFeederBackwards = new RunFeeder(feeder, Direction.BACKWARDS);
  private final Climb raiseClimber = new Climb(climber, ClimberState.RAISE);
  private final Climb lowerClimber = new Climb(climber, ClimberState.LOWER);
  private final RunNeck runNeck = new RunNeck(shooter);
  private final Shoot shoot = new Shoot(shooter);
  private final ArmAndIntake armAndIntake = new ArmAndIntake(arm, intake);
  private final IntakeAndFeeder intakeAndFeeder = new IntakeAndFeeder(intake, feeder);
  private final FeederAndShoot feederAndShoot = new FeederAndShoot(feeder, shooter);
  private final ArmIntakeAndFeeder armIntakeAndFeeder = new ArmIntakeAndFeeder(arm, intake, feeder);

  // Auto
  private final ZeroAuto zeroAuto = new ZeroAuto();
  private final FirstAuto firstAuto = new FirstAuto();
  private final SecondAuto secondAuto = new SecondAuto();
  private final ThirdAuto thirdAuto = new ThirdAuto();

  private final SendableChooser<Command> sendableChooser = new SendableChooser<>();



  public RobotContainer() {
    configureButtonBindings();
    configureAutos();
    zeroSubsystems();
  }

  public void periodic() {

  }  

  private void zeroSubsystems() {
    arm.zeroArm();
    climber.zeroClimber();
  }

  private void configureButtonBindings() {
    drivetrain.setDefaultCommand(drive);
    runIntakeButton.whenHeld(runIntakeForwards);
    shootButton.whenHeld(shoot);
    runNeckButton.whenHeld(runNeck);
    runIntakeBackwardsButton.whenHeld(runIntakeBackwards);
    raiseArmButton.whenHeld(raiseArm);
    lowerArmButton.whenHeld(lowerArm);
    runFeederForwardsButton.whenHeld(runFeederForwards);
    runFeederBackwardsButton.whenHeld(runFeederBackwards);
    raiseClimberButton.whenHeld(raiseClimber);
    lowerClimberButton.whenHeld(lowerClimber);
    lowerArmAndIntakeButton.whenHeld(armAndIntake);
    runIntakeAndFeederButton.whenHeld(intakeAndFeeder);
    runFeederAndShootButton.whenHeld(feederAndShoot);
    lowerArmIntakeAndFeederButton.whenHeld(armIntakeAndFeeder);
  }

  private void configureAutos() {
    // TODO: Rename Autos on Dashboard
    sendableChooser.setDefaultOption("No Auto", zeroAuto);
    sendableChooser.addOption("First Auto", firstAuto);
    sendableChooser.addOption("Second Auto", secondAuto);
    sendableChooser.addOption("Third Auto", thirdAuto);
  }

  public Command getAutonomousCommand() {
    return sendableChooser.getSelected();
  }
}

