package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.Direction;

public class Feeder extends SubsystemBase {
    private CANSparkMax feederSpark;
    private Direction direction;

    public Feeder() {
        feederSpark = new CANSparkMax(Constants.CanIds.feederSpark, MotorType.kBrushless);
        direction = Direction.FORWARDS;
    }

    public void runFeeder(Direction direction) {
        this.direction = direction;
        switch(direction) {
            case FORWARDS:
                feederSpark.set(Constants.FeederConstants.feederSpeed);
                break;
            case BACKWARDS:
                feederSpark.set(Constants.FeederConstants.feederSpeed);
                break;
        }
    }
    public void stop() {
        feederSpark.set(0.0);
    }

    public CANSparkMax getFeederSpark() {
        return this.feederSpark;
    }

    public void close(){
        feederSpark.close();    
}
}
