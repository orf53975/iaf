package nl.nn.ibistesttool;

import java.security.Principal;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import nl.nn.adapterframework.core.IPipeLineSession;
import nl.nn.adapterframework.core.ISecurityHandler;

import org.apache.commons.lang.NotImplementedException;

/**
 * Wrapper class for PipeLineSession to be able to debug storing values in
 * session keys.
 * 
 * @author  Jaco de Groot (jaco@dynasol.nl)
 */

public class PipeLineSessionDebugger implements IPipeLineSession {
	private IPipeLineSession pipeLineSession;
	private IbisDebugger ibisDebugger;

	PipeLineSessionDebugger(IPipeLineSession pipeLineSession) {
		this.pipeLineSession = pipeLineSession;
	}

	public void setIbisDebugger(IbisDebugger ibisDebugger) {
		this.ibisDebugger = ibisDebugger;
	}

	// Methods implementing IPipeLineSession

	public String getMessageId() {
		return pipeLineSession.getMessageId();
	}

	public String getOriginalMessage() {
		return pipeLineSession.getOriginalMessage();
	}

	public void setSecurityHandler(ISecurityHandler handler) {
		pipeLineSession.setSecurityHandler(handler);
	}

	public ISecurityHandler getSecurityHandler() throws NotImplementedException {
		return pipeLineSession.getSecurityHandler();
	}

	public boolean isUserInRole(String role) throws NotImplementedException {
		return pipeLineSession.isUserInRole(role);
	}

	public Principal getPrincipal() throws NotImplementedException {
		return pipeLineSession.getPrincipal();
	}

	// Methods implementing Map

	public void clear() {
		pipeLineSession.clear();
	}

	public boolean containsKey(Object arg0) {
		return pipeLineSession.containsKey(arg0);
	}

	public boolean containsValue(Object arg0) {
		return pipeLineSession.containsValue(arg0);
	}

	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		return pipeLineSession.entrySet();
	}

	public boolean equals(Object arg0) {
		return pipeLineSession.equals(arg0);
	}

	public Object get(Object arg0) {
		return pipeLineSession.get(arg0);
	}

	public int hashCode() {
		return pipeLineSession.hashCode();
	}

	public boolean isEmpty() {
		return pipeLineSession.isEmpty();
	}

	public Set keySet() {
		return pipeLineSession.keySet();
	}

	public Object put(String arg0, Object arg1) {
		arg1 = ibisDebugger.storeInSessionKey(getMessageId(), arg0, arg1);
		return pipeLineSession.put(arg0, arg1);
	}

	public void putAll(Map arg0) {
		pipeLineSession.putAll(arg0);
	}

	public Object remove(Object arg0) {
		return pipeLineSession.remove(arg0);
	}

	public int size() {
		return pipeLineSession.size();
	}

	public Collection<Object> values() {
		return pipeLineSession.values();
	}

	// Remaining methods

	public String toString() {
		return pipeLineSession.toString();
	}
}
