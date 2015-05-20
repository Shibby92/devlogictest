package controllers;

import models.MathCal;
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
		if(expression.equals("")){
			flash("error", "Your field is empty!");
			return redirect("/");
		}
		return ok(result.render(MathCal.GetIntResult(expression)));

	}

	public static Result stringNum(){
    	DynamicForm form= Form.form().bindFromRequest();
    	if(form.get("engnum").equals("")){
			flash("error", "Your field is empty!");
			return redirect("/");
		}
    	int number = Integer.parseInt(form.get("engnum"));
    	
    	return ok(engnumber.render(MathCal.GetStringResult(number)));
    }
	
	public static Result wordExpression(){
		DynamicForm form= Form.form().bindFromRequest();
		String expression= form.get("engexpression");
		if(expression.equals("")){
			flash("error", "Your field is empty!");
			return redirect("/");
		}
		String numberInWords=MathCal.GetStringResult(MathCal.GetIntResult(expression));
		int number = MathCal.GetIntResult(expression);
		return ok(wordexpression.render(numberInWords,number));
	}
	
	public static Result calculator(){
		return ok(calculator.render());
	}
}
