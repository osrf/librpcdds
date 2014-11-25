package com.eprosima.idl.parser.tree;

public interface Definition
{
    void setParent(Object obj);
    
    Object getParent();
    
    /*!
     * This function is used to search the first interface.
     */
    public Interface getFirstInterface(String idlFile);
    
    /*!
     * This function is used to search the first exception.
     */
    public com.eprosima.idl.parser.tree.Exception getFirstException(String idlFile);
    
    public boolean isIsModule();
    
    public boolean isIsInterface();
    
    public boolean isIsException();
    
    public boolean isIsTypeDeclaration();

    public boolean isIsConstDeclaration();
}
