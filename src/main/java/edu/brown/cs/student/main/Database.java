package edu.brown.cs.student.main;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Database {
  private static Connection conn = null;

  public Database(String filename) {
    try {
      Class.forName("org.sqlite.JDBC");
      String urlToDB = "jdbc:sqlite:" + filename;

      // This is a check so we don't create files that don't exist
      if (new File(filename).exists()) {
        conn = DriverManager.getConnection(urlToDB);
      } else {
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public int getUserFromDatabase(String username, String password) {
    int output = -1;
    try {
      // SQL search
      PreparedStatement prep = conn
          .prepareStatement("SELECT id from login WHERE username = ? AND password = ?");
      prep.setString(1, username);
      prep.setString(2, password);
      // Gather data
      ResultSet result = prep.executeQuery();

      if (result.next()) {
        output = result.getInt(1);
      } else {
      }
      result.close();
      prep.close();
      return output;
    } catch (Exception e) {
      e.printStackTrace();
      return output;
    }

  }

  public List<String> getInterests(int id) {
    int output = -1;
    try {
      // SQL search
      PreparedStatement prep = conn
          .prepareStatement("SELECT interest FROM interests WHERE user = ?");
      prep.setInt(1, id);
      // Gather data
      ResultSet result = prep.executeQuery();
      List<String> interests = new ArrayList<>();
      while (result.next()) {
        System.out.println(result.getString(1));
        interests.add(result.getString(1));
      }
      result.close();
      prep.close();
      return interests;
    } catch (Exception e) {
      e.printStackTrace();
      return new ArrayList<>();
    }

  }

}
