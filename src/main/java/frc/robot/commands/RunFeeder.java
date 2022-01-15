package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.Button;

import frc.robot.subsystems.Feeder;

public class RunFeeder extends CommandBase{
    private Feeder feeder;
    private Button control;

    public RunFeeder(Feeder feeder, Button ctrl) {
        this.feeder = feeder;
        this.control = ctrl;
    }

    @Override
    public void execute() {
        feeder.set(this.control.get()); // run forwards
    }
}
