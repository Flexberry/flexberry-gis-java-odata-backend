package NewPlatform.Flexberry.GIS.model;

import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.Converter;
import NewPlatform.Flexberry.GIS.utils.UUIDConverter;

import javax.persistence.*;
import java.util.UUID;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmIgnore;
import java.util.List;

/**
 * Entity implementation class for Entity: LayerLink
 */
@Entity(name = "NewPlatformNewPlatform.Flexberry.GISLayerLink")
@Table(schema = "public", name = "LayerLink")
public class LayerLink {

    @Id
    @Converter(converterClass = UUIDConverter.class, name = "primarykey")
    @Convert("primarykey")
    @Column(name = "primarykey", length = 16, unique = true, nullable = false)
    private UUID primarykey;

    @Column(name = "AllowShow")
    private Boolean allowshow;

    @EdmIgnore
    @Converter(converterClass = UUIDConverter.class, name = "MapObjectSetting")
    @Convert("MapObjectSetting")
    @Column(name = "MapObjectSetting", length = 16, unique = true, nullable = false)
    private UUID _mapobjectsettingid;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "MapObjectSetting", insertable = false, updatable = false)
    private MapObjectSetting mapobjectsetting;

    @EdmIgnore
    @Converter(converterClass = UUIDConverter.class, name = "Layer")
    @Convert("Layer")
    @Column(name = "Layer", length = 16, unique = true, nullable = false)
    private UUID _layerid;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "Layer", insertable = false, updatable = false)
    private MapLayer layer;

    @OneToMany(mappedBy = "layerlink", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<LinkParameter> parameters;


    public LayerLink() {
        super();
    }

    public void setPrimarykey(UUID primarykey) {
        this.primarykey = primarykey;
    }

    public UUID getPrimarykey() {
        return primarykey;
    }

    public Boolean getAllowShow() {
      return allowshow;
    }

    public void setAllowShow(Boolean allowshow) {
      this.allowshow = allowshow;
    }


}