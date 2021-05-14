package sample.model;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmIgnore;
import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.Converter;
import sample.utils.UUIDConverter;

import javax.persistence.*;
import java.util.UUID;


/**
 * Entity implementation class for Entity: MapLayer
 */
@Entity(name = "MapLayer")
@Table(schema = "fgis", name = "maplayer")
public class MapLayer {

    @Id
    @Converter(converterClass = UUIDConverter.class, name = "primarykey")
    @Convert("primarykey")
    @Column(name = "primarykey", length = 16, unique = true, nullable = false)
    private UUID primarykey;

    @Column(name = "name", length = 250)
    private String name;

    @Column(name = "description")
    private String description;

    @EdmIgnore
    @Converter(converterClass = UUIDConverter.class, name = "map")
    @Convert("map")
    @Column(name = "map", length = 16, unique = true, nullable = false)
    private UUID _mapid;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "map", insertable = false, updatable = false)
    private Map map;


    public MapLayer() {
        super();
    }

    public UUID getPrimarykey() {
        return primarykey;
    }

    public void setPrimarykey(UUID primarykey) {
        this.primarykey = primarykey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}