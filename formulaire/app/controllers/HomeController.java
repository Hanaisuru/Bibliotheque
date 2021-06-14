package controllers;

import models.Person;
import views.html.*;
import play.mvc.*;
import java.util.List ; 
import play.data.* ;
import javax.inject.Inject; 
import play.i18n.MessagesApi;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    @Inject
    FormFactory formFactory; 
    Form <Person > personForm ;
    MessagesApi messagesApi;
    
    @Inject
    public HomeController(FormFactory formFactory, MessagesApi messagesApi) {
     this.personForm = formFactory.form(Person.class);
     this.messagesApi = messagesApi;
    }
    
    /*
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index(String fname) {
        return ok(index.render(fname));
    }
    
     public Result helloworld(String fname) {
        return ok(helloworld.render(fname));
    }
    
    public Result sayhelloform (Http.Request request) {
        personForm = formFactory.form(Person.class) ;
        return ok(sayhelloform.render(personForm, request, messagesApi.preferred(request))) ; 
    }
    
    public Result helloworldform(Http.Request request) {
       final Form<Person> pForm = personForm.bindFromRequest(request) ; 
    //    if (pForm.hasErrors()){
      //      return badRequest(sayhelloform.render(pForm,request, messagesApi.preferred(request)));
    //    }
    //    else{
            Person a = pForm.get();
            a.save();
        return ok(helloworldform.render(a)) ;
    //    }
    }
    
     public Result sayhello() {
        return ok(views.html.sayhello.render());
    }
    
    public Result all(){
        List<Person> liste = Person.find.all();
        return ok(all.render(liste));
    }
    
    public Result show (Long id) {
        Person p = Person.find.byId(id) ;
        return ok(show.render(p)) ;
    }
    
    public Result update(Long id, Http.Request request){
        personForm = formFactory.form(Person.class) ;
        Person p = Person.find.byId(id);
        return ok(update.render(personForm, id, request, messagesApi.preferred(request)));
    }

    public Result updateOk(Long id, Http.Request request){
        personForm = formFactory.form(Person.class) ;
        personForm = personForm.bindFromRequest(request) ;
        if (personForm.hasErrors()){
            return badRequest(update.render(personForm,id,request, messagesApi.preferred(request)));
        }
        else{
            Person p = personForm.get();
            p.id=id;
            p.update();
            return redirect(routes.HomeController.all());
        }
    }
}
