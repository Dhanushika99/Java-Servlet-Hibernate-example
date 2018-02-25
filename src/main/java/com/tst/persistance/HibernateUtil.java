package com.tst.persistance;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;





public class HibernateUtil {/*
	private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new AnnotationConfiguration().configure().buildSessionFactory();

        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
    	// Close caches and connection pools
    	getSessionFactory().close();
    }

*/
	

	private static StandardServiceRegistry registry;
	  private static SessionFactory sessionFactory;

	  public static SessionFactory getSessionFactory() {
	    if (sessionFactory == null) {
	      try {
	        // Create registry
//	        registry = new StandardServiceRegistryBuilder()
//	            .configure().
//	            .build();
//
//	        // Create MetadataSources
//	        MetadataSources sources = new MetadataSources(registry);
//
//	        // Create Metadata
//	        Metadata metadata = sources.getMetadataBuilder().build();
//
//	        // Create SessionFactory
//	        sessionFactory = metadata.getSessionFactoryBuilder().build();
	    	  
	    	  sessionFactory= new Configuration().configure().buildSessionFactory();
	      } catch (Exception e) {
	        e.printStackTrace();
	        if (registry != null) {
	          StandardServiceRegistryBuilder.destroy(registry);
	        }
	      }
	    }
	    return sessionFactory;
	  }

	  public static void shutdown() {
	    if (registry != null) {
	      StandardServiceRegistryBuilder.destroy(registry);
	    }
	  }
}
