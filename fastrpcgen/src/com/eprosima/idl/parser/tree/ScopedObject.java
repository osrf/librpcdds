package com.eprosima.idl.parser.tree;

public class ScopedObject
{
	public String getScopeFile()
	{
		return m_scope;
	}
	
	public void setScopeFile(String scope, boolean isinscope)
	{
		m_scope = scope;	
		m_isinscope = isinscope;
	}
	
	public boolean isInScope()
	{
		return m_isinscope;
	}
	
	private String m_scope = null;
	private boolean m_isinscope = false;
}
