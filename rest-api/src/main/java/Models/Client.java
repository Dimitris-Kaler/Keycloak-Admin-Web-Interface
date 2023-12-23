package Models;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;

public class Client {
String id;
String clientId;
String name;
String rootUrl;
String baseUrl;
boolean surrogateAuthRequired;
boolean enabled;
boolean alwaysDisplayInConsole;
String clientAuthenticatorType;
 List<String> redirectUris;
 List<String> webOrigins;
 int notBefore;
 boolean bearerOnly;
 boolean consentRequired;

boolean standardFlowEnabled;
boolean implicitFlowEnabled;
boolean directAccessGrantsEnabled;
boolean serviceAccountsEnabled;
boolean publicClient;
boolean frontchannelLogout;
String protocol;
Map<String,String>attributes;
Map<String, String> authenticationFlowBindingOverrides;
boolean fullScopeAllowed;
int nodeReRegistrationTimeout;
List<String> defaultClientScopes;
List<String> optionalClientScopes;
Map<String, Boolean> access;

public Client() {
	
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getClientId() {
	return clientId;
}

public void setClientId(String clientId) {
	this.clientId = clientId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getRootUrl() {
	return rootUrl;
}

public void setRootUrl(String rootUrl) {
	this.rootUrl = rootUrl;
}

public String getBaseUrl() {
	return baseUrl;
}

public void setBaseUrl(String baseUrl) {
	this.baseUrl = baseUrl;
}

public boolean isSurrogateAuthRequired() {
	return surrogateAuthRequired;
}

public void setSurrogateAuthRequired(boolean surrogateAuthRequired) {
	this.surrogateAuthRequired = surrogateAuthRequired;
}

public boolean isEnabled() {
	return enabled;
}

public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}

public boolean isAlwaysDisplayInConsole() {
	return alwaysDisplayInConsole;
}

public void setAlwaysDisplayInConsole(boolean alwaysDisplayInConsole) {
	this.alwaysDisplayInConsole = alwaysDisplayInConsole;
}

public String getClientAuthenticatorType() {
	return clientAuthenticatorType;
}

public void setClientAuthenticatorType(String clientAuthenticatorType) {
	this.clientAuthenticatorType = clientAuthenticatorType;
}

public List<String> getRedirectUris() {
	return redirectUris;
}

public void setRedirectUris(List<String> redirectUris) {
	this.redirectUris = redirectUris;
}

public List<String> getWebOrigins() {
	return webOrigins;
}

public void setWebOrigins(List<String> webOrigins) {
	this.webOrigins = webOrigins;
}

public int getNotBefore() {
	return notBefore;
}

public void setNotBefore(int notBefore) {
	this.notBefore = notBefore;
}

public boolean isBearerOnly() {
	return bearerOnly;
}

public void setBearerOnly(boolean bearerOnly) {
	this.bearerOnly = bearerOnly;
}

public boolean isConsentRequired() {
	return consentRequired;
}

public void setConsentRequired(boolean consentRequired) {
	this.consentRequired = consentRequired;
}

public boolean isStandardFlowEnabled() {
	return standardFlowEnabled;
}

public void setStandardFlowEnabled(boolean standardFlowEnabled) {
	this.standardFlowEnabled = standardFlowEnabled;
}

public boolean isImplicitFlowEnabled() {
	return implicitFlowEnabled;
}

public void setImplicitFlowEnabled(boolean implicitFlowEnabled) {
	this.implicitFlowEnabled = implicitFlowEnabled;
}

public boolean isDirectAccessGrantsEnabled() {
	return directAccessGrantsEnabled;
}

public void setDirectAccessGrantsEnabled(boolean directAccessGrantsEnabled) {
	this.directAccessGrantsEnabled = directAccessGrantsEnabled;
}

public boolean isServiceAccountsEnabled() {
	return serviceAccountsEnabled;
}

public void setServiceAccountsEnabled(boolean serviceAccountsEnabled) {
	this.serviceAccountsEnabled = serviceAccountsEnabled;
}

public boolean isPublicClient() {
	return publicClient;
}

public void setPublicClient(boolean publicClient) {
	this.publicClient = publicClient;
}

public boolean isFrontchannelLogout() {
	return frontchannelLogout;
}

public void setFrontchannelLogout(boolean frontchannelLogout) {
	this.frontchannelLogout = frontchannelLogout;
}

public String getProtocol() {
	return protocol;
}

public void setProtocol(String protocol) {
	this.protocol = protocol;
}

public Map<String, String> getAttributes() {
	return attributes;
}

public void setAttributes(Map<String, String> attributes) {
	this.attributes = attributes;
}

public Map<String, String> getAuthenticationFlowBindingOverrides() {
	return authenticationFlowBindingOverrides;
}

public void setAuthenticationFlowBindingOverrides(Map<String, String> authenticationFlowBindingOverrides) {
	this.authenticationFlowBindingOverrides = authenticationFlowBindingOverrides;
}

public boolean isFullScopeAllowed() {
	return fullScopeAllowed;
}

public void setFullScopeAllowed(boolean fullScopeAllowed) {
	this.fullScopeAllowed = fullScopeAllowed;
}

public int getNodeReRegistrationTimeout() {
	return nodeReRegistrationTimeout;
}

public void setNodeReRegistrationTimeout(int nodeReRegistrationTimeout) {
	this.nodeReRegistrationTimeout = nodeReRegistrationTimeout;
}

public List<String> getDefaultClientScopes() {
	return defaultClientScopes;
}

public void setDefaultClientScopes(List<String> defaultClientScopes) {
	this.defaultClientScopes = defaultClientScopes;
}

public List<String> getOptionalClientScopes() {
	return optionalClientScopes;
}

public void setOptionalClientScopes(List<String> optionalClientScopes) {
	this.optionalClientScopes = optionalClientScopes;
}

public Map<String, Boolean> getAccess() {
	return access;
}

public void setAccess(Map<String, Boolean> access) {
	this.access = access;
}




}
