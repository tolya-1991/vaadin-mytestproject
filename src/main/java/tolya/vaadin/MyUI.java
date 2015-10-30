package tolya.vaadin;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

/**
 *
 */
@Theme("mytheme")
@Widgetset("tolya.vaadin.MyAppWidgetset")
public class MyUI extends UI {

    private Button btnLogin = new Button("Login");
    private TextField login = new TextField("Username");
    private PasswordField password = new PasswordField("Password");


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        layout.addComponent(new Label("Please login and password to pass the authentication of the user."));
        layout.addComponent(new Label());
        layout.addComponent(login);
        layout.addComponent(password);
        layout.addComponent(btnLogin);

        btnLogin.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                try {
                    if ("admin".equals(login) && password.equals("admin")) {
                        layout.addComponent(new Label("Congratulations Admin have passed authentication"));
                    } else if ("user".equals(login) && password.equals("user")) {
                        layout.addComponent(new Label("Congratulations User have passed authentication"));
                    } else {
                        layout.addComponent(new Label("Login failed !"));
                                            }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
