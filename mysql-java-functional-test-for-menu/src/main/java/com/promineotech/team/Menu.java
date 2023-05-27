/**
 * 
 */
package com.promineotech.team;

import com.promineotech.service.TeamService;

/**
 * @author Amanda
 *
 */
public class Menu {
  private TeamService teamService = new TeamService();
  
  public static void main(String[] args) {
    new Menu().run();
  } //end of main METHOD

  /**
   * 
   */      
  private void run() {
    createTables();    
    
    dropTables();
  } //end of run METHOD

  /**
   * 
   */
  public void createTables() {
    teamService.createTables();
  } //end of createTables METHOD

  public void dropTables() {
    teamService.dropTables();
  } //end of dropTables METHOD


} //end of Menu CLASS
