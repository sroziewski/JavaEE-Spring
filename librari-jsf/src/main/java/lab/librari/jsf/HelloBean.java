package lab.librari.jsf;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.FacesComponent;

@ManagedBean(name = "helloBean")
@ApplicationScoped
//@SessionScoped
public class HelloBean {
    private int count;

    public String getHelloMessage(){
        return "Jey jey jey!";
    }

    public int getCount(){
        return ++count;
    }
}
