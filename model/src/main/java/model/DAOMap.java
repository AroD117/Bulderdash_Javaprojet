package model;
//salut
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Diamond;
import entity.Entity;
import entity.EntityFactory;
import entity.IEntity;
import entity.IMap;
import entity.Map;
import entity.Rock;


/* The Class DAOMap.
 *
 * @author Jean-Aymeric Diet
 */
class DAOMap  {
	private static int x = 0;
	private static int y = 0;
	private final Connection connection;
    /* Instantiates a new DAO hello world.
     *
     * @param connection
     *          the connection
     * @throws SQLException
     *           the SQL exception
     */
    public DAOMap(Connection connection) throws SQLException {
        this.connection = connection;
    }
    
    /* (non-Javadoc)
     *
     * @see model.DAOEntity#find(int)
     */
   
    ResultSet resultSet;
  
    public static IMap find( int id) 
    {
       IMap map = null;

        try {
            final String sql = "SELECT map FROM map WHERE id ="+ id ;
            final CallableStatement call = prepareCall(sql);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            if (resultSet.first()) 
            {
                try {
					map = Switch(resultSet);
					return map;
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
    
    public static  IMap Switch(ResultSet rs) throws SQLException, IOException 
	{	 
	  IMap map = new Map(50, 40, new IEntity[50][40]);
	  
	  for (char c : rs.getString("map").toCharArray())
	  {
		  if (x == 50) {
			  x = 0;
			  y++;
		  }
		  map.setOnTheMapXY1(x, y, EntityFactory.getFromFileSymbol(c));
		  if (c == 'd') {
			  map.addPawn(new Diamond(x, y, map));
		  }
		  else if (c == 'c') {
			  map.addPawn(new Rock(x, y, map));
		  }
		  x++;
	  }
	  return map;
	}
    
    public static CallableStatement prepareCall(final String query) throws SQLException {
		return DBConnection.getInstance().getConnection().prepareCall(query);
	}

  
    
    }