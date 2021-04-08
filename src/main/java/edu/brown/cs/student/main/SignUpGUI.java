package edu.brown.cs.student.main;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.QueryParamsMap;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class SignUpGUI implements TemplateViewRoute {

  @Override
  public ModelAndView handle(Request request, Response response) throws Exception {
    // TODO Auto-generated method stub
    QueryParamsMap form = request.queryMap();
    String message = "";
    String username = form.value("username");
    String password = form.value("password");
    String verify = form.value("password2");
    if (!password.equals(verify)) {
      message = "Passwords do not match";
    } else if (Main.login.usernameTaken(username)) {
      message = "Username is already taken :0(";
    } else {
      int id = Main.login.addUser(username, password);
      request.session().attribute(Main.USERID, id);
      response.redirect("/loggedin");
      return null;
    }
    Map<String, String> variables = new HashMap<>();
    variables.put("message", message);
    return new ModelAndView(variables, "signup.ftl");
  }
}
