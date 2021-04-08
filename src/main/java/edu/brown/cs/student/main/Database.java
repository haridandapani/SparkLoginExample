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
      // String encrypted = Encryption.encrypt(password);
      // prep.setString(2, encrypted);
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

  public boolean usernameTaken(String username) {
    try {
      // SQL search
      PreparedStatement prep = conn.prepareStatement("SELECT * FROM login WHERE username = ?");
      prep.setString(1, username);
      // Gather data
      ResultSet result = prep.executeQuery();
      return result.next();
    } catch (Exception e) {
      e.printStackTrace();
      return true;
    }

  }

  public int addUser(String username, String password) {
    try {
      // SQL search
      PreparedStatement prep = conn
          .prepareStatement("INSERT INTO login(username, password) VALUES (?, ?)");
      prep.setString(1, username);
      prep.setString(2, password);
      // prep.setSTring(2, Encryption.encrypt(password));
      // Gather data
      prep.executeUpdate();
      prep.close();

      PreparedStatement prep2 = conn.prepareStatement("SELECT id FROM login WHERE username = ?");
      prep2.setString(1, username);
      ResultSet result2 = prep2.executeQuery();
      if (result2.next()) {
        return result2.getInt(1);
      }
      return -1;
    } catch (Exception e) {
      e.printStackTrace();
      return -1;
    }

  }

  public void updatePassword(int id, String newpassword) {
    try {
      // SQL search
      PreparedStatement prep = conn.prepareStatement("UPDATE login SET password = ? WHERE id = ?");
      prep.setString(1, newpassword);
      prep.setInt(2, id);

      // prep.setSTring(2, Encryption.encrypt(password));
      // Gather data
      prep.executeUpdate();
      prep.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
