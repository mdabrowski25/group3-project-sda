module pl.sdacademy {
    requires javafx.controls;
    requires com.google.gson;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;
    requires net.bytebuddy;
    requires com.fasterxml.classmate;
    requires java.xml.bind;
    requires com.sun.xml.bind;
    opens pl.sdacademy.entity;
    opens pl.sdacademy.credentials;
    opens pl.sdacademy;
    exports pl.sdacademy.JavaFx;
    exports pl.sdacademy;
    exports pl.sdacademy.entity;
}