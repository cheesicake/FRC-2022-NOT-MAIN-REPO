package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class MoveArm extends CommandBase{
    
    private Arm arm;
    private boolean direction; //if true run forward, if false run backward

    public MoveArm(Arm arm, boolean direction) {
        this.arm = arm;
        this.direction = direction;
        addRequirements(arm);
        
    }

    @Override
    public void execute() {
        if (direction == true) {
            arm.raiseArm();
        }
        else {
            arm.lowerArm();
        }
    }

}

