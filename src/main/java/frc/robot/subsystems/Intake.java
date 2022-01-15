package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;

public class Intake extends SubsystemBase implements SingleMotorSubsystem {
    private CANSparkMax intakeSpark;

    public Intake() {
        intakeSpark = new CANSparkMax(Constants.CanIds.intakeSpark, MotorType.kBrushless);
    }

    public void set(boolean dir) {
        if (dir) {
            intakeSpark.set(Constants.IntakeAndArmConstants.intakeSpeed);
        } else {
            intakeSpark.set(-Constants.IntakeAndArmConstants.intakeSpeed);
        }
    }
    public void stop() {
        intakeSpark.set(0.0);
    }

    public CANSparkMax getMotor() { // why
        return this.intakeSpark;
    }
}
