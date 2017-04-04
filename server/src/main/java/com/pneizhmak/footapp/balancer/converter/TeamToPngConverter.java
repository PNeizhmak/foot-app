package com.pneizhmak.footapp.balancer.converter;

import com.pneizhmak.footapp.db.model.Team;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

/**
 * @author Pavel Neizhmak
 */
public class TeamToPngConverter {

    public static BufferedImage createImage(Collection<Team> result) {

        BufferedImage bufferedImage = new BufferedImage(350, 200, BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();

        for (int index = 0; index < result.size(); index++) {
            Team team = new ArrayList<>(result).get(index);
            if (index == 0) {
                g.drawString("Team " + String.valueOf(index + 1), 20, 20);
                g.drawLine(20, 20, 60, 20);
                final int[] nameY = {40};
                team.getPlayers().forEach(playerProfile -> {
                    g.drawString(playerProfile.getPlayer().getName(), 20, nameY[0]);
                    g.drawString(playerProfile.getPosition().getName(), 100, nameY[0]);
                    nameY[0] += 20;
                });
            } else if (index == 1) {
                g.drawString("Team " + String.valueOf(index + 1), 180, 20);
                g.drawLine(180, 20, 220, 20);
                final int[] nameY = {40};
                team.getPlayers().forEach(playerProfile -> {
                    g.drawString(playerProfile.getPlayer().getName(), 180, nameY[0]);
                    g.drawString(playerProfile.getPosition().getName(), 260, nameY[0]);
                    nameY[0] += 20;
                });
            }
        }
        return bufferedImage;
    }
}
