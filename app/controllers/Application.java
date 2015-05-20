package controllers;

import Models.MathCal;
import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	public static Result result() {
		DynamicForm form = Form.form().bindFromRequest();
		String expression = form.get("expression");
		return ok(result.render(MathCal.GetIntResult(expression)));

	}

	public static Result stringNum(){
    	DynamicForm form= Form.form().bindFromRequest();
    	int number = Integer.parseInt(form.get("engnum"));
    	return ok(engnumber.render(MathCal.GetStringResult(number)));
    }
}
