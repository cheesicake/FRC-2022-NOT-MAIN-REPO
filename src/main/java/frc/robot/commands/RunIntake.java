package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.Constants.Direction;;

public class RunIntake extends CommandBase{
    private Intake intake;
    private Direction direction; 

    public RunIntake(Intake intake, Direction direction) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void execute() {

        intake.runIntake(Direction.FORWARDS);
    }

    @Override
    public void end(boolean i) {
        intake.stopIntake();
    }
    
}

