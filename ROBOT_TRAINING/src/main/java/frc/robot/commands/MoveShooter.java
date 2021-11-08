package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class MoveShooter extends CommandBase{
    public MoveShooter(){
        addRequirements(RobotContainer.getShooter());
    }

    public void execute(){
        RobotContainer.getShooter().moveshooter(Constants.SHOOTER_SPEED);
    }

    public boolean isFinished(){
        return !RobotContainer.getJoy().getRawButton(Constants.SHOOTER_BUTTON);
    }

    public void end(boolean interrupted){
        RobotContainer.getShooter().stop();
    }
}
