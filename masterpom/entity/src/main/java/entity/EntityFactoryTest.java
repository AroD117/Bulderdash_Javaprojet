package entity;
//salut
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.EntityFactory;

public class EntityFactoryTest {

@BeforeClass

  public static void setUpBeforeClass() throws Exception {

  }



  @AfterClass

  public static void tearDownAfterClass() throws Exception {

  }



  @Before

  public void setUp() throws Exception {

  }



  @After

  public void tearDown() throws Exception {

  }

 

  //This test verify that method testCreateBrokenSurface does not return a null result,
  //and we verify that a piece has been properly initialized and are equals

  @Test

  public void testBrokenSurface() {

    assertNotNull(EntityFactory.createBrokenSurface());

    assertEquals(EntityFactory.createBrokenSurface().getSprite().getConsoleImage(), ' ');

  }

  

  //This test verify that method testCreateBreakableSurface does not return a null result,
  //and verify that a piece has been properly initialized and are equals.


  @Test

  public void testCreateBreakableSurface() {

    assertNotNull(EntityFactory.createBreakableSurface());

    assertEquals(EntityFactory.createBreakableSurface().getSprite().getConsoleImage(), 'b');

  }

  

  //This test verify that method testCreateWall does not return a null result,
  //and verify that a piece has been properly initialized and are equals.


  @Test

  public void testCreateWall() {

    assertNotNull(EntityFactory.createWall());

    assertEquals(EntityFactory.createWall().getSprite().getConsoleImage(), 'a');

  }
}
  
  //This test verify that method testCreateDoor does not return a null result,
  //and verify that a piece has been properly initialized and are equals.

  /*public void testCreateDoor() {
 
  assertNotNull (EntityFactory.createDoor());
  
  assertEquals(EntityFactory.createDoor().getSprite().getConsoleImage(), 'e');
  }

}*/