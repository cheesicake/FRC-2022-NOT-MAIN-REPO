package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.math.controller.PIDController;

public class Arm extends SubsystemBase{
    private CANSparkMax armSpark1;
    private CANSparkMax armSpark2;
    private MotorControllerGroup armSparks;
    private Encoder encoder;
    private PIDController pid;
    
    public static enum ArmState {
        LOW,
        HIGH
    }
    
    private ArmState armState;

    private int lowSetPoint, highSetPoint;

    public Arm() {
        armSpark1 = new CANSparkMax(Constants.CanIds.armSpark1, MotorType.kBrushless);
        armSpark2 = new CANSparkMax(Constants.CanIds.armSpark2, MotorType.kBrushless);

        //TODO: CHECK WHICH ONES ARE INVERTED
        armSpark1.setInverted(true);
        armSpark2.setInverted(false);

        armSparks = new MotorControllerGroup(armSpark1, armSpark2);
        encoder = new Encoder(
            Constants.IntakeAndArmConstants.encoderChannelA,
            Constants.IntakeAndArmConstants.encoderChannelB,
            Constants.IntakeAndArmConstants.encoderReverse,
            Constants.IntakeAndArmConstants.encodingType
        );
        lowSetPoint = Constants.IntakeAndArmConstants.pidLowSetPoint;
        highSetPoint = Constants.IntakeAndArmConstants.pidHighSetPoint;

        pid = new PIDController(
            Constants.IntakeAndArmConstants.kP, 
            Constants.IntakeAndArmConstants.kI, 
            Constants.IntakeAndArmConstants.kD
        );

        armState = ArmState.HIGH;
    }

    public void setArmSpeed(double speed) {
        armSparks.set(speed);
    }

    public int getEncoderRaw() {
        return encoder.getRaw();
    }

    public double calculatePID(double encoderRaw, int setPoint) {
        return pid.calculate(encoderRaw, setPoint);
    }

    public void runArm(ArmState armState) {
        this.armState = armState;
        switch (this.armState) {
            case HIGH:
                setArmSpeed(calculatePID(getEncoderRaw(), highSetPoint));
                break;
            case LOW:
                setArmSpeed(calculatePID(getEncoderRaw(), lowSetPoint));
                break;
        }
    }

    public void resetPID() {
        pid.reset();
    }

    public MotorControllerGroup getArmSpark() {
        return armSparks;
    }

    public void zeroArm() {
        pid.reset();
        armState = ArmState.HIGH;
        runArm(armState);
    }

    public void close() {
        armSparks.close();
        encoder.close();
        pid.close();
    }

}

