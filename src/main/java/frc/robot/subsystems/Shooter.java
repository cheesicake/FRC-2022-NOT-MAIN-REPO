package frc.robot.subsystems;

import java.util.function.BooleanSupplier;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
    private WPI_TalonFX shooterTalonLeft;
    private WPI_TalonFX shooterTalonRight;
<<<<<<< HEAD

    private CANSparkMax neckSpark;
=======
    private double targetVelocity;
>>>>>>> 50024466d6cace26f3538f652189a34f6aee5285

    public Shooter() {
        shooterTalonLeft = new WPI_TalonFX(Constants.CanIds.shooterTalonLeft);
        shooterTalonRight = new WPI_TalonFX(Constants.CanIds.shooterTalonRight);

<<<<<<< HEAD
        neckSpark = new CANSparkMax(Constants.CanIds.neckSpark,MotorType.kBrushless);
=======
        shooterTalonLeft.follow(shooterTalonRight);

        shooterTalonRight.config_kP(Constants.ShooterConstants.kPIDLoopIdx, Constants.ShooterConstants.kP);
        shooterTalonRight.config_kI(Constants.ShooterConstants.kPIDLoopIdx, Constants.ShooterConstants.kI);
        shooterTalonRight.config_kD(Constants.ShooterConstants.kPIDLoopIdx, Constants.ShooterConstants.kD);
        shooterTalonRight.config_kF(Constants.ShooterConstants.kPIDLoopIdx, Constants.ShooterConstants.kF);
>>>>>>> 50024466d6cace26f3538f652189a34f6aee5285

        shooterTalonLeft.setInverted(true);
    }

<<<<<<< HEAD
    public void shoot() {
        shooterTalonLeft.set(Constants.ShooterConstants.shootSpeed);
        shooterTalonRight.set(Constants.ShooterConstants.shootSpeed);
    }

    public void runNeck() {
        neckSpark.set(Constants.ShooterConstants.neckSpeed);
    }
=======
    public void shoot(double targetVelocity) {
        this.targetVelocity = targetVelocity;
        System.out.println(getVelocity());
        System.out.println(shooterTalonLeft.getMotorOutputPercent());
        shooterTalonRight.set(ControlMode.Velocity, targetVelocity); 
    }

    public void stop() {
        shooterTalonRight.set(0);
    }

    public double getVelocity() {
        return shooterTalonRight.getSelectedSensorVelocity();
    }

    //WaitUntilCommand Refuses to Accept Boolean Values


    public WPI_TalonFX getLeftShooterTalon() {
        return shooterTalonLeft;
    }

    public WPI_TalonFX getRightShooterTalon() {
        return shooterTalonRight;
    }

>>>>>>> 50024466d6cace26f3538f652189a34f6aee5285
}
