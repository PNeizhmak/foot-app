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
        balancerController.makeTeams(Arrays.asList(1, 32, 14, 15, 20, 23, 33, 9, 38, 16, 18, 37, 34, 35, 36), 3, true, true);
    }
}