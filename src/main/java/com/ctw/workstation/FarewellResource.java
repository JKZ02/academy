package com.ctw.workstation;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/goodbye")
public class FarewellResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String goodbye() {
        return "<br> " +
                "<h1 " +
                "style=\"" +
                "color:red;" +
                "margin:auto;" +
                "width:50%;" +
                "text-align:center;" +
                "\">Farewell from Quarkus REST \uD83D\uDE3F" +
                "<br>" +
                "<a href=\"/workstation/hello\">Hello</a>\n";
    }
}
