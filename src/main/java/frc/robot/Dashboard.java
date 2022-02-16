package frc.robot;

import java.beans.Encoder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {


    public Dashboard() {
        display();
    }

    public void display() {
        intakeInfo();
        feederInfo();
        climberInfo();
        shooterInfo();
        visionInfo();
    }

    public void intakeInfo() {
        SmartDashboard.putBoolean("String", true); //Example
    }

    public void feederInfo() {
        SmartDashboard.putBoolean("String", true);
        //Encoder
        //Encoder feederMotorEncoder = new Encoder (10);
        //feederMotorEncoder.getDistance();
        //Voltage
        SmartDashboard.putNumber("Voltage", feeder.getAverageVoltage());
        SmartDashboard.putNumber("Feeder encoder", feederMotorEncoder.getEncoderRaw());
    }


    public void climberInfo() {
        SmartDashboard.putNumber("Climber Encoder", climber.getEncoderRaw());
        SmartDashboard.putNumber("Climber Low Limit", climber.getLowSetPoint());
        SmartDashboard.putNumber("Climber High Limit", climber.getHighSetPoint());
        //Get encoder values 
    }

    public void shooterInfo() {
        SmartDashboard.putBoolean("String", true);
    }

    public void visionInfo() {
        SmartDashboard.putBoolean("String", true);
    }

}