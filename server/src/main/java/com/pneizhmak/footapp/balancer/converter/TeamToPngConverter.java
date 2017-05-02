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
                g.drawString("Team " + String.valueOf(index + 1), 20, 20);
                g.drawLine(20, 20, 60, 20);
                team.getPlayers().forEach(playerProfile ->
                        drawItems(g, nameY, playerProfile.getPlayer().getName(), 20, nameY[0],
                                playerProfile.getPosition().getName(), 110));
            } else if (index == 1) {
                g.drawString("Team " + String.valueOf(index + 1), 180, 20);
                g.drawLine(180, 20, 220, 20);
                team.getPlayers().forEach(playerProfile ->
                        drawItems(g, nameY, playerProfile.getPlayer().getName(), 180, nameY[0],
                                playerProfile.getPosition().getName(), 270));
            } else if (index == 2) {
                g.drawString("Team " + String.valueOf(index + 1), 340, 20);
                g.drawLine(340, 20, 380, 20);
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
