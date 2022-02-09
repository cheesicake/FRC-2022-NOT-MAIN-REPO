package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Dir;
import frc.robot.subsystems.Feeder;

public class RunFeeder extends CommandBase{
    private Feeder feeder;
    private Dir dir;

    public RunFeeder(Feeder feeder, Dir dir) {
        this.feeder = feeder;
        this.dir = dir;

        addRequirements(feeder);
    }

    @Override
    public void execute() {
        feeder.set(this.dir.equals(Dir.FORWARDS));
    }

    @Override
    public void end(boolean i) {
        feeder.stop();
    }
}
