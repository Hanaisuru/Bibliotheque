package controllers;

import models.Livre;
import models.Adherent;
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
    Form <Livre> livreForm ;
    Form <Adherent> adherentForm;
    MessagesApi messagesApi;
    
    @Inject
    public HomeController(FormFactory formFactory, MessagesApi messagesApi) {
     this.livreForm = formFactory.form(Livre.class);
     this.adherentForm=formFactory.form(Adherent.class);
     this.messagesApi = messagesApi;
    }
    
    /*
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render());
    }
    
     public Result helloworld(String fname) {
        return ok(helloworld.render(fname));
    }
    
    public Result sayhelloform (Http.Request request) {
        livreForm = formFactory.form(Livre.class) ;
        return ok(sayhelloform.render(livreForm, request, messagesApi.preferred(request))) ; 
    }
    
    public Result helloworldform(Http.Request request) {
       final Form<Livre> lForm = livreForm.bindFromRequest(request) ; 
    //    if (pForm.hasErrors()){
      //      return badRequest(sayhelloform.render(pForm,request, messagesApi.preferred(request)));
    //    }
    //    else{
            Livre a = lForm.get();
            a.save();
        return ok(helloworldform.render(a)) ;
    //    }
    }
    
     public Result sayhello() {
        return ok(views.html.sayhello.render());
    }
    
    public Result sayhelloformadh (Http.Request request) {
        adherentForm = formFactory.form(Adherent.class) ;
        return ok(sayhelloformadh.render(adherentForm, request, messagesApi.preferred(request))) ; 
    }
    
    public Result helloworldformadh(Http.Request request) {
       final Form<Adherent> aForm = adherentForm.bindFromRequest(request) ; 
    //    if (pForm.hasErrors()){
      //      return badRequest(sayhelloform.render(pForm,request, messagesApi.preferred(request)));
    //    }
    //    else{
            Adherent b = aForm.get();
            b.save();
        return ok(helloworldformadh.render(b)) ;
    //    }
    }
    
    
    
    public Result all(){
        List<Livre> liste = Livre.find.all();
        return ok(all.render(liste));
    }
    
    public Result alladh(){
        List<Adherent> listeadh = Adherent.find.all();
        return ok(alladh.render(listeadh));
    }
    
    public Result show (Long id) {
        Livre l = Livre.find.byId(id) ;
        return ok(show.render(l)) ;
    }
    
    public Result showadh (Long id) {
        Adherent a = Adherent.find.byId(id) ;
        return ok(showadh.render(a)) ;
    }
    
    public Result update(Long id, Http.Request request){
        livreForm = formFactory.form(Livre.class) ;
        Livre l = Livre.find.byId(id);
        return ok(update.render(livreForm, id, request, messagesApi.preferred(request)));
    }

    public Result updateadh(Long id, Http.Request request){
        adherentForm = formFactory.form(Adherent.class) ;
        Adherent a = Adherent.find.byId(id);
        return ok(updateadh.render(adherentForm, id, request, messagesApi.preferred(request)));
    }

    public Result updateOk(Long id, Http.Request request){
        livreForm = formFactory.form(Livre.class) ;
        livreForm = livreForm.bindFromRequest(request) ;
        if (livreForm.hasErrors()){
            return badRequest(update.render(livreForm,id,request, messagesApi.preferred(request)));
        }
        else{
            Livre l = livreForm.get();
            l.setId(id);
            l.update();
            return redirect(routes.HomeController.all());
        }
    }
    
    public Result updateOkadh(Long id, Http.Request request){
        adherentForm = formFactory.form(Adherent.class) ;
        adherentForm = adherentForm.bindFromRequest(request) ;
        if (adherentForm.hasErrors()){
            return badRequest(updateadh.render(adherentForm,id,request, messagesApi.preferred(request)));
        }
        else{
            Adherent a = adherentForm.get();
            a.setIdAdh(id);
            a.update();
            return redirect(routes.HomeController.alladh());
        }
    }
    
    public Result delete(Long id){
        Livre livre=Livre.find.byId(id);
        livre.delete();
        return redirect(routes.HomeController.all());
    }
    public Result deleteadh(Long id){
        Adherent adherent=Adherent.find.byId(id);
        adherent.delete();
        return redirect(routes.HomeController.alladh());
    }
    
    
}
