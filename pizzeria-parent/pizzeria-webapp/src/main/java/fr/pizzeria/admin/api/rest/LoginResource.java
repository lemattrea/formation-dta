package fr.pizzeria.admin.api.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("/login")
public class LoginResource {
	
	private static final String MDP = "admin";
	private static final String ADDRESSE = "admin@admin.fr";
	@Inject private TokenService tokenService;
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response login(@FormParam("email") String email, @FormParam("motDePasse") String mdp) {
		Response resp = null;
		
		if(ADDRESSE.equals(email) && MDP.equals(mdp)) {
			// Cas OK
			
			// Génération de token unique
			String token = tokenService.generateNewToken();
			
			resp = Response.ok(token).build();
			
		}else {
			// KO
			resp = Response.status(Status.FORBIDDEN).build();
		}
		
		return resp;
	}

}
