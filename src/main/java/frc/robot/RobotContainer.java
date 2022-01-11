// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Drive;
import frc.robot.commands.ExampleCommand;
import frc.robot.constants.JoystickConstants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private Drivetrain drivetrain = new Drivetrain();

  private Joystick leftJoystick = new Joystick(JoystickConstants.leftJoystickPort);
  private Joystick rightJoystick = new Joystick(JoystickConstants.rightJoystickPort);
  private Joystick secondaryJoystick = new Joystick(JoystickConstants.secondaryJoystickPort);

  //Buttons

  //Commands
  private final Drive drive = new Drive(drivetrain, leftJoystick, rightJoystick);
  

  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    drivetrain.setDefaultCommand(drive);
  }


  public void getAutonomousCommand() { //Temporarily replaced Command with Void to be able to build

    return;
  }
}
