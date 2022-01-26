package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase{
    private CANSparkMax climberSparkMotorOne;
    private CANSparkMax climberSparkMotorTwo;

    public static enum ClimberState {
        RAISE,
        LOWER
    }


    private MotorControllerGroup climberSparks;
    private ClimberState climberState;

    public Climber() {
        climberSparkMotorOne = new CANSparkMax(Constants.CanIds.climberSpark1, MotorType.kBrushless);
        climberSparkMotorTwo = new CANSparkMax(Constants.CanIds.climberSpark2, MotorType.kBrushless);

        climberSparks = new MotorControllerGroup(climberSparkMotorOne, climberSparkMotorTwo);
        climberState = ClimberState.LOWER;

    }
    

    public void raiseClimber() {
        climberSparks.set(Constants.ClimberConstants.raiseClimberSpeed);
    }

    public void lowerClimber() {
        climberSparks.set(Constants.ClimberConstants.lowerClimberSpeed);
    }

    public MotorControllerGroup getClimberGroup() {
        return climberSparks;
    }

    public void runClimber(ClimberState climberState) {
        this.climberState = climberState;
        if (this.climberState == ClimberState.RAISE) {
            raiseClimber();
        } else if (this.climberState == ClimberState.LOWER) {
            lowerClimber();
        }
    }
}
