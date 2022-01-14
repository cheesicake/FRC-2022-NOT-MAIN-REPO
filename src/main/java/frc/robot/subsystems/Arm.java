package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.IntakeAndArmConstants;

public class Arm extends SubsystemBase{
    private CANSparkMax armSpark;

    public Arm() {
        armSpark = new CANSparkMax(Constants.CanIds.armSpark, MotorType.kBrushless);
    }

    public void raiseArm() {
        armSpark.set(IntakeAndArmConstants.raiseArmSpeed);
        
    }

    public void lowerArm() {
        armSpark.set(IntakeAndArmConstants.lowerArmSpeed);
    }

    public CANSparkMax getArmSpark() {
        return armSpark;
    }
}
