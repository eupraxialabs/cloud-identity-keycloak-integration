package com.ibm.security.access.authenticator;

import java.util.ArrayList;
import java.util.List;

import org.keycloak.Config.Scope;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.AuthenticatorFactory;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.AuthenticationExecutionModel.Requirement;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;

import com.ibm.security.access.util.CloudIdentityUtilities;

public class CloudIdentityQrLoginAuthenticatorFactory implements AuthenticatorFactory {
	
	public static final String ID = "ci-qr-login-authenticator";
	
	private static final List<ProviderConfigProperty> CONFIG_PROPERTIES = new ArrayList<ProviderConfigProperty>();
	
	private static final AuthenticationExecutionModel.Requirement[] REQUIREMENT_CHOICES = {
			AuthenticationExecutionModel.Requirement.REQUIRED,
			AuthenticationExecutionModel.Requirement.ALTERNATIVE
	};
	
	static {
		ProviderConfigProperty property;
		
		property = new ProviderConfigProperty();
		property.setName(CloudIdentityUtilities.CONFIG_TENANT_FQDN);
		property.setLabel("Tenant Fully Qualified Domain Name");
		property.setType(ProviderConfigProperty.STRING_TYPE);
		property.setHelpText("The FQDN of your Cloud Identity tenant");
		CONFIG_PROPERTIES.add(property);
		
		property = new ProviderConfigProperty();
		property.setName(CloudIdentityUtilities.CONFIG_CLIENT_ID);
		property.setLabel("API Client ID");
		property.setType(ProviderConfigProperty.STRING_TYPE);
		property.setHelpText("Client ID from your Cloud Identity API Client");
		CONFIG_PROPERTIES.add(property);
		
		property = new ProviderConfigProperty();
		property.setName(CloudIdentityUtilities.CONFIG_CLIENT_SECRET);
		property.setLabel("API Client Secret");
		property.setType(ProviderConfigProperty.STRING_TYPE);
		property.setHelpText("Client Secret from your Cloud Identity API Client");
		property.setSecret(true);
		CONFIG_PROPERTIES.add(property);
	}

	public void close() {
		// no-op
	}

	public Authenticator create(KeycloakSession session) {
		return new CloudIdentityQrLoginAuthenticator();
	}

	public List<ProviderConfigProperty> getConfigProperties() {
		// TODO Auto-generated method stub
		return CONFIG_PROPERTIES;
	}

	public String getDisplayType() {
		return "Cloud Identity QR Login Authenticator";
	}

	public String getHelpText() {
		return "Cloud Identity QR Login Authenticator help text";
	}

	public String getId() {
		return ID;
	}

	public String getReferenceCategory() {
		return null;
	}

	public Requirement[] getRequirementChoices() {
		return REQUIREMENT_CHOICES;
	}

	public void init(Scope config) {
		// no-op
	}

	public boolean isConfigurable() {
		return true;
	}

	public boolean isUserSetupAllowed() {
		return false;
	}

	public void postInit(KeycloakSessionFactory factory) {
		// no-op
	}

}
