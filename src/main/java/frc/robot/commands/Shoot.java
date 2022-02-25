package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Neck;
import frc.robot.subsystems.Shooter;
import frc.robot.Constants.Direction;

public class Shoot extends CommandBase {
    private Neck neck;
    private Shooter shooter;
    private Double targetVelocity;
    private Double leftVelocity;
    private Double rightVelocity;

    public Shoot(Neck neck, Shooter shooter, double targetVelocity) {
        this.targetVelocity = targetVelocity;
        this.shooter = shooter;
        this.neck = neck;

        addRequirements(neck, shooter);
    }

    @Override
    public void execute() {
        shooter.shoot();

        leftVelocity = shooter.getLeftVelocity();
        rightVelocity = shooter.getRightVelocity();

        //wait until both left and right velocities are above the target
        while (leftVelocity < targetVelocity || rightVelocity < targetVelocity) {
            leftVelocity = shooter.getLeftVelocity();
            rightVelocity = shooter.getRightVelocity();
        }
        
        neck.runNeck(Direction.FORWARDS);
    }

    @Override 
    public void end(boolean i) {
        shooter.stop();
        neck.stop();
    }
}
