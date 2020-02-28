package org.acme;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Emmanuel Bernard emmanuel@hibernate.org
 */
@Entity
public class Foo {
    private Long id;
    private Long version;
    private String name;
    private Set<Bar> bars = new HashSet<>();

    @Id @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<Bar> getBars() {
        return bars;
    }

    public void setBars(Set<Bar> bars) {
        this.bars = bars;
    }

    public void setName(String name) {
        this.name = name;
    }
}
