package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Feeder;

public class RunFeeder extends CommandBase{
    private Feeder feeder;

    public RunFeeder(Feeder feeder) {
        this.feeder = feeder;

        addRequirements(feeder);
    }

    @Override
    public void execute() {
        feeder.set(true); // run forwards
    }
}
