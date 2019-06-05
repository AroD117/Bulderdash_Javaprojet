package model;
//salut
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Entity;
import entity.Map;


/* The Class DAOMap.
 *
 * @author Jean-Aymeric Diet
 */
class DAOMap extends DAOEntity {
	
    /* Instantiates a new DAO hello world.
     *
     * @param connection
     *          the connection
     * @throws SQLException
     *           the SQL exception
     */
    public DAOMap(Connection connection) throws SQLException {
        super(connection);
    }
    
    /* (non-Javadoc)
     *
     * @see model.DAOEntity#find(int)
     */
   
    ResultSet resultSet;
    public int map_number = 1;
    public Map find(final int id) 
    {
       

        try {
            final String sql = "SELECT map FROM map WHERE id ="+ map_number ;
            final CallableStatement call = this.getConnection().prepareCall(sql);
            call.execute();
            if (resultSet.next()) 
            {
                try {
					this.Switch(resultSet);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void Switch(ResultSet rs) throws SQLException, IOException 
	{	 
	  System.out.println("testrzpg,");
	 
	  for (char c : rs.getString("map").toCharArray())
	  {
		  System.out.println(c);
		  if (c == 'a') 
		  {


		  }
		  
	  }
	}

    
	@Override
	public boolean create(Entity entity) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete(Entity entity) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean update(Entity entity) {
		// TODO Auto-generated method stub
		return false;
	}
    
    }
