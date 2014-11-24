// $ANTLR 2.7.7 (20060906): "idl.g" -> "IDLParser.java"$

    package com.eprosima.idl.parser.grammar;
    
    import com.eprosima.idl.context.Context;
    import com.eprosima.idl.generator.manager.TemplateManager;
    import com.eprosima.idl.generator.manager.TemplateGroup;
    import com.eprosima.idl.generator.manager.TemplateUtil;
    import com.eprosima.idl.parser.typecode.*;
    import com.eprosima.idl.parser.tree.*;
    import com.eprosima.idl.util.Pair;
    import com.eprosima.idl.parser.exception.ParseException;
   
    import java.util.Vector;
 
import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;

public class IDLParser extends antlr.LLkParser       implements IDLTokenTypes
 {

    TemplateManager tmanager = null;
    Context ctx = null;

protected IDLParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public IDLParser(TokenBuffer tokenBuf) {
  this(tokenBuf,4);
}

protected IDLParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public IDLParser(TokenStream lexer) {
  this(lexer,4);
}

public IDLParser(ParserSharedInputState state) {
  super(state,4);
  tokenNames = _tokenNames;
}

	public final boolean  specification(
		Context context, TemplateManager templatemanager, TemplateGroup maintemplates
	) throws RecognitionException, TokenStreamException {
		boolean returnedValue = false;
		
		
		//! Used to catch each definition grammar element in the whole IDL file.
		Pair<Definition, TemplateGroup> dtg = null;
		
		ctx = context;
		tmanager = templatemanager;
		
		
		try {      // for error handling
			{
			_loop3:
			do {
				if ((LA(1)==LITERAL_import)) {
					import_dcl();
				}
				else {
					break _loop3;
				}
				
			} while (true);
			}
			{
			int _cnt5=0;
			_loop5:
			do {
				if ((_tokenSet_0.member(LA(1)))) {
					dtg=definition();
					if ( inputState.guessing==0 ) {
						if(dtg!=null){maintemplates.setAttribute("definitions", dtg.second()); ctx.addDefinition(dtg.first());}
					}
				}
				else {
					if ( _cnt5>=1 ) { break _loop5; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt5++;
			} while (true);
			}
			if ( inputState.guessing==0 ) {
				
					    returnedValue = true;
					
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_1);
			} else {
			  throw ex;
			}
		}
		return returnedValue;
	}
	
	public final void import_dcl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_import);
			imported_scope();
			match(SEMI);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_2);
			} else {
			  throw ex;
			}
		}
	}
	
	public final Pair<Definition, TemplateGroup>  definition() throws RecognitionException, TokenStreamException {
		Pair<Definition, TemplateGroup> dtg = null;
		
		
		// TODO Cambiar esto. No me gusta la forma.
		Pair<TypeDeclaration, TemplateGroup> tdtg = null;
		Pair<ConstDeclaration, TemplateGroup> cdtg = null;
		Pair<Module, TemplateGroup> mtg = null;
		Pair<Interface, TemplateGroup> itg = null;
		Pair<com.eprosima.idl.parser.tree.Exception, TemplateGroup> etg = null;
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_typedef:
			case LITERAL_native:
			case LITERAL_struct:
			case LITERAL_union:
			case LITERAL_enum:
			{
				tdtg=type_dcl();
				match(SEMI);
				if ( inputState.guessing==0 ) {
					if(tdtg!=null){dtg = new Pair<Definition, TemplateGroup>(tdtg.first(), tdtg.second());}
				}
				break;
			}
			case LITERAL_const:
			{
				cdtg=const_dcl();
				match(SEMI);
				if ( inputState.guessing==0 ) {
					if(cdtg!=null){dtg = new Pair<Definition, TemplateGroup>(cdtg.first(), cdtg.second());}
				}
				break;
			}
			case LITERAL_exception:
			{
				etg=except_dcl();
				match(SEMI);
				if ( inputState.guessing==0 ) {
					if(etg!=null){dtg = new Pair<Definition, TemplateGroup>(etg.first(), etg.second());}
				}
				break;
			}
			case LITERAL_module:
			{
				mtg=module();
				match(SEMI);
				if ( inputState.guessing==0 ) {
					if(mtg!=null){dtg = new Pair<Definition, TemplateGroup>(mtg.first(), mtg.second());}
				}
				break;
			}
			case LITERAL_typeid:
			{
				type_id_dcl();
				match(SEMI);
				break;
			}
			case LITERAL_typeprefix:
			{
				type_prefix_dcl();
				match(SEMI);
				break;
			}
			case LITERAL_component:
			{
				component();
				match(SEMI);
				break;
			}
			case LITERAL_home:
			{
				home_dcl();
				match(SEMI);
				break;
			}
			default:
				boolean synPredMatched10 = false;
				if ((((LA(1) >= LITERAL_abstract && LA(1) <= LITERAL_interface)) && (LA(2)==LITERAL_interface||LA(2)==IDENT) && (_tokenSet_3.member(LA(3))) && (_tokenSet_4.member(LA(4))))) {
					int _m10 = mark();
					synPredMatched10 = true;
					inputState.guessing++;
					try {
						{
						{
						switch ( LA(1)) {
						case LITERAL_abstract:
						{
							match(LITERAL_abstract);
							break;
						}
						case LITERAL_local:
						{
							match(LITERAL_local);
							break;
						}
						case LITERAL_interface:
						{
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						match(LITERAL_interface);
						}
					}
					catch (RecognitionException pe) {
						synPredMatched10 = false;
					}
					rewind(_m10);
inputState.guessing--;
				}
				if ( synPredMatched10 ) {
					itg=interf();
					match(SEMI);
					if ( inputState.guessing==0 ) {
						if(itg!=null){dtg = new Pair<Definition, TemplateGroup>(itg.first(), itg.second());}
					}
				}
				else {
					boolean synPredMatched13 = false;
					if (((LA(1)==LITERAL_abstract||LA(1)==LITERAL_custom||LA(1)==LITERAL_valuetype) && (LA(2)==LITERAL_valuetype||LA(2)==IDENT) && (_tokenSet_5.member(LA(3))) && (_tokenSet_6.member(LA(4))))) {
						int _m13 = mark();
						synPredMatched13 = true;
						inputState.guessing++;
						try {
							{
							{
							switch ( LA(1)) {
							case LITERAL_abstract:
							{
								match(LITERAL_abstract);
								break;
							}
							case LITERAL_custom:
							{
								match(LITERAL_custom);
								break;
							}
							case LITERAL_valuetype:
							{
								break;
							}
							default:
							{
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
							}
							match(LITERAL_valuetype);
							}
						}
						catch (RecognitionException pe) {
							synPredMatched13 = false;
						}
						rewind(_m13);
inputState.guessing--;
					}
					if ( synPredMatched13 ) {
						value();
						match(SEMI);
					}
					else {
						boolean synPredMatched16 = false;
						if (((LA(1)==LITERAL_abstract||LA(1)==LITERAL_custom||LA(1)==LITERAL_eventtype) && (LA(2)==LITERAL_eventtype||LA(2)==IDENT) && (_tokenSet_5.member(LA(3))) && (_tokenSet_7.member(LA(4))))) {
							int _m16 = mark();
							synPredMatched16 = true;
							inputState.guessing++;
							try {
								{
								{
								switch ( LA(1)) {
								case LITERAL_abstract:
								{
									match(LITERAL_abstract);
									break;
								}
								case LITERAL_custom:
								{
									match(LITERAL_custom);
									break;
								}
								case LITERAL_eventtype:
								{
									break;
								}
								default:
								{
									throw new NoViableAltException(LT(1), getFilename());
								}
								}
								}
								match(LITERAL_eventtype);
								}
							}
							catch (RecognitionException pe) {
								synPredMatched16 = false;
							}
							rewind(_m16);
inputState.guessing--;
						}
						if ( synPredMatched16 ) {
							event();
							match(SEMI);
						}
						else if ((LA(1)==AT) && (LA(2)==LITERAL_Annotation)) {
							annotation_type();
							match(SEMI);
						}
						else if ((LA(1)==AT) && (LA(2)==IDENT)) {
							annotation_application();
						}
					else {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}}}
					}
				}
				catch (RecognitionException ex) {
					if (inputState.guessing==0) {
						reportError(ex);
						recover(ex,_tokenSet_8);
					} else {
					  throw ex;
					}
				}
				return dtg;
			}
			
	public final Pair<TypeDeclaration, TemplateGroup>  type_dcl() throws RecognitionException, TokenStreamException {
		Pair<TypeDeclaration, TemplateGroup> returnPair = null;
		
		
		Pair<TypeCode, TemplateGroup> ttg = null;
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_typedef:
			{
				match(LITERAL_typedef);
				ttg=type_declarator();
				break;
			}
			case LITERAL_enum:
			{
				ttg=enum_type();
				break;
			}
			case LITERAL_native:
			{
				match(LITERAL_native);
				simple_declarator();
				break;
			}
			default:
				boolean synPredMatched115 = false;
				if (((LA(1)==LITERAL_struct) && (LA(2)==IDENT) && (LA(3)==LCURLY))) {
					int _m115 = mark();
					synPredMatched115 = true;
					inputState.guessing++;
					try {
						{
						struct_type();
						}
					}
					catch (RecognitionException pe) {
						synPredMatched115 = false;
					}
					rewind(_m115);
inputState.guessing--;
				}
				if ( synPredMatched115 ) {
					ttg=struct_type();
				}
				else {
					boolean synPredMatched117 = false;
					if (((LA(1)==LITERAL_union) && (LA(2)==IDENT) && (LA(3)==LITERAL_switch))) {
						int _m117 = mark();
						synPredMatched117 = true;
						inputState.guessing++;
						try {
							{
							union_type();
							}
						}
						catch (RecognitionException pe) {
							synPredMatched117 = false;
						}
						rewind(_m117);
inputState.guessing--;
					}
					if ( synPredMatched117 ) {
						ttg=union_type();
					}
					else if ((LA(1)==LITERAL_struct||LA(1)==LITERAL_union) && (LA(2)==IDENT) && (LA(3)==SEMI)) {
						constr_forward_decl();
					}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}}
				}
				if ( inputState.guessing==0 ) {
					
						    if(ttg!=null)
						        returnPair = new Pair<TypeDeclaration, TemplateGroup>(new TypeDeclaration(ttg.first()), ttg.second());
						
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_9);
				} else {
				  throw ex;
				}
			}
			return returnPair;
		}
		
	public final Pair<ConstDeclaration, TemplateGroup>  const_dcl() throws RecognitionException, TokenStreamException {
		Pair<ConstDeclaration, TemplateGroup> returnPair = null;
		
		
		ConstDeclaration constDecl = null;
		TypeCode typecode = null;
		String name = null, value = null;
		TemplateGroup constTemplates = tmanager.createTemplateGroup("const_decl");
		
		
		try {      // for error handling
			match(LITERAL_const);
			typecode=const_type();
			name=identifier();
			match(ASSIGN);
			value=const_exp();
			if ( inputState.guessing==0 ) {
				
					   if(typecode != null)
					   {
				constDecl = new ConstDeclaration(typecode, name, value);
				constTemplates.setAttribute("ctx", ctx);
				constTemplates.setAttribute("const", constDecl);
					       
					       returnPair = new Pair<ConstDeclaration, TemplateGroup>(constDecl, constTemplates);
				}
				else
				{
				throw new RuntimeException("ERROR (File " + ctx.getFilename() + ", Line " + (LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Cannot parse constant declaration");
				}
				
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		return returnPair;
	}
	
	public final Pair<com.eprosima.idl.parser.tree.Exception, TemplateGroup>  except_dcl() throws RecognitionException, TokenStreamException {
		Pair<com.eprosima.idl.parser.tree.Exception, TemplateGroup> returnPair = null;
		
		
		String name = null;
		com.eprosima.idl.parser.tree.Exception exceptionObject = null;
		TemplateGroup exTemplates = null;
		
		
		try {      // for error handling
			match(LITERAL_exception);
			name=identifier();
			if ( inputState.guessing==0 ) {
				
				// Create the Exception object.
				exceptionObject = new com.eprosima.idl.parser.tree.Exception(ctx.getScope(), name);
				if(ctx.setScopedFileToObject(exceptionObject) || ctx.isScopeLimitToAll())
				{
				exTemplates = tmanager.createTemplateGroup("exception");
				exTemplates.setAttribute("ctx", ctx);
				// Set the the exception object to the TemplateGroup of the module.
				exTemplates.setAttribute("exception", exceptionObject);
				}
				// Its a dependency.
				else
				{
				ctx.addIncludeDependency(ctx.getScopeFile());
				}
					
			}
			match(LCURLY);
			opt_member_list(exceptionObject);
			match(RCURLY);
			if ( inputState.guessing==0 ) {
				
				ctx.addException(exceptionObject.getScopedname(), exceptionObject);
				// Create the returned data.
				returnPair = new Pair<com.eprosima.idl.parser.tree.Exception, TemplateGroup>(exceptionObject, exTemplates);
				
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		return returnPair;
	}
	
	public final Pair<Interface, TemplateGroup>  interf() throws RecognitionException, TokenStreamException {
		Pair<Interface, TemplateGroup> itg = null;
		
		
		try {      // for error handling
			{
			if (((LA(1) >= LITERAL_abstract && LA(1) <= LITERAL_interface)) && (LA(2)==LITERAL_interface||LA(2)==IDENT) && (LA(3)==LCURLY||LA(3)==COLON||LA(3)==IDENT) && (_tokenSet_10.member(LA(4)))) {
				itg=interface_dcl();
			}
			else if (((LA(1) >= LITERAL_abstract && LA(1) <= LITERAL_interface)) && (LA(2)==LITERAL_interface||LA(2)==IDENT) && (LA(3)==SEMI||LA(3)==IDENT) && (_tokenSet_11.member(LA(4)))) {
				forward_dcl();
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		return itg;
	}
	
	public final Pair<Module, TemplateGroup>  module() throws RecognitionException, TokenStreamException {
		Pair<Module, TemplateGroup> returnPair = null;
		
		
		Module moduleObject = null;
		TemplateGroup moduleTemplates = null;
		TemplateGroup tg = null;
		// Store old namespace.
		String name = null, old_scope = ctx.getScope();
		
		
		try {      // for error handling
			match(LITERAL_module);
			name=identifier();
			if ( inputState.guessing==0 ) {
				
					       // Create the Module object.
					       moduleObject = new Module(name);
					       // Set temporarily annotations.
				ctx.setTmpAnnotations(moduleObject);
				
					       if(ctx.isInScopedFile() || ctx.isScopeLimitToAll())
				{
				moduleTemplates = tmanager.createTemplateGroup("module");
					           // Set the module object to the TemplateGroup of the module.
					           moduleTemplates.setAttribute("module", moduleObject);
					           moduleTemplates.setAttribute("ctx", ctx);
					           ctx.setCurrentModule(moduleObject);
					       }
					       // Update to a new namespace.
				if(old_scope.isEmpty())
					           ctx.setScope(name);
				else
					           ctx.setScope(old_scope + "::" + name);
					
			}
			match(LCURLY);
			tg=definition_list(moduleObject);
			if ( inputState.guessing==0 ) {
				if(moduleTemplates!=null && tg!=null)moduleTemplates.setAttribute("definition_list", tg);
			}
			match(RCURLY);
			if ( inputState.guessing==0 ) {
				
					       // Set the old namespace.
					       ctx.setScope(old_scope);
					       // Create the returned data.
					       returnPair = new Pair<Module, TemplateGroup>(moduleObject, moduleTemplates);
					
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		return returnPair;
	}
	
	public final void value() throws RecognitionException, TokenStreamException {
		
		
		System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : "1") + "): ValueType declarations are not supported. Ignoring...");
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_abstract:
			{
				value_abs_dcl();
				break;
			}
			case LITERAL_custom:
			{
				value_custom_dcl();
				break;
			}
			default:
				if ((LA(1)==LITERAL_valuetype) && (LA(2)==IDENT) && (LA(3)==LCURLY||LA(3)==COLON||LA(3)==LITERAL_supports)) {
					value_dcl();
				}
				else if ((LA(1)==LITERAL_valuetype) && (LA(2)==IDENT) && (LA(3)==SEMI) && (_tokenSet_8.member(LA(4)))) {
					value_box_dcl();
				}
				else if ((LA(1)==LITERAL_valuetype) && (LA(2)==IDENT) && (LA(3)==SEMI) && (_tokenSet_8.member(LA(4)))) {
					value_forward_dcl();
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void type_id_dcl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_typeid);
			if ( inputState.guessing==0 ) {
				
				System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : "1") + "): TypeID declarations are not supported. Ignoring...");
				
			}
			scoped_name();
			string_literal();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void type_prefix_dcl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_typeprefix);
			if ( inputState.guessing==0 ) {
				
				System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : "1") + "): TypePrefix declarations are not supported. Ignoring...");
				
			}
			scoped_name();
			string_literal();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void event() throws RecognitionException, TokenStreamException {
		
		
		System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Event declarations are not supported. Ignoring...");
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_abstract:
			{
				event_abs();
				break;
			}
			case LITERAL_custom:
			{
				event_custom();
				break;
			}
			case LITERAL_eventtype:
			{
				event_dcl();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void component() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_component);
			if ( inputState.guessing==0 ) {
				
				System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Component declarations are not supported. Ignoring...");
				
			}
			identifier();
			{
			switch ( LA(1)) {
			case LCURLY:
			case COLON:
			case LITERAL_supports:
			{
				component_dcl();
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void home_dcl() throws RecognitionException, TokenStreamException {
		
		
		System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Home declarations are not supported. Ignoring...");
		
		
		try {      // for error handling
			home_header();
			home_body();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void annotation_type() throws RecognitionException, TokenStreamException {
		
		
		String name = null;
		Annotation annotation = null;
		
		
		try {      // for error handling
			match(AT);
			match(LITERAL_Annotation);
			match(LITERAL_local);
			match(LITERAL_interface);
			name=identifier();
			if ( inputState.guessing==0 ) {
				
				annotation = new Annotation(ctx.getScope(), name);
				
			}
			match(LCURLY);
			annotation_member_list(annotation);
			match(RCURLY);
			if ( inputState.guessing==0 ) {
				
				// Add anotation typecode to the map with all typecodes.
				ctx.addAnnotation(annotation.getScopedname(), annotation);
				
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void annotation_application() throws RecognitionException, TokenStreamException {
		
		
		String id = null, value = null;
		
		
		try {      // for error handling
			match(AT);
			id=identifier();
			match(LPAREN);
			value=literal();
			match(RPAREN);
			if ( inputState.guessing==0 ) {
				
				// Check if the annotation was defined and has only one member.
				if(ctx.getAnnotation(id) != null)
				{
				if(ctx.getAnnotation(id).getMembers().size() == 1)
				ctx.addTmpAnnotation(id, value);
				else
				throw new ParseException(ctx.getScopeFile(), LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : 1, "The annotation " + id + " has defined more than one attribute.");
				}
				else
				throw new ParseException(ctx.getScopeFile(), LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : 1, "The annotation " + id + " cannot be found.");
				
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_12);
			} else {
			  throw ex;
			}
		}
	}
	
	public final String  identifier() throws RecognitionException, TokenStreamException {
		String id = LT(1).getText();
		
		
		try {      // for error handling
			match(IDENT);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_13);
			} else {
			  throw ex;
			}
		}
		return id;
	}
	
	public final TemplateGroup  definition_list(
		DefinitionContainer dc
	) throws RecognitionException, TokenStreamException {
		TemplateGroup dlTemplates = tmanager.createTemplateGroup("definition_list");
		
		
		Pair<Definition, TemplateGroup> dtg = null;
		
		
		try {      // for error handling
			{
			int _cnt20=0;
			_loop20:
			do {
				if ((_tokenSet_0.member(LA(1)))) {
					dtg=definition();
					if ( inputState.guessing==0 ) {
						if(dtg!=null){dc.add(dtg.first()); dlTemplates.setAttribute("definitions", dtg.second());}
					}
				}
				else {
					if ( _cnt20>=1 ) { break _loop20; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt20++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_14);
			} else {
			  throw ex;
			}
		}
		return dlTemplates;
	}
	
	public final Pair<Interface, TemplateGroup>  interface_dcl() throws RecognitionException, TokenStreamException {
		Pair<Interface, TemplateGroup> returnPair = null;
		
		
		Interface interfaceObject = null;
		TemplateGroup interfaceTemplates = null;
		TemplateGroup tg = null;
		String name = null, old_scope = ctx.getScope();
		
		
		try {      // for error handling
			{
			{
			switch ( LA(1)) {
			case LITERAL_abstract:
			{
				match(LITERAL_abstract);
				break;
			}
			case LITERAL_local:
			{
				match(LITERAL_local);
				break;
			}
			case LITERAL_interface:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(LITERAL_interface);
			name=identifier();
			if ( inputState.guessing==0 ) {
				
				// Create the Interface object.
				interfaceObject = new Interface(ctx.getScope(), name);
				// Set temporarily annotations.
				ctx.setTmpAnnotations(interfaceObject);
				if(ctx.setScopedFileToObject(interfaceObject) || ctx.isScopeLimitToAll())
				{
				interfaceTemplates = tmanager.createTemplateGroup("interface");
				interfaceTemplates.setAttribute("ctx", ctx);
				// Set the the interface object to the TemplateGroup of the module.
				interfaceTemplates.setAttribute("interface", interfaceObject);
				ctx.addInterface(interfaceObject.getScopedname(), interfaceObject);
				}
				
					       // Update to a new namespace.
				if(old_scope.isEmpty())
					           ctx.setScope(name);
				else
					           ctx.setScope(old_scope + "::" + name);
				
			}
			{
			switch ( LA(1)) {
			case COLON:
			{
				interface_inheritance_spec();
				break;
			}
			case LCURLY:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(LCURLY);
			tg=interface_body(interfaceObject);
			if ( inputState.guessing==0 ) {
				if(interfaceTemplates!=null && tg!=null)interfaceTemplates.setAttribute("export_list", tg);
			}
			match(RCURLY);
			}
			if ( inputState.guessing==0 ) {
				
					       // Set the old namespace.
					       ctx.setScope(old_scope);
				// Create the returned data.
				returnPair = new Pair<Interface, TemplateGroup>(interfaceObject, interfaceTemplates);
				
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		return returnPair;
	}
	
	public final void forward_dcl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_abstract:
			{
				match(LITERAL_abstract);
				break;
			}
			case LITERAL_local:
			{
				match(LITERAL_local);
				break;
			}
			case LITERAL_interface:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(LITERAL_interface);
			identifier();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void interface_inheritance_spec() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(COLON);
			scoped_name_list();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_15);
			} else {
			  throw ex;
			}
		}
	}
	
	public final TemplateGroup  interface_body(
		ExportContainer ec
	) throws RecognitionException, TokenStreamException {
		TemplateGroup elTemplates = tmanager.createTemplateGroup("export_list");
		
		
		Pair<Export, TemplateGroup> etg = null;
		
		
		try {      // for error handling
			{
			_loop31:
			do {
				if ((_tokenSet_16.member(LA(1)))) {
					etg=export();
					if ( inputState.guessing==0 ) {
						if(etg!=null){ec.add(etg.first()); etg.first().resolve(ctx); elTemplates.setAttribute("exports", etg.second());}
					}
				}
				else {
					break _loop31;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_14);
			} else {
			  throw ex;
			}
		}
		return elTemplates;
	}
	
	public final Pair<Export, TemplateGroup>  export() throws RecognitionException, TokenStreamException {
		Pair<Export, TemplateGroup> etg = null;
		
		
		// TODO Cambiar esto. No me gusta la forma.
		Pair<TypeDeclaration, TemplateGroup> tetg = null;
		Pair<ConstDeclaration, TemplateGroup> cetg = null;
		Pair<Operation, TemplateGroup> oetg = null;
		Pair<com.eprosima.idl.parser.tree.Exception, TemplateGroup> eetg = null;
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_typedef:
			case LITERAL_native:
			case LITERAL_struct:
			case LITERAL_union:
			case LITERAL_enum:
			{
				tetg=type_dcl();
				match(SEMI);
				if ( inputState.guessing==0 ) {
					if(tetg!=null){etg = new Pair<Export, TemplateGroup>(tetg.first(), tetg.second());}
				}
				break;
			}
			case LITERAL_const:
			{
				cetg=const_dcl();
				match(SEMI);
				if ( inputState.guessing==0 ) {
					if(cetg!=null){etg = new Pair<Export, TemplateGroup>(cetg.first(), cetg.second());}
				}
				break;
			}
			case LITERAL_exception:
			{
				eetg=except_dcl();
				match(SEMI);
				if ( inputState.guessing==0 ) {
					if(eetg!=null){etg = new Pair<Export, TemplateGroup>(eetg.first(), eetg.second());}
				}
				break;
			}
			case LITERAL_readonly:
			case LITERAL_attribute:
			{
				attr_dcl();
				match(SEMI);
				break;
			}
			case SCOPEOP:
			case IDENT:
			case LITERAL_float:
			case LITERAL_double:
			case LITERAL_long:
			case LITERAL_short:
			case LITERAL_unsigned:
			case LITERAL_char:
			case LITERAL_wchar:
			case LITERAL_boolean:
			case LITERAL_octet:
			case LITERAL_any:
			case LITERAL_Object:
			case LITERAL_string:
			case LITERAL_wstring:
			case LITERAL_oneway:
			case LITERAL_void:
			case LITERAL_ValueBase:
			{
				oetg=op_dcl();
				match(SEMI);
				if ( inputState.guessing==0 ) {
					if(oetg!=null){etg = new Pair<Export, TemplateGroup>(oetg.first(), oetg.second());}
				}
				break;
			}
			case LITERAL_typeid:
			{
				type_id_dcl();
				match(SEMI);
				break;
			}
			case LITERAL_typeprefix:
			{
				type_prefix_dcl();
				match(SEMI);
				break;
			}
			case AT:
			{
				annotation_application();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_17);
			} else {
			  throw ex;
			}
		}
		return etg;
	}
	
	public final Vector<Pair<String, TypeCode>>  attr_dcl() throws RecognitionException, TokenStreamException {
		Vector<Pair<String, TypeCode>> declvector = null;
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_readonly:
			{
				readonly_attr_spec();
				break;
			}
			case LITERAL_attribute:
			{
				declvector=attr_spec();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		return declvector;
	}
	
	public final Pair<Operation, TemplateGroup>  op_dcl() throws RecognitionException, TokenStreamException {
		Pair<Operation, TemplateGroup> returnPair = null;
		
		
		Operation operationObject = null;
		TemplateGroup operationTemplates = tmanager.createTemplateGroup("operation");
		TemplateGroup tpl = null;
		String name = "";
		boolean oneway = false;
		TypeCode retType = null;
		Vector<String> exceptions = null;
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_oneway:
			{
				oneway=op_attribute();
				break;
			}
			case SCOPEOP:
			case IDENT:
			case LITERAL_float:
			case LITERAL_double:
			case LITERAL_long:
			case LITERAL_short:
			case LITERAL_unsigned:
			case LITERAL_char:
			case LITERAL_wchar:
			case LITERAL_boolean:
			case LITERAL_octet:
			case LITERAL_any:
			case LITERAL_Object:
			case LITERAL_string:
			case LITERAL_wstring:
			case LITERAL_void:
			case LITERAL_ValueBase:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			retType=op_type_spec();
			if ( inputState.guessing==0 ) {
				name += LT(1).getText();
			}
			match(IDENT);
			if ( inputState.guessing==0 ) {
				
				// Create the Operation object.
				operationObject = new Operation(name);
				// Set temporarily annotations.
				ctx.setTmpAnnotations(operationObject);
				// Set the the interface object to the TemplateGroup of the module.
				operationTemplates.setAttribute("operation", operationObject);
				operationTemplates.setAttribute("ctx", ctx);
				
				// Set return type
				operationObject.setRettype(retType);
				
				// Set oneway
				if(oneway) operationObject.setOneway(true);
				
			}
			tpl=parameter_dcls(operationObject);
			{
			switch ( LA(1)) {
			case LITERAL_raises:
			{
				exceptions=raises_expr();
				if ( inputState.guessing==0 ) {
					
						          // Search global exceptions and add them to the operation.
						          for(int count = 0; count < exceptions.size(); ++count)
						          {
						             String ename = exceptions.get(count);
						             com.eprosima.idl.parser.tree.Exception exception = ctx.getException(ename);
						             
						             if(exception != null)
						                operationObject.addException(exception);
						             else
						                operationObject.addUnresolvedException(ename);
						          }
						
				}
				break;
			}
			case SEMI:
			case LITERAL_context:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_context:
			{
				context_expr();
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				
					       // Store the parameter list template group in the operation template group.
					       operationTemplates.setAttribute("param_list", tpl);
				// Create the returned data.
				returnPair = new Pair<Operation, TemplateGroup>(operationObject, operationTemplates);
				
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		return returnPair;
	}
	
	public final Vector<String>  scoped_name_list() throws RecognitionException, TokenStreamException {
		Vector<String> retlist = null;
		
		
		String sname = null;
		retlist = new Vector<String>();
		
		
		try {      // for error handling
			sname=scoped_name();
			if ( inputState.guessing==0 ) {
				retlist.add(sname);
			}
			{
			_loop38:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					sname=scoped_name();
					if ( inputState.guessing==0 ) {
						retlist.add(sname);
					}
				}
				else {
					break _loop38;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_18);
			} else {
			  throw ex;
			}
		}
		return retlist;
	}
	
	public final void interface_name() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			scoped_name();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_19);
			} else {
			  throw ex;
			}
		}
	}
	
	public final String  scoped_name() throws RecognitionException, TokenStreamException {
		String literal = "";
		
		
		String aux = null;
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case SCOPEOP:
			{
				if ( inputState.guessing==0 ) {
					literal += LT(1).getText();
				}
				match(SCOPEOP);
				break;
			}
			case IDENT:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				literal += LT(1).getText();
			}
			match(IDENT);
			{
			_loop42:
			do {
				if ((LA(1)==SCOPEOP)) {
					if ( inputState.guessing==0 ) {
						literal += LT(1).getText();
					}
					match(SCOPEOP);
					aux=identifier();
					if ( inputState.guessing==0 ) {
						literal += aux;
					}
				}
				else {
					break _loop42;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_20);
			} else {
			  throw ex;
			}
		}
		return literal;
	}
	
	public final void value_dcl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			value_header();
			match(LCURLY);
			{
			_loop54:
			do {
				if ((_tokenSet_21.member(LA(1)))) {
					value_element();
				}
				else {
					break _loop54;
				}
				
			} while (true);
			}
			match(RCURLY);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void value_abs_dcl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_abstract);
			match(LITERAL_valuetype);
			identifier();
			{
			switch ( LA(1)) {
			case LCURLY:
			case COLON:
			case LITERAL_supports:
			{
				value_abs_full_dcl();
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void value_box_dcl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_valuetype);
			identifier();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void value_custom_dcl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_custom);
			value_dcl();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void value_forward_dcl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_valuetype);
			identifier();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void value_abs_full_dcl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			value_inheritance_spec();
			match(LCURLY);
			{
			_loop51:
			do {
				if ((_tokenSet_16.member(LA(1)))) {
					export();
				}
				else {
					break _loop51;
				}
				
			} while (true);
			}
			match(RCURLY);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void value_inheritance_spec() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case COLON:
			{
				value_value_inheritance_spec();
				break;
			}
			case LCURLY:
			case LITERAL_supports:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_supports:
			{
				value_interface_inheritance_spec();
				break;
			}
			case LCURLY:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_15);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void value_header() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_valuetype);
			identifier();
			value_inheritance_spec();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_15);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void value_element() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case SCOPEOP:
			case IDENT:
			case LITERAL_const:
			case LITERAL_typedef:
			case LITERAL_native:
			case LITERAL_float:
			case LITERAL_double:
			case LITERAL_long:
			case LITERAL_short:
			case LITERAL_unsigned:
			case LITERAL_char:
			case LITERAL_wchar:
			case LITERAL_boolean:
			case LITERAL_octet:
			case LITERAL_any:
			case LITERAL_Object:
			case AT:
			case LITERAL_struct:
			case LITERAL_union:
			case LITERAL_enum:
			case LITERAL_string:
			case LITERAL_wstring:
			case LITERAL_exception:
			case LITERAL_oneway:
			case LITERAL_void:
			case LITERAL_ValueBase:
			case LITERAL_typeid:
			case LITERAL_typeprefix:
			case LITERAL_readonly:
			case LITERAL_attribute:
			{
				export();
				break;
			}
			case LITERAL_public:
			case LITERAL_private:
			{
				state_member();
				break;
			}
			case LITERAL_factory:
			{
				init_dcl();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_22);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void value_value_inheritance_spec() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(COLON);
			{
			switch ( LA(1)) {
			case LITERAL_truncatable:
			{
				match(LITERAL_truncatable);
				break;
			}
			case SCOPEOP:
			case IDENT:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			value_name();
			{
			_loop63:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					value_name();
				}
				else {
					break _loop63;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_23);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void value_interface_inheritance_spec() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_supports);
			interface_name();
			{
			_loop66:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					interface_name();
				}
				else {
					break _loop66;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_15);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void value_name() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			scoped_name();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_24);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void state_member() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_public:
			{
				match(LITERAL_public);
				break;
			}
			case LITERAL_private:
			{
				match(LITERAL_private);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			type_spec();
			declarators();
			match(SEMI);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_22);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void init_dcl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_factory);
			identifier();
			match(LPAREN);
			{
			switch ( LA(1)) {
			case LITERAL_in:
			{
				init_param_decls();
				break;
			}
			case RPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(RPAREN);
			{
			switch ( LA(1)) {
			case LITERAL_raises:
			{
				raises_expr();
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(SEMI);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_22);
			} else {
			  throw ex;
			}
		}
	}
	
	public final TypeCode  type_spec() throws RecognitionException, TokenStreamException {
		TypeCode typecode = null;
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case SCOPEOP:
			case IDENT:
			case LITERAL_float:
			case LITERAL_double:
			case LITERAL_long:
			case LITERAL_short:
			case LITERAL_unsigned:
			case LITERAL_char:
			case LITERAL_wchar:
			case LITERAL_boolean:
			case LITERAL_octet:
			case LITERAL_any:
			case LITERAL_Object:
			case LITERAL_sequence:
			case LITERAL_string:
			case LITERAL_wstring:
			case LITERAL_fixed:
			case LITERAL_ValueBase:
			{
				typecode=simple_type_spec();
				break;
			}
			case LITERAL_struct:
			case LITERAL_union:
			case LITERAL_enum:
			{
				constr_type_spec();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_25);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final Vector<Pair<String, ContainerTypeCode>>  declarators() throws RecognitionException, TokenStreamException {
		Vector<Pair<String, ContainerTypeCode>> declvector = new Vector<Pair<String, ContainerTypeCode>>();
		
		
		Pair<String, ContainerTypeCode> pair = null;
		
		
		try {      // for error handling
			pair=declarator();
			if ( inputState.guessing==0 ) {
				
				if(pair != null)
				declvector.add(pair);
				else
				throw new ParseException(ctx.getScopeFile(), (LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : 1), "Cannot parse type declarator");
				
			}
			{
			_loop128:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					pair=declarator();
					if ( inputState.guessing==0 ) {
						
						if(pair != null)
						declvector.add(pair);
						else
						throw new ParseException(ctx.getScopeFile(), (LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : 1), "Cannot parse type declarator");
						
					}
				}
				else {
					break _loop128;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		return declvector;
	}
	
	public final void init_param_decls() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			init_param_decl();
			{
			_loop77:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					init_param_decl();
				}
				else {
					break _loop77;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_26);
			} else {
			  throw ex;
			}
		}
	}
	
	public final Vector<String>  raises_expr() throws RecognitionException, TokenStreamException {
		Vector<String> exlist = null;
		
		
		try {      // for error handling
			match(LITERAL_raises);
			match(LPAREN);
			exlist=scoped_name_list();
			match(RPAREN);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_27);
			} else {
			  throw ex;
			}
		}
		return exlist;
	}
	
	public final void init_param_decl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			init_param_attribute();
			param_type_spec();
			simple_declarator();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_28);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void init_param_attribute() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_in);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_29);
			} else {
			  throw ex;
			}
		}
	}
	
	public final TypeCode  param_type_spec() throws RecognitionException, TokenStreamException {
		TypeCode typecode = null;
		
		
		String literal = null;
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_float:
			case LITERAL_double:
			case LITERAL_long:
			case LITERAL_short:
			case LITERAL_unsigned:
			case LITERAL_char:
			case LITERAL_wchar:
			case LITERAL_boolean:
			case LITERAL_octet:
			case LITERAL_any:
			case LITERAL_Object:
			case LITERAL_ValueBase:
			{
				typecode=base_type_spec();
				break;
			}
			case LITERAL_string:
			{
				typecode=string_type();
				break;
			}
			case LITERAL_wstring:
			{
				typecode=wide_string_type();
				break;
			}
			case SCOPEOP:
			case IDENT:
			{
				literal=scoped_name();
				if ( inputState.guessing==0 ) {
					
					// Find typecode in the global map.
					typecode = ctx.getTypeCode(literal);
					
					if(typecode == null)
					throw new ParseException(ctx.getScopeFile(), LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : 1, "The type " + literal + " cannot be found.");
					
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_25);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final Pair<String, ContainerTypeCode>  simple_declarator() throws RecognitionException, TokenStreamException {
		Pair<String, ContainerTypeCode> pair = null;
		
		
		String name = null;
		
		
		try {      // for error handling
			name=identifier();
			if ( inputState.guessing==0 ) {
				
					       pair = new Pair<String, ContainerTypeCode>(name, null);
					
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_30);
			} else {
			  throw ex;
			}
		}
		return pair;
	}
	
	public final TypeCode  const_type() throws RecognitionException, TokenStreamException {
		TypeCode typecode = null;
		
		
		String literal = null;
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_char:
			{
				typecode=char_type();
				break;
			}
			case LITERAL_wchar:
			{
				typecode=wide_char_type();
				break;
			}
			case LITERAL_boolean:
			{
				typecode=boolean_type();
				break;
			}
			case LITERAL_string:
			{
				typecode=string_type();
				break;
			}
			case LITERAL_wstring:
			{
				typecode=wide_string_type();
				break;
			}
			case LITERAL_fixed:
			{
				fixed_pt_const_type();
				break;
			}
			case SCOPEOP:
			case IDENT:
			{
				literal=scoped_name();
				if ( inputState.guessing==0 ) {
					
						       // Find typecode in the global map.
						       typecode = ctx.getTypeCode(literal);
						       
						       if(typecode == null)
						           throw new ParseException(ctx.getScopeFile(), LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : 1, "The type " + literal + " cannot be found.");
						
				}
				break;
			}
			case LITERAL_octet:
			{
				typecode=octet_type();
				break;
			}
			default:
				boolean synPredMatched83 = false;
				if ((((LA(1) >= LITERAL_long && LA(1) <= LITERAL_unsigned)) && (LA(2)==IDENT||LA(2)==LITERAL_long||LA(2)==LITERAL_short) && (LA(3)==IDENT||LA(3)==ASSIGN||LA(3)==LITERAL_long) && (_tokenSet_31.member(LA(4))))) {
					int _m83 = mark();
					synPredMatched83 = true;
					inputState.guessing++;
					try {
						{
						integer_type();
						}
					}
					catch (RecognitionException pe) {
						synPredMatched83 = false;
					}
					rewind(_m83);
inputState.guessing--;
				}
				if ( synPredMatched83 ) {
					typecode=integer_type();
				}
				else if (((LA(1) >= LITERAL_float && LA(1) <= LITERAL_long)) && (LA(2)==IDENT||LA(2)==LITERAL_double) && (LA(3)==IDENT||LA(3)==ASSIGN) && (_tokenSet_31.member(LA(4)))) {
					typecode=floating_pt_type();
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_25);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final String  const_exp() throws RecognitionException, TokenStreamException {
		String literal = null;
		
		
		try {      // for error handling
			literal=or_expr();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_32);
			} else {
			  throw ex;
			}
		}
		return literal;
	}
	
	public final TypeCode  integer_type() throws RecognitionException, TokenStreamException {
		TypeCode typecode = null;
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_long:
			case LITERAL_short:
			{
				typecode=signed_int();
				break;
			}
			case LITERAL_unsigned:
			{
				typecode=unsigned_int();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_33);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final TypeCode  char_type() throws RecognitionException, TokenStreamException {
		TypeCode typecode = new PrimitiveTypeCode(TypeCode.KIND_CHAR);
		
		
		try {      // for error handling
			match(LITERAL_char);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_33);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final TypeCode  wide_char_type() throws RecognitionException, TokenStreamException {
		TypeCode typecode = new PrimitiveTypeCode(TypeCode.KIND_WCHAR);
		
		
		try {      // for error handling
			match(LITERAL_wchar);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_34);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final TypeCode  boolean_type() throws RecognitionException, TokenStreamException {
		TypeCode typecode = new PrimitiveTypeCode(TypeCode.KIND_BOOLEAN);
		
		
		try {      // for error handling
			match(LITERAL_boolean);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_33);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final TypeCode  floating_pt_type() throws RecognitionException, TokenStreamException {
		TypeCode typecode = null;
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_float:
			{
				match(LITERAL_float);
				if ( inputState.guessing==0 ) {
					typecode = new PrimitiveTypeCode(TypeCode.KIND_FLOAT);
				}
				break;
			}
			case LITERAL_double:
			{
				match(LITERAL_double);
				if ( inputState.guessing==0 ) {
					typecode = new PrimitiveTypeCode(TypeCode.KIND_DOUBLE);
				}
				break;
			}
			case LITERAL_long:
			{
				match(LITERAL_long);
				match(LITERAL_double);
				if ( inputState.guessing==0 ) {
					typecode = new PrimitiveTypeCode(TypeCode.KIND_LONGDOUBLE);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_34);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final TypeCode  string_type() throws RecognitionException, TokenStreamException {
		TypeCode typecode = null;
		
		
		String maxsize = null;
		
		
		try {      // for error handling
			match(LITERAL_string);
			{
			switch ( LA(1)) {
			case LT:
			{
				match(LT);
				maxsize=positive_int_const();
				match(GT);
				break;
			}
			case COMMA:
			case IDENT:
			case GT:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				typecode = new StringTypeCode(TypeCode.KIND_STRING, maxsize);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_34);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final TypeCode  wide_string_type() throws RecognitionException, TokenStreamException {
		TypeCode typecode = null;
		
		
		String maxsize = null;
		
		
		try {      // for error handling
			match(LITERAL_wstring);
			{
			switch ( LA(1)) {
			case LT:
			{
				match(LT);
				maxsize=positive_int_const();
				match(GT);
				break;
			}
			case COMMA:
			case IDENT:
			case GT:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				typecode = new StringTypeCode(TypeCode.KIND_WSTRING, maxsize);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_34);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final void fixed_pt_const_type() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_fixed);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_25);
			} else {
			  throw ex;
			}
		}
	}
	
	public final TypeCode  octet_type() throws RecognitionException, TokenStreamException {
		TypeCode typecode = new PrimitiveTypeCode(TypeCode.KIND_OCTET);
		
		
		try {      // for error handling
			match(LITERAL_octet);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_34);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final String  or_expr() throws RecognitionException, TokenStreamException {
		String literal = null;
		
		
		String aux = null;
		
		
		try {      // for error handling
			literal=xor_expr();
			{
			_loop87:
			do {
				if ((LA(1)==OR)) {
					if ( inputState.guessing==0 ) {
						literal += LT(1).getText();
					}
					match(OR);
					aux=xor_expr();
					if ( inputState.guessing==0 ) {
						literal += aux;
					}
				}
				else {
					break _loop87;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_32);
			} else {
			  throw ex;
			}
		}
		return literal;
	}
	
	public final String  xor_expr() throws RecognitionException, TokenStreamException {
		String literal = null;
		
		
		String aux = null;
		
		
		try {      // for error handling
			literal=and_expr();
			{
			_loop90:
			do {
				if ((LA(1)==XOR)) {
					if ( inputState.guessing==0 ) {
						literal += LT(1).getText();
					}
					match(XOR);
					aux=and_expr();
					if ( inputState.guessing==0 ) {
						literal += aux;
					}
				}
				else {
					break _loop90;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_35);
			} else {
			  throw ex;
			}
		}
		return literal;
	}
	
	public final String  and_expr() throws RecognitionException, TokenStreamException {
		String literal = null;
		
		
		String aux = null;
		
		
		try {      // for error handling
			literal=shift_expr();
			{
			_loop93:
			do {
				if ((LA(1)==AND)) {
					if ( inputState.guessing==0 ) {
						literal += LT(1).getText();
					}
					match(AND);
					aux=shift_expr();
					if ( inputState.guessing==0 ) {
						literal += aux;
					}
				}
				else {
					break _loop93;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_36);
			} else {
			  throw ex;
			}
		}
		return literal;
	}
	
	public final String  shift_expr() throws RecognitionException, TokenStreamException {
		String literal = null;
		
		
		String aux = null;
		
		
		try {      // for error handling
			literal=add_expr();
			{
			_loop97:
			do {
				if ((LA(1)==LSHIFT||LA(1)==RSHIFT)) {
					if ( inputState.guessing==0 ) {
						literal += LT(1).getText();
					}
					{
					switch ( LA(1)) {
					case LSHIFT:
					{
						match(LSHIFT);
						break;
					}
					case RSHIFT:
					{
						match(RSHIFT);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					aux=add_expr();
					if ( inputState.guessing==0 ) {
						literal += aux;
					}
				}
				else {
					break _loop97;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_37);
			} else {
			  throw ex;
			}
		}
		return literal;
	}
	
	public final String  add_expr() throws RecognitionException, TokenStreamException {
		String literal = null;
		
		
		String aux = null;
		
		
		try {      // for error handling
			literal=mult_expr();
			{
			_loop101:
			do {
				if ((LA(1)==PLUS||LA(1)==MINUS)) {
					if ( inputState.guessing==0 ) {
						literal += LT(1).getText();
					}
					{
					switch ( LA(1)) {
					case PLUS:
					{
						match(PLUS);
						break;
					}
					case MINUS:
					{
						match(MINUS);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					aux=mult_expr();
					if ( inputState.guessing==0 ) {
						literal += aux;
					}
				}
				else {
					break _loop101;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_38);
			} else {
			  throw ex;
			}
		}
		return literal;
	}
	
	public final String  mult_expr() throws RecognitionException, TokenStreamException {
		String literal = null;
		
		
		String aux = null;
		
		
		try {      // for error handling
			literal=unary_expr();
			{
			_loop105:
			do {
				if (((LA(1) >= STAR && LA(1) <= MOD))) {
					if ( inputState.guessing==0 ) {
						literal += LT(1).getText();
					}
					{
					switch ( LA(1)) {
					case STAR:
					{
						match(STAR);
						break;
					}
					case DIV:
					{
						match(DIV);
						break;
					}
					case MOD:
					{
						match(MOD);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					aux=unary_expr();
					if ( inputState.guessing==0 ) {
						literal += aux;
					}
				}
				else {
					break _loop105;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_39);
			} else {
			  throw ex;
			}
		}
		return literal;
	}
	
	public final String  unary_expr() throws RecognitionException, TokenStreamException {
		String literal = null;
		
		
		String aux = null;
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case PLUS:
			case MINUS:
			case TILDE:
			{
				if ( inputState.guessing==0 ) {
					literal = LT(1).getText();
				}
				{
				switch ( LA(1)) {
				case MINUS:
				{
					match(MINUS);
					break;
				}
				case PLUS:
				{
					match(PLUS);
					break;
				}
				case TILDE:
				{
					match(TILDE);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				aux=primary_expr();
				if ( inputState.guessing==0 ) {
					literal += aux;
				}
				break;
			}
			case SCOPEOP:
			case IDENT:
			case LPAREN:
			case LITERAL_TRUE:
			case LITERAL_FALSE:
			case INT:
			case OCTAL:
			case HEX:
			case STRING_LITERAL:
			case WIDE_STRING_LITERAL:
			case CHAR_LITERAL:
			case WIDE_CHAR_LITERAL:
			case FIXED:
			case FLOAT:
			{
				literal=primary_expr();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_40);
			} else {
			  throw ex;
			}
		}
		return literal;
	}
	
	public final String  primary_expr() throws RecognitionException, TokenStreamException {
		String lit = null;
		
		
		String aux = null;
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case SCOPEOP:
			case IDENT:
			{
				lit=scoped_name();
				break;
			}
			case LITERAL_TRUE:
			case LITERAL_FALSE:
			case INT:
			case OCTAL:
			case HEX:
			case STRING_LITERAL:
			case WIDE_STRING_LITERAL:
			case CHAR_LITERAL:
			case WIDE_CHAR_LITERAL:
			case FIXED:
			case FLOAT:
			{
				lit=literal();
				break;
			}
			case LPAREN:
			{
				if ( inputState.guessing==0 ) {
					lit = LT(1).getText();
				}
				match(LPAREN);
				aux=const_exp();
				if ( inputState.guessing==0 ) {
					lit += aux; lit += LT(1).getText();
				}
				match(RPAREN);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_40);
			} else {
			  throw ex;
			}
		}
		return lit;
	}
	
	public final String  literal() throws RecognitionException, TokenStreamException {
		String lit = null;
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case INT:
			case OCTAL:
			case HEX:
			{
				lit=integer_literal();
				break;
			}
			case STRING_LITERAL:
			{
				lit=string_literal();
				break;
			}
			case WIDE_STRING_LITERAL:
			{
				lit=wide_string_literal();
				break;
			}
			case CHAR_LITERAL:
			{
				lit=character_literal();
				break;
			}
			case WIDE_CHAR_LITERAL:
			{
				lit=wide_character_literal();
				break;
			}
			case FIXED:
			{
				lit=fixed_pt_literal();
				break;
			}
			case FLOAT:
			{
				lit=floating_pt_literal();
				break;
			}
			case LITERAL_TRUE:
			case LITERAL_FALSE:
			{
				lit=boolean_literal();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_40);
			} else {
			  throw ex;
			}
		}
		return lit;
	}
	
	public final String  integer_literal() throws RecognitionException, TokenStreamException {
		String literal = LT(1).getText();
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case INT:
			{
				match(INT);
				break;
			}
			case OCTAL:
			{
				match(OCTAL);
				break;
			}
			case HEX:
			{
				match(HEX);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_40);
			} else {
			  throw ex;
			}
		}
		return literal;
	}
	
	public final String  string_literal() throws RecognitionException, TokenStreamException {
		String literal = "";
		
		
		try {      // for error handling
			{
			int _cnt291=0;
			_loop291:
			do {
				if ((LA(1)==STRING_LITERAL)) {
					if ( inputState.guessing==0 ) {
						literal += LT(1).getText();
					}
					match(STRING_LITERAL);
				}
				else {
					if ( _cnt291>=1 ) { break _loop291; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt291++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_40);
			} else {
			  throw ex;
			}
		}
		return literal;
	}
	
	public final String  wide_string_literal() throws RecognitionException, TokenStreamException {
		String literal = "";
		
		
		try {      // for error handling
			{
			int _cnt294=0;
			_loop294:
			do {
				if ((LA(1)==WIDE_STRING_LITERAL)) {
					if ( inputState.guessing==0 ) {
						literal += LT(1).getText();
					}
					match(WIDE_STRING_LITERAL);
				}
				else {
					if ( _cnt294>=1 ) { break _loop294; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt294++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_40);
			} else {
			  throw ex;
			}
		}
		return literal;
	}
	
	public final String  character_literal() throws RecognitionException, TokenStreamException {
		String literal = LT(1).getText();
		
		
		try {      // for error handling
			match(CHAR_LITERAL);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_40);
			} else {
			  throw ex;
			}
		}
		return literal;
	}
	
	public final String  wide_character_literal() throws RecognitionException, TokenStreamException {
		String literal = LT(1).getText();
		
		
		try {      // for error handling
			match(WIDE_CHAR_LITERAL);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_40);
			} else {
			  throw ex;
			}
		}
		return literal;
	}
	
	public final String  fixed_pt_literal() throws RecognitionException, TokenStreamException {
		String literal = LT(1).getText();
		
		
		try {      // for error handling
			match(FIXED);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_40);
			} else {
			  throw ex;
			}
		}
		return literal;
	}
	
	public final String  floating_pt_literal() throws RecognitionException, TokenStreamException {
		String literal = LT(1).getText();
		
		Token  f = null;
		
		try {      // for error handling
			f = LT(1);
			match(FLOAT);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_40);
			} else {
			  throw ex;
			}
		}
		return literal;
	}
	
	public final String  boolean_literal() throws RecognitionException, TokenStreamException {
		String lit = null;
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_TRUE:
			{
				match(LITERAL_TRUE);
				if ( inputState.guessing==0 ) {
					lit = "true";
				}
				break;
			}
			case LITERAL_FALSE:
			{
				match(LITERAL_FALSE);
				if ( inputState.guessing==0 ) {
					lit = "false";
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_40);
			} else {
			  throw ex;
			}
		}
		return lit;
	}
	
	public final String  positive_int_const() throws RecognitionException, TokenStreamException {
		String literal = null;
		
		
		try {      // for error handling
			literal=const_exp();
			if ( inputState.guessing==0 ) {
				
				try
				{
				int value = Integer.parseInt(literal);
				
				if(value < 0)
				throw new ParseException(ctx.getFilename(), LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : 1, "The expression '" + literal + "' is not supported. You must use a positive integer.");
				}
				catch(NumberFormatException e)
				{
				}
				
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_41);
			} else {
			  throw ex;
			}
		}
		return literal;
	}
	
	public final Pair<TypeCode, TemplateGroup>  type_declarator() throws RecognitionException, TokenStreamException {
		Pair<TypeCode, TemplateGroup> returnPair = null;
		
		
		Vector<Pair<String, ContainerTypeCode>> declvector = null;
		TypeCode typecode = null;
		AliasTypeCode typedefTypecode = null;
		TemplateGroup typedefTemplates = tmanager.createTemplateGroup("typedef_decl");
		
		
		try {      // for error handling
			typecode=type_spec();
			declvector=declarators();
			if ( inputState.guessing==0 ) {
				
					   if(typecode != null && declvector != null)
					   {
					       for(int count = 0; count < declvector.size(); ++count)
					       {
					           typedefTypecode = new AliasTypeCode(ctx.getScope(), declvector.get(count).first());
					           
					           if(declvector.get(count).second() != null)
					           {
					               // Array declaration
					               declvector.get(count).second().setContentTypeCode(typecode);
					               typedefTypecode.setContentTypeCode(declvector.get(count).second());
					           }
					           else
					           {
					               // Simple declaration
					               typedefTypecode.setContentTypeCode(typecode);
					           }
					           
					           typedefTemplates.setAttribute("typedefs", typedefTypecode);
					           // Add alias typecode to the map with all typecodes.
					           ctx.addTypeCode(typedefTypecode.getScopedname(), typedefTypecode);
					       }
				
				typedefTemplates.setAttribute("ctx", ctx);
					       
					       returnPair = new Pair<TypeCode, TemplateGroup>(typecode, typedefTemplates);
				}
				else
				{
				throw new RuntimeException("ERROR (File " + ctx.getFilename() + ", Line " + (LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Cannot parse type declaration");
				}
					
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		return returnPair;
	}
	
	public final Pair<TypeCode, TemplateGroup>  struct_type() throws RecognitionException, TokenStreamException {
		Pair<TypeCode, TemplateGroup> returnPair = null;
		
		
		String name = null;
		StructTypeCode structTP = null;
		TemplateGroup structTemplates = tmanager.createTemplateGroup("struct_type");
		
		
		try {      // for error handling
			match(LITERAL_struct);
			name=identifier();
			if ( inputState.guessing==0 ) {
				
					       structTP = new StructTypeCode(ctx.getScope(), name);
					
			}
			match(LCURLY);
			member_list(structTP);
			match(RCURLY);
			if ( inputState.guessing==0 ) {
				
					       structTemplates.setAttribute("ctx", ctx);
				structTemplates.setAttribute("struct", structTP);
				// Add struct typecode to the map with all typecodes.
				ctx.addTypeCode(structTP.getScopedname(), structTP);
				// Return the returned data.
				returnPair = new Pair<TypeCode, TemplateGroup>(structTP, structTemplates);
					
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_42);
			} else {
			  throw ex;
			}
		}
		return returnPair;
	}
	
	public final Pair<TypeCode, TemplateGroup>  union_type() throws RecognitionException, TokenStreamException {
		Pair<TypeCode, TemplateGroup> returnPair = null;
		
		
		String name = null;
		int line = 0;
		TypeCode dist_type = null;
		UnionTypeCode unionTP = null;
		TemplateGroup unionTemplates = tmanager.createTemplateGroup("union_type");
		
		
		try {      // for error handling
			match(LITERAL_union);
			name=identifier();
			match(LITERAL_switch);
			match(LPAREN);
			dist_type=switch_type_spec();
			match(RPAREN);
			if ( inputState.guessing==0 ) {
				
				// TODO Check supported types for discriminator: long, enumeration, etc...
					       unionTP = new UnionTypeCode(ctx.getScope(), name, dist_type);
				line = LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : 1;
					
			}
			match(LCURLY);
			switch_body(unionTP);
			match(RCURLY);
			if ( inputState.guessing==0 ) {
				
					       // Calculate default label.
					       unionTP.setDefaultvalue(TemplateUtil.getUnionDefaultLabel(unionTP.getDiscriminator(), unionTP.getMembers(), ctx.getScopeFile(), line));
					       unionTemplates.setAttribute("ctx", ctx);
				unionTemplates.setAttribute("union", unionTP);
				
				// Add union typecode to the map with all typecodes.
				ctx.addTypeCode(unionTP.getScopedname(), unionTP);
				// Return the returned data.
				returnPair = new Pair<TypeCode, TemplateGroup>(unionTP, unionTemplates);
				
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_42);
			} else {
			  throw ex;
			}
		}
		return returnPair;
	}
	
	public final Pair<TypeCode, TemplateGroup>  enum_type() throws RecognitionException, TokenStreamException {
		Pair<TypeCode, TemplateGroup> returnPair = null;
		
		
		String name = null;
		EnumTypeCode enumTP = null;
		TemplateGroup enumTemplates = tmanager.createTemplateGroup("enum_type");
		
		
		try {      // for error handling
			match(LITERAL_enum);
			name=identifier();
			if ( inputState.guessing==0 ) {
				
					       enumTP = new EnumTypeCode(ctx.getScope(), name);
					
			}
			match(LCURLY);
			enumerator_list(enumTP);
			match(RCURLY);
			if ( inputState.guessing==0 ) {
				
				enumTemplates.setAttribute("ctx", ctx);
				enumTemplates.setAttribute("enum", enumTP);
				// Add enum typecode to the map with all typecodes.
				ctx.addTypeCode(enumTP.getScopedname(), enumTP);
				// Return the returned data.
				returnPair = new Pair<TypeCode, TemplateGroup>(enumTP, enumTemplates);
					
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_43);
			} else {
			  throw ex;
			}
		}
		return returnPair;
	}
	
	public final void constr_forward_decl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_struct:
			{
				match(LITERAL_struct);
				identifier();
				break;
			}
			case LITERAL_union:
			{
				match(LITERAL_union);
				identifier();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final TypeCode  simple_type_spec() throws RecognitionException, TokenStreamException {
		TypeCode typecode = null;
		
		
		String literal = null;
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_float:
			case LITERAL_double:
			case LITERAL_long:
			case LITERAL_short:
			case LITERAL_unsigned:
			case LITERAL_char:
			case LITERAL_wchar:
			case LITERAL_boolean:
			case LITERAL_octet:
			case LITERAL_any:
			case LITERAL_Object:
			case LITERAL_ValueBase:
			{
				typecode=base_type_spec();
				break;
			}
			case LITERAL_sequence:
			case LITERAL_string:
			case LITERAL_wstring:
			case LITERAL_fixed:
			{
				typecode=template_type_spec();
				break;
			}
			case SCOPEOP:
			case IDENT:
			{
				literal=scoped_name();
				if ( inputState.guessing==0 ) {
					
						       // Find typecode in the global map.
						       typecode = ctx.getTypeCode(literal);
						       
						       if(typecode == null)
						           throw new ParseException(ctx.getScopeFile(), LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : 1, "The type " + literal + " cannot be found.");
						
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_34);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final void constr_type_spec() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_struct:
			{
				struct_type();
				break;
			}
			case LITERAL_union:
			{
				union_type();
				break;
			}
			case LITERAL_enum:
			{
				enum_type();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_25);
			} else {
			  throw ex;
			}
		}
	}
	
	public final TypeCode  base_type_spec() throws RecognitionException, TokenStreamException {
		TypeCode typecode = null;
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_char:
			{
				typecode=char_type();
				break;
			}
			case LITERAL_wchar:
			{
				typecode=wide_char_type();
				break;
			}
			case LITERAL_boolean:
			{
				typecode=boolean_type();
				break;
			}
			case LITERAL_octet:
			{
				typecode=octet_type();
				break;
			}
			case LITERAL_any:
			{
				any_type();
				if ( inputState.guessing==0 ) {
					throw new ParseException(ctx.getScopeFile(), LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : 1, "Unsupported 'any' type.");
				}
				break;
			}
			case LITERAL_Object:
			{
				object_type();
				if ( inputState.guessing==0 ) {
					throw new ParseException(ctx.getScopeFile(), LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : 1, ": Unsupported 'Object' type.");
				}
				break;
			}
			case LITERAL_ValueBase:
			{
				value_base_type();
				if ( inputState.guessing==0 ) {
					throw new ParseException(ctx.getScopeFile(), LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : 1, "Unsupported 'ValueBase' type.");
				}
				break;
			}
			default:
				boolean synPredMatched123 = false;
				if ((((LA(1) >= LITERAL_float && LA(1) <= LITERAL_long)) && (_tokenSet_44.member(LA(2))) && (_tokenSet_45.member(LA(3))) && (_tokenSet_46.member(LA(4))))) {
					int _m123 = mark();
					synPredMatched123 = true;
					inputState.guessing++;
					try {
						{
						floating_pt_type();
						}
					}
					catch (RecognitionException pe) {
						synPredMatched123 = false;
					}
					rewind(_m123);
inputState.guessing--;
				}
				if ( synPredMatched123 ) {
					typecode=floating_pt_type();
				}
				else if (((LA(1) >= LITERAL_long && LA(1) <= LITERAL_unsigned)) && (_tokenSet_47.member(LA(2))) && (_tokenSet_48.member(LA(3))) && (_tokenSet_46.member(LA(4)))) {
					typecode=integer_type();
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_34);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final TypeCode  template_type_spec() throws RecognitionException, TokenStreamException {
		TypeCode typecode = null;
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_sequence:
			{
				typecode=sequence_type();
				break;
			}
			case LITERAL_string:
			{
				typecode=string_type();
				break;
			}
			case LITERAL_wstring:
			{
				typecode=wide_string_type();
				break;
			}
			case LITERAL_fixed:
			{
				fixed_pt_type();
				if ( inputState.guessing==0 ) {
					throw new ParseException(ctx.getScopeFile(), LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : 1, "Unsupported 'fixed' type.");
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_34);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final void any_type() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_any);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_34);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void object_type() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_Object);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_34);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void value_base_type() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_ValueBase);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_34);
			} else {
			  throw ex;
			}
		}
	}
	
	public final SequenceTypeCode  sequence_type() throws RecognitionException, TokenStreamException {
		SequenceTypeCode typecode = null;
		
		
		TypeCode type = null;
		String maxsize = null;
		
		
		try {      // for error handling
			match(LITERAL_sequence);
			match(LT);
			type=simple_type_spec();
			maxsize=opt_pos_int();
			match(GT);
			if ( inputState.guessing==0 ) {
				
					       typecode = new SequenceTypeCode(maxsize);
					       typecode.setContentTypeCode(type);
					
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_34);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final void fixed_pt_type() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_fixed);
			match(LT);
			positive_int_const();
			match(COMMA);
			positive_int_const();
			match(GT);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_34);
			} else {
			  throw ex;
			}
		}
	}
	
	public final Pair<String, ContainerTypeCode>  declarator() throws RecognitionException, TokenStreamException {
		Pair<String, ContainerTypeCode> pair = null;
		
		
		try {      // for error handling
			if ((LA(1)==IDENT) && (LA(2)==SEMI||LA(2)==COMMA)) {
				pair=simple_declarator();
			}
			else if ((LA(1)==IDENT) && (LA(2)==LBRACK)) {
				pair=complex_declarator();
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_49);
			} else {
			  throw ex;
			}
		}
		return pair;
	}
	
	public final Pair<String, ContainerTypeCode>  complex_declarator() throws RecognitionException, TokenStreamException {
		Pair<String, ContainerTypeCode> pair = null;
		
		
		try {      // for error handling
			pair=array_declarator();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_49);
			} else {
			  throw ex;
			}
		}
		return pair;
	}
	
	public final Pair<String, ContainerTypeCode>  array_declarator() throws RecognitionException, TokenStreamException {
		Pair<String, ContainerTypeCode> pair = null;
		
		
		String name = LT(1).getText(), size = null;
		ArrayTypeCode typecode = new ArrayTypeCode();
		
		
		try {      // for error handling
			match(IDENT);
			{
			int _cnt181=0;
			_loop181:
			do {
				if ((LA(1)==LBRACK)) {
					size=fixed_array_size();
					if ( inputState.guessing==0 ) {
						
							           typecode.addDimension(size);
							
					}
				}
				else {
					if ( _cnt181>=1 ) { break _loop181; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt181++;
			} while (true);
			}
			if ( inputState.guessing==0 ) {
				
					       pair = new Pair<String, ContainerTypeCode>(name, typecode);
					
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_49);
			} else {
			  throw ex;
			}
		}
		return pair;
	}
	
	public final TypeCode  signed_int() throws RecognitionException, TokenStreamException {
		TypeCode typecode = null;
		
		
		try {      // for error handling
			if ((LA(1)==LITERAL_short)) {
				typecode=signed_short_int();
			}
			else if ((LA(1)==LITERAL_long) && (_tokenSet_33.member(LA(2)))) {
				typecode=signed_long_int();
			}
			else if ((LA(1)==LITERAL_long) && (LA(2)==LITERAL_long)) {
				typecode=signed_longlong_int();
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_33);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final TypeCode  unsigned_int() throws RecognitionException, TokenStreamException {
		TypeCode typecode = null;
		
		
		try {      // for error handling
			if ((LA(1)==LITERAL_unsigned) && (LA(2)==LITERAL_short)) {
				typecode=unsigned_short_int();
			}
			else if ((LA(1)==LITERAL_unsigned) && (LA(2)==LITERAL_long) && (_tokenSet_33.member(LA(3)))) {
				typecode=unsigned_long_int();
			}
			else if ((LA(1)==LITERAL_unsigned) && (LA(2)==LITERAL_long) && (LA(3)==LITERAL_long)) {
				typecode=unsigned_longlong_int();
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_33);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final TypeCode  signed_short_int() throws RecognitionException, TokenStreamException {
		TypeCode typecode = new PrimitiveTypeCode(TypeCode.KIND_SHORT);
		
		
		try {      // for error handling
			match(LITERAL_short);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_33);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final TypeCode  signed_long_int() throws RecognitionException, TokenStreamException {
		TypeCode typecode = new PrimitiveTypeCode(TypeCode.KIND_LONG);
		
		
		try {      // for error handling
			match(LITERAL_long);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_33);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final TypeCode  signed_longlong_int() throws RecognitionException, TokenStreamException {
		TypeCode typecode = new PrimitiveTypeCode(TypeCode.KIND_LONGLONG);
		
		
		try {      // for error handling
			match(LITERAL_long);
			match(LITERAL_long);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_33);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final TypeCode  unsigned_short_int() throws RecognitionException, TokenStreamException {
		TypeCode typecode = new PrimitiveTypeCode(TypeCode.KIND_USHORT);
		
		
		try {      // for error handling
			match(LITERAL_unsigned);
			match(LITERAL_short);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_33);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final TypeCode  unsigned_long_int() throws RecognitionException, TokenStreamException {
		TypeCode typecode = new PrimitiveTypeCode(TypeCode.KIND_ULONG);
		
		
		try {      // for error handling
			match(LITERAL_unsigned);
			match(LITERAL_long);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_33);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final TypeCode  unsigned_longlong_int() throws RecognitionException, TokenStreamException {
		TypeCode typecode = new PrimitiveTypeCode(TypeCode.KIND_ULONGLONG);
		
		
		try {      // for error handling
			match(LITERAL_unsigned);
			match(LITERAL_long);
			match(LITERAL_long);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_33);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final void annotation_member_list(
		Annotation annotation
	) throws RecognitionException, TokenStreamException {
		
		
		Vector<Pair<String, TypeCode>> declvector = null;
		
		
		try {      // for error handling
			{
			int _cnt151=0;
			_loop151:
			do {
				if ((LA(1)==LITERAL_readonly||LA(1)==LITERAL_attribute)) {
					declvector=attr_dcl();
					match(SEMI);
					if ( inputState.guessing==0 ) {
						
						for(int count = 0; count < declvector.size(); ++count)
						annotation.addMember(new Member(declvector.get(count).second(), declvector.get(count).first()));
						
					}
				}
				else {
					if ( _cnt151>=1 ) { break _loop151; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt151++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_14);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void member_list(
		StructTypeCode structTP
	) throws RecognitionException, TokenStreamException {
		
		
		Vector<Pair<String, TypeCode>> declvector = null;
		
		
		try {      // for error handling
			{
			int _cnt155=0;
			_loop155:
			do {
				if ((_tokenSet_50.member(LA(1)))) {
					declvector=member();
					if ( inputState.guessing==0 ) {
						
							           for(int count = 0; count < declvector.size(); ++count)
							               structTP.addMember(new Member(declvector.get(count).second(), declvector.get(count).first()));
							
					}
				}
				else {
					if ( _cnt155>=1 ) { break _loop155; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt155++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_14);
			} else {
			  throw ex;
			}
		}
	}
	
	public final Vector<Pair<String, TypeCode>>  member() throws RecognitionException, TokenStreamException {
		Vector<Pair<String, TypeCode>> newVector = new Vector<Pair<String, TypeCode>>();
		
		
		Vector<Pair<String, ContainerTypeCode>> declvector = null;
		TypeCode typecode = null;
		
		
		try {      // for error handling
			typecode=type_spec();
			declvector=declarators();
			match(SEMI);
			if ( inputState.guessing==0 ) {
				
					       if(typecode!=null)
					       {
						       for(int count = 0; count < declvector.size(); ++count)
						       {
						           if(declvector.get(count).second() != null)
						           {
						               // Array declaration
						               declvector.get(count).second().setContentTypeCode(typecode);
						               newVector.add(new Pair<String, TypeCode>(declvector.get(count).first(), declvector.get(count).second()));
						               
						           }
						           else
						           {
						               // Simple declaration
						               newVector.add(new Pair<String, TypeCode>(declvector.get(count).first(), typecode));
						           }
						       }
					       }
					       else
					       {
					           throw new RuntimeException("In function 'member': null pointer.");
					       }
					
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_51);
			} else {
			  throw ex;
			}
		}
		return newVector;
	}
	
	public final TypeCode  switch_type_spec() throws RecognitionException, TokenStreamException {
		TypeCode typecode = null;
		
		
		String literal = null;
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_long:
			case LITERAL_short:
			case LITERAL_unsigned:
			{
				typecode=integer_type();
				break;
			}
			case LITERAL_char:
			{
				typecode=char_type();
				break;
			}
			case LITERAL_boolean:
			{
				typecode=boolean_type();
				break;
			}
			case LITERAL_enum:
			{
				enum_type();
				break;
			}
			case SCOPEOP:
			case IDENT:
			{
				literal=scoped_name();
				if ( inputState.guessing==0 ) {
					
					// Find typecode in the global map.
					typecode = ctx.getTypeCode(literal);
					
					if(typecode == null)
					throw new ParseException(ctx.getScopeFile(), LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : 1, "The type " + literal + " cannot be found.");
					
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_26);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final void switch_body(
		UnionTypeCode unionTP
	) throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			case_stmt_list(unionTP);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_14);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void case_stmt_list(
		UnionTypeCode unionTP
	) throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			int _cnt162=0;
			_loop162:
			do {
				if ((LA(1)==LITERAL_case||LA(1)==LITERAL_default)) {
					case_stmt(unionTP);
				}
				else {
					if ( _cnt162>=1 ) { break _loop162; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt162++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_14);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void case_stmt(
		UnionTypeCode unionTP
	) throws RecognitionException, TokenStreamException {
		
		
		Pair<String, TypeCode> element = null;
		String label = null;
		boolean defaul = false;
		UnionMember member = new UnionMember();
		
		
		try {      // for error handling
			{
			int _cnt165=0;
			_loop165:
			do {
				switch ( LA(1)) {
				case LITERAL_case:
				{
					match(LITERAL_case);
					label=const_exp();
					if ( inputState.guessing==0 ) {
						member.addLabel(TemplateUtil.checkUnionLabel(unionTP.getDiscriminator(), label, ctx.getScopeFile(), LT(0) != null ? LT(0).getLine() - ctx.getCurrentIncludeLine() : 1));
					}
					match(COLON);
					break;
				}
				case LITERAL_default:
				{
					match(LITERAL_default);
					if ( inputState.guessing==0 ) {
						defaul = true;
					}
					match(COLON);
					break;
				}
				default:
				{
					if ( _cnt165>=1 ) { break _loop165; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				}
				_cnt165++;
			} while (true);
			}
			element=element_spec();
			match(SEMI);
			if ( inputState.guessing==0 ) {
				
					       if(element!=null)
					       {
						       member.setTypecode(element.second());
						       member.setName(element.first());
						       int index = unionTP.addMember(member);
						       if(defaul) unionTP.setDefaultindex(index);
					       }
					       else
					       {
					           throw new RuntimeException("In function 'case_stmt': null pointer.");
					       }
					
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_52);
			} else {
			  throw ex;
			}
		}
	}
	
	public final Pair<String, TypeCode>  element_spec() throws RecognitionException, TokenStreamException {
		Pair<String, TypeCode> newpair = null;
		
		
		Pair<String, ContainerTypeCode> decl = null;
		TypeCode typecode = null;
		
		
		try {      // for error handling
			typecode=type_spec();
			decl=declarator();
			if ( inputState.guessing==0 ) {
				
					        if(typecode!=null)
					        {
					            if(decl.second() != null)
					            {
					                decl.second().setContentTypeCode(typecode);
					                newpair = new Pair<String, TypeCode>(decl.first(), decl.second());
					            }
					            else
					            {
					                newpair = new Pair<String, TypeCode>(decl.first(), typecode);
					            }
				}
				else
					        {
					            throw new RuntimeException("In function 'element_spec': null pointer.");
					        }
				
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		return newpair;
	}
	
	public final void enumerator_list(
		EnumTypeCode enumTP
	) throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			enumerator(enumTP);
			{
			_loop170:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					enumerator(enumTP);
				}
				else {
					break _loop170;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_14);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void enumerator(
		EnumTypeCode enumTP
	) throws RecognitionException, TokenStreamException {
		
		
		String name = null;
		
		
		try {      // for error handling
			name=identifier();
			if ( inputState.guessing==0 ) {
				enumTP.addMember(new EnumMember(name));
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_53);
			} else {
			  throw ex;
			}
		}
	}
	
	public final String  opt_pos_int() throws RecognitionException, TokenStreamException {
		String literal = null;
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case COMMA:
			{
				match(COMMA);
				literal=positive_int_const();
				break;
			}
			case GT:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_54);
			} else {
			  throw ex;
			}
		}
		return literal;
	}
	
	public final String  fixed_array_size() throws RecognitionException, TokenStreamException {
		String literal = null;
		
		
		try {      // for error handling
			match(LBRACK);
			literal=positive_int_const();
			match(RBRACK);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_55);
			} else {
			  throw ex;
			}
		}
		return literal;
	}
	
	public final void readonly_attr_spec() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_readonly);
			match(LITERAL_attribute);
			param_type_spec();
			readonly_attr_declarator();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final Vector<Pair<String, TypeCode>>  attr_spec() throws RecognitionException, TokenStreamException {
		Vector<Pair<String, TypeCode>> newVector = new Vector<Pair<String, TypeCode>>();
		
		
		TypeCode typecode = null;
		Vector<Pair<String, ContainerTypeCode>> declvector = null;
		
		
		try {      // for error handling
			match(LITERAL_attribute);
			typecode=param_type_spec();
			declvector=attr_declarator();
			if ( inputState.guessing==0 ) {
				
					   if(typecode != null)
				{
				for(int count = 0; count < declvector.size(); ++count)
				{
				// attr_declarator always is a simple declarator. Not a complex (array):
				// Simple declaration
				newVector.add(new Pair<String, TypeCode>(declvector.get(count).first(), typecode));
				}
				}
				else
				{
				throw new RuntimeException("In function 'attr_spec': null pointer.");
				}
					
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		return newVector;
	}
	
	public final void opt_member_list(
		com.eprosima.idl.parser.tree.Exception exceptionObject
	) throws RecognitionException, TokenStreamException {
		
		
		Vector<Pair<String, TypeCode>> declvector = null;
		
		
		try {      // for error handling
			{
			_loop187:
			do {
				if ((_tokenSet_50.member(LA(1)))) {
					declvector=member();
					if ( inputState.guessing==0 ) {
						
							          for(int count = 0; count < declvector.size(); ++count)
							              exceptionObject.addMember(new Member(declvector.get(count).second(), declvector.get(count).first()));
							
					}
				}
				else {
					break _loop187;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_14);
			} else {
			  throw ex;
			}
		}
	}
	
	public final boolean  op_attribute() throws RecognitionException, TokenStreamException {
		boolean ret = false;
		
		
		try {      // for error handling
			match(LITERAL_oneway);
			if ( inputState.guessing==0 ) {
				ret = true;
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_56);
			} else {
			  throw ex;
			}
		}
		return ret;
	}
	
	public final TypeCode  op_type_spec() throws RecognitionException, TokenStreamException {
		TypeCode typecode = null;
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case SCOPEOP:
			case IDENT:
			case LITERAL_float:
			case LITERAL_double:
			case LITERAL_long:
			case LITERAL_short:
			case LITERAL_unsigned:
			case LITERAL_char:
			case LITERAL_wchar:
			case LITERAL_boolean:
			case LITERAL_octet:
			case LITERAL_any:
			case LITERAL_Object:
			case LITERAL_string:
			case LITERAL_wstring:
			case LITERAL_ValueBase:
			{
				typecode=param_type_spec();
				break;
			}
			case LITERAL_void:
			{
				match(LITERAL_void);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_25);
			} else {
			  throw ex;
			}
		}
		return typecode;
	}
	
	public final TemplateGroup  parameter_dcls(
		Operation operation
	) throws RecognitionException, TokenStreamException {
		TemplateGroup tpl = tmanager.createTemplateGroup("param_list");
		
		
		try {      // for error handling
			match(LPAREN);
			{
			switch ( LA(1)) {
			case LITERAL_in:
			case LITERAL_out:
			case LITERAL_inout:
			{
				param_dcl_list(operation, tpl);
				break;
			}
			case RPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(RPAREN);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_57);
			} else {
			  throw ex;
			}
		}
		return tpl;
	}
	
	public final void context_expr() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_context);
			match(LPAREN);
			string_literal_list();
			match(RPAREN);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void param_dcl_list(
		Operation operation, TemplateGroup tpl
	) throws RecognitionException, TokenStreamException {
		
		
		Pair<Param, TemplateGroup> ptg = null;
		
		
		try {      // for error handling
			ptg=param_dcl();
			if ( inputState.guessing==0 ) {
				if(ptg!=null){operation.add(ptg.first()); tpl.setAttribute("parameters", ptg.second());}
			}
			{
			_loop198:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					ptg=param_dcl();
					if ( inputState.guessing==0 ) {
						if(ptg!=null){operation.add(ptg.first()); tpl.setAttribute("parameters", ptg.second());}
					}
				}
				else {
					break _loop198;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_26);
			} else {
			  throw ex;
			}
		}
	}
	
	public final Pair<Param, TemplateGroup>  param_dcl() throws RecognitionException, TokenStreamException {
		Pair<Param, TemplateGroup> returnPair = null;
		
		
		TemplateGroup paramTemplate = tmanager.createTemplateGroup("param");
		Pair<String, ContainerTypeCode> pair = null;
		TypeCode typecode = null;
		String literal = LT(1).getText();
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_in:
			{
				match(LITERAL_in);
				break;
			}
			case LITERAL_out:
			{
				match(LITERAL_out);
				break;
			}
			case LITERAL_inout:
			{
				match(LITERAL_inout);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			typecode=param_type_spec();
			pair=simple_declarator();
			if ( inputState.guessing==0 ) {
				
					        if(typecode != null)
					        {
						        Param param = null;
						        if(literal.equals("in"))
						            param = new InputParam(pair.first(), typecode);
						        else if(literal.equals("out"))
						            param = new OutputParam(pair.first(), typecode);
						        else if(literal.equals("inout"))
						            param = new InoutParam(pair.first(), typecode);
						            
						        paramTemplate.setAttribute("parameter", param);
						        returnPair = new Pair<Param, TemplateGroup>(param, paramTemplate);
					        }
					        else
					        {
					            throw new RuntimeException("In function 'param_dcl': null pointer.");
					        }
					
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_28);
			} else {
			  throw ex;
			}
		}
		return returnPair;
	}
	
	public final void string_literal_list() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			string_literal();
			{
			_loop205:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					string_literal();
				}
				else {
					break _loop205;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_26);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void imported_scope() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case SCOPEOP:
			case IDENT:
			{
				scoped_name();
				break;
			}
			case STRING_LITERAL:
			{
				string_literal();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void readonly_attr_declarator() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			simple_declarator();
			{
			switch ( LA(1)) {
			case LITERAL_raises:
			{
				raises_expr();
				break;
			}
			case SEMI:
			case COMMA:
			{
				{
				_loop219:
				do {
					if ((LA(1)==COMMA)) {
						match(COMMA);
						simple_declarator();
					}
					else {
						break _loop219;
					}
					
				} while (true);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final Vector<Pair<String, ContainerTypeCode>>  attr_declarator() throws RecognitionException, TokenStreamException {
		Vector<Pair<String, ContainerTypeCode>> declvector = new Vector<Pair<String, ContainerTypeCode>>();
		
		
		Pair<String, ContainerTypeCode> pair = null;
		
		
		try {      // for error handling
			pair=simple_declarator();
			if ( inputState.guessing==0 ) {
				declvector.add(pair);
			}
			{
			boolean synPredMatched224 = false;
			if (((LA(1)==SEMI||LA(1)==LITERAL_getraises||LA(1)==LITERAL_setraises) && (_tokenSet_58.member(LA(2))) && (_tokenSet_59.member(LA(3))) && (_tokenSet_60.member(LA(4))))) {
				int _m224 = mark();
				synPredMatched224 = true;
				inputState.guessing++;
				try {
					{
					switch ( LA(1)) {
					case LITERAL_getraises:
					{
						match(LITERAL_getraises);
						break;
					}
					case LITERAL_setraises:
					{
						match(LITERAL_setraises);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
				}
				catch (RecognitionException pe) {
					synPredMatched224 = false;
				}
				rewind(_m224);
inputState.guessing--;
			}
			if ( synPredMatched224 ) {
				attr_raises_expr();
			}
			else if ((LA(1)==SEMI||LA(1)==COMMA) && (_tokenSet_61.member(LA(2))) && (_tokenSet_62.member(LA(3))) && (_tokenSet_63.member(LA(4)))) {
				{
				_loop226:
				do {
					if ((LA(1)==COMMA)) {
						match(COMMA);
						pair=simple_declarator();
						if ( inputState.guessing==0 ) {
							declvector.add(pair);
						}
					}
					else {
						break _loop226;
					}
					
				} while (true);
				}
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		return declvector;
	}
	
	public final void attr_raises_expr() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_getraises:
			{
				get_excep_expr();
				break;
			}
			case SEMI:
			case LITERAL_setraises:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_setraises:
			{
				set_excep_expr();
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void get_excep_expr() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_getraises);
			exception_list();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_64);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void set_excep_expr() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_setraises);
			exception_list();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void exception_list() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LPAREN);
			scoped_name();
			{
			_loop234:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					scoped_name();
				}
				else {
					break _loop234;
				}
				
			} while (true);
			}
			match(RPAREN);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_64);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void component_dcl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case COLON:
			{
				component_inheritance_spec();
				break;
			}
			case LCURLY:
			case LITERAL_supports:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_supports:
			{
				supported_interface_spec();
				break;
			}
			case LCURLY:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(LCURLY);
			component_body();
			match(RCURLY);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void component_inheritance_spec() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(COLON);
			scoped_name();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_23);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void supported_interface_spec() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_supports);
			scoped_name();
			{
			_loop242:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					scoped_name();
				}
				else {
					break _loop242;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_65);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void component_body() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			_loop246:
			do {
				if ((_tokenSet_66.member(LA(1)))) {
					component_export();
				}
				else {
					break _loop246;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_14);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void component_export() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_provides:
			{
				provides_dcl();
				match(SEMI);
				break;
			}
			case LITERAL_uses:
			{
				uses_dcl();
				match(SEMI);
				break;
			}
			case LITERAL_emits:
			{
				emits_dcl();
				match(SEMI);
				break;
			}
			case LITERAL_publishes:
			{
				publishes_dcl();
				match(SEMI);
				break;
			}
			case LITERAL_consumes:
			{
				consumes_dcl();
				match(SEMI);
				break;
			}
			case LITERAL_readonly:
			case LITERAL_attribute:
			{
				attr_dcl();
				match(SEMI);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_67);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void provides_dcl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_provides);
			interface_type();
			identifier();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void uses_dcl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_uses);
			{
			switch ( LA(1)) {
			case LITERAL_multiple:
			{
				match(LITERAL_multiple);
				break;
			}
			case SCOPEOP:
			case IDENT:
			case LITERAL_Object:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			interface_type();
			identifier();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void emits_dcl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_emits);
			scoped_name();
			identifier();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void publishes_dcl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_publishes);
			scoped_name();
			identifier();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void consumes_dcl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_consumes);
			scoped_name();
			identifier();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void interface_type() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case SCOPEOP:
			case IDENT:
			{
				scoped_name();
				break;
			}
			case LITERAL_Object:
			{
				match(LITERAL_Object);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_25);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void home_header() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_home);
			identifier();
			{
			switch ( LA(1)) {
			case COLON:
			{
				home_inheritance_spec();
				break;
			}
			case LITERAL_supports:
			case LITERAL_manages:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_supports:
			{
				supported_interface_spec();
				break;
			}
			case LITERAL_manages:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(LITERAL_manages);
			scoped_name();
			{
			switch ( LA(1)) {
			case LITERAL_primarykey:
			{
				primary_key_spec();
				break;
			}
			case LCURLY:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_15);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void home_body() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LCURLY);
			{
			_loop266:
			do {
				if ((_tokenSet_68.member(LA(1)))) {
					home_export();
				}
				else {
					break _loop266;
				}
				
			} while (true);
			}
			match(RCURLY);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void home_inheritance_spec() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(COLON);
			scoped_name();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_69);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void primary_key_spec() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_primarykey);
			scoped_name();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_15);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void home_export() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case SCOPEOP:
			case IDENT:
			case LITERAL_const:
			case LITERAL_typedef:
			case LITERAL_native:
			case LITERAL_float:
			case LITERAL_double:
			case LITERAL_long:
			case LITERAL_short:
			case LITERAL_unsigned:
			case LITERAL_char:
			case LITERAL_wchar:
			case LITERAL_boolean:
			case LITERAL_octet:
			case LITERAL_any:
			case LITERAL_Object:
			case AT:
			case LITERAL_struct:
			case LITERAL_union:
			case LITERAL_enum:
			case LITERAL_string:
			case LITERAL_wstring:
			case LITERAL_exception:
			case LITERAL_oneway:
			case LITERAL_void:
			case LITERAL_ValueBase:
			case LITERAL_typeid:
			case LITERAL_typeprefix:
			case LITERAL_readonly:
			case LITERAL_attribute:
			{
				export();
				break;
			}
			case LITERAL_factory:
			{
				factory_dcl();
				match(SEMI);
				break;
			}
			case LITERAL_finder:
			{
				finder_dcl();
				match(SEMI);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_70);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void factory_dcl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_factory);
			identifier();
			match(LPAREN);
			init_param_decls();
			match(RPAREN);
			{
			switch ( LA(1)) {
			case LITERAL_raises:
			{
				raises_expr();
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void finder_dcl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_finder);
			identifier();
			match(LPAREN);
			init_param_decls();
			match(RPAREN);
			{
			switch ( LA(1)) {
			case LITERAL_raises:
			{
				raises_expr();
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void event_abs() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_abstract);
			event_header();
			{
			switch ( LA(1)) {
			case LCURLY:
			case COLON:
			case LITERAL_supports:
			{
				event_abs_dcl();
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void event_custom() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_custom);
			event_header();
			event_elem_dcl();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void event_dcl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			event_header();
			{
			switch ( LA(1)) {
			case LCURLY:
			case COLON:
			case LITERAL_supports:
			{
				event_elem_dcl();
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void event_header() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_eventtype);
			identifier();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_71);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void event_abs_dcl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			value_inheritance_spec();
			match(LCURLY);
			{
			_loop280:
			do {
				if ((_tokenSet_16.member(LA(1)))) {
					export();
				}
				else {
					break _loop280;
				}
				
			} while (true);
			}
			match(RCURLY);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void event_elem_dcl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			value_inheritance_spec();
			match(LCURLY);
			{
			_loop286:
			do {
				if ((_tokenSet_16.member(LA(1)))) {
					export();
				}
				else {
					break _loop286;
				}
				
			} while (true);
			}
			match(RCURLY);
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		";",
		"\"abstract\"",
		"\"local\"",
		"\"interface\"",
		"\"custom\"",
		"\"valuetype\"",
		"\"eventtype\"",
		"\"module\"",
		"{",
		"}",
		":",
		",",
		"::",
		"an identifer",
		"\"truncatable\"",
		"\"supports\"",
		"\"public\"",
		"\"private\"",
		"\"factory\"",
		"(",
		")",
		"\"in\"",
		"\"const\"",
		"=",
		"|",
		"^",
		"&",
		"<<",
		">>",
		"+",
		"-",
		"*",
		"/",
		"%",
		"~",
		"\"TRUE\"",
		"\"FALSE\"",
		"\"typedef\"",
		"\"native\"",
		"\"float\"",
		"\"double\"",
		"\"long\"",
		"\"short\"",
		"\"unsigned\"",
		"\"char\"",
		"\"wchar\"",
		"\"boolean\"",
		"\"octet\"",
		"\"any\"",
		"\"Object\"",
		"@",
		"\"Annotation\"",
		"\"struct\"",
		"\"union\"",
		"\"switch\"",
		"\"case\"",
		"\"default\"",
		"\"enum\"",
		"\"sequence\"",
		"<",
		">",
		"\"string\"",
		"\"wstring\"",
		"[",
		"]",
		"\"exception\"",
		"\"oneway\"",
		"\"void\"",
		"\"out\"",
		"\"inout\"",
		"\"raises\"",
		"\"context\"",
		"\"fixed\"",
		"\"ValueBase\"",
		"\"import\"",
		"\"typeid\"",
		"\"typeprefix\"",
		"\"readonly\"",
		"\"attribute\"",
		"\"getraises\"",
		"\"setraises\"",
		"\"component\"",
		"\"provides\"",
		"\"uses\"",
		"\"multiple\"",
		"\"emits\"",
		"\"publishes\"",
		"\"consumes\"",
		"\"home\"",
		"\"manages\"",
		"\"primarykey\"",
		"\"finder\"",
		"an integer value",
		"an octal value",
		"a hexadecimal value value",
		"a string literal",
		"a wide string literal",
		"a character literal",
		"a wide character literal",
		"FIXED",
		"a floating point value",
		"?",
		".",
		"!",
		"white space",
		"a preprocessor directive",
		"a comment",
		"a comment",
		"an escape sequence",
		"an escaped character value",
		"a digit",
		"a non-zero digit",
		"an octal digit",
		"a hexadecimal digit",
		"an escaped identifer"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2540036786973839328L, 270630944L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 2540036786973839328L, 270647328L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 151568L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 2558042389390524402L, 271032550L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 675856L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 2558042389398650866L, 271032550L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 2558042389391310834L, 271032550L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 2540036786973847522L, 270630944L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 16L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 2558042389390520320L, 499942L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { 2540036786973847538L, 270630944L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = { 2558042389397843938L, 2418516198L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	private static final long[] mk_tokenSet_13() {
		long[] data = { 288230650921349136L, 35971925009L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	private static final long[] mk_tokenSet_14() {
		long[] data = { 8192L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	private static final long[] mk_tokenSet_15() {
		long[] data = { 4096L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());
	private static final long[] mk_tokenSet_16() {
		long[] data = { 2558042389390491648L, 499942L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());
	private static final long[] mk_tokenSet_17() {
		long[] data = { 2558042389397839872L, 2147983590L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());
	private static final long[] mk_tokenSet_18() {
		long[] data = { 16781312L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());
	private static final long[] mk_tokenSet_19() {
		long[] data = { 36864L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());
	private static final long[] mk_tokenSet_20() {
		long[] data = { 274626957328L, 35970351121L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_20 = new BitSet(mk_tokenSet_20());
	private static final long[] mk_tokenSet_21() {
		long[] data = { 2558042389397831680L, 499942L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_21 = new BitSet(mk_tokenSet_21());
	private static final long[] mk_tokenSet_22() {
		long[] data = { 2558042389397839872L, 499942L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_22 = new BitSet(mk_tokenSet_22());
	private static final long[] mk_tokenSet_23() {
		long[] data = { 528384L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_23 = new BitSet(mk_tokenSet_23());
	private static final long[] mk_tokenSet_24() {
		long[] data = { 561152L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_24 = new BitSet(mk_tokenSet_24());
	private static final long[] mk_tokenSet_25() {
		long[] data = { 131072L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_25 = new BitSet(mk_tokenSet_25());
	private static final long[] mk_tokenSet_26() {
		long[] data = { 16777216L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_26 = new BitSet(mk_tokenSet_26());
	private static final long[] mk_tokenSet_27() {
		long[] data = { 16L, 2048L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_27 = new BitSet(mk_tokenSet_27());
	private static final long[] mk_tokenSet_28() {
		long[] data = { 16809984L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_28 = new BitSet(mk_tokenSet_28());
	private static final long[] mk_tokenSet_29() {
		long[] data = { 18005602416656384L, 8198L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_29 = new BitSet(mk_tokenSet_29());
	private static final long[] mk_tokenSet_30() {
		long[] data = { 16810000L, 1573888L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_30 = new BitSet(mk_tokenSet_30());
	private static final long[] mk_tokenSet_31() {
		long[] data = { 1950057955328L, 2194728288256L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_31 = new BitSet(mk_tokenSet_31());
	private static final long[] mk_tokenSet_32() {
		long[] data = { 16826384L, 17L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_32 = new BitSet(mk_tokenSet_32());
	private static final long[] mk_tokenSet_33() {
		long[] data = { 16941056L, 1L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_33 = new BitSet(mk_tokenSet_33());
	private static final long[] mk_tokenSet_34() {
		long[] data = { 163840L, 1L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_34 = new BitSet(mk_tokenSet_34());
	private static final long[] mk_tokenSet_35() {
		long[] data = { 285261840L, 17L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_35 = new BitSet(mk_tokenSet_35());
	private static final long[] mk_tokenSet_36() {
		long[] data = { 822132752L, 17L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_36 = new BitSet(mk_tokenSet_36());
	private static final long[] mk_tokenSet_37() {
		long[] data = { 1895874576L, 17L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_37 = new BitSet(mk_tokenSet_37());
	private static final long[] mk_tokenSet_38() {
		long[] data = { 8338325520L, 17L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_38 = new BitSet(mk_tokenSet_38());
	private static final long[] mk_tokenSet_39() {
		long[] data = { 34108129296L, 17L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_39 = new BitSet(mk_tokenSet_39());
	private static final long[] mk_tokenSet_40() {
		long[] data = { 274626297872L, 17L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_40 = new BitSet(mk_tokenSet_40());
	private static final long[] mk_tokenSet_41() {
		long[] data = { 32768L, 17L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_41 = new BitSet(mk_tokenSet_41());
	private static final long[] mk_tokenSet_42() {
		long[] data = { 131088L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_42 = new BitSet(mk_tokenSet_42());
	private static final long[] mk_tokenSet_43() {
		long[] data = { 16908304L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_43 = new BitSet(mk_tokenSet_43());
	private static final long[] mk_tokenSet_44() {
		long[] data = { 17592186208256L, 1L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_44 = new BitSet(mk_tokenSet_44());
	private static final long[] mk_tokenSet_45() {
		long[] data = { 1949940547600L, 2194729862153L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_45 = new BitSet(mk_tokenSet_45());
	private static final long[] mk_tokenSet_46() {
		long[] data = { 8899112863549075442L, 2197395849199L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_46 = new BitSet(mk_tokenSet_46());
	private static final long[] mk_tokenSet_47() {
		long[] data = { 105553116430336L, 1L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_47 = new BitSet(mk_tokenSet_47());
	private static final long[] mk_tokenSet_48() {
		long[] data = { 37134312636432L, 2194729862153L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_48 = new BitSet(mk_tokenSet_48());
	private static final long[] mk_tokenSet_49() {
		long[] data = { 32784L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_49 = new BitSet(mk_tokenSet_49());
	private static final long[] mk_tokenSet_50() {
		long[] data = { 7151707412171522048L, 12294L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_50 = new BitSet(mk_tokenSet_50());
	private static final long[] mk_tokenSet_51() {
		long[] data = { 7151707412171530240L, 12294L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_51 = new BitSet(mk_tokenSet_51());
	private static final long[] mk_tokenSet_52() {
		long[] data = { 1729382256910278656L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_52 = new BitSet(mk_tokenSet_52());
	private static final long[] mk_tokenSet_53() {
		long[] data = { 40960L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_53 = new BitSet(mk_tokenSet_53());
	private static final long[] mk_tokenSet_54() {
		long[] data = { 0L, 1L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_54 = new BitSet(mk_tokenSet_54());
	private static final long[] mk_tokenSet_55() {
		long[] data = { 32784L, 8L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_55 = new BitSet(mk_tokenSet_55());
	private static final long[] mk_tokenSet_56() {
		long[] data = { 18005602416656384L, 8326L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_56 = new BitSet(mk_tokenSet_56());
	private static final long[] mk_tokenSet_57() {
		long[] data = { 16L, 3072L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_57 = new BitSet(mk_tokenSet_57());
	private static final long[] mk_tokenSet_58() {
		long[] data = { 2558042389406228480L, 2395447526L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_58 = new BitSet(mk_tokenSet_58());
	private static final long[] mk_tokenSet_59() {
		long[] data = { -2071664624683253744L, 17051782L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_59 = new BitSet(mk_tokenSet_59());
	private static final long[] mk_tokenSet_60() {
		long[] data = { -6377097321372205070L, 2194998927398L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_60 = new BitSet(mk_tokenSet_60());
	private static final long[] mk_tokenSet_61() {
		long[] data = { 2558042389397839872L, 2395447526L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_61 = new BitSet(mk_tokenSet_61());
	private static final long[] mk_tokenSet_62() {
		long[] data = { -2071664624683220976L, 17051782L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_62 = new BitSet(mk_tokenSet_62());
	private static final long[] mk_tokenSet_63() {
		long[] data = { -6377097321381675022L, 2197394268390L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_63 = new BitSet(mk_tokenSet_63());
	private static final long[] mk_tokenSet_64() {
		long[] data = { 16L, 1048576L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_64 = new BitSet(mk_tokenSet_64());
	private static final long[] mk_tokenSet_65() {
		long[] data = { 4096L, 536870912L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_65 = new BitSet(mk_tokenSet_65());
	private static final long[] mk_tokenSet_66() {
		long[] data = { 0L, 247857152L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_66 = new BitSet(mk_tokenSet_66());
	private static final long[] mk_tokenSet_67() {
		long[] data = { 8192L, 247857152L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_67 = new BitSet(mk_tokenSet_67());
	private static final long[] mk_tokenSet_68() {
		long[] data = { 2558042389394685952L, 2147983590L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_68 = new BitSet(mk_tokenSet_68());
	private static final long[] mk_tokenSet_69() {
		long[] data = { 524288L, 536870912L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_69 = new BitSet(mk_tokenSet_69());
	private static final long[] mk_tokenSet_70() {
		long[] data = { 2558042389394694144L, 2147983590L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_70 = new BitSet(mk_tokenSet_70());
	private static final long[] mk_tokenSet_71() {
		long[] data = { 544784L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_71 = new BitSet(mk_tokenSet_71());
	
	}
