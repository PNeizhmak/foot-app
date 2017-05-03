package com.pneizhmak.footapp.balancer.converter;

import com.pneizhmak.footapp.db.model.Team;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author Pavel Neizhmak
 */
public class TeamToPngConverter {

    private static int pngWidth = 350;

    public static void createImage(Collection<Team> result) {

        if (result.size() == 3) {
            pngWidth = 530;
        }

        BufferedImage bufferedImage = new BufferedImage(pngWidth, 200, BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();

        for (int index = 0; index < result.size(); index++) {
            Team team = new ArrayList<>(result).get(index);
            final int[] nameY = {40};
            if (index == 0) {
                g.drawString("Team " + String.valueOf(index + 1) + " skill: " + team.getTeamWeight().toString(), 20, 20);
                g.drawLine(20, 21, 110, 21);
                team.getPlayers().forEach(playerProfile ->
                        drawItems(g, nameY, playerProfile.getPlayer().getName(), 20, nameY[0],
                                playerProfile.getPosition().getName(), 110));
            } else if (index == 1) {
                g.drawString("Team " + String.valueOf(index + 1) + " skill: " + team.getTeamWeight().toString(), 180, 20);
                g.drawLine(180, 21, 270, 21);
                team.getPlayers().forEach(playerProfile ->
                        drawItems(g, nameY, playerProfile.getPlayer().getName(), 180, nameY[0],
                                playerProfile.getPosition().getName(), 270));
            } else if (index == 2) {
                g.drawString("Team " + String.valueOf(index + 1) + " skill: " + team.getTeamWeight().toString(), 340, 20);
                g.drawLine(340, 21, 430, 21);
                team.getPlayers().forEach(playerProfile ->
                        drawItems(g, nameY, playerProfile.getPlayer().getName(), 340, nameY[0],
                                playerProfile.getPosition().getName(), 430));
            }
        }
        writeImage(bufferedImage);
    }

    private static void drawItems(Graphics g, int[] nameY, String player, int x, int y, String position, int x2) {
        g.drawString(player, x, y);
        g.drawString(position, x2, y);
        nameY[0] += 20;
    }

    private static void writeImage(BufferedImage bufferedImage) {
        try {
            ImageIO.write(bufferedImage, "png", new File("teams.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
