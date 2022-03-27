package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.math.filter.MedianFilter;


public class Limelight {

    private static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight-unicorn");
    private static NetworkTableEntry tx = table.getEntry("tx");
    private static NetworkTableEntry ty = table.getEntry("ty");
    private static NetworkTableEntry ta = table.getEntry("ta");
    private static MedianFilter filter = new MedianFilter(7);

    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);
    

    public static double getarea() {
        double area = ta.getDouble(0.0);
        return area;
    }
    
    public static double getTx() {
        double x = tx.getDouble(0.0);
        return x;
    }
    
    public static double getTy() {
        return filter.calculate(ty.getDouble(0.0));
    }
    
    public static double getdistances(){
        double distance = (206-58)/(Math.tan(Math.toRadians(41+Limelight.getTy())));
        return distance;
    }

    private static int compensation = 0;
    public static double getTargetVelocity() {
        double velocity = -1;
        double distance = Limelight.getdistances();
        if(distance >= 140 && distance < 180) {
            velocity = 9200 + 300 * (distance - 140) / 40;

        }else if(distance >= 180 && distance < 210) {
            velocity = 9500 + 450 * (distance - 180) / 30;

        }else if(distance >= 210 && distance < 240) {
            velocity = 9950 + 250 * (distance - 210) / 30;

        }else if(distance >= 240 && distance < 270) {
            velocity = 10200 + 700 * (distance - 240) / 30;

        }else if(distance >= 270 && distance < 300) {
            velocity = 10900 + 400 * (distance - 270) / 30;

        }else if(distance >= 300 && distance < 330) {
            velocity = 11300 + 400 * (distance - 300) / 30;

        }else if(distance >= 330 && distance < 360) {
            velocity = 11700 + 300 * (distance - 330) / 30;

        }else if(distance >= 360 && distance < 390) {
            velocity = 12000 + 50 * (distance - 360) / 30;
            
        }else if(distance >= 390 && distance < 420) {
            velocity = 12050;
        }
        
        return velocity + compensation;
    }

    // @Override
    // public void periodic(){
    //     // SmartDashboard.putNumber("Distance_Limelight", getdistances());
    //     SmartDashboard.putNumber("tx", Limelight.getTx());
    //     if(Limelight.getarea()>0){
    //         SmartDashboard.putBoolean("findthething",true);
    //     }else{
    //         SmartDashboard.putBoolean("findthething",false);
    //     }
    //     SmartDashboard.putNumber("dis_program", Limelight.getdistances());
    // }
}
