/**
 * 
 */
package com.promineotech.service;

import java.util.NoSuchElementException;
import com.promineotech.dao.TeamDao;
import com.promineotech.model.Team;

/**
 * This class is in the service layer(package) and is responsible for liaising between the controller
 *  (Main.java) and the DAO layer ({@link TeamDao}.java). Business rules are applied here. 
 * @author Amanda
 *
 */
public class TeamService {
  private TeamDao teamDao = new TeamDao();
  
  /**
   * Call TeamDao to create the tables
   */
  public void createTables() {
    teamDao.createTables();
  } 
  
  /**
   * call TeamDao to drop the tables
   */
  public void dropTables() {
    teamDao.dropTables();
  } 
  
  /**
   * Create a team given the team name. 
   * @param teamName
   */
  public void createTeam(String teamName) {
    teamDao.createTeam(teamName);
  } 
  
  /**
   * find the Team record 
   */
  public Team findTeam(String teamName) {
    return teamDao.findTeam(teamName)
        .orElseThrow(() -> new NoSuchElementException("Team " + teamName + " is not found"));
  }
  
  
} //end of TeamService CLASS
