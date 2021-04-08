package edu.brown.cs.student.main;

public class Encryption {

  public static String encrypt(String toEncrypt) {
    return "Hari" + toEncrypt;
  }

  public static String decrypt(String toDecrypt) {
    return toDecrypt.replaceFirst("Hari", "");
  }
}
