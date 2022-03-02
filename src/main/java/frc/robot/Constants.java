package frc.robot;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

import java.lang.Math;

public class Constants {

    public class CanIds {
      
        public final static int pigeonId = 0;
        public final static int rightFrontTalon = 1;
        public final static int rightRearTalon = 2;
        public final static int leftFrontTalon = 3;
        public final static int leftRearTalon = 4;
        public final static int shooterTalonRight = 5;
        public final static int shooterTalonLeft = 6;
        public final static int intakeSpark = 7;
        public final static int armSpark1 = 8;
        public final static int armSpark2 = 9;
        public final static int feederSpark = 10;
        public final static int neckSpark = 11;
        public final static int climberSpark1 = 12;
        public final static int climberSpark2 = 13;
        
    }

    public class JoystickConstants {
        public final static int leftJoystickPort = 0;
        public final static int rightJoystickPort = 1;
        public final static int secondaryJoystickPort = 2;

        public class SecondaryJoystick { // Temporary Buttons for Controls meant for Week 1 Teams to use
            public final static int lowerArm = 0; // Implement PID System to preset these positions
            public final static int raiseArm = 1;
            public final static int runIntakeForwards = 2;
            public final static int runIntakeBackwards = 3;

            public final static int runFeederForwards = 4;
            public final static int runFeederBackwards = 5;
            public final static int runShooter = 6;
            public final static int raiseClimber = 7;
            public final static int lowerClimber = 8;
            public final static int runNeck = 9;

            public final static int moveArmAndIntake = 10;
            public final static int runIntakeAndFeeder = 11;
            public final static int runFeederAndShoot = 12;
            public final static int moveArmIntakeandShoot = 13;
        }
    }

    public static class DriveTrainConstants {
        public final static double kP = 0.5;
        public final static double kI = 0;
        public final static double kD = 0;
        public final static double metersPerRev = Units.metersToInches(3) * 2 * Math.PI;
        
        public final static double trackWidth = Units.inchesToMeters(25);
        
        //TODO: Need to get actual values later from the characterization tool.
        public static final double kS = 1;
        public static final double kV = 1;
        public static final double kA = 1;
    }
    
    public static class ClimberConstants {
        public final static int encoderChannelA = 2;
        public final static int encoderChannelB = 3;
        public final static Boolean encoderReverse = false;
        public final static EncodingType encodingType = EncodingType.k1X;

        public final static double kP = 0;
        public final static double kI = 0;
        public final static double kD = 0;

        public final static int pidLowSetPoint = 0;
        public final static int pidHighSetPoint = 0;
        public final double trackWidth = Units.inchesToMeters(25); // TODO: Need To Determine In Meters


        //Need to get actual values later from the characterization tool.
        public static final  double kS = 1;
        public static final double kV = 1;
        public static final double kA = 1;

    }

    public static enum Direction {
        FORWARDS,
        BACKWARDS
    }

    public static class IntakeAndArmConstants {
        public final static double intakeSpeed = 0.3;
        public final static double backwardsIntakeSpeed = -0.3;
        
        public final static double raiseArmSpeed = 0.1;
        public final static double lowerArmSpeed = -0.1;

        public final static int encoderChannelA = 0;
        public final static int encoderChannelB = 1;
        public final static boolean encoderReverse = false;
        public final static EncodingType encodingType = EncodingType.k1X;

        public final static int kP = 0;
        public final static int kI = 0;
        public final static int kD = 0;
        
        public final static int pidLowSetPoint = 0;
        public final static int pidHighSetPoint = 0;
    }

    public static class FeederConstants {
        public final static double feederSpeed = 0.3;
        public final static double backwardsFeederSpeed = -0.3;
    }


    public static class ShooterConstants {
        public final static double neckSpeed = 0.5;
        public final static double shootSpeed = 1.0;
    }


}