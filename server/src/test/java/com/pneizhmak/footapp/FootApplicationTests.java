package com.pneizhmak.footapp;

import com.pneizhmak.footapp.controller.TeamBalancerController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * @author Pavel Neizhmak
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FootApplicationTests {

    @Autowired
    private TeamBalancerController balancerController;

    @Test
    public void contextLoads() {
    }

    @Test
    public void makeTeams() {
        balancerController.makeTeams(Arrays.asList(1, 14, 15, 20, 23, 33, 5, 6, 16, 18, 24, 26, 28, 30), 2);
    }
}