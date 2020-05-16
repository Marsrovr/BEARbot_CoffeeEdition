
package frc.robot.subsystems;


import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.RobotControlCommand; 




public class DriveSubsystem extends Subsystem {
 
  //talon declarations
  public Talon f_LeftMotor = new Talon(RobotMap.f_leftMotor);
  public Talon b_LeftMotor = new Talon(RobotMap.b_leftMotor);
  public Talon f_RightMotor = new Talon(RobotMap.f_rightMotor);
  public Talon b_RightMotor = new Talon(RobotMap.b_rightMotor);
  
  // speed controller objects
  SpeedControllerGroup leftMotor = new SpeedControllerGroup(f_LeftMotor, b_LeftMotor);
  SpeedControllerGroup rightMotor = new SpeedControllerGroup(f_RightMotor, b_RightMotor);

  // object to code differential drive via cheater methods
  public DifferentialDrive tankDrive = new DifferentialDrive(leftMotor, rightMotor);



  public void TeleopDrive(double speed, double rotation) {

    if(Math.abs(speed) > .10 && Math.abs(rotation) > .10) {
    tankDrive.arcadeDrive(speed, rotation);
    }
    
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new RobotControlCommand());
  }
}
