package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Drive;
import frc.robot.constants.JoystickConstants;
import frc.robot.subsystems.Drivetrain;


public class RobotContainer {
  
  private Drivetrain drivetrain = new Drivetrain();

  private Joystick leftJoystick = new Joystick(JoystickConstants.leftJoystickPort);
  private Joystick rightJoystick = new Joystick(JoystickConstants.rightJoystickPort);
  private Joystick secondaryJoystick = new Joystick(JoystickConstants.secondaryJoystickPort);

  //TODO:REMOVE ALL EXAMPLE BUTTONS, COMMANDS, METHODS AFTER WEEK 1

  //Buttons
  private final JoystickButton exampleButton = new JoystickButton(secondaryJoystick, 1);


  //Commands
  private final Drive drive = new Drive(drivetrain, leftJoystick, rightJoystick);
  private final Drive exampleCommand = new Drive(drivetrain, leftJoystick, rightJoystick);
  

  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    drivetrain.setDefaultCommand(drive);
    exampleButton.whenHeld(exampleCommand); //Example Code 
  }


  public void getAutonomousCommand() { //Temporarily replaced Command with Void to be able to build

    return;
  }
}
