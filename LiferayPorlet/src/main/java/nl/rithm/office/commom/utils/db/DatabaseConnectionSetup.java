package nl.rithm.office.commom.utils.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import nl.rithm.office.commom.utils.ApplicationConstants;

public class DatabaseConnectionSetup {
	
	public static Connection getConnection(String connectionSource) throws SQLException, NamingException{
		
		/*Below 3 lines are mandat for using JNDI based datasource if using dafault Liferay Portlets :- STUPID*/
		Thread thread = Thread.currentThread();
		ClassLoader origLoader = thread.getContextClassLoader();
		thread.setContextClassLoader(PortalClassLoaderUtil.getClassLoader());
		
		Connection conn = null;
		DataSource ds = null;
		Context context = new InitialContext();
		Context envContext  = (Context)context.lookup(ApplicationConstants.ENV_CONTEXT);
		if(ApplicationConstants.LIFERAY_DB.equalsIgnoreCase(connectionSource)) {
			ds = (DataSource)envContext.lookup(ApplicationConstants.LIFERAYDB_JNDI);
		}else {
			ds = (DataSource)envContext.lookup(ApplicationConstants.APPLICATIONDB_JNDI);
		}	
		 		
		conn = ds.getConnection();
		
		return conn;		
	}
	

}
