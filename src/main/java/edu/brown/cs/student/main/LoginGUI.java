package edu.brown.cs.student.main;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.QueryParamsMap;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class LoginGUI implements TemplateViewRoute {

  @Override
  public ModelAndView handle(Request request, Response response) throws Exception {
    System.out.println("IN LOGIN!");
    QueryParamsMap form = request.queryMap();

    String username = form.value("username");
    String password = form.value("password");
    int output = Main.login.getUserFromDatabase(username, password);
    if (output != -1) {
      request.session().attribute(Main.USERID, output);
      response.redirect("/loggedin");
      return null;
    }
    System.out.println(output);
    Map<String, String> variables = new HashMap<>();
    return new ModelAndView(variables, "main.ftl");
  }
}
