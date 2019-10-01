package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.service.PlaytimeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PlaytimeServiceImplTest {

    @Autowired
    @Qualifier("PlaytimeServiceImpl")
    private PlaytimeService playtimeService;
    private Playtime playtime;
    private Set<Playtime> playtimes = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        playtime = PlaytimeFactory.getPlaytime("social");
        playtimes.add(playtime);
    }

    @Test
    public void aCreate() {
        Playtime playService = playtimeService.create(PlaytimeFactory.getPlaytime("distracted"));
        System.out.println("Created playtime: " + playService.getBehaviour());
        Assert.assertNotNull(playService);
        playtimes.add(playService);
    }

    @Test
    public void cUpdate() {
        String newBehaviour = "communicating";
        Playtime updated = playtimeService.update(new Playtime.Builder().copy(playtime).social(newBehaviour).build());
        System.out.println("In update, updated = " + updated);
        playtimes.add(updated);
        Assert.assertEquals(updated.getId(), playtimeService.read(updated.getId()));
    }

    @Test
    public void eDelete() {
        int total = playtimes.size();
        System.out.println("Before deleting object: " + playtime.getId());
        playtimes.remove(playtime.getId());
        System.out.println("After deleting object: " + playtime.getId());
        Assert.assertEquals(total, playtimes.size() - 1);
    }

    @Test
    public void bRead()
    {
        Playtime readPlaytime = playtimeService.read(playtime.getId());
        System.out.println("readPlaytime id: " + readPlaytime.getId());
        System.out.println("playtimeService id: " + playtimeService.read(readPlaytime.getId()));
        Assert.assertEquals(readPlaytime.getId(), playtimeService.read(readPlaytime.getId()));
    }

    @Test
    public void dGetAll()
    {
        List<Playtime> playtimeList = playtimeService.getAll();
        System.out.println("Display all objects: " + playtimeList.toString());
        Assert.assertEquals(playtimeList.size(), playtimeService.getAll().size());
    }

}