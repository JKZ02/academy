package com.ctw.workstation;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String hello() {
        return "<br> " +
                "<h1 " +
                "style=\"" +
                "color:red;" +
                "margin:auto;" +
                "width:50%;" +
                "text-align:center;" +
                "\">Hello from Quarkus REST \uD83D\uDC4B" +
                "<br>" +
                "<a href=\"/workstation/goodbye\">Goodbye</a>\n";
    }
}
