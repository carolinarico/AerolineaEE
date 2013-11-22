package entidad;

import entidad.Reserva;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-11-22T10:30:34")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Short> idcliente;
    public static volatile SingularAttribute<Cliente, String> numident;
    public static volatile SingularAttribute<Cliente, String> nombres;
    public static volatile SingularAttribute<Cliente, String> apellidos;
    public static volatile SingularAttribute<Cliente, String> tipoident;
    public static volatile SingularAttribute<Cliente, String> login;
    public static volatile CollectionAttribute<Cliente, Reserva> reservaCollection;
    public static volatile SingularAttribute<Cliente, String> password;

}