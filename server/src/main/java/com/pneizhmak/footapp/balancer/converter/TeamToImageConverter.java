package com.pneizhmak.footapp.balancer.converter;

import com.pneizhmak.footapp.db.model.Team;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

/**
 * @author Pavel Neizhmak
 */
public class TeamToImageConverter {

    public static BufferedImage createImage(Collection<Team> result) {

        BufferedImage bufferedImage = new BufferedImage(350, 200, BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();

        for (int index = 0; index < result.size(); index++) {
            Team team = new ArrayList<>(result).get(0);
            if (index == 0) {
                g.drawString("Team", 20, 20);
                g.drawLine(20, 20, 50, 20);
                final int[] nameY = {40};
                team.getPlayers().forEach(playerProfile -> {
                    g.drawString(playerProfile.getPlayer().getName(), 20, nameY[0]);
                    g.drawString(playerProfile.getPosition().getName(), 100, nameY[0]);
                    nameY[0] += 20;
                });
            } else if (index == 1) {
                g.drawString("Team", 170, 20);
                g.drawLine(170, 20, 200, 20);
                final int[] nameY = {40};
                team.getPlayers().forEach(playerProfile -> {
                    g.drawString(playerProfile.getPlayer().getName(), 170, nameY[0]);
                    g.drawString(playerProfile.getPosition().getName(), 250, nameY[0]);
                    nameY[0] += 20;
                });
            }
        }
        return bufferedImage;
    }
}
