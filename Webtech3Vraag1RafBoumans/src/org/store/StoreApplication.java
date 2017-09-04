package org.store;
import org.restlet.*;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.restlet.routing.Router;

public class StoreApplication extends Application {

    @Override
    public synchronized Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a new instance of HelloWorldResource.
        Router router = new Router(getContext());

        // Defines only one route
        router.attach("/products", StoreResource.class);

        return router;
    }


    public static void main(String[] args) throws Exception {

        Component component = new Component();

        // Add a new HTTP server listening on port 8182.
        component.getServers().add(Protocol.HTTP, 8182);

        // Attach the sample application.
        component.getDefaultHost().attach("/store", new StoreApplication());

        // Start the component.
        component.start();
    }


}