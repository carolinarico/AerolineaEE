package entidad;

import entidad.Cliente;
import entidad.Vuelo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-11-21T10:45:22")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static volatile SingularAttribute<Reserva, Cliente> idcliente;
    public static volatile SingularAttribute<Reserva, Date> fechar;
    public static volatile SingularAttribute<Reserva, Short> idreserva;
    public static volatile SingularAttribute<Reserva, Vuelo> idvuelo;

}