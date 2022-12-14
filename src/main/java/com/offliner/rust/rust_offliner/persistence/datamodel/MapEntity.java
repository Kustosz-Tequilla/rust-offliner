package com.offliner.rust.rust_offliner.persistence.datamodel;

import javax.persistence.*;
import java.io.File;
import java.util.List;

@Entity
@Table(name = "maps")
public class MapEntity {

    @Id
    @Column(name = "map_id")
    private long id;

    @Column(name = "map_size")
    private int size;

    @Column(name = "image_path")
    private String imagePath;


    @OneToOne
    @JoinColumn(name = "server_id", referencedColumnName = "server_id")
    private ServerEntity server;

    @OneToMany(mappedBy = "map")
    private List<BaseEntity> baseList;

    public ServerEntity getServer() {
        return server;
    }

    public void setServer(ServerEntity server) {
        this.server = server;
    }

    public MapEntity(long id, int size, String imagePath, List<BaseEntity> baseList) {
        this.id = id;
        this.size = size;
        this.imagePath = imagePath;
        this.baseList = baseList;
    }

    public MapEntity() {

    }

    public int getSize() {
        return size;
    }

    public String getImagePath() {
        return imagePath;
    }

    public File getImage() {
        return new File(this.imagePath);
    }
}
