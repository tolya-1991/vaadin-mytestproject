package tolya.vaadin;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 */
@Theme("mytheme")
@Widgetset("tolya.vaadin.MyAppWidgetset")

public class MyUI extends UI {

    private ArrayList<People> reeaDatabase() {

        ArrayList<People> peoples = new ArrayList<People>();

        try {

            Class.forName("org.postgresql.Driver");

            Connection connection = null;

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/university", "postgres", "Casper_2501");

            String selectTableSQL = "SELECT id, name, surname, town, adress, age from my_group";

            Statement statement = null;

            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(selectTableSQL);

            while (result.next()) {
                Integer id = Integer.parseInt(result.getString("id"));
                String name = result.getString("name");
                String surname = result.getString("surname");
                String town = result.getString("town");
                String adress = result.getString("adress");
                Integer age = Integer.parseInt(result.getString("age"));
                People people = new People(id, name, surname, town, adress, age);
                peoples.add(people);

            }

        } catch (ClassNotFoundException e) {

            e.printStackTrace();


        } catch (SQLException e) {

            e.printStackTrace();

        }
        return peoples;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        layout.addComponent(new Label("List of people from the database"));
        for (People people : reeaDatabase()) {
            TextField date = new TextField();
            date.setColumns(50);
            date.setValue(people.getId() + ". " + people.getName() + "  " + people.getSurname() + ", город - " + people.getTown() + ", улица -  " + people.getAdress() + ", возраст  " + people.getAge());
            layout.addComponent(date);
        }
        ;
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
