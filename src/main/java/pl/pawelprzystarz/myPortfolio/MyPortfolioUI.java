package pl.pawelprzystarz.myPortfolio;

import com.vaadin.annotations.Theme;
import com.vaadin.server.*;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.io.File;

@SpringUI
@Theme("valo")
public class MyPortfolioUI extends UI {

    private VerticalLayout verticalLayout;
    private HorizontalLayout layout;
    private String imagePath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setupLayout();
        addInfo();
        addSection();
        addSkills();
    }

    private void addSection() {
        VerticalLayout section = new VerticalLayout();
        section.setResponsive(true);
        section.setSpacing(true);
        section.setDefaultComponentAlignment(Alignment.TOP_CENTER);
        section.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

        VerticalLayout myCareer = new VerticalLayout();
        myCareer.setSizeFull();
        myCareer.setResponsive(true);
        myCareer.setSpacing(true);

        Label career = new Label("My Career");
        career.addStyleName(ValoTheme.LABEL_SUCCESS);
        myCareer.addComponent(career);

        Label aboutMe = new Label("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?");
        aboutMe.setSizeFull();
        aboutMe.addStyleName(ValoTheme.LABEL_H4);
        myCareer.addComponent(aboutMe);

        VerticalLayout myProjects = new VerticalLayout();
        myProjects.setResponsive(true);
        myProjects.setSpacing(true);
        myProjects.setSizeFull();

        Label project = new Label("My Projects");
        project.addStyleName(ValoTheme.LABEL_SUCCESS);
        myProjects.addComponent(project);

        Label projects = new Label("At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.");
        projects.addStyleName(ValoTheme.LABEL_H4);
        projects.setSizeFull();
        myProjects.addComponent(projects);

        section.addComponents(myCareer, myProjects);

        layout.addComponent(section);
        layout.setComponentAlignment(section, Alignment.TOP_CENTER);
    }

    private void addSkills() {
        VerticalLayout skills = new VerticalLayout();
        skills.setResponsive(true);
        skills.setSpacing(true);
        skills.addStyleName(ValoTheme.LAYOUT_WELL);
        skills.setWidth("40%");
        skills.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);

        Label skill = new Label("My skills: ");
        skill.addStyleName(ValoTheme.LABEL_COLORED);
        skill.setSizeFull();

        Label java = new Label("Java:");
        java.addStyleName(ValoTheme.LABEL_SMALL);
        java.setSizeFull();

        ProgressBar javapb = new ProgressBar();
        javapb.setValue(0.8F);
        javapb.setSizeFull();

        Label spring = new Label("Spring:");
        spring.addStyleName(ValoTheme.LABEL_SMALL);
        spring.setSizeFull();

        ProgressBar springpb = new ProgressBar();
        springpb.setValue(0.6F);
        springpb.setSizeFull();

        Label javafx = new Label("JavaFX:");
        javafx.addStyleName(ValoTheme.LABEL_SMALL);
        javafx.setSizeFull();

        ProgressBar javafxpb = new ProgressBar();
        javafxpb.setValue(0.7F);
        javafxpb.setSizeFull();

        Label sql = new Label("MySQL:");
        sql.addStyleName(ValoTheme.LABEL_SMALL);
        sql.setSizeFull();

        ProgressBar sqlpb = new ProgressBar();
        sqlpb.setValue(0.92F);
        sqlpb.setSizeFull();

        Label vaadin = new Label("Vaadin: ");
        vaadin.addStyleName(ValoTheme.LABEL_SMALL);
        vaadin.setSizeFull();

        ProgressBar vaadinpb = new ProgressBar();
        vaadinpb.setValue(0.6F);
        vaadinpb.setSizeFull();

        skills.addComponents(skill, java, javapb, spring, springpb, javafx, javafxpb, sql, sqlpb, vaadin, vaadinpb);
        skills.setComponentAlignment(skill, Alignment.TOP_CENTER);

        layout.addComponent(skills);
        layout.setComponentAlignment(skills, Alignment.TOP_RIGHT);
        layout.setSizeFull();
        layout.setMargin(true);
    }

    private void addInfo() {
        VerticalLayout info = new VerticalLayout();
        info.setResponsive(true);
        info.setSpacing(true);
        info.addStyleName(ValoTheme.LAYOUT_CARD);
        info.setWidth("45%");

        FileResource resource = new FileResource(new File(imagePath + "/WEB-INF/images/myPhoto.jpg"));
        Image myPhoto = new Image("Paweł Przystarz", resource);
        myPhoto.setSizeFull();
        myPhoto.setResponsive(true);

        info.addComponent(myPhoto);
        info.setComponentAlignment(myPhoto, Alignment.TOP_CENTER);

        Label aboutMe = new Label("Hi, I am trying to start my career as Junior Java Developer. I have just finished" +
                " my training and I am looking for an oportunity to get a nice job.");
        aboutMe.setSizeFull();
        aboutMe.setResponsive(true);

        info.addComponent(aboutMe);
        info.setComponentAlignment(aboutMe, Alignment.TOP_LEFT);

        layout.addComponent(info);
        layout.setComponentAlignment(info, Alignment.TOP_LEFT);
    }

    private void setupLayout() {
        verticalLayout = new VerticalLayout();
        verticalLayout.setResponsive(true);
        verticalLayout.setSpacing(true);
        setContent(verticalLayout);

        layout = new HorizontalLayout();
        layout.setSpacing(true);
        layout.setResponsive(true);
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        verticalLayout.addComponent(layout);
    }
}
