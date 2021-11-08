package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class MovePulley extends CommandBase{
    public MovePulley(){
        addRequirements(RobotContainer.getPulley());
    }

    public void execute(){
        RobotContainer.getPulley().movePulley(Constants.PULLEY_SPEED);
    }

    public boolean isFinished(){
        return !RobotContainer.getJoy().getRawButton(Constants.PULLEY_BUTTON);
    }

    public void end(boolean interrupted){
        RobotContainer.getPulley().stop();
    }
}
