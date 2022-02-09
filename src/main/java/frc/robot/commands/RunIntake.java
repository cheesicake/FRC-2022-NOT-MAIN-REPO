package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Dir;
import frc.robot.subsystems.Intake;

public class RunIntake extends CommandBase{
    private Intake intake;
    private Dir dir; //if true run intake forward, if false run intake backward
    public RunIntake(Intake intake, Dir dir) {
        this.intake = intake;
        this.dir = dir;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        intake.set(this.dir.equals(Dir.FORWARDS));
    }

    @Override
    public void end(boolean i) {
        intake.stop();
    }
}
