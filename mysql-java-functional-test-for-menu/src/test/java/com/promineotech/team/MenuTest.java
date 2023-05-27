/**
 * 
 */
package com.promineotech.team;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Amanda
 *
 */
class MenuTest {
  private Menu menu;

  /**
   * @throws java.lang.Exception
   */
  @BeforeEach
  void setUp() {
    menu = new Menu();
    menu.createTables();
  }

  /**
   * @throws java.lang.Exception
   */
  @AfterEach
  void tearDown() {
    menu.dropTables();
  }

  @Test
  void test() {
    
  } 

} //end of MenuTest CLASS
