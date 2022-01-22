package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class RunIntakeBackwards extends CommandBase{
    private Intake intake;

    public RunIntakeBackwards(Intake intake) {
        this.intake = intake;

        addRequirements(intake);
    }

    @Override
    public void execute() {
        intake.set(false);
    }
}
