package edu.brown.cs.student.main;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class LogoutGUI implements TemplateViewRoute {

  @Override
  public ModelAndView handle(Request request, Response response) throws Exception {
    // TODO Auto-generated method stub
    request.session().removeAttribute(Main.USERID);
    Map<String, String> variables = new HashMap<>();
    response.redirect("/");
    return null;
  }
}
