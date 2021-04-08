package edu.brown.cs.student.main;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class SignUpGUI implements TemplateViewRoute {

  @Override
  public ModelAndView handle(Request request, Response response) throws Exception {
    // TODO Auto-generated method stub
    Map<String, String> variables = new HashMap<>();
    return new ModelAndView(variables, "signup.ftl");
  }
}
