package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.Auto.FirstAuto;
import frc.robot.Auto.SecondAuto;
import frc.robot.Auto.ThirdAuto;
import frc.robot.Auto.ZeroAuto;
import frc.robot.commands.Climb;
import frc.robot.commands.Drive;
import frc.robot.subsystems.Climber;
import frc.robot.auto.FirstAuto;
import frc.robot.auto.SecondAuto;
import frc.robot.auto.ThirdAuto;
import frc.robot.auto.ZeroAuto;
import frc.robot.commands.Drive;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Climber.ClimberState;

public class RobotContainer {

  private Drivetrain drivetrain = new Drivetrain();
  private Climber climber = new Climber();

  private Joystick leftJoystick = new Joystick(Constants.JoystickConstants.leftJoystickPort);
  private Joystick rightJoystick = new Joystick(Constants.JoystickConstants.rightJoystickPort);
  private Joystick secondaryJoystick = new Joystick(Constants.JoystickConstants.secondaryJoystickPort);


  // Buttons
  private final JoystickButton exampleButton = new JoystickButton(secondaryJoystick, 1);
  private final JoystickButton raiseClimberButton = new JoystickButton(secondaryJoystick, Constants.JoystickConstants.SecondaryJoystick.raiseClimber);
  private final JoystickButton lowerClimberButton = new JoystickButton(secondaryJoystick, Constants.JoystickConstants.SecondaryJoystick.lowerClimber);
  

  // Commands
  private final Drive drive = new Drive(drivetrain, leftJoystick, rightJoystick);
  private final Climb raiseClimber = new Climb(climber, ClimberState.RAISE);
  private final Climb lowerClimber = new Climb(climber, ClimberState.LOWER);
  


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
    raiseClimberButton.whenHeld(raiseClimber);
    lowerClimberButton.whenHeld(lowerClimber);

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
