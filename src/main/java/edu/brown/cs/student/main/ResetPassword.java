package edu.brown.cs.student.main;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.QueryParamsMap;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ResetPassword implements TemplateViewRoute {

  @Override
  public ModelAndView handle(Request request, Response response) throws Exception {
    System.out.println("IN LOGIN!");
    QueryParamsMap form = request.queryMap();

    String username = form.value("username");
    String oldpassword = form.value("oldpassword");
    String newpass = form.value("newpass");
    String newpassverify = form.value("newpassverify");

    int output = Main.login.getUserFromDatabase(username, oldpassword);
    if (output != -1 && newpass.equals(newpassverify)) {
      Main.login.updatePassword(output, newpass);
    }
    System.out.println(output);
    Map<String, String> variables = new HashMap<>();
    return new ModelAndView(variables, "main.ftl");
  }
}
