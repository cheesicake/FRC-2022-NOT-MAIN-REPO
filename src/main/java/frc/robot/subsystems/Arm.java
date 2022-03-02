package frc.robot.subsystems;

import java.util.TooManyListenersException;

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
<<<<<<< HEAD
    private Encoder encoder;
=======
    private Encoder encoder1, encoder2;
>>>>>>> 50024466d6cace26f3538f652189a34f6aee5285
    private PIDController pid;
    
    public static enum ArmState {
        LOW,
        HIGH
    }
    
    private ArmState armState;

    private double lowSetPoint, highSetPoint;

    public Arm() {
        armSpark1 = new CANSparkMax(Constants.CanIds.armSpark1, MotorType.kBrushless);
        armSpark2 = new CANSparkMax(Constants.CanIds.armSpark2, MotorType.kBrushless);

        //TODO: CHECK WHICH ONES ARE INVERTED
        armSpark1.setInverted(true);
        armSpark2.setInverted(false);

        armSparks = new MotorControllerGroup(armSpark1, armSpark2);
<<<<<<< HEAD
        encoder = new Encoder(
            Constants.IntakeAndArmConstants.encoderChannelA,
            Constants.IntakeAndArmConstants.encoderChannelB,
            Constants.IntakeAndArmConstants.encoderReverse,
            Constants.IntakeAndArmConstants.encodingType
=======
        encoder1 = new Encoder(
            2,
            3
        );
        encoder2 = new Encoder(
            0,
            1
>>>>>>> 50024466d6cace26f3538f652189a34f6aee5285
        );
        lowSetPoint = Constants.IntakeAndArmConstants.pidLowSetPoint;
        highSetPoint = Constants.IntakeAndArmConstants.pidHighSetPoint;

        pid = new PIDController(
            Constants.IntakeAndArmConstants.kP, 
            Constants.IntakeAndArmConstants.kI, 
            Constants.IntakeAndArmConstants.kD
        );

        //pid.setTolerance(Constants.IntakeAndArmConstants.tolerance);

        armState = ArmState.HIGH;
    }

    public void setArmSpeed(double speed) {
        if (speed >= 0.6) {
            speed = 0.6;
        } else if (speed <= -0.6) {
            speed = -0.6;
        }
        //System.out.println(speed);
        armSparks.set(speed);
    }

<<<<<<< HEAD
    public int getEncoderRaw() {
        return encoder.getRaw();
=======
    public double getEncoderRaw() {
        //System.out.println("Encoder Average: " + (encoder1.getRaw()+encoder2.getRaw())/2);
        return encoder2.getRaw();
>>>>>>> 50024466d6cace26f3538f652189a34f6aee5285
    }

    public double calculatePID(double encoderRaw, double setPoint) {
        if (atSetpoint(setPoint, Constants.IntakeAndArmConstants.tolerance)) {
            return 0;
        } else {
            return pid.calculate(encoderRaw, setPoint);
        }
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
<<<<<<< HEAD
        pid.reset();
=======
        resetPID();
        encoder1.reset();
        encoder2.reset();
>>>>>>> 50024466d6cace26f3538f652189a34f6aee5285
        armState = ArmState.HIGH;
        runArm(armState);
    }

    public boolean atSetpoint(Double setpoint, Double tolerance) {
        return getEncoderRaw() <= setpoint + tolerance && getEncoderRaw() >= setpoint - tolerance;
    }

    public void close() {
        armSpark1.close();
        armSpark2.close();
        encoder.close();
        pid.close();
    }

}