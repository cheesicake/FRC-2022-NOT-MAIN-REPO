package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.auto.FirstAuto;
import frc.robot.auto.SecondAuto;
import frc.robot.auto.ThirdAuto;
import frc.robot.auto.ZeroAuto;
import frc.robot.commands.Drive;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer {

  private Drivetrain drivetrain = new Drivetrain();

  private Joystick leftJoystick = new Joystick(Constants.JoystickConstants.leftJoystickPort);
  private Joystick rightJoystick = new Joystick(Constants.JoystickConstants.rightJoystickPort);
  private Joystick secondaryJoystick = new Joystick(Constants.JoystickConstants.secondaryJoystickPort);


  // Buttons
  private final JoystickButton exampleButton = new JoystickButton(secondaryJoystick, 1);

  // Commands
  private final Drive drive = new Drive(drivetrain, leftJoystick, rightJoystick);


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
