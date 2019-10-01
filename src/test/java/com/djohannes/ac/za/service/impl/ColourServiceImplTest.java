package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.service.ColourService;
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
public class ColourServiceImplTest {

        @Autowired
        @Qualifier("ColourServiceImpl")
        private ColourService colourService;
        private Colour colour;
        private Set<Colour> colours = new HashSet<>();

        @Before
        public void setUp() throws Exception {
            colour = ColourFactory.getColour("Green");
            colours.add(colour);
        }

        @Test
        public void aCreate() {
            Colour colService = colourService.create(ColourFactory.getColour("Brown"));
            System.out.println("Created colour: " + colService.getColour());
            Assert.assertNotNull(colService);
            colours.add(colService);
        }

        @Test
        public void cUpdate() {
            String newColour = "Blue";
            Colour updated = colourService.update(new Colour.Builder().copy(colour).colour(newColour).build());
            System.out.println("In update, updated = " + updated);
            colours.add(updated);
            Assert.assertEquals(updated.getId(), colourService.read(updated.getId()));
        }

        @Test
        public void eDelete() {
            int total = colours.size();
            System.out.println("Before deleting object: " + colour.getId());
            colours.remove(colour.getId());
            System.out.println("After deleting object: " + colour.getId());
            Assert.assertEquals(total, colours.size() - 1);
        }

        @Test
        public void bRead()
        {
            Colour readColour = colourService.read(colour.getId());
            System.out.println("readColour id: " + readColour.getId());
            System.out.println("colourService id: " + colourService.read(readColour.getId()));
            Assert.assertEquals(readColour.getId(), colourService.read(readColour.getId()));
        }

        @Test
        public void dGetAll()
        {
            List<Colour> colourList = colourService.getAll();
            System.out.println("Display all objects: " + colourList.toString());
            Assert.assertEquals(colourList.size(), colourService.getAll().size());
        }

}