package entidad;

import entidad.Ciudad;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-11-22T10:30:34")
@StaticMetamodel(Vuelo.class)
public class Vuelo_ { 

    public static volatile SingularAttribute<Vuelo, String> codigo;
    public static volatile SingularAttribute<Vuelo, Ciudad> destino;
    public static volatile SingularAttribute<Vuelo, Short> idvuelo;
    public static volatile SingularAttribute<Vuelo, String> fechav;
    public static volatile SingularAttribute<Vuelo, Ciudad> origen;

}