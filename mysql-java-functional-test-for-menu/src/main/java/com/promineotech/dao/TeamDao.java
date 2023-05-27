/**
 * 
 */
package com.promineotech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import com.promineotech.model.Team;

/**
 * This DAO layer read and writes team information to the team table. 
 * Even though a player table is created and dropped, the player table is not used; this class
 *  demonstrates how it could be used. 
 * @author Amanda
 *
 */
public class TeamDao {
  
  private Connection conn;
  
  /**
   * DAO constructor to create connection to H2 in-memory database.
   * @throws MemDbException Thrown if the connection cannot be obtained. 
   */
  public TeamDao() {
    try {
      conn = DriverManager.getConnection("jdbc:h2:mem:test");
    } catch (SQLException e) {
      throw new MemDbException("Error getting connection", e);
    }
  }

  /**
   * Generates the SQL to create the tables 
   * @throws MemDbException thrown if there is an error creating the tables
   */
  public void createTables() {
    // @formatter:off
    String sql = ""
        + "CREATE TABLE team ("
        + " team_pk INT NOT NULL PRIMARY KEY AUTO_INCREMENT,"
        + " team_name VARCHAR(100) NOT NULL,"
        + " UNIQUE KEY (team_name)"
        + ");"
        + " "
        + "CREATE TABLE player ("
        + " player_pk INT NOT NULL PRIMARY KEY AUTO_INCREMENT,"
        + " FOREIGN KEY (team_fk) REFERENCES team (team_pk) ON DELETE CASCADE,"
        + " UNIQUE KEY (player_name)"
        + ");";
    // @formatter:on
    
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.executeUpdate();
      System.out.println("Created team and player tables");
    } catch (SQLException e) {
      throw new MemDbException(e);
    }     
  } //end of createTables METHOD

  /**
   * This generates SQL to drop the tables; Prepared Statement is executed to drop the tables.
   * @throws MemDbException Thrown if tables cannot be dropped
   */
  public void dropTables() {
    // @formatter:off
    String sql = ""
        + "DROP TABLE player;"
        + "DROP TABLE team";
    // @formatter:on
    
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.executeUpdate();
      System.out.println("Dropped team and player tables");
    } catch (SQLException e) {
      throw new MemDbException(e);
    }
  } //end of dropTables METHOD

  /**
   * Add a new team to the team table.
   * 
   * @param teamName The team name
   * @throws MemDbException Thrown if there is an error adding the team.
   */
  public void createTeam(String teamName) {
    String sql = "INSERT INTO team (team_name) VALUES (?)";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, teamName);
      stmt.executeUpdate();
    } catch (SQLException e) {
      throw new MemDbException(e);
    }
  }

  /**
   * Find the team record given the team name.
   * 
   * @param teamName The name of the team to find
   * @return An Optional wrapping the {@link Team} object if found, otherwise an empty Optional
   * @throws MemDbException Throw if an error occurs retrieving the Team record
   */
  public Optional<Team> findTeam(String teamName) {
    String sql = "SELECT * FROM team WHERE team_name = ?";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
      Team team = null;
      stmt.setString(1, teamName);

      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          int pk = rs.getInt("team_pk");
          String name = rs.getString("team_name");
          team = new Team(pk, name);
        }

        return Optional.ofNullable(team);
      }
    } catch (SQLException e) {
      throw new MemDbException(e);
    }
  }
  
  
  
  
  
  
  
  
  
} //end of TeamDao CLASS
