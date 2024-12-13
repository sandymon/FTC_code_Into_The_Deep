package com.example.meepmeep;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;
public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(12, -60, Math.toRadians(90)))
                        .splineToConstantHeading(new Vector2d(0.1,-32), Math.toRadians(90))
                        .splineToConstantHeading(new Vector2d(0.1, -50),Math.toRadians(270))
                        .splineToConstantHeading(new Vector2d(35.9, -48.07), Math.toRadians(90))
                        .splineToConstantHeading(new Vector2d(35.9, -5.3), Math.toRadians(90))
                        .splineToConstantHeading(new Vector2d(47, -5.3), Math.toRadians(270))
                        .splineToConstantHeading(new Vector2d(47, -54.93), Math.toRadians(270))

                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
