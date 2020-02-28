package org.acme;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/greeting")
public class GreetingResource {

    @Inject
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("/third")
    public Foo edit() {
        Foo foo = em.find(Foo.class, 1L);
        foo.setName( foo.getName() + foo.getVersion() );
        System.out.println(foo.getName() + foo.getVersion() + foo.getBars().size());
        em.flush();
        return foo;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("/second")
    public Foo hello() {
        Foo foo = em.find(Foo.class, 1L);
        System.out.println(foo.getName() + foo.getVersion() + foo.getBars().size());
        em.flush();
        return foo;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/init")
    @Transactional
    public Foo init() {
        Foo foo = new Foo();
        foo.setName("Foo");
        Bar bar  = new Bar();
        bar.setName("bar");
        foo.getBars().add(bar);
        em.persist(foo);
        em.flush();
        return foo;
    }
}