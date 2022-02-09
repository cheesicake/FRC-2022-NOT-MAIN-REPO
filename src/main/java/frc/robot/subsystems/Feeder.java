package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Feeder extends SubsystemBase implements SingleMotorSubsystem {
    private CANSparkMax feederMotor;

    public Feeder() {
        feederMotor = new CANSparkMax(Constants.CanIds.feederSpark1, MotorType.kBrushless);
    }

    public void set(boolean dir) {
        feederMotor.set((dir ? 1.0 : 0.0 )*Constants.FeederConstants.feederSpeed);
    }
    public void stop() {
        feederMotor.set(0.0);
    }

    public CANSparkMax getMotor() {
        return this.feederMotor;
    }

    public void close(){
        feederMotor.close();
    }
}
