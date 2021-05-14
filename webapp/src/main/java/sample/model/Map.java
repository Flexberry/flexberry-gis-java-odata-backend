package sample.model;

import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.Converter;
import sample.utils.UUIDConverter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * Entity implementation class for Entity: Map
 */
@Entity(name = "Map")
@Table(schema = "fgis", name = "map")
public class Map {

    @Id
    @Converter(converterClass = UUIDConverter.class, name = "primarykey")
    @Convert("primarykey")
    @Column(name = "primarykey", length = 16, unique = true, nullable = false)
    private UUID primarykey;

    @Column(name = "name", length = 250)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "\"public\"")
    private Boolean ispublic = true;

    @OneToMany(mappedBy = "map", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<MapLayer> layers;


    public Map() {
        super();
    }

    public void setPrimarykey(UUID primaryKey) {
        this.primarykey = primaryKey;
    }

    public UUID getPrimarykey() {
        return primarykey;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setIspublic(Boolean ispublic) {
        this.ispublic = ispublic;
    }

    public Boolean getIspublic() {
        return ispublic;
    }

    @PrePersist
    public void logNewMapAttempt() {
        System.out.println("Map - PrePersist");
    }

    @PostPersist
    public void logNewMapAdded() {
        System.out.println("Map - PostPersist");
    }

    @PreRemove
    public void logMapRemovalAttempt() {
        System.out.println("Map - PreRemove");
    }

    @PostRemove
    public void logMapRemoval() {
        System.out.println("Map - PostRemove");
    }

    @PreUpdate
    public void logMapUpdateAttempt() {
        System.out.println("Map - PreUpdate");
    }

    @PostUpdate
    public void logMapUpdate() {
        System.out.println("Map - PostUpdate");
    }

    @PostLoad
    public void logMapLoad() {
        System.out.println("Map - PostLoad");
    }
}