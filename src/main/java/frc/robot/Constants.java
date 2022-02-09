package frc.robot;

import edu.wpi.first.math.util.Units;
<<<<<<< HEAD
import edu.wpi.first.wpilibj.CounterBase.EncodingType;


=======
>>>>>>> a17a2ce1da8f914c57ea02eedc1210672d2f5ad3
import java.lang.Math;

public class Constants {

    public class CanIds {
<<<<<<< HEAD
=======

>>>>>>> a17a2ce1da8f914c57ea02eedc1210672d2f5ad3
        public final static int pigeonId = 0;
        public final static int rightFrontTalon = 1;
        public final static int rightRearTalon = 2;
        public final static int leftFrontTalon = 3;
        public final static int leftRearTalon = 4;

<<<<<<< HEAD

        public final static int intakeSpark = 5;
        public final static int armSpark = 6;
=======
        public final static int intakeSpark1 = 5;
        public final static int intakeSpark2 = 6;
>>>>>>> a17a2ce1da8f914c57ea02eedc1210672d2f5ad3
        public final static int feederSpark1 = 7;
        public final static int feederSpark2 = 8;
        public final static int feederSpark3 = 9;
        public final static int climberSpark1 = 10;
        public final static int climberSpark2 = 11;
<<<<<<< HEAD
        public final static int shooterTalonLeft = 12;
        public final static int shooterTalonRight = 13;
        public final static int shooterSparkNeck = 14;
=======
        public final static int shooterSpark1 = 12;
        public final static int shooterSpark2 = 13;
>>>>>>> a17a2ce1da8f914c57ea02eedc1210672d2f5ad3
    }

    public class JoystickConstants {
        public final static int leftJoystickPort = 0;
        public final static int rightJoystickPort = 1;
        public final static int secondaryJoystickPort = 2;

        public class SecondaryJoystick { // Temporary Buttons for Controls meant for Week 1 Teams to use
            public final static int lowerArm = 0; // Implement PID System to preset these positions
            public final static int raiseArm = 1;
            public final static int runIntakeForward = 2;
            public final static int runIntakeBackwards = 3;
            public final static int runFeeder = 4;
            public final static int runShooter = 5;
<<<<<<< HEAD
            public final static int raiseClimber = 6;
            public final static int lowerClimber = 7;
            public final static int runNeck = 8;
        }
    }
    
    public static class DriveTrainConstants {
        public final static double kP = 0.5;
        public final static double kI = 0;
        public final static double kD = 0;
        public final static double metersPerRev = Units.metersToInches(3) * 2 * Math.PI;

        public final double trackWidth = Units.inchesToMeters(25); // TODO: Need To Determine In Meters
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

    public static class ShooterConstants {
        public final static double shootSpeed = 1.0;
        public final static double neckSpeed = 0.5;
    }
=======
        }

    }

    public class DriveTrainConstants {
        public final static double kP = 0.5;
        public final static double kI = 0;
        public final static double kD = 0;

        public final double metersPerRev = Units.metersToInches(3) * 2 * Math.PI;

        public final double trackWidth = 0.5; // TODO: Need To Determine In Meters

    }

>>>>>>> a17a2ce1da8f914c57ea02eedc1210672d2f5ad3
}