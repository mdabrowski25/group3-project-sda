module pl.sdacademy {
    requires javafx.controls;
    requires com.google.gson;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;
    opens pl.sdacademy;
    exports pl.sdacademy.JavaFx;
    exports pl.sdacademy;
    exports pl.sdacademy.entity;
}