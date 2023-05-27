/**
 * 
 */
package com.promineotech.model;

/**
 * This is the Team object; has only an ID (primary key value) and a name, no getters. 
 * @author Amanda
 */
public class Team {
  private int teamPK;
  private String teamName;

  /**
   * Constructor that sets all instance variables
   */
  public Team(int teamPK, String teamName) {
    this.teamPK = teamPK;
    this.teamName = teamName;
  }
  
  /**
   * @return the teamPK
   */
  public int getTeamPK() {
    return teamPK;
  }
  
  /**
   * @return the teamName
   */
  public String getTeamName() {
    return teamName;
  }
  
  /**
   * Representation of the team as a String
   */
 @Override
 public String toString() {
   return "Team [teamPK=" + teamPK + ", teamName=" + teamName + "]";
 }

}
