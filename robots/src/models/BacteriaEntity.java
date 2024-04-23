package models;

import java.awt.*;

import static addons.Bacteriaaddons.*;

public class BacteriaEntity implements Entity {
    private volatile double bacteriaPositionX = 100;
    private volatile double bacteriaPositionY = 100;
    private volatile double bacteriaDirection = 0;

    private volatile int targetPositionX = 150;
    private volatile int targetPositionY = 100;

    private static final double maxVelocity = 0.1;
    private static final double maxAngularVelocity = 0.001;

    public double getBacteriaPositionX(){return bacteriaPositionX;}
    public double getBacteriaPositionY(){return bacteriaPositionY;}
    public double getBacteriaDirection(){return bacteriaDirection;}

    @Override
    public void update() {
        double distance = distance(targetPositionX, targetPositionY,
                bacteriaPositionX, bacteriaPositionY);
        if (distance < 0.5)
        {
            return;
        }
        double velocity = maxVelocity;
        double angleToTarget = angleTo(bacteriaPositionX, bacteriaPositionY, targetPositionX, targetPositionY);
        double angularVelocity = 0;
        if (angleToTarget > bacteriaDirection)
        {
            angularVelocity = maxAngularVelocity;
        }
        if (angleToTarget < bacteriaDirection)
        {
            angularVelocity = -maxAngularVelocity;
        }

        moveBacteria(velocity, angularVelocity, 10);
    }





    private void moveBacteria(double velocity, double angularVelocity, double duration) //model
    {
        velocity = applyLimits(velocity, 0, maxVelocity);
        angularVelocity = applyLimits(angularVelocity, -maxAngularVelocity, maxAngularVelocity);
        double newX = bacteriaPositionX + velocity / angularVelocity *
                (Math.sin(bacteriaDirection + angularVelocity * duration) -
                        Math.sin(bacteriaDirection));
        if (!Double.isFinite(newX))
        {
            newX = bacteriaPositionX + velocity * duration * Math.cos(bacteriaDirection);
        }
        double newY = bacteriaPositionY - velocity / angularVelocity *
                (Math.cos(bacteriaDirection + angularVelocity * duration) -
                        Math.cos(bacteriaDirection));
        if (!Double.isFinite(newY))
        {
            newY = bacteriaPositionY + velocity * duration * Math.sin(bacteriaDirection);
        }
        bacteriaPositionX = newX;
        bacteriaPositionY = newY;
        double newDirection = asNormalizedRadians(bacteriaDirection + angularVelocity * duration);
        bacteriaDirection = newDirection;
    }

    public void setTarget(Point target) {
            targetPositionX = target.x;
            targetPositionY = target.y;
    }
}
