package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Intake extends SubsystemBase {
    private CANSparkMax intakeSpark;

    public Intake() {
        intakeSpark = new CANSparkMax(Constants.CanIds.intakeSpark, MotorType.kBrushless);
    }

    public void set(boolean dir) {
        intakeSpark.set((dir ? 1.0 : -1.0) * Constants.IntakeAndArmConstants.intakeSpeed);
    }
    public void stop() {
        intakeSpark.set(0.0);
    }

    public CANSparkMax getMotor() { // why
        return this.intakeSpark;
    }

    public void close() {
        this.intakeSpark.close();
    }
}
