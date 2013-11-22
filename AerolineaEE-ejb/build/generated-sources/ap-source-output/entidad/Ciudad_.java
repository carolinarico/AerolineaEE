package entidad;

import entidad.Vuelo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-11-22T10:30:34")
@StaticMetamodel(Ciudad.class)
public class Ciudad_ { 

    public static volatile SingularAttribute<Ciudad, String> nombre;
    public static volatile CollectionAttribute<Ciudad, Vuelo> vueloCollection;
    public static volatile CollectionAttribute<Ciudad, Vuelo> vueloCollection1;
    public static volatile SingularAttribute<Ciudad, Short> idciudad;

}