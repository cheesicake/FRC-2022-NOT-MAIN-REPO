package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Intake.Direction;

public class RunIntake extends CommandBase{
    
    private Intake intake;
    private Direction direction; //if true run intake forward, if false run intake backward
    public RunIntake(Intake intake, Direction direction) {
        this.intake = intake;
        this.direction = direction;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        intake.runIntake(direction);
    }

    
}
