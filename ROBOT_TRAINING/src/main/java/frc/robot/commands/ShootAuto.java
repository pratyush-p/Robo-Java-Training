package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ShootAuto extends CommandBase{
    public ShootAuto(){
        addRequirements(RobotContainer.getTransport());
        addRequirements(RobotContainer.getPulley());
        addRequirements(RobotContainer.getShooter());
    }

    public void execute(){
        RobotContainer.getTransport().moveTransport(Constants.TRANSPORT_SPEED);
        RobotContainer.getPulley().movePulley(Constants.PULLEY_SPEED);
        RobotContainer.getShooter().moveshooter(Constants.SHOOTER_SPEED);
    }

    public boolean isFinished(){
        return !RobotContainer.getJoy().getRawButton(Constants.SHOOT_AUTO_BUTTON);
    }

    public void end(boolean interrupted){
        RobotContainer.getTransport().stop();
        RobotContainer.getPulley().stop();
        RobotContainer.getShooter().stop();
    }
}
