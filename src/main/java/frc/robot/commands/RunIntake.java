package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class RunIntake extends CommandBase{
    
    private Intake intake;
    private boolean direction; //if true run intake forward, if false run intake backward
    public RunIntake(Intake intake, boolean direction) {
        this.intake = intake;
        this.direction = direction;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        if (direction == true) {
            intake.runIntake();
        }
        else {
            intake.runIntakeBackwards();
        }
    }

    
}
