package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class Shoot extends CommandBase {
    private Shooter shooter;
<<<<<<< HEAD
    
    public Shoot(Shooter shooter) {
        this.shooter = shooter;
=======



    public Shoot(Shooter shooter) {
        this.shooter = shooter;

>>>>>>> 50024466d6cace26f3538f652189a34f6aee5285
        addRequirements(shooter);
    }

    @Override
    public void execute() {
<<<<<<< HEAD
        shooter.shoot();
=======
        shooter.getRightShooterTalon().set(1);
    }

    @Override 
    public void end(boolean i) {
        shooter.stop();
>>>>>>> 50024466d6cace26f3538f652189a34f6aee5285
    }
}
