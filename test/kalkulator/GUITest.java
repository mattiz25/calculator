/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class GUITest {

    public GUITest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of suma method, of class GUI.
     */
    @Test
    public void testSuma() {
        System.out.println("suma");
        System.out.println("");

        GUI instance = new GUI();
        float x = 5;
        float y = 10;
        float expResult = 15.0f;
        float result = instance.suma(x, y);
        System.out.println("result = " + result);
        System.out.println("expResult = " + expResult);
        System.out.println("");
        System.out.println("-------------------------------------------------------------");

        Assert.assertEquals(expResult, result, 0.0000002f);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of różnica method, of class GUI.
     */
    @Test
    public void testRóżnica() {
        System.out.println("różnica");
        System.out.println("");

        GUI instance = new GUI();
        float x = 5;
        float y = 10;
        float expResult = -5;
        float result = instance.różnica(x, y);
        System.out.println("result = " + result);
        System.out.println("expResult = " + expResult);
        System.out.println("-------------------------------------------------------------");

        Assert.assertEquals(expResult, result, 5);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iloczyn method, of class GUI.
     */
    @Test
    public void testIloczyn() {
        System.out.println("iloczyn");
        System.out.println("");

        GUI instance = new GUI();
        float x = 5;
        float y = 10;
        float expResult = 50;
        float result = instance.iloczyn(x, y);
        System.out.println("result = " + result);
        System.out.println("expResult = " + expResult);
        System.out.println("-------------------------------------------------------------");

        Assert.assertEquals(expResult, result, 5);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iloraz method, of class GUI.
     */
    @Test
    public void testIloraz() {
        System.out.println("iloraz");
        System.out.println("");

        GUI instance = new GUI();
        float x = 5;
        float y = 10;
        float expResult = 0.5f;
        float result = instance.iloraz(x, y);
        System.out.println("result = " + result);
        System.out.println("expResult = " + expResult);
        System.out.println("-------------------------------------------------------------");

        Assert.assertEquals(expResult, result, 5);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of zesp_suma method, of class GUI.
     */
    @Test
    public void testZesp_suma() {

        System.out.println("zesp_suma");
        System.out.println("");

        GUI instance = new GUI();
        int re1 = 2;
        int im1 = 2;
        int re2 = 2;
        int im2 = 2;

        instance.re1 = re1;
        instance.im1 = im1;
        instance.re2 = re2;
        instance.im2 = im2;
        instance.zesp_suma(re1, re2, im1, im2);
        int expectedREW = 4;
        int expectedIMW = 4;
        int ResultREW = instance.reW;
        int ResultIMW = instance.imW;

        System.out.println("Result: " + ResultREW + " + " + ResultIMW + "i");
        System.out.println("Exprected: " + expectedREW + " + " + expectedIMW + "i");
        System.out.println("-------------------------------------------------------------");

        Assert.assertEquals(ResultREW, expectedREW, 0.02f);
        Assert.assertEquals(ResultIMW, expectedIMW, 0.02f);

        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of zesp_różnica method, of class GUI.
     */
    @Test
    public void testZesp_różnica() {
        System.out.println("zesp_różnica");
        System.out.println("");

        GUI instance = new GUI();
        int re1 = 2;
        int im1 = 2;
        int re2 = 3;
        int im2 = 3;

        instance.re1 = re1;
        instance.im1 = im1;
        instance.re2 = re2;
        instance.im2 = im2;
        instance.zesp_różnica(re1, re2, im1, im2);
        int expectedREW = -1;
        int expectedIMW = -1;
        int ResultREW = instance.reW;
        int ResultIMW = instance.imW;

        System.out.println("Result: " + ResultREW + " + " + ResultIMW + "i");
        System.out.println("Exprected: " + expectedREW + " + " + expectedIMW + "i");
        System.out.println("-------------------------------------------------------------");

        Assert.assertEquals(ResultREW, expectedREW, 0.02f);
        Assert.assertEquals(ResultIMW, expectedIMW, 0.02f);

        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of zesp_iloczyn method, of class GUI.
     */
    @Test
    public void testZesp_iloczyn() {
        System.out.println("zesp_iloczyn");
        System.out.println("");

        GUI instance = new GUI();
        int re1 = 2;
        int im1 = 2;
        int re2 = 3;
        int im2 = 3;

        instance.re1 = re1;
        instance.im1 = im1;
        instance.re2 = re2;
        instance.im2 = im2;
        instance.zesp_iloczyn(re1, re2, im1, im2);
        int expectedREW = 0;
        int expectedIMW = 12;
        int ResultREW = instance.reW;
        int ResultIMW = instance.imW;

        System.out.println("Result: " + ResultREW + " + " + ResultIMW + "i");
        System.out.println("Exprected: " + expectedREW + " + " + expectedIMW + "i");
        System.out.println("-------------------------------------------------------------");

        Assert.assertEquals(ResultREW, expectedREW, 0.02f);
        Assert.assertEquals(ResultIMW, expectedIMW, 0.02f);

        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of zesp_iloraz method, of class GUI.
     */
    @Test
    public void testZesp_iloraz() {
        GUI instance = new GUI();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
