
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;

public class Feeder extends SubsystemBase implements SingleMotorSubsystem {
    private CANSparkMax feederMotors;

    public Feeder() {
        feederMotors =  new CANSparkMax(Constants.CanIds.feederSpark1, MotorType.kBrushless);
            
    }

    public void set(boolean dir) {
        feederMotors.set((dir ? 1.0 : 0.0 )*Constants.IntakeAndArmConstants.feederSpeed);
    }
    public void stop() {
        feederMotors.set(0.0);
    }

    public CANSparkMax getMotor() {
        return this.feederMotors;
    }

    public Object getFeederSpeed() {
        return null;
    }
}