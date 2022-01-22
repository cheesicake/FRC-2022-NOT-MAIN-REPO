package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase implements SingleMotorSubsystem {
    private CANSparkMax armSpark;

    public Arm() {
        armSpark = new CANSparkMax(Constants.CanIds.armSpark, MotorType.kBrushless);
    }

    public void set(boolean dir) {
        armSpark.set((dir ? 1.0 : -1.0) * Constants.IntakeAndArmConstants.armSpeed);
    }
    public void stop() {
        armSpark.set(0.0);
    }

    public CANSparkMax getMotor() {
        return armSpark;
    }
}
