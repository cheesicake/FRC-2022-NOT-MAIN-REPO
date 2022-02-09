package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Auto.FirstAuto;
import frc.robot.Auto.SecondAuto;
import frc.robot.Auto.ThirdAuto;
import frc.robot.Auto.ZeroAuto;
import frc.robot.commands.Drive;
<<<<<<< HEAD
import frc.robot.commands.RunNeck;
import frc.robot.commands.Shoot;
=======
>>>>>>> a17a2ce1da8f914c57ea02eedc1210672d2f5ad3
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;

public class RobotContainer {

  private Drivetrain drivetrain = new Drivetrain();
  private Shooter shooter = new Shooter();

  private Joystick leftJoystick = new Joystick(Constants.JoystickConstants.leftJoystickPort);
  private Joystick rightJoystick = new Joystick(Constants.JoystickConstants.rightJoystickPort);
  private Joystick secondaryJoystick = new Joystick(Constants.JoystickConstants.secondaryJoystickPort);

  // TODO:REMOVE ALL EXAMPLE BUTTONS, COMMANDS, METHODS AFTER WEEK 1

  // Buttons
  private final JoystickButton exampleButton = new JoystickButton(secondaryJoystick, 1);
<<<<<<< HEAD
  private final JoystickButton shootButton = new JoystickButton(secondaryJoystick, Constants.JoystickConstants.SecondaryJoystick.runShooter);
  private final JoystickButton runNeckButton = new JoystickButton(secondaryJoystick, Constants.JoystickConstants.SecondaryJoystick.runNeck);

  //Commands
  private final Drive drive = new Drive(drivetrain, leftJoystick, rightJoystick);
  private final Drive exampleCommand = new Drive(drivetrain, leftJoystick, rightJoystick);
  private final Shoot shoot = new Shoot(shooter);
  private final RunNeck runNeck = new RunNeck(shooter);
  
=======

  // Commands
  private final Drive drive = new Drive(drivetrain, leftJoystick, rightJoystick);
  private final Drive exampleCommand = new Drive(drivetrain, leftJoystick, rightJoystick);
>>>>>>> a17a2ce1da8f914c57ea02eedc1210672d2f5ad3

  // Auto
  private final ZeroAuto zeroAuto = new ZeroAuto();
  private final FirstAuto firstAuto = new FirstAuto();
  private final SecondAuto secondAuto = new SecondAuto();
  private final ThirdAuto thirdAuto = new ThirdAuto();

  private final SendableChooser<Command> sendableChooser = new SendableChooser<>();

  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    configureAutos();
  }

  private void configureButtonBindings() {
    drivetrain.setDefaultCommand(drive);
<<<<<<< HEAD
    shootButton.whenHeld(shoot);
    runNeckButton.whenHeld(runNeck);
    exampleButton.whenHeld(exampleCommand); //Example Code 
=======
    exampleButton.whenHeld(exampleCommand); // Example Code
>>>>>>> a17a2ce1da8f914c57ea02eedc1210672d2f5ad3
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
