module pl.sdacademy {
    requires javafx.controls;
    requires javafx.graphics;
    requires com.google.gson;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;
    requires net.bytebuddy;
    requires com.fasterxml.classmate;
    requires java.xml.bind;
    requires com.sun.xml.bind;
    requires mysql.connector.java;
    opens pl.sdacademy.entity;
    opens pl.sdacademy.credentials;
    opens pl.sdacademy.apiCore;
    exports pl.sdacademy.JavaFx;
    exports pl.sdacademy.JavaFx.ChartExample;
    exports pl.sdacademy.entity;
    exports pl.sdacademy.apiCore;
}