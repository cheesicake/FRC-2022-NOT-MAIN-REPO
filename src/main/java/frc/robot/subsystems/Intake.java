package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
    private CANSparkMax intakeSpark;
    private Direction direction;

    public static enum Direction {
        FORWARD,
        BACKWARD
    }

    public void runIntake(Direction forward) {
        this.direction = forward;
        switch(forward) {
            case FORWARD:
                intakeSpark.set(Constants.IntakeAndArmConstants.intakeSpeed);
                break;
            case BACKWARD:
                intakeSpark.set(Constants.IntakeAndArmConstants.backwardsIntakeSpeed);
                break;
        }
    }


    public void stopIntake() {
        intakeSpark.set(0);
    }

    public CANSparkMax getIntakeSpark() {
        return intakeSpark;
    }

    public void close() {
        intakeSpark.close();
    }

}

