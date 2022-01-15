package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public interface SingleMotorSubsystem {
    public void set(boolean direction); // left false right true
    public void stop();
    public MotorController getMotor();
}