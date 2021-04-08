package edu.brown.cs.student.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class UserPage implements TemplateViewRoute {

  @Override
  public ModelAndView handle(Request request, Response response) throws Exception {
    // TODO Auto-generated method stub
    Map<String, String> variables = new HashMap<>();
    // System.out.println((String) request.session().attribute(Main.USERID));
    if (request.session().attribute(Main.USERID) != null) {
      int id = request.session().attribute(Main.USERID);
      List<String> interests = Main.login.getInterests(id);

      variables.put("content", "Hello, person with id = " + String.valueOf(id));
      variables.put("interests", outputToHTML(interests));
      return new ModelAndView(variables, "loggedin.ftl");
    }
    response.redirect("/");
    return null;
  }

  public String outputToHTML(List<String> output) {
    StringBuilder builder = new StringBuilder();
    for (String element : output) {
      builder.append(element);
      builder.append("<br>");
    }
    return builder.toString();
  }
}
