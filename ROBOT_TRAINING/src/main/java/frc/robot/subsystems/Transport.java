package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Transport extends SubsystemBase{

    public SpeedController transport;

    public Transport(SpeedController transport){
        this.transport = transport;
    }

    public void moveTransport(double speed){
        transport.set(speed);
    }

    public void stop(){
        transport.stopMotor();
    }
}
